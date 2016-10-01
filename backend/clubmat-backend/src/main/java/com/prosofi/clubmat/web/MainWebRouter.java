package com.prosofi.clubmat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainWebRouter {

	@RequestMapping(value={"/signup","/","", "/instituciones/**", "/signin"})
	public String app(){
		return "app";
	}
}