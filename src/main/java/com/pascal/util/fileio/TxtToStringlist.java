
package com.pascal.util.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月14日
 * @category com.pascal.util.fileio
 * @copyright PASCAL
 */
public class TxtToStringlist
{

	public static List<String> readTxtFileIntoStringArrList(String filePath)
	{
		List<String> list = new ArrayList<String>();
		try
		{
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists())
			{ // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file),
						encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null)
				{
					list.add(lineTxt);
				}
				bufferedReader.close();
				read.close();
			}
			else
			{
				System.out.println("找不到指定的文件");
			}
		}
		catch (Exception e)
		{
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 第N次出现的位置
	 * 
	 * @param args
	 */
	public static int getCharacterPosition(String string)
	{
		// 这里是获取"/"符号的位置
		Matcher slashMatcher = Pattern.compile("2016").matcher(string);
		int mIdx = 0;
		while (slashMatcher.find())
		{
			mIdx++;
			// 当"|||"符号第二次出现的位置
			if (mIdx == 1)
			{
				break;
			}
		}
		return slashMatcher.start();
	}

	// get keys from value
	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value)
	{
		Set<T> keys = new HashSet<T>();
		for (Entry<T, E> entry : map.entrySet())
		{
			if (Objects.equals(value, entry.getValue()))
			{
				keys.add(entry.getKey());
			}
		}
		return keys;
	}

	public static void main(String[] args)
	{
		List<String> stringList = readTxtFileIntoStringArrList("d:\\test2.txt");
		System.out.println(stringList.size());
		List<Map> resultList = new ArrayList<>();
		for (String str : stringList)
		{
			Map tempMap = new HashMap<>();
			if (str.contains("WorkPro.cpp 1842"))
			{
				String startTime = str.substring(20, 39);
				String[] strarry = str.split("|||");
				String id = str.substring(getCharacterPosition(str) - 10,
						getCharacterPosition(str) - 3);
				// System.out.println(str);
				tempMap.put("startTime", startTime);
				tempMap.put("id", id);
			}
			if (str.contains("WorkPro.cpp 1957"))
			{
				String endTime = str.substring(20, 39);
				tempMap.put("endTime", endTime);
				String id = str.substring(str.indexOf("|||") + 3,
						str.indexOf("|||") + 10);
				tempMap.put("id", id);
			}
			if (!tempMap.isEmpty())
			{
				resultList.add(tempMap);
			}
		}
		System.out.println(resultList.size());
		/**
		 * 根据id合并map
		 */
		Map newMap = null;
		List<Map> combinedResult = new ArrayList<>();
		for (int i = 0; i < resultList.size(); i++)
		{
			for (int j = i + 1; j < resultList.size(); j++)
			{
				if (resultList.get(i).keySet().contains("startTime") && resultList.get(i)
						.get("id").equals(resultList.get(j).get("id")))
				{
					newMap = new HashMap<>();
					newMap.put("startTime", resultList.get(i).get("startTime"));
					newMap.put("endTime", resultList.get(j).get("endTime"));
					newMap.put("id", resultList.get(i).get("id"));
					combinedResult.add(newMap);
				}
			}
		}
		System.out.println(combinedResult.size());
		List<String> stringListTemp = new ArrayList<>();
		for (Map map : combinedResult)
		{
			stringListTemp.addAll(map.values());
		}
		System.out.println(stringListTemp);
		/**
		 * 由于两个相同ID不是连在一起，不能用词方法
		 */
		/*
		 * List<Map> finalList = new ArrayList<>(); String idTemp = null; Map mapTemp =
		 * null; for (Map map : resultList) { if
		 * (!String.valueOf(idTemp).equals(map.get("id"))) { mapTemp = new HashMap<>();
		 * mapTemp.put("id", String.valueOf(map.get("id"))); mapTemp.put("startTime",
		 * String.valueOf(map.get("startTime"))); idTemp = String.valueOf(map.get("id"));
		 * } else { mapTemp.put("endTime", String.valueOf(map.get("endTime")));
		 * finalList.add(mapTemp); } }
		 */
		/**
		 * LIST<MAP>TO LIST<STIRNG>
		 */
		/*
		 * List<String> stringResult = new ArrayList<>(); for (Map map : finalList) {
		 * StringBuilder sb = new StringBuilder();
		 * sb.append(map.get("startTime")).append("#").append(map.get("endTime"))
		 * .append("#").append(map.get("id")); stringResult.add(sb.toString()); }
		 * System.out.println(stringResult.size());
		 */
		/**
		 * List<Map>写出
		 */
		try
		{
			PrintWriter pw = new PrintWriter(new FileWriter("d:\\test1.txt"));
			for (String str : stringListTemp)
			{
				pw.println(str);
			}
			pw.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
