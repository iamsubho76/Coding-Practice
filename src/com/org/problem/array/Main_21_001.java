package com.org.problem.array;

/**
 *Given an array A[] and a number x, check for pair in A[] with sum as x
 *Write a C program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.

 * 
 *Time Complexity: Depends on what sorting algorithm we use. If we use Merge Sort or Heap Sort then (-)(nlogn) in worst case. If we use Quick Sort then O(n^2) in worst case.
 *Auxiliary Space : Again, depends on sorting algorithm. For example auxiliary space is O(n) for merge sort and O(1) for Heap Sort.

 *Example:
 *Let Array be {1, 4, 45, 6, 10, -8} and sum to find be 16

 *Sort the array
 *A = {-8, 1, 4, 6, 10, 45}

 *Initialize l = 0, r = 5
 *A[l] + A[r] ( -8 + 45) > 16 => decrement r. Now r = 10
 *A[l] + A[r] ( -8 + 10) < 2 => increment l. Now l = 1
 *A[l] + A[r] ( 1 + 10) < 16 => increment l. Now l = 2
 *A[l] + A[r] ( 4 + 10) < 14 => increment l. Now l = 3
 *A[l] + A[r] ( 6 + 10) == 16 => Found candidates (return 1)

 *Note: If there are more than one pair having the given sum then this algorithm reports only one. Can be easily extended for this though.
 */

public class Main_21_001 {
	private static final int MAX = 100000; // Max size of Hashmap
	// main function
	public static void main(String args[]) {
		//Method-1 start
		/*int A1[] = { 1, 4, 45, 6, 10, -8 };
		int n1 = 16;
		int arr_size = 6;

		if (hasArrayTwoCandidates(A1, arr_size, n1))
			System.out.println("Array has two " + "elements with sum 16");
		else
			System.out.println("Array doesn't have " + "two elements with sum 16 ");*/
		//end
		//Start Method-2
		 int A2[] = {1, 4, 45, 6, 10, 8};
	     int n2 = 16;
	     printpairs(A2,  n2);
	     //end
	}

	//Method-1 approach from line number 41 to 111
	static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
		int l, r;

		/* Sort the elements */
		sort(A, 0, arr_size - 1);

		/*
		 * Now look for the two candidates in the sorted array
		 */
		l = 0;
		r = arr_size - 1;
		while (l < r) {
			if (A[l] + A[r] == sum)
				return true;
			else if (A[l] + A[r] < sum)
				l++;
			else // A[i] + A[j] > sum
				r--;
		}
		return false;
	}

	/*
	 * Below functions are only to sort the array using QuickSort
	 */

	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	static void sort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	static int partition(int arr[], int low, int high) {
		int pivot = arr[high];

		// index of smaller element
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}
	
	//Method-2 approach from line number 121 to 140
	static void printpairs(int arr[],int sum)
    {
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[MAX];
 
        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];
 
            // checking for condition
            if (temp>=0 && binmap[temp])
            {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", "+temp+")");
            }
            binmap[arr[i]] = true;
        }
    }
}
