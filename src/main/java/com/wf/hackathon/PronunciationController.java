package com.wf.hackathon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PronunciationController {
	private static final String ENGLISH="en";
	private static final String HINDI="hi";
	private static final String RUSSIAN="rs";
	private static final String CHINEESE="zh-CN";
	private static final String ARABIC="ar";
	private static final String POLISH="pl";
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/name/pronunciation")
	public String namePronunciation(@RequestParam String name,@RequestParam Test selectLanguage) {
		Trying_Different_Languages tl= new Trying_Different_Languages(selectLanguage.name());
		
		return "Success";
	}
}

