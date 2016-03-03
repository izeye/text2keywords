package com.izeye.text2keywords.service;

import com.izeye.text2keywords.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by izeye on 16. 3. 3..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class Text2KeywordsServiceTests {
	
	@Autowired
	Text2KeywordsService text2KeywordsService;
	
	@Test
	public void testExtractTopNKeywords() {
		String text = "This is a test. That is another test.";
		int n = 5;
		List<String> keywords = text2KeywordsService.extractTopNKeywords(text, n);
		System.out.println(keywords);
	}
	
}
