
package com.pascal.designpattern.singleton;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月4日
 * @category com.pascal.designpattern.singleton
 * @copyright PASCAL
 */
public class SynchronizedSingleton implements Runnable
{

	private SynchronizedSingleton()
	{
		System.out.println("LazySingleton is create" + SynchronizedSingleton.instance);
	}

	private static SynchronizedSingleton instance = null;

	public static synchronized SynchronizedSingleton getInstance()
	{
		if (instance == null)
		{
			instance = new SynchronizedSingleton();
			System.out.println("a");
		}
		return instance;
	}

	public static void createString()
	{
		System.out.println("create String");
	}

	/*
	 * getInstance 方法是static，因此多个thread共享的是class-level的lock
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
		{
			SynchronizedSingleton.getInstance();
		}
		// System.out.println(beginTime);
		// System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() - beginTime);
		// System.out.println(LazySingleton.getInstance().toString());
	}

	public static void main(String[] args)
	{
		// LazySingleton.createString();
		// System.out.println(SynchronizedSingleton.instance);
		for (int i = 0; i < 5; i++)
		{
			// System.out.println(i);
			new Thread(new SynchronizedSingleton()).start();
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println("---" + new SynchronizedSingleton().getInstance());
		System.out.println(SynchronizedSingleton.instance);
	}
}
