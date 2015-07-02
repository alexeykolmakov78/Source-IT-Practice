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

    static Queue<Node> nodeQueue = new PriorityQueue<>((n1, n2) -> (int) (n2.minDistance - n1.minDistance));

    public static Dijkstra getDijkstra() {
        Dijkstra dijkstra = new Dijkstra();
        initNodes(dijkstra);
        return dijkstra;
    }

    private Dijkstra() {
        postOffices = Storage.getInstance().getById("postOffices");
        transitDeliveryTransports = Storage.getInstance().getById("deliveryTransports");
        nodes = new ArrayList<>();
    }

    public void search(PostOffice start, Dijkstra.SearchParam param) {
        Node startNode = getByPostOffice(start, nodes);
        startNode.minDistance = 0;
        nodeQueue.add(startNode);
        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.poll();
            List<DeliveryTransport> curRelatedDT = current.relatedDeliveryTransports();
            for (DeliveryTransport dt : curRelatedDT) {
                Node next = getByPostOffice(dt.getDestinationPostOffice(), nodes);
                // in case of searching cheapest transit
                // todo changes to ensure different types of weight(coast, distance, time)
//                double weight = dt.getPrice();
                // in case of searching shortest transit
//                double weight = dt.getDistance();
                double weight = getWeight(dt, param);
                double distanceThroughCurrent = current.minDistance + weight;
                if (distanceThroughCurrent < next.minDistance) {
                    nodeQueue.remove(next);
                    next.minDistance = distanceThroughCurrent;
                    next.previous = current;
                    nodeQueue.add(next);
                }
            }
        }
    }

    private double getWeight(DeliveryTransport dt, SearchParam param) {
        switch (param){
            case COST:
                return dt.getPrice();
            case DISTANCE:
                return dt.getDistance();
        }


        return 0;
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

    private static void initNodes(Dijkstra dijkstra) {
        nodes.addAll(postOffices.stream()
                .map(po -> dijkstra.new Node(po, INF, null))
                .collect(Collectors.toList()));
    }

    private Node getByPostOffice(PostOffice po, Collection <Node> nodeCollection) {
        for (Node n : nodeCollection) {
            if (n.current.equals(po)) {
                return n;
            }
        }
        return null;
    }

    public enum SearchParam{
        COST, DISTANCE
    }

    /****************************************************************************/
    final class Node {
        private PostOffice current;
        private double minDistance;
        private Node previous;
        private List<DeliveryTransport> relatedDT;

        public Node(PostOffice current, double minDistance, PostOffice previous) {
            this.current = current;
            this.minDistance = minDistance;
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
                    "current=" + current +
                    ", minDistance=" + minDistance +
                    ", previous=" + previous +
                    ", relatedDT=" + relatedDT +
                    '}';
        }
    }


}
