
package com.pascal.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年5月24日
 * @category com.pascal.util
 * @copyright PASCAL
 */
public class LastDayofMonth
{

	public static Date lastDayMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		cal.setTime(date);
		System.out.println(date);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(value);
		cal.set(Calendar.DAY_OF_MONTH, value);
		return cal.getTime();
	}

	public static void main(String[] args)
	{
		System.out.println(lastDayMonth(new Date()));
	}
}
