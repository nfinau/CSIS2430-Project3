import java.util.List;

/**
 * Team Name: Naomi
 * Team Members: Naomi Finau
 * Course: CSIS 2430
 * Project: Programming Project 3 - The Knapsack Problem
 * Primary Author: Naomi Finau 
 *
 * Runs all required project outputs:
 * 1. Three greedy strategies
 * 2. Brute-force optimal
 * 3. Comparison summary
 * 4. Dynamic programming optimal 
 */
public class Main {
    public static void main(String[] args) {
        List<Payload> payloads = KnapsackSolver.buildDefaultPayloads();

        KnapsackResult highestRating = KnapsackSolver.greedyHighestRatingFirst(payloads);
        KnapsackResult lightest = KnapsackSolver.greedyLightestFirst(payloads);
        KnapsackResult bestRatio = KnapsackSolver.greedyBestRatioFirst(payloads);

        long bruteStart = System.nanoTime();
        List<KnapsackResult> topThree = KnapsackSolver.bruteForceTopThree(payloads);
        KnapsackResult bruteForceOptimal = topThree.get(0);
        long bruteEnd = System.nanoTime();

        long dpStart = System.nanoTime();
        KnapsackResult dpOptimal = KnapsackSolver.dynamicProgrammingOptimal(payloads);
        long dpEnd = System.nanoTime();

        System.out.println("==========================================");
        System.out.println("PROJECT 3 - THE KNAPSACK PROBLEM");
        System.out.println("==========================================");
        System.out.println();

        highestRating.printDetailed();
        lightest.printDetailed();
        bestRatio.printDetailed();

        System.out.println("==========================================");
        System.out.println("BRUTE FORCE OPTIMAL");
        System.out.println("==========================================");
        bruteForceOptimal.printDetailed();

        KnapsackSolver.printTopThree(topThree);

        System.out.println("==========================================");
        System.out.println("DYNAMIC PROGRAMMING OPTIMAL (EXTRA CREDIT)");
        System.out.println("==========================================");
        dpOptimal.printDetailed();

        KnapsackSolver.printComparisonSummary(
            highestRating,
            lightest,
            bestRatio,
            bruteForceOptimal,
            dpOptimal
        );

        System.out.println("==========================================");
        System.out.println("RUNTIME COMPARISON");
        System.out.println("==========================================");
        System.out.println("Brute Force runtime (ns): " + (bruteEnd - bruteStart));
        System.out.println("Dynamic Programming runtime (ns): " + (dpEnd - dpStart));
        System.out.println();
        System.out.println("Expected answer notes:");
        System.out.println("- Brute force gives the true optimal subset.");
        System.out.println("- Dynamic programming should match brute force.");
        System.out.println("- Greedy methods may or may not match the optimal subset.");
    }
}
