# FANG

## Array
1. Find subarray with given sum (Non negative Numbers) | ContinuousSubArrayWithGivenSum | [sliding window, preSum]
2. Find subarray with given sum (Negative Numbers) | SubarrayWithGivenSum | [preSum]
    -   Note  :- It can be done only using preSum not with sliding window
3. Subarray Sum Equals K - total number of continuous subarrays whose sum equals to k | SubarraySumEqualsK | [preSum, frequency map]
4. Merge two sorted array without extra space
5. Rearrange Array Alternately in O(1) space
6. Sort an array of 0s, 1s and 2s
7. Best Time to Buy and Sell Stock [Kadane's Problem]

## Binary Search
1. Binary Search
2. Find First and Last Position of Element in Sorted Array
3. Search in sorted rotated array
4. Search in sorted rotated array with duplicates
5. Find minimum in rotated sorted array

## Sliding Window
### Fixed Size Window
1. Max sum of 'k' consecutive elements in the array
2. Ist -ve number in every window of Size K - use queue
3. Count occurrences of Anagrams :- Here ptr string len is K
4. Maximum of all subarrays of size k | Sliding Window Maximum
### Variable Size Window
1. Longest Subarray of sum K
2. Longest Substring With K Unique Characters

## String
1. Reverse words in a given string
2. Permutations of a given string

## Binary Tree
1. In order traversal - iteratively
2. Pre-order traversal - iteratively (push before while loop)
3. Level order traversal - (push before while loop)
4. Left/Right view
5. Maximum Depth of Binary Tree
6. Balanced Binary Tree (left_height-right_height <=1)
7. Diameter of Binary Tree
8. Children sum parent
9. Root to leaf path - concept is important
   1. Path Sum
   2. Path Sum II
    
## Heap - Priority Queue
1. Kth Largest Element in an Array

## Dynamic Programming
1. 0-1 knapsack
   1. Subset Sum
   2. Equal sum partition
   3. Count of subset sum with a given sum
   4. Minimum subset sum difference
   5. Count the number of subset with a given difference
   6. Target Sum
2. Unbounded knapsack
   1. Rod cutting problem
   2. Coin change problem - Maximum number of ways
   3. Coin change problem - Minimum number of ways
   4. Ribbon cut problem
3. Fibonacci
4. LCS
5. LIS
6. Kadane's algorithm
7. Matrix chain multiplication
8. DP on trees
9. DP on grids

#Notes
-  sliding window will work for positive numbers only ..but if there negative numbers are also present then it will not 
   work.. in that case you can use hashmap to solve the problem
-  Because let's say in the given array [4,1,1,1,2,3,5] when we found the sum within the window to be greater than the 
   desired value 5 (i=0, j=2 -> [4,1,1]), we started reducing the size of the window by doing i++. 
   Here we assumed that once the sum of elements within the window becomes greater than 5 then increasing the window size 
   will just add to the sum and hence we will not attain the sum 5 again. This is true when all the element are positive 
   and hence reducing the window size by doing i++ makes sense. But this might not be true if array also contains negative 
   numbers. Consider the array [4,1,1,-2,1,5], here we would have found the sum to be greater than 5 for i=0, j=2 and if 
   we would have now started reducing the window size by doing i++, we would have missed the potential subarray (i=0, j=4).
   In short, the discussed approach will not work with array having negative numbers.

