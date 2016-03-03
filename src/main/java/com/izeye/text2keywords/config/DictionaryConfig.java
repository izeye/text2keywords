package com.izeye.text2keywords.config;

import com.izeye.text2keywords.repository.DefaultDictionary;
import com.izeye.text2keywords.repository.Dictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by izeye on 15. 10. 23..
 */
@Configuration
public class DictionaryConfig {

	private static final String RESOURCE_LOCATION_COMMON_ENGLISH_WORDS
			= "classpath:dictionaries/common-english-words.txt";
	
	@Bean
	public Dictionary commonEnglishWordsDictionary() {
		return new DefaultDictionary(RESOURCE_LOCATION_COMMON_ENGLISH_WORDS);
	}
	
}
