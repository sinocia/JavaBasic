
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

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年5月24日
 * @category com.pascal.util
 * @copyright PASCAL
 */
public class CsvBatchSql
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
		List<String> dataList = importCsv(
				new File("C:/Users/Administrator/Desktop/山西联通接口/大唐-号线/commaTest.csv"));
		if (dataList != null && !dataList.isEmpty())
		{
			for (String data : dataList)
			{
				System.out.println(data);
			}
		}
		// boolean isSuccess = exportCsv(new File("D:/test/ljq.csv"), dataList);
		// System.out.println(isSuccess);
	}
}
