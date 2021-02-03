
package com.pascal.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huanglei(工号) Tel:☎
 * @version 1.0
 * @since 2017-4-26 上午10:26:16
 * @category com.linkage.app.bussiness.itv.sx.com.pascal.util
 * @copyright 南京联创科技 网管科技部
 */
public class CSVUtil
{

	/**
	 * 导出
	 * 
	 * @param file
	 *            csv文件(路径+文件名)，csv文件不存在会自动创建
	 * @param dataList
	 *            数据
	 * @return
	 */
	public static boolean exportCsv(String path, List<String> dataList)
	{
		boolean isSucess = false;
		File file = new File(path);
		if (!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try
		{
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			if (dataList != null && !dataList.isEmpty())
			{
				for (String data : dataList)
				{
					bw.append(data).append("\r");
				}
			}
			isSucess = true;
		}
		catch (Exception e)
		{
			isSucess = false;
			e.printStackTrace();
		}
		finally
		{
			if (bw != null)
			{
				try
				{
					bw.close();
					bw = null;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if (osw != null)
			{
				try
				{
					osw.close();
					osw = null;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if (out != null)
			{
				try
				{
					out.close();
					out = null;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return isSucess;
	}

	/**
	 * 导入
	 * 
	 * @param file
	 *            csv文件(路径+文件)
	 * @return
	 */
	public static List<String> importCsv(File file)
	{
		List<String> dataList = new ArrayList<String>();
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null)
			{
				dataList.add(line);
			}
		}
		catch (Exception e)
		{
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
					br = null;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return dataList;
	}

	public static void main(String[] args)
	{
		/*
		 * List<String> dataList = new ArrayList<String>(); dataList.add("1,5,6");
		 * dataList.add("2,7,8"); dataList.add("3,9,0");
		 * System.out.println(dataList.size());
		 */
		/*
		 * List<String> dataList = importCsv( new
		 * File("C:/Users/Administrator/Desktop/山西联通接口/大唐-号线/commaTest.csv")); if
		 * (dataList != null && !dataList.isEmpty()) { for (String data : dataList) {
		 * System.out.println(data); } }
		 */
		// boolean isSuccess = exportCsv(new File("D:/test/ljq.csv"), dataList);
		// System.out.println(isSuccess);
		String str = "[WorkPro.cpp 1842] [2017-07-13 22:14:42] [Info] [1146365696] | abcde|||16|||1919890|||1919890|||20170204185640|||301|||201|||5|||0|||908AKT.AKT00Z01/Q-C300-1|||135.253.164.2|||0|||5|||6|||61|||ZTE-F460||||||9080572604C|||09085720895|||王双年|||0000000|||88888888|||克州阿克陶县人民西路无门牌号幸福小区4号楼3单";
		Pattern pattern = Pattern.compile("|||");
		Matcher findMatcher = pattern.matcher(str);
		int number = 0;
		while (findMatcher.find())
		{
			number++;
			if (number == 2)
			{// 当“A”第二次出现时停止
				break;
			}
		}
		int i = findMatcher.start();// “A”第二次出现的位置
		System.out.println("'A'第二次出现的位置是：" + i);
	}
}
