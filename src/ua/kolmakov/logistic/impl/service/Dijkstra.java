package ua.kolmakov.logistic.impl.service;

import ua.kolmakov.logistic.api.model.post.PostOffice;
import ua.kolmakov.logistic.api.model.transport.DeliveryTransport;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Kolmakov Alexey on 29.06.2015.
 */
public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE;

    private static List<Node> nodes;
    private static List<PostOffice> postOffices;
    private static List<DeliveryTransport> transitDeliveryTransports;

    private Queue<Node> nodeQueue;

    public static Dijkstra getDijkstra() {
        Dijkstra dijkstra = new Dijkstra();
        return dijkstra;
    }

    private Dijkstra() {
        postOffices = Storage.getInstance().getById("postOffices");
        transitDeliveryTransports = Storage.getInstance().getById("deliveryTransports");
        nodes = new ArrayList<>();
    }

    public void search(PostOffice start, Dijkstra.SearchParam param) {
        initNodes();
        nodeQueue = new PriorityQueue<>((n1, n2) -> (int) (n2.minWeight - n1.minWeight));
        Node startNode = getByPostOffice(start, nodes);
        startNode.minWeight = 0;
        nodeQueue.add(startNode);
        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.poll();
            List<DeliveryTransport> curRelatedDT = current.relatedDeliveryTransports();
            for (DeliveryTransport dt : curRelatedDT) {
                Node next = getByPostOffice(dt.getDestinationPostOffice(), nodes);
                double weight = getWeight(dt, param);
                double distanceThroughCurrent = current.minWeight + weight;
                if (distanceThroughCurrent < next.minWeight) {
                    next.minWeight = distanceThroughCurrent;
                    next.previous = current;
                    nodeQueue.add(next);
                }
//                System.out.println("------everyStep nodeQueue next" + next);
//                System.out.println("------everyStep nodeQueue"+nodeQueue);
            }
        }
    }

    private double getWeight(DeliveryTransport dt, SearchParam param) {
        switch (param) {
            case COST:
                return dt.getPrice();
            case DISTANCE:
                return dt.getDistance();
        }
        throw new IllegalArgumentException("Incorrect param type " + param);
    }

    // shortest path
    public List<PostOffice> getTransit(PostOffice dest) {
        List<PostOffice> path = new ArrayList<>();
        for (Node node = getByPostOffice(dest, nodes); node != null; node = node.previous) {
            path.add(node.current);
        }
        Collections.reverse(path);
        return path;
    }

    private void initNodes() {
        nodes.clear();
        nodes.addAll(postOffices.stream()
                .map(po -> this.new Node(po, INF, null))
                .collect(Collectors.toList()));
    }

    private Node getByPostOffice(PostOffice po, Collection<Node> nodeCollection) {
        for (Node n : nodeCollection) {
            if (n.current.equals(po)) {
                return n;
            }
        }
        return null;
    }

    public enum SearchParam {
        COST, DISTANCE
    }

    /****************************************************************************/
    final class Node {
        private PostOffice current;
        private double minWeight;
        private Node previous;
        private List<DeliveryTransport> relatedDT;

        public Node(PostOffice current, double minDistance, PostOffice previous) {
            this.current = current;
            this.minWeight = minDistance;
            this.previous = getByPostOffice(previous, nodes);
            this.relatedDT = relatedDeliveryTransports();
        }

        private List<DeliveryTransport> relatedDeliveryTransports() {
            List<DeliveryTransport> relatedDT = transitDeliveryTransports.stream()
                    .filter(dt -> dt.getStartPostOffice().equals(current))
                    .collect(Collectors.toList());
            return relatedDT;
        }

        @Override
        public String toString() {
            return "\nNode{" +
                    "current=" + current.getAddress().getCountry() +
                    ", \nminWeight=" + minWeight +
                    ", \nprevious=" + ((previous == null) ? "null" : previous.current) +
                    ", \nrelatedDT=" + relatedDT +
                    '}';
        }
    }


}
