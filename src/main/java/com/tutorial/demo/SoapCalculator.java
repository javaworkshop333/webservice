package com.tutorial.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.apache.log4j.Logger;
@WebService// annotation- program configuration

public class SoapCalculator {

	public int add( int p1, int p2) {
		System.out.println("adding "+p1+"  "+p2); 
		return p1+p2;
	}
	 
}
