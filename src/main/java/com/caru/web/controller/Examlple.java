package com.caru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caru.core.model.ExampleModel;
import com.caru.core.service.ExampleService;

@Controller
@ResponseBody
public class Examlple {
	@Autowired
	private ExampleService dictionaryService;
	
	@RequestMapping(value="/word/example", method = RequestMethod.GET, produces="application/json")
	public  ExampleModel.Result getWordExample(
			@RequestParam("q") String q,   
			@RequestParam(value = "display", defaultValue = "10") String display,
			@RequestParam(value = "hl", defaultValue = "none") String hl,
			@RequestParam(value = "r_psglen", defaultValue = "none") String r_psglen) throws Exception{
	
		return dictionaryService.getWordExample(q, display, hl, r_psglen);
	}
}