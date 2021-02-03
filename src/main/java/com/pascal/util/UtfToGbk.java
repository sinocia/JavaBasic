
package com.pascal.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年5月24日
 * @category com.pascal.util
 * @copyright PASCAL
 */
public class UtfToGbk
{

	public static void main(String[] args)
	{
		try
		{
			FileInputStream fIn = new FileInputStream("D:/360/20170522.txt");
			InputStreamReader inReader = new InputStreamReader(fIn, "utf-8");
			BufferedReader bufr = new BufferedReader(inReader);
			BufferedWriter bufw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("D:/360/02.txt"), "gbk"));
			int ch = 0;
			while ((ch = bufr.read()) != -1)
			{
				System.out.print((char) ch);
				bufw.write(ch);
			}
			if (bufr != null)
			{
				bufr.close();
			}
			if (bufw != null)
			{
				bufw.close();
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
