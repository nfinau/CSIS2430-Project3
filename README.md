# CSIS2430 Project 3 - The Knapsack Problem

---

## How to Run the Program

1. Open the project in Eclipse
2. Ensure `src` is marked as a source folder
3. Locate `Main.java`
4. Right-click → Run As → Java Application

---

## Algorithms Implemented

### Greedy Strategies
1. Highest Rating First
2. Lightest Weight First
3. Best Rating-to-Weight Ratio

### Brute Force
- Evaluates all possible subsets (2¹² = 4096)
- Guarantees optimal solution

### Dynamic Programming (Extra Credit)
- Efficiently computes optimal solution using DP table
- Matches brute force optimal result with better performance

---

## Results Summary

- Greedy strategies produced valid but **not always optimal** solutions
- Brute force identified the **true optimal subset**
- Dynamic programming matched brute force results
- Demonstrated trade-offs between speed and optimality

---

## Verification Evidence

- Program was executed successfully for all strategies
- Output includes:
  - Selected experiments
  - Total weight
  - Total rating
  - Top 3 brute force subsets
  - Comparison summary

See:
- `docs/test_results.md`
- `docs/knapsack_output.png`

---

## Key Observations

- Greedy algorithms are fast but can miss optimal solutions
- Brute force guarantees correctness but is computationally expensive
- Dynamic programming provides the best balance of efficiency and optimality

---

## Notes

- All experiments were treated as indivisible (0/1 selection)
- No runtime or compilation errors were encountered
- Edge cases (weight constraints) were properly handled

---

## Contribution Summary

- Naomi:
  - Implementation lead
  - Verification lead
  - Testing and validation
  - Output analysis and documentation
  - Evidence collection (screenshots + results)


---
