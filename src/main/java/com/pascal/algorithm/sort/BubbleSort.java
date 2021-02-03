
package com.pascal.algorithm.sort;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月19日
 * @category com.pascal.algorithm.sort
 * @copyright PASCAL
 */
public class BubbleSort
{

	public static void main(String[] args)
	{
		int[] arr = { 2, 5, 3, 53, 1, 24, 56, 32, 31, 35, 47, 87, 65, 76, 56, 89, 54, 22,
				33, 11 };
		for (int i = arr.length - 1; i >= 0; i--)
		{
			for (int j = i - 1; j >= 0; j--)
			{
				int temp;
				if (arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
}
