
package com.pascal.designpattern.singleton;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月4日
 * @category com.pascal.designpattern.singleton
 * @copyright PASCAL
 */
public class UnsynchronizedSingleton implements Runnable
{

	private UnsynchronizedSingleton()
	{
		System.out.println("Singleton is create");
	}

	private static UnsynchronizedSingleton instance = new UnsynchronizedSingleton();

	public static UnsynchronizedSingleton getInsatnce()
	{
		return instance;
	}

	public static void createString()
	{
		System.out.println("createString in Singleton");
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		long beginTime = System.currentTimeMillis();
		int num = 0;
		for (int i = 0; i < 90000; i++)
		{
			num++;
		}
		System.out.println(num);
		System.out.println(beginTime);
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() - beginTime);
		System.out.println(Thread.currentThread());
		// System.out.println(UnsynchronizedSingleton.getInsatnce().toString());
		UnsynchronizedSingleton.getInsatnce();
	}

	public static void main(String[] args)
	{
		// Singleton.createString();
		for (int i = 0; i < 5; i++)
		{
			String s = String.valueOf(i);
			Thread t1 = new Thread(new UnsynchronizedSingleton(), s);
			t1.setPriority(i + 1);
			t1.start();
		}
	}
}
