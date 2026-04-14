import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Team Name: Naomi
 * Team Members: Naomi Finau
 * Course: CSIS 2430
 * Project: Programming Project 3 - The Knapsack Problem
 * Primary Author: Naomi Finau
 *
 * Contains the greedy, brute-force, and dynamic programming solutions.
 */
public class KnapsackSolver {
    public static final int MAX_WEIGHT = 700;

    public static KnapsackResult greedyHighestRatingFirst(List<Payload> payloads) {
        List<Payload> sorted = new ArrayList<>(payloads);
        sorted.sort(
            Comparator.comparingInt(Payload::getRating).reversed()
                .thenComparingInt(Payload::getWeight)
                .thenComparing(Payload::getName)
        );

        return buildGreedyResult("Greedy Strategy 1 - Highest Rating First", sorted);
    }

    public static KnapsackResult greedyLightestFirst(List<Payload> payloads) {
        List<Payload> sorted = new ArrayList<>(payloads);
        sorted.sort(
            Comparator.comparingInt(Payload::getWeight)
                .thenComparing(Comparator.comparingInt(Payload::getRating).reversed())
                .thenComparing(Payload::getName)
        );

        return buildGreedyResult("Greedy Strategy 2 - Lightest First", sorted);
    }

    public static KnapsackResult greedyBestRatioFirst(List<Payload> payloads) {
        List<Payload> sorted = new ArrayList<>(payloads);
        sorted.sort(
            Comparator.comparingDouble(Payload::getRatio).reversed()
                .thenComparing(Comparator.comparingInt(Payload::getRating).reversed())
                .thenComparingInt(Payload::getWeight)
                .thenComparing(Payload::getName)
        );

        return buildGreedyResult("Greedy Strategy 3 - Best Rating-to-Weight Ratio", sorted);
    }

    private static KnapsackResult buildGreedyResult(String name, List<Payload> ordered) {
        List<Payload> chosen = new ArrayList<>();
        int currentWeight = 0;

        for (Payload p : ordered) {
            if (currentWeight + p.getWeight() <= MAX_WEIGHT) {
                chosen.add(p);
                currentWeight += p.getWeight();
            }
        }

        return new KnapsackResult(name, chosen);
    }

    public static List<KnapsackResult> bruteForceTopThree(List<Payload> payloads) {
        List<KnapsackResult> validResults = new ArrayList<>();
        int n = payloads.size();

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Payload> chosen = new ArrayList<>();
            int totalWeight = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    Payload p = payloads.get(i);
                    totalWeight += p.getWeight();
                    chosen.add(p);
                }
            }

            if (totalWeight <= MAX_WEIGHT) {
                validResults.add(new KnapsackResult("Brute Force Candidate", chosen));
            }
        }

        validResults.sort(
            Comparator.comparingInt(KnapsackResult::getTotalRating).reversed()
                .thenComparingInt(KnapsackResult::getTotalWeight)
        );

        return validResults.subList(0, Math.min(3, validResults.size()));
    }

    public static KnapsackResult bruteForceOptimal(List<Payload> payloads) {
        return bruteForceTopThree(payloads).get(0);
    }

    public static KnapsackResult dynamicProgrammingOptimal(List<Payload> payloads) {
        int n = payloads.size();
        int[][] dp = new int[n + 1][MAX_WEIGHT + 1];

        for (int i = 1; i <= n; i++) {
            Payload current = payloads.get(i - 1);
            for (int w = 0; w <= MAX_WEIGHT; w++) {
                dp[i][w] = dp[i - 1][w];

                if (current.getWeight() <= w) {
                    int includeValue = current.getRating() + dp[i - 1][w - current.getWeight()];
                    if (includeValue > dp[i][w]) {
                        dp[i][w] = includeValue;
                    }
                }
            }
        }

        List<Payload> selected = new ArrayList<>();
        int w = MAX_WEIGHT;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Payload chosen = payloads.get(i - 1);
                selected.add(chosen);
                w -= chosen.getWeight();
            }
        }

        java.util.Collections.reverse(selected);
        return new KnapsackResult("Dynamic Programming Optimal", selected);
    }

    public static void printComparisonSummary(
        KnapsackResult highestRating,
        KnapsackResult lightest,
        KnapsackResult ratio,
        KnapsackResult bruteForce,
        KnapsackResult dynamic
    ) {
        System.out.println("==========================================");
        System.out.println("COMPARISON SUMMARY");
        System.out.println("==========================================");

        printCompact(highestRating);
        printCompact(lightest);
        printCompact(ratio);
        printCompact(bruteForce);
        printCompact(dynamic);

        System.out.println();
        System.out.println("Greedy strategies compared to brute-force optimal:");

        compareGreedy(highestRating, bruteForce);
        compareGreedy(lightest, bruteForce);
        compareGreedy(ratio, bruteForce);

        System.out.println();
    }

    private static void printCompact(KnapsackResult result) {
        System.out.println(result.getStrategyName());
        System.out.println("  Total weight: " + result.getTotalWeight() + " kg");
        System.out.println("  Total rating: " + result.getTotalRating());
    }

    private static void compareGreedy(KnapsackResult greedy, KnapsackResult optimal) {
        boolean matched = greedy.sameSelection(optimal);
        System.out.println("- " + greedy.getStrategyName() + ": "
            + (matched ? "MATCHED the optimal subset" : "did NOT match the optimal subset"));
    }

    public static void printTopThree(List<KnapsackResult> topThree) {
        System.out.println("==========================================");
        System.out.println("TOP 3 VALID SUBSETS (BRUTE FORCE)");
        System.out.println("==========================================");

        for (int i = 0; i < topThree.size(); i++) {
            KnapsackResult result = topThree.get(i);
            System.out.println("Rank #" + (i + 1));
            result.printDetailed();
        }
    }

    public static List<Payload> buildDefaultPayloads() {
        return Arrays.asList(
            new Payload(1, "Cloud Patterns", 36, 5),
            new Payload(2, "Solar Flares", 264, 9),
            new Payload(3, "Solar Power", 188, 6),
            new Payload(4, "Binary Stars", 203, 8),
            new Payload(5, "Relativity", 104, 8),
            new Payload(6, "Seed Viability", 7, 4),
            new Payload(7, "Sun Spots", 90, 2),
            new Payload(8, "Mice Tumors", 65, 8),
            new Payload(9, "Microgravity Plant Growth", 75, 5),
            new Payload(10, "Micrometeorites", 170, 9),
            new Payload(11, "Cosmic Rays", 80, 7),
            new Payload(12, "Yeast Fermentation", 27, 4)
        );
    }

    /*
     * Dynamic Programming idea (required even if not implemented):
     *
     * Let dp[i][w] represent the best total rating we can get using the first i
     * payloads with capacity w.
     *
     * Transition:
     * - Do not take payload i: dp[i][w] = dp[i-1][w]
     * - Take payload i if its weight fits:
     *   dp[i][w] = max(dp[i][w], rating_i + dp[i-1][w - weight_i])
     *
     * The final answer is dp[n][700].
     * We can reconstruct the chosen subset by walking backward through the table.
     */
}
