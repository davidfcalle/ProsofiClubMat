package com.prosofi.clubmat.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

	@RequestMapping(value="/api/hello", method = RequestMethod.GET)
	public String sayHello(){
		return "Hello World";
	}
}
