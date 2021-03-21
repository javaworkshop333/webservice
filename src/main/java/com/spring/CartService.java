package com.spring;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.springdata.CartEntity;
import com.springdata.CartRepository;

@Service
@Scope(value="session", 
		  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartService {
	@Autowired
	CartRepository cr;
	public ArrayList<String> cartItems=new ArrayList<String> ();
	public String addItems(String uid,String product) {
		cartItems.add(product);
		CartEntity ce=new CartEntity();
		ce.setId(System.currentTimeMillis());
		ce.setProducts(product);
		ce.setUid(uid);
		cr.save(ce);
		return cartItems.toString();
	}
}
