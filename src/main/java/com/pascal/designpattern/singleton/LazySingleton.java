
package com.pascal.designpattern.singleton;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月4日
 * @category com.pascal.designpattern.singleton
 * @copyright PASCAL
 */
public class LazySingleton
{

	private LazySingleton()
	{
		System.out.println("LazySingleton is create");
	}

	private static LazySingleton instance = null;

	public static synchronized LazySingleton getInstance()
	{
		if (instance == null)
		{
			instance = new LazySingleton();
		}
		return instance;
	}

	public static void createString()
	{
		System.out.println("create String");
	}

	public static void main(String[] args)
	{
		LazySingleton.createString();
		System.out.println(LazySingleton.instance);
	}
}
