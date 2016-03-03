package com.izeye.text2keywords.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by izeye on 16. 3. 3..
 */
public class MapUtilsTests {
	
	@Test
	public void testSortByValue() {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 2);
		map.put("b", 3);
		map.put("c", 4);
		map.put("d", 5);
		map.put("e", 1);
		map.put("f", 1);
		
		SortedMap<String, Integer> sorted = MapUtils.sortByValue(map);
		System.out.println(map);
		System.out.println(sorted);
		
		SortedMap<String, Integer> reverseSorted = MapUtils.sortByValue(map, true);
		System.out.println(reverseSorted);
	}
	
}
