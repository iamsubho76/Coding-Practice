package com.org.problem.pattern;

import java.math.BigInteger;

/**
 * Reference link below
 * http://masc.cs.gmu.edu/wiki/BinomialCoefficients
 * http://mathworld.wolfram.com/BinomialCoefficient.html
 *
 */
public class BinomialCoefficients {

	/* Compute binomial coefficient (n choose m) using DP */
	public static BigInteger binomial(int n, int m) {
		int i, j;
		BigInteger[] b = new BigInteger[n + 1];
		b[0] = BigInteger.ONE;
		for (i = 1; i <= n; i++) {
			b[i] = BigInteger.ONE;
			for (j = i - 1; j > 0; j--)
				b[j] = b[j].add(b[j - 1]);
		}
		return b[m];
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println("Value of C(" + n + ", " + k + ") " + "is" + " " + binomial(n, k));
	}
}
