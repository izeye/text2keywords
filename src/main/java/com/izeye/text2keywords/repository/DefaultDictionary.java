package com.izeye.text2keywords.repository;

import com.izeye.text2keywords.util.JarResourceUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by izeye on 15. 10. 23..
 */
public class DefaultDictionary implements Dictionary {
	
	private final Set<String> words = new HashSet<>();
	
	public DefaultDictionary(String... resourceLocations) {
		for (String resourceLocation : resourceLocations) {
			this.words.addAll(JarResourceUtils.readLines(resourceLocation));
		}
	}
	
	@Override
	public boolean contains(String word) {
		return words.contains(word);
	}
	
}
