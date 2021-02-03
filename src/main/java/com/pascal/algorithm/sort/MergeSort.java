
package com.pascal.algorithm.sort;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月19日
 * @category com.pascal.algorithm.sort
 * @copyright PASCAL
 */
public class MergeSort
{

	private static double[] merge(double[] a, double[] b)
	{
		double[] c = new double[a.length + b.length];
		int i = 0 , j = 0;
		for (int k = 0; k < c.length; k++)
		{
			if (i >= a.length)
				c[k] = b[j++];
			else if (j >= b.length)
				c[k] = a[i++];
			else if (a[i] <= b[j])
				c[k] = a[i++];
			else
				c[k] = b[j++];
		}
		return c;
	}

	public static double[] mergesort(double[] input)
	{
		int N = input.length;
		if (N <= 1)
			return input;
		double[] a = new double[N / 2];
		double[] b = new double[N - N / 2];
		for (int i = 0; i < a.length; i++)
			a[i] = input[i];
		for (int i = 0; i < b.length; i++)
			b[i] = input[i + N / 2];
		return merge(mergesort(a), mergesort(b));
	}

	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	private static boolean isSorted(double[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i - 1])
				return false;
		return true;
	}

	// generate N real numbers between 0 and 1, and mergesort them
	public static void main(String[] args)
	{
		int N = 3;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = Math.random() * 50 + 1;
		a = mergesort(a);
		/*
		 * for (int i = 0; i < N; i++) System.out.println(a[i]);
		 */
		System.out.println(isSorted(a));
	}
}
