
package com.pascal.designpattern.singleton;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月4日
 * @category com.pascal.designpattern.singleton
 * @copyright PASCAL
 */
public class Singleton1
{

	private Singleton1()
	{
		System.out.println("Singleton is create");
	}

	private static Singleton1 instance = new Singleton1();

	public static Singleton1 getInsatnce()
	{
		return instance;
	}

	public static void createString()
	{
		System.out.println("createString in Singleton");
	}

	public static void main(String[] args)
	{
		// Singleton1.createString();
	}
}
