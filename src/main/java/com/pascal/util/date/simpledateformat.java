
package com.pascal.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年6月13日
 * @category timedate
 * @copyright PASCAL
 */
public class simpledateformat
{

	public static void main(String[] args)
	{
		try
		{
			// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			Date date = new Date();
			String time = format.format(date);
			String year = time.substring(0, 4);
			String month = time.substring(5, 7);
			String day = time.substring(8, 10);
			System.out.println(time);
			System.out.println(year);
			System.out.println(month);
			System.out.println(day);
			// String time = "2017-06-08";
			String startTime = time + " " + "00:00:00";
			String endTime = time + " " + "23:59:59";
			Date starDate = format.parse(startTime);
			long start = starDate.getTime() / 1000;
			// System.out.println(starDate);
			// System.out.println(start);
			Date endDate = format.parse(endTime);
			long end = endDate.getTime() / 1000;
			// System.out.println(endDate);
			// System.out.println(end);
			Calendar a = Calendar.getInstance();
			// System.out.println(a.get(Calendar.DAY_OF_MONTH));
			// a.setTime(starDate);
			// System.out.println(a.get(Calendar.YEAR));// 得到年
			// System.out.println(a.get(Calendar.MONTH) + 1);// 由于月份是从0开始的所以加1
			// System.out.println(a.get(Calendar.DATE));
			// String tabTime = "_" + String.valueOf(a.get(Calendar.YEAR)) + "_"
			// + String.valueOf((a.get(Calendar.MONTH) + 1));
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
