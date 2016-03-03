package com.izeye.text2keywords.util;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by izeye on 16. 3. 3..
 */
public abstract class MapUtils {

	public static <K, V extends Comparable<V>> SortedMap<K, V> sortByValue(
			Map<K, V> map, boolean reverse) {
		SortedMap<K, V> sorted = new TreeMap<>(new Comparator<K>() {
			@Override
			public int compare(K o1, K o2) {
				int result = map.get(o1).compareTo(map.get(o2)) * (reverse ? -1 : 1);
				// NOTE: To allow duplication but it doesn't look nice.
				return result == 0 ? 1 : result;
			}
		});
		sorted.putAll(map);
		return sorted;
	}
	
	public static <K, V extends Comparable<V>> SortedMap<K, V> sortByValue(Map<K, V> map) {
		return sortByValue(map, false);
	}
	
}
