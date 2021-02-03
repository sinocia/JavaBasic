
package com.pascal.algorithm.search;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月19日
 * @category com.pascal.algorithm.search
 * @copyright PASCAL
 */
public class BinarySearch
{

	private BinarySearch()
	{
	}

	/**
	 * Returns the index of the specified key in the specified array.
	 *
	 * @param a
	 *            the array of integers, must be sorted in ascending order
	 * @param key
	 *            the search key
	 * @return index of key in array {@code a} if present; {@code -1} otherwise
	 */
	public static int indexOf(int[] a, int key)
	{
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi)
		{
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] arr = { 2, 5, 53, 65, 76, 89, 542, 1122, 3355, 12231 };
		int index = indexOf(arr, 542);
		System.out.println(index);
	}
}
