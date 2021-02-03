
package com.pascal.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FirstLastDayofLastMonth
{

	public static void main(String[] args)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		int value = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		String lastDay = String.valueOf(value);
		SimpleDateFormat beginTimeFormart = new SimpleDateFormat("yyyy_MM_01 00:00:00");
		SimpleDateFormat endTimeFormat = new SimpleDateFormat(
				"yyyy_MM_" + lastDay + " 23:59:59");
		// System.out.println(value);
		// calendar.add(Calendar., amount);
		// calendar.add(Calendar.DATE, -1);
		System.out.println(calendar.getTime());
		String begin = beginTimeFormart.format(calendar.getTime());
		System.out.println(begin);
		String end = endTimeFormat.format(calendar.getTime());
		System.out.println(end);
		DateFormat formatter = new SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
		Date firstDay = null , endDay = null;
		try
		{
			firstDay = formatter.parse(begin);
			endDay = formatter.parse(end);
		}
		catch (ParseException e)
		{
			System.out.println("PARSE WENT WRONG!!!");
			e.printStackTrace();
		}
		System.out.println(firstDay);
		System.out.println(endDay);
		long firstTime = firstDay.getTime() / 1000;
		long endTime = endDay.getTime() / 1000;
		System.out.println(firstTime);
		System.out.println(endTime);
	}
}
