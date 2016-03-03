package com.izeye.text2keywords.web;

import com.izeye.text2keywords.service.Text2KeywordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by izeye on 16. 3. 3..
 */
@Controller
@RequestMapping(path = "/text2keywords")
public class HomeController {
	
	private static final int TOP_N = 5;
	
	@Autowired
	private Text2KeywordsService text2KeywordsService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public List<String> text2keywords(@RequestParam String text) {
		log.info("text: {}", text);
		List<String> keywords = text2KeywordsService.extractTopNKeywords(text, TOP_N);
		log.info("keywords: {}", keywords);
		return keywords;
	}
	
}
