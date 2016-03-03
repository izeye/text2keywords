package com.izeye.text2keywords.service;

import java.util.List;

/**
 * Created by izeye on 16. 3. 3..
 */
public interface Text2KeywordsService {
	
	List<String> extractTopNKeywords(String text, int n);
}
