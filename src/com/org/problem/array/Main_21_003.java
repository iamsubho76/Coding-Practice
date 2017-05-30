package com.org.problem.array;

public class Main_21_003 {
	/*Find the Number Occurring Odd Number of Times
	Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. 
	Find the number in O(n) time & constant space.

	Example:
	I/P = [1, 2, 3, 2, 3, 1, 3]
	O/P = 3
	A Simple Solution is to run two nested loops. The outer loop picks all elements one by one and inner loop counts number of 
	occurrences of the element picked by outer loop. Time complexity of this solution is O(n2).

	A Better Solution is to use Hashing. Use array elements as key and their counts as value. Create an empty hash table. 
	One by one traverse the given array elements and store counts. Time complexity of this solution is O(n). But it requires extra space for hashing.

	The Best Solution is to do bitwise XOR of all the elements. XOR of all elements gives us odd occurring element. 
	Please note that XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
	*/
    int getOddOccurrence(int ar[], int ar_size) 
    {
        int i;
        int res = 0;
        for (i = 0; i < ar_size; i++) 
        {
            res = res ^ ar[i];
        }
        return res;
    }
 
    public static void main(String[] args) 
    {
    	Main_21_003 occur = new Main_21_003();
        int ar[] = new int[]{1, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 1};
        int n = ar.length;
        System.out.println(occur.getOddOccurrence(ar, n));
    }
}
