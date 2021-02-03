
package com.pascal.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator (PASCAL)
 * @version 1.0
 * @since 2017年7月14日
 * @category com.pascal.util
 * @copyright PASCAL
 */
public class CombineSameKey
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<Map> list = new ArrayList<>();
		Map map0 = new HashMap();
		map0.put(1, 1);
		list.add(map0);
		Map map1 = new HashMap();
		map1.put(3, 4);
		list.add(map1);
		Map map2 = new HashMap();
		map2.put(1, 2);
		list.add(map2);
		Map map3 = new HashMap();
		map3.put(1, 3);
		list.add(map3);
		Map map4 = new HashMap();
		map4.put(2, 2);
		list.add(map4);
		Map map5 = new HashMap();
		map5.put(2, 1);
		list.add(map5);
		Map map6 = new HashMap();
		map6.put(3, 1);
		list.add(map6);
		// 要求将上面的List<Map>中的map中key相同的value合并
		// 最终得到下面的结果List<Map<Object,List>>,其中三个map分别为
		// 1->[1,2,3]
		// 2->[2,1]
		// 3->[4,3]
		Map m = mapCombine(list);
		System.out.println(m);
	}

	public static Map mapCombine(List<Map> list)
	{
		Map<Object, List> map = new HashMap<>();
		for (Map m : list)
		{
			Iterator<Object> it = m.keySet().iterator();
			System.out.println(m.keySet());
			while (it.hasNext())
			{
				Object key = it.next();
				if (!map.containsKey(key))
				{
					List newList = new ArrayList<>();
					newList.add(m.get(key));
					map.put(key, newList);
				}
				else
				{
					map.get(key).add(m.get(key));
				}
			}
		}
		return map;
	}
}
