
package com.pascal.util.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author handp (Ailk No.76057)
 * @version 1.0
 * @since 2017�?9�?5�?
 * @category com.linkage.app.bussiness.wlananalysis.feiyang.js.com.pascal.util
 * @copyright Ailk NBS-Network Mgt. RD Dept.
 */
public class FieToList
{

	public static List<LinkedHashMap<String, String>> fileToList(String filePath)
	{
		List<LinkedHashMap<String, String>> resultList = new ArrayList<LinkedHashMap<String, String>>();
		BufferedReader in = null;
		try
		{
			InputStream is = new FileInputStream(filePath);
			in = new BufferedReader(
					new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
			// in = new BufferedReader(new FileReader(filePath));
			String line = "";
			LinkedHashMap<String, String> tempMap;
			while ((line = in.readLine()) != null)
			{
				// System.out.println(line);
				String[] parts = line.split("\\|");
				// System.out.println("数组长度" + parts.length);
				tempMap = new LinkedHashMap<String, String>();
				tempMap.put("username", parts[0]);
				// System.out.println(parts[0]);
				tempMap.put("area", parts[1]);
				tempMap.put("iptvsn", parts[2]);
				tempMap.put("iptvmac", parts[3]);
				tempMap.put("mos", parts[4]);
				tempMap.put("badtype", parts[5]);
				resultList.add(tempMap);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not existed!");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Can Not Read File!");
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					System.out.println("File not correct closed!");
					e.printStackTrace();
				}
			}
		}
		return resultList;
	}
}
