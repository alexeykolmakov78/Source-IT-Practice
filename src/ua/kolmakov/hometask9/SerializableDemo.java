package ua.kolmakov.hometask9;

/**
 * Created by Kolmakov Alexey on 13.06.2015.
 */

public class SerializableDemo {

    public static void main(String[] args) {
        SerializableSoccerCup soccer = new SerializableSoccerCup();
        soccer.setResults(soccer.generateRandomResults());
        soccer.createRating();

        if (soccer.saveData()) {
            System.out.println("saveData success");
        } else {
            System.out.println("saveData failed");
        }

        SerializableSoccerCup soccer1 = new SerializableSoccerCup();

        if(soccer1.loadData()!=null){
            soccer1 = soccer.loadData();
            System.out.println("loadData success");
        }else {
            System.out.println("loadData failed");
        }

            System.out.println("Results of 20 matches:" + soccer1.getResults());
            System.out.println("=================================");
            System.out.println("Rating of 10 teams:" + soccer1.getRating());
            System.out.println("=================================");
            System.out.println("The team \"Team 1\" have " + soccer1.getTeamPoints("Team 1") + " points.");
            System.out.println("The team \"Team 8\" have " + soccer1.getTeamPoints("Team 8") + " points.");
            System.out.println("=================================");
            System.out.println("The team \"Team 1\" won " + soccer1.matchesWon("Team 1") + " times.");
            System.out.println("The team \"Team 8\" won " + soccer1.matchesWon("Team 8") + " times.");
            System.out.println("=================================");
            System.out.println("The six leaders of the Cup:" + soccer1.getLeaders(6));
        }

    }
