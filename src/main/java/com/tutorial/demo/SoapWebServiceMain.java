package com.tutorial.demo;

import javax.xml.ws.Endpoint;

public class SoapWebServiceMain {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5555/calculator", new SoapCalculator());
	}

}
