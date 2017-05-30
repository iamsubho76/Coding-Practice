package com.org.problem.array;

import java.util.HashMap;
import java.util.Map;

public class Main_21_002 {
	/*Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

	Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:

	       I/P : 3 3 4 2 4 4 2 4 4
	       O/P : 4 

	       I/P : 3 3 4 2 4 4 2 4
	       O/P : NONE
 	*/
    /* Driver program to test the above functions */
    public static void main(String[] args) 
    {
        int a[] = new int[]{2,2,2,2,5,5,2,3,3};
         
        findMajority(a);
    }
    
    private static void findMajority(int[] arr) 
    {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
 
        for(int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                    int count = map.get(arr[i]) +1;
                    if (count > arr.length /2) {
                        System.out.println("Majority found : " + arr[i]);
                        return;
                    } else
                        map.put(arr[i], count);
 
            }
            else
                map.put(arr[i],1);
            }
            System.out.println(" No Majority element");
    }
}
