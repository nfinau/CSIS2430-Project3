# Pseudocode – Programming Project 3 (Knapsack Problem)

## Team Information
- Naomi Finau (Verification Lead)
- Noah Kolling (Implementation Lead)
- Jackson (No participation)

---

## Overview
This document outlines the pseudocode for all implemented algorithms:
- Three Greedy Strategies
- Brute Force (Exhaustive Search)
- Dynamic Programming (concept + implementation)

---

## Greedy Strategy 1 – Highest Rating First

Sort items in descending order by rating

Initialize:
totalWeight = 0
selectedItems = empty list

For each item in sorted list:
If totalWeight + item.weight <= 700:
Add item to selectedItems
totalWeight += item.weight

Return selectedItems

---

## Greedy Strategy 2 – Lightest Weight First

Sort items in ascending order by weight

Initialize:
totalWeight = 0
selectedItems = empty list

For each item in sorted list:
If totalWeight + item.weight <= 700:
Add item to selectedItems
totalWeight += item.weight

Return selectedItems

---

## Greedy Strategy 3 – Best Rating-to-Weight Ratio

For each item:
Compute ratio = rating / weight

Sort items in descending order by ratio

Initialize:
totalWeight = 0
selectedItems = empty list

For each item in sorted list:
If totalWeight + item.weight <= 700:
Add item to selectedItems
totalWeight += item.weight

Return selectedItems

---

## Brute Force (Exhaustive Search)

bestSubset = empty
bestRating = 0

For each subset in all possible subsets (2^n):
totalWeight = sum of weights in subset
totalRating = sum of ratings in subset

If totalWeight <= 700 AND totalRating > bestRating:
    bestSubset = subset
    bestRating = totalRating
Return bestSubset

---

## Top 3 Subsets (Brute Force Extension)

validSubsets = empty list

For each subset:
If totalWeight <= 700:
Add subset to validSubsets

Sort validSubsets by totalRating (descending)

Return top 3 subsets

---

## Dynamic Programming (Optimal Solution)

Create DP table dp[n+1][capacity+1]

For i from 0 to n:
For w from 0 to capacity:
If i == 0 OR w == 0:
dp[i][w] = 0
Else if item[i].weight <= w:
dp[i][w] = max(
item[i].rating + dp[i-1][w - item[i].weight],
dp[i-1][w]
)
Else:
dp[i][w] = dp[i-1][w]

Reconstruct solution:
Start from dp[n][capacity]
Trace back selected items

Return optimal subset

---

## Summary

- Greedy algorithms use simple heuristics and run quickly
- Brute force guarantees correctness but is computationally expensive
- Dynamic programming efficiently finds the optimal solution
