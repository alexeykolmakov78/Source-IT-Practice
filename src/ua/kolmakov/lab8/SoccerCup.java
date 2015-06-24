package ua.kolmakov.lab8;

import java.util.*;

/**
 * Created by Kolmakov Alexey on 13.06.2015.
 */

// 2. В двух листах записаны результаты 20 игр двух футбольных команд (если игра окончилась выигрышем данной команды,
// то записано число 3, проигрышем— 0, если игра окончилась вничью— 1).
// Организовать заполнение листов и проверку корректности ввода значений. На основе имеющихся данных определить:
// а) суммарное количество баллов, которое заработала каждая команда:
// б) количество матчей, окончившихся победой, для каждой команды;
// в) вывести, какие игры команды могли провести совместно(на основании результатов).
// г) вывести комманды которые пиереходят на следующий этап соревнований (6 комманд)

public class SoccerCup {

    private static final int NUMBER_OF_MATCHES = 20;
    private static final List<String> TEAMS = Collections.unmodifiableList(new ArrayList<>(
            Arrays.asList("Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8", "Team 9", "Team10")
    ));

    private Map<String, Integer> rating;
    private List<Result> results;

    public SoccerCup() {
        this.results = new ArrayList<Result>();
        this.rating = new HashMap<String, Integer>();
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void createRating() {
        for (Iterator<Result> itr = results.iterator(); itr.hasNext(); ) {
            Result matchResult = itr.next();
            if (matchResult.goal1 > matchResult.goal2) {
                addRatingsPoints(matchResult.team1, 3);
            } else if (matchResult.goal1 < matchResult.goal2) {
                addRatingsPoints(matchResult.team2, 3);
            } else {
                // in case of drawn game
                addRatingsPoints(matchResult.team1, 1);
                addRatingsPoints(matchResult.team2, 1);
            }
        }
    }

    public Map<String, Integer> getRating() {
        SortedMap<String, Integer> result = new TreeMap<String, Integer>(new PointsComparator());
        result.putAll(rating);
        return result;
    }

    public int matchesWon(String team) {
        if (!TEAMS.contains(team)) {
            throw new IllegalArgumentException("There is no team \"" + team + "\" in the SoccerCup.");
        } else {
            int winCounter = 0;
            for (Iterator<Result> itr = results.iterator(); itr.hasNext(); ) {
                Result next = itr.next();
                if (next.team1.equals(team) && next.goal1 > next.goal2) {
                    winCounter++;
                } else if (next.team2.equals(team) && next.goal2 > next.goal1) {
                    winCounter++;
                }
            }
            return winCounter;
        }
    }

    public int getTeamPoints(String team) {
        if (!TEAMS.contains(team)) {
            throw new IllegalArgumentException("Illegal team");
        } else if (!rating.containsKey(team)) {
            return 0;
        } else {
            return rating.get(team);
        }
    }

    public List<String> getLeaders(int numberOfLeaders) {
        List<String> leaders = new ArrayList<>(getRating().keySet());
        return leaders.subList(0, numberOfLeaders);
    }

    public List<Result> generateRandomResults() {
        List<Result> res = new ArrayList<>(20);
        Random rnd = new Random();
        int matchCount = 0;
        while (matchCount < NUMBER_OF_MATCHES) {
            for (int index = 0; index < TEAMS.size() - 1; ) {
                String team1 = TEAMS.get(index);
                String team2 = TEAMS.get(++index);
                int goal1 = rnd.nextInt(7);
                int goal2 = rnd.nextInt(7);
                res.add(new Result(team1, team2, goal1, goal2));
                matchCount++;
                index++;
            }
        }
        return res;
    }

    private void addRatingsPoints(String team, int points) {
        if (!TEAMS.contains(team)) {
            throw new IllegalArgumentException("There is no team \"" + team + "\" in the SoccerCup.");
        }
        if (points != 1 && points != 3) {
            throw new IllegalArgumentException("Incorrect points value\"" + points + "\"");
        } else if (rating.containsKey(team)) {
            rating.put(team, (rating.get(team) + points));
        } else {
            rating.put(team, points);
        }
    }


    private final class Result  {
        private String team1;
        private String team2;
        private int goal1;
        private int goal2;

        public Result(String team1, String team2, int goal1, int goal2) {
            this.team1 = team1;
            this.team2 = team2;
            this.goal1 = goal1;
            this.goal2 = goal2;
        }

        @Override
        public String toString() {
            return "\n" + team1 + " : " + team2 + " === score: " + goal1 + " : " + goal2;
        }
    }

    private final class PointsComparator implements Comparator {
        @Override
        public int compare(Object k1, Object k2) {
            if ((k1.getClass() != String.class) || (k2.getClass() != String.class)) {
                throw new IllegalArgumentException("The key must be a String");
            } else if (!rating.containsKey(k1) || !rating.containsKey(k2)) {
                throw new IllegalArgumentException("There are no such keys \'" + k1 + "\" or \"" + k2 + "\" in the Map");
            } else {
                return (rating.get(k2) == rating.get(k1))
                        ? ((String) k1).compareTo((String) k2)
                        : rating.get(k2) - rating.get(k1);
            }
        }
    }
}
