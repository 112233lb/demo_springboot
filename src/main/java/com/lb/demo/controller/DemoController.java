package com.lb.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/demo")
public class DemoController {
	@RequestMapping(value="/demo")
	public Map<String,Object> demo(){
		System.out.println("*****");
		return null;
	}
}
