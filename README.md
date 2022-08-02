# FANG

## Array
### Reverse/Rotate the array

- Reverse integer (without using long) - https://leetcode.com/problems/reverse-integer/
   ```
   tricky if you can't store the output in long, overflow cases are important
   temp = rev * 10 + pop; statement can cause overflow.
   
   Integer.MIN_VALUE = -2147483648  , Integer.MAX_VALUE = 2147483647
   
   
   if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0; // why 7 ? because due to max value
   if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0; // why -8 ? because due to min value
   ```
- Reverse string recursively
    ```
   return reverse(str.substring(1)) + str.charAt(0);
   ```
- Reverse Words in a String - https://leetcode.com/problems/reverse-words-in-a-string-iii/

- Write a program to cyclically rotate an array by one. - Reversal algorithm - https://leetcode.com/problems/rotate-array/
   ```
   //reverse complete array
   reverse(nums, 0, nums.length - 1);
   //reverse k elements
   reverse(nums, 0, k - 1);
   //reverse k to n elements
   reverse(nums, k, nums.length - 1);
   ```
Similar
- Reverse Only Letters - https://leetcode.com/problems/reverse-only-letters/   

### SubArray - sliding window
- Kadane’s Algorithm - Maximum Subarray
   ```
   max_end_here=Math.max(num,max_end_here+num);        
   max_so_far=Math.max(max_so_far,max_end_here);
   ```
- Best Time to Buy and Sell Stock - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ - Similar to kadane's algo
- Find subarray with given sum (Non negative Numbers) | ContinuousSubArrayWithGivenSum | [sliding window, preSum]
- Find subarray with given sum (Negative Numbers) | SubarrayWithGivenSum | [preSum]
    -   Note  :- It can be done only using preSum not with sliding window
- Subarray Sum Equals K - total number of continuous subarrays whose sum equals to k | SubarraySumEqualsK | [preSum, frequency map]
- Merge two sorted array without extra space
- Rearrange Array Alternately in O(1) space
- Sort an array of 0s, 1s and 2s
- Best Time to Buy and Sell Stock [Kadane's Problem]

## Matrix
1. UniquePaths
2. MaxAreaOfIsland

## Binary Search
1. Binary Search
2. Find First and Last Position of Element in Sorted Array
3. Search in sorted rotated array
4. Search in sorted rotated array with duplicates
5. Find minimum in rotated sorted array

## Stack
1. Next Greater to left/ Next smallest to left 
2. Next smallest to right / Next Greater to right
3. Stock Span Problem
4. Maximum area of Histogram
5. Maximum area of rectangle in binary matrix
6. Rain water trapping
7. Implement MinStack
8. Implement stack using Heap
9. The celebrity problem
10. longest valid parenthesis
11. Iterative TOH

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
3. Post-order traversal - iteratively using one stack and 2 stacks
4. Level order traversal - (push before while loop)
5. Left/Right view - iteratively(using level order) and recursively
6. Maximum Depth of Binary Tree
   1. "Bottom-up" Solution >> postOrder traversal | bottom_up(root)
   2. "Top-down" Solution >> preOrder traversal | top_down(root, params)
7. Balanced Binary Tree (left_height-right_height <=1)
8. Diameter of Binary Tree
9. Basic recursion
   1. Children sum parent 
   2. Symmetric Tree
   3. Sum of Left Leaves - Imp
10. Root to leaf path - concept is important
    1. Path Sum
    2. Path Sum II
11. Vertical order traversal - level order + hd (horizontal distance)
12. Vertical order traversal II - with sorted node values if are on same level
13. Construct Binary Tree from Inorder and Postorder Traversal
14. Construct Binary Tree from Preorder and Inorder Traversal
15. TODO
    1. top view
    2. bottom view
    
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

## Recursion / Backtracking
1. Subsets 
2. Subset Sum
3. Combiantions 
4. Combiantions III 
5. Subset II 
6. Combination Sum II 
7. Combination Sum 
8. Permutation 
9. Permutation II 
10. Generate Parentheses 
11. Letter Combinations of a Phone Number 
12. Palindrome Partitioning 
13. Permutations

# TODO
- FindPeakElement
- RemoveDuplicatesFromSortedList_II

#Notes
- sliding window will work for positive numbers only ..but if there negative numbers are also present then it will not 
   work.. in that case you can use hashmap to solve the problem
- Because let's say in the given array [4,1,1,1,2,3,5] when we found the sum within the window to be greater than the 
   desired value 5 (i=0, j=2 -> [4,1,1]), we started reducing the size of the window by doing i++. 
   Here we assumed that once the sum of elements within the window becomes greater than 5 then increasing the window size 
   will just add to the sum and hence we will not attain the sum 5 again. This is true when all the element are positive 
   and hence reducing the window size by doing i++ makes sense. But this might not be true if array also contains negative 
   numbers. Consider the array [4,1,1,-2,1,5], here we would have found the sum to be greater than 5 for i=0, j=2 and if 
   we would have now started reducing the window size by doing i++, we would have missed the potential subarray (i=0, j=4).
   In short, the discussed approach will not work with array having negative numbers.

# Cheat Sheet
```java
Queue<TreeNode> queue = new LinkedList<>();
```

