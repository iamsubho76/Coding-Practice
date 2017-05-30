package com.org.problem.array;

public class Swap2ElementWithoutUsingTempVar {
	/*	Problems with above methods
	1) The multiplication and division based approach doesn’ work if one of the numbers is 0 as the product becomes 0 irrespective of the other number.

	  int x = 10, y = 5;
 
	  // Code to swap 'x' and 'y'
	  x = x * y;  // x now becomes 50
	  y = x / y;  // y becomes 10
	  x = x / y;  // x becomes 5
	 
	  printf("After Swapping: x = %d, y = %d", x, y);
	 
	  return 0;
	2) Both Arithmetic solutions may cause arithmetic overflow. If x and y are too large, addition and multiplication may go out of integer range.

	int x = 10, y = 5;
 
	  // Code to swap 'x' and 'y'
	  x = x + y;  // x now becomes 15
	  y = x - y;  // y becomes 10
	  x = x - y;  // x becomes 5
	 
	  printf("After Swapping: x = %d, y = %d", x, y);
	 
	  return 0;
	3) When we use pointers to variable and make a function swap, all of the above methods fail when both pointers point to the same variable. Let’s take a look what will happen in this case if both are pointing to the same variable.

	// Bitwise XOR based method
	x = x ^ x; // x becomes 0
	x = x ^ x; // x remains 0
	x = x ^ x; // x remains 0

	// Arithmetic based method
	x = x + x; // x becomes 2x
	x = x – x; // x becomes 0
	x = x – x; // x remains 0
	
	The bitwise XOR operator can be used to swap two variables. The XOR of two numbers x and y returns a number which has all the 
	bits as 1 wherever bits of x and y differ. For example XOR of 10 (In Binary 1010) and 5 (In Binary 0101) is 1111 and XOR of 7 
	(0111) and 5 (0101) is (0010).
 	*/
	public static void main(String[] args) {
		  int x = 10, y = 5;
		  
		  // Code to swap 'x' (1010) and 'y' (0101)
		  x = x ^ y;  // x now becomes 15 (1111)
		  y = x ^ y;  // y becomes 10 (1010)
		  x = x ^ y;  // x becomes 5 (0101)
		 
		  System.out.printf("After Swapping: x = %d, y = %d", x, y);
	}
}
