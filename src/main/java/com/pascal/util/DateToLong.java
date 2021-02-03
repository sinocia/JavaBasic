
package com.pascal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年5月24日
 * @category com.pascal.util
 * @copyright PASCAL
 */
public class DateToLong
{

	public static void main(String[] args)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			Date date = new Date();
			System.out.println(date);
			String dateString = dateFormat.format(date);
			System.out.println(dateString);
			Date start_date = dateFormat.parse(dateString.substring(0, 9) + " 00:00:00");
			System.out.println(start_date);
			Long start_time = start_date.getTime() / 1000;
			System.out.println(start_time);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
