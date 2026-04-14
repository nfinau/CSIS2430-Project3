import java.util.ArrayList;
import java.util.List;

/**
 * Team Name: Naomi
 * Team Members: Naomi Finau
 * Course: CSIS 2430
 * Project: Programming Project 3 - The Knapsack Problem
 * Primary Author: Naomi Finau 
 *
 * Stores the result of a knapsack strategy.
 */
public class KnapsackResult {
    private final String strategyName;
    private final List<Payload> selected;
    private final int totalWeight;
    private final int totalRating;

    public KnapsackResult(String strategyName, List<Payload> selected) {
        this.strategyName = strategyName;
        this.selected = new ArrayList<>(selected);

        int weightSum = 0;
        int ratingSum = 0;
        for (Payload p : selected) {
            weightSum += p.getWeight();
            ratingSum += p.getRating();
        }

        this.totalWeight = weightSum;
        this.totalRating = ratingSum;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public List<Payload> getSelected() {
        return new ArrayList<>(selected);
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public boolean sameSelection(KnapsackResult other) {
        if (other == null || selected.size() != other.selected.size()) {
            return false;
        }

        List<Integer> thisIds = new ArrayList<>();
        List<Integer> otherIds = new ArrayList<>();

        for (Payload p : selected) {
            thisIds.add(p.getId());
        }
        for (Payload p : other.selected) {
            otherIds.add(p.getId());
        }

        java.util.Collections.sort(thisIds);
        java.util.Collections.sort(otherIds);

        return thisIds.equals(otherIds);
    }

    public void printDetailed() {
        System.out.println(strategyName);
        System.out.println("Chosen experiments:");
        for (Payload p : selected) {
            System.out.println("  - " + p);
        }
        System.out.println("Total weight: " + totalWeight + " kg");
        System.out.println("Total rating: " + totalRating);
        System.out.println();
    }
}
