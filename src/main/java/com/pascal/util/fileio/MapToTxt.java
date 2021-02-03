
package com.pascal.util.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapToTxt
{

	private static void mapToTxt(Map hashmap) throws IOException
	{
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Value1");
		map.put(2, "Value2");
		map.put(3, "Value3");
		map.put(4, "Value4");
		map.put(5, "Value5");
		// then, define how many records we want to print to the file
		// int recordsToPrint = 3;
		FileWriter fstream;
		BufferedWriter out;
		// create your filewriter and bufferedreader
		fstream = new FileWriter("values.txt");
		out = new BufferedWriter(fstream);
		// initialize the record count
		int count = 0;
		// create your iterator for your map
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
		// then use the iterator to loop through the map, stopping when we reach the
		// last record in the map or when we have printed enough records
		while (it.hasNext())
		{
			// the key/value pair is stored here in pairs
			Map.Entry<Integer, String> pairs = it.next();
			System.out.println("Value is " + pairs.getValue());
			// since you only want the value, we only care about pairs.getValue(), which
			// is written to out
			out.write(pairs.getValue() + "\n");
			// increment the record count once we have printed to the file
			count++;
		}
		// lastly, close the file and end
		out.close();
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
}
