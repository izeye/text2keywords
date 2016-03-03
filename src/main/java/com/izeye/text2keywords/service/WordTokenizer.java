package com.izeye.text2keywords.service;

import com.izeye.text2keywords.domain.WordToken;

/**
 * Created by izeye on 15. 10. 23..
 */
public interface WordTokenizer {

	WordToken next();
	
}
