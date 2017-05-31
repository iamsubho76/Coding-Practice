package com.org.coding.arrays;

/*Sort an array of 0s, 1s and 2s
	Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
	
	Example
	Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
	Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
	The problem is similar to our old post Segregate 0s and 1s in an array, and both of these problems are variation of famous Dutch national flag problem.
	
	The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections:
	
	a[1..Lo-1] zeroes (red)
	a[Lo..Mid-] ones (white)
	a[Mid..Hi] unknown
	a[Hi+1..N] twos (blue)
	The unknown region is shrunk while maintaining these conditions
	
	Lo := 1; Mid := 1; Hi := N;
	while Mid <= Hi do
	Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
	case a[Mid] in
	0: swap a[Lo] and a[Mid]; Lo++; Mid++
	1: Mid++
	2: swap a[Mid] and a[Hi]; Hi–
	— Dutch National Flag Algorithm, or 3-way Partitioning —
	
	Part way through the process, some red, white and blue elements are known and are in the “right” place. The section of unknown elements, a[Mid..Hi], is shrunk by examining a[Mid]:
	0 0 0 1 1 1 ? ? ? ? 2 2 2
		  ^	    ^     ^
		  Lo   Mid   Hi
		  
	  Examine a[Mid]. There are three possibilities: 
		  a[Mid] is (0) red, (1) white or (2) blue.
		  Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++
		  
	0 0 0 0 1 1 1 ? ? ? 2 2 2
			^	  ^   ^
			Lo   Mid  Hi
	
	Case (1) a[Mid] is white, Mid++
	
	0 0 0 1 1 1 1 ? ? ? 2 2 2
		  ^	      ^   ^
		  Lo     Mid Hi
		  
    Case (2) a[Mid] is blue, swap a[Mid] and a[Hi]; Hi-
    
    0 0 0 1 1 1 ? ? ? 2 2 2 2
          ^     ^   ^
          Lo   Mid  Hi
    
    Continue until Mid>Hi.
*/


public class Segregrate_0s_n_1s_2s {
    // Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
    static void sort012(int a[], int arr_size)
    {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (a[mid])
            {
            case 0:
            {
                temp   =  a[lo];
                a[lo]  = a[mid];
                a[mid] = temp;
                lo++;
                mid++;
                break;
            }
            case 1:
                mid++;
                break;
            case 2:
            {
                temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
                break;
            }
            }
        }
    }
 
    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }
}
