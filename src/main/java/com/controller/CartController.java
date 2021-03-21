package com.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cd;
	//http://localhost/add2Cart?product=iphone
	@RequestMapping(value = "/add2Cart", method = RequestMethod.GET
			, produces=MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String add2Cart(HttpServletResponse  response,
			@RequestParam("product") String product,
			@RequestParam("userid") String userid) {
		String allItemName=cd.addItems(userid,product);
		String cartitems=allItemName;
		System.out.println(cartitems);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		return cartitems;
	}
}