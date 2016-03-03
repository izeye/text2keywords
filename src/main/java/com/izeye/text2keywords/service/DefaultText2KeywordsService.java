package com.izeye.text2keywords.service;

import com.izeye.text2keywords.domain.WordToken;
import com.izeye.text2keywords.repository.Dictionary;
import com.izeye.text2keywords.util.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by izeye on 16. 3. 3..
 */
@Service
public class DefaultText2KeywordsService implements Text2KeywordsService {
	
	@Resource(name = "commonEnglishWordsDictionary")
	private Dictionary commonEnglishWordsDictionary;
	
	@Override
	public List<String> extractTopNKeywords(String text, int n) {
		Map<String, Integer> keywordCountMap = new TreeMap<>();
		WordTokenizer tokenizer = new DefaultWordTokenizer(text);
		WordToken token;
		while ((token = tokenizer.next()) != null) {
			String lowerCaseWord = token.getLowerCaseWord();
			Integer count = keywordCountMap.getOrDefault(lowerCaseWord, 0);
			count++;
			keywordCountMap.put(lowerCaseWord, count);
		}
		removeStopWords(keywordCountMap);
		System.out.println(keywordCountMap);
		SortedMap<String, Integer> reverseCountSortedMap = MapUtils.sortByValue(keywordCountMap, true);
		System.out.println(reverseCountSortedMap);
		List<String> reverseCountSorted = new ArrayList<>(reverseCountSortedMap.keySet());
		

		int size = reverseCountSorted.size();
		return reverseCountSorted.subList(0, n > size ? size : n);
	}

	private void removeStopWords(Map<String, Integer> keywordCountMap) {
		List<String> stopWords = keywordCountMap.keySet().stream()
				.filter(key -> commonEnglishWordsDictionary.contains(key))
				.collect(Collectors.toList());
		stopWords.forEach(keywordCountMap::remove);
	}

}
