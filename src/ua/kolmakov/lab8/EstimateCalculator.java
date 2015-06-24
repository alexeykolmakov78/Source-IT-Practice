package ua.kolmakov.lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Kolmakov Alexey on 13.06.2015.
 */
public class EstimateCalculator {
    private static final int NUM_OF_JUDGE = 8;
    private List<Integer> estimates;

    public EstimateCalculator() {
        estimates = randomEstimates();
        System.out.println("Estimates created: " + estimates);
    }

    public EstimateCalculator(List estimates) {
        this.estimates = estimates;
    }

    public int avgEstimate() {
        Integer maxEstimate = Collections.max(estimates);
        Integer minEstimate = Collections.min(estimates);
        Integer sumEstimate = 0;
        List<Integer> tmp = new ArrayList<>(estimates);
        Collections.copy(tmp, estimates);
        tmp.remove(maxEstimate);
        tmp.remove(minEstimate);
        // additional info
        System.out.println("***** remove " + maxEstimate + " & " + minEstimate);
        //
        for (Integer each : tmp) {
            sumEstimate += each;
        }
        return sumEstimate / tmp.size();
    }

    private List<Integer> randomEstimates() {
        List<Integer> result = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < NUM_OF_JUDGE; i++)
            result.add(rnd.nextInt(10) + 1);
        return result;
    }
}
