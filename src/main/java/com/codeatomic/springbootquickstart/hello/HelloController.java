package com.codeatomic.springbootquickstart.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	//getMapping
	@RequestMapping("/")
	public String hellowWorld(){
		//this statement will return the HelloWorld string//
		return "Hello World!";
	}
}
