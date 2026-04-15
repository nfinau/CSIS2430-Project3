# Test Plan – Programming Project 3 (Knapsack Problem)

## Team Information
- Naomi Finau (Implementation Lead, Verification Lead, Communications Lead)
  
---

## Objective
The purpose of this test plan is to verify that all implemented algorithms correctly:
- Respect the 700 kg weight constraint
- Accurately calculate total weight and total rating
- Produce valid subsets of experiments
- Correctly identify optimal and non-optimal solutions

---

## Test Environment
- Language: Java
- IDE: Eclipse
- Runtime: Java SE 8 (jre1.8.0_421)
- Platform: Windows

---

## Test Cases

### Test Case 1: Basic Execution
**Description:** Run the program without modification  
**Expected Result:**
- Program runs successfully with no errors
- All algorithm outputs are displayed
- No crashes or exceptions

---

### Test Case 2: Weight Constraint Validation
**Description:** Verify that all selected subsets do not exceed 700 kg  
**Expected Result:**
- Every strategy output has total weight ≤ 700 kg
- No invalid overweight combinations are included

---

### Test Case 3: Greedy Strategy Output
**Description:** Validate correctness of greedy algorithms  
**Expected Result:**
- Each greedy strategy produces a valid subset
- Total weight and rating are calculated correctly
- Results differ between strategies

---

### Test Case 4: Brute Force Optimality
**Description:** Verify brute force finds the best solution  
**Expected Result:**
- Highest total rating among all subsets is identified
- Output includes:
  - Optimal subset
  - Top 3 valid subsets
- Matches expected optimal solution

---

### Test Case 5: Dynamic Programming Verification
**Description:** Compare DP result to brute force result  
**Expected Result:**
- DP solution matches brute force optimal subset
- Total weight and rating are identical

---

### Test Case 6: Output Formatting
**Description:** Ensure output is readable and structured  
**Expected Result:**
- Clear labels for each algorithm
- Proper formatting of:
  - Experiment lists
  - Weight and rating totals
- Sections are easy to distinguish

---

## Edge Case Testing

### Edge Case 1: Near Capacity Limit
**Description:** Verify behavior near 700 kg boundary  
**Expected Result:**
- Subsets stay within limit without exceeding
- Program handles tight constraints correctly

---

### Edge Case 2: Small Weight Items
**Description:** Ensure small-weight experiments are handled correctly  
**Expected Result:**
- Multiple small items can be combined properly
- No rounding or calculation errors

---

### Edge Case 3: Ratio-Based Sorting
**Description:** Validate rating-to-weight ratio calculations  
**Expected Result:**
- Ratio values are accurate
- Sorting order is correct
- No division or precision errors

---

## Verification Method

Verification was completed by:
- Running the program in Eclipse
- Reviewing console output for correctness
- Comparing:
  - Greedy vs brute force results
  - DP vs brute force results
- Capturing output screenshot for evidence

---

## Evidence

- Full output screenshot:
  - `docs/knapsack_output.png`

- Detailed results:
  - `docs/test_results.md`

---

## Conclusion

All implemented algorithms:
- Execute successfully
- Produce valid subsets
- Respect constraints
- Demonstrate expected behavior

The brute force and dynamic programming approaches correctly identify the optimal solution, while greedy strategies provide valid but non-optimal results.
