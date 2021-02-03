
package com.pascal.designpattern.singleton;

/**
 * 解决同步关键字低效率
 * 
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月4日
 * @category com.pascal.designpattern.singleton
 * @copyright PASCAL
 */
public class InnerclassSingleton
{

	private InnerclassSingleton()
	{
		System.out.println("StaticSingleton is create");
	}

	private static class SingletonHolder
	{

		private static InnerclassSingleton instance = new InnerclassSingleton();
	}

	public static InnerclassSingleton getInstance()
	{
		return SingletonHolder.instance;
	}
}
