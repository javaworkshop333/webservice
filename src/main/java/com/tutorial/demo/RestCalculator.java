package com.tutorial.demo;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCalculator {
	Logger log=Logger.getLogger("RestCalculator");
	// http://localhost/areaOfrect?length=10&breadth=5
	@RequestMapping(value = "/areaOfrect", method = RequestMethod.POST)
	public int areaOfrect(@RequestParam("length") int a, @RequestParam("breadth") int b) {
		int area=a * b;
		return area;
	}
	
	@RequestMapping(value = "/areaofsquare/{side}", method = RequestMethod.GET)
	public int areofSquare(@PathVariable int side) throws Exception {
		int area=side * side;
		return area;
	}
	
	// http://localhost/addCal/10/20
	@RequestMapping(value = "/addition/{abc}/{pqr}", method = RequestMethod.GET)
	public int add(@PathVariable int abc, @PathVariable int pqr) throws Exception {
		int sum=abc + pqr;
		return sum;
	}

	// http://localhost/subCal?param1=10&param2=5
	@RequestMapping(value = "/subCal", method = RequestMethod.GET)
	public int sub(@RequestParam("param1") int a, @RequestParam("param2") int b) {
		int sub=a - b;
		return sub;
	}
	
	// http://localhost/jsonReqMul - send json in request body,
	// input type json string
	@RequestMapping(value = "/jsonReqMul", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public int mulCalculator(@RequestBody Input in) {
		// "Input" parameter is json compliant java program
		int mul=in.param1 * in.param2  ;
		return mul;
	}
	
	// http://localhost/jsonRes/1/2
	@RequestMapping(value = "/jsonRes/{param1}/{param2}", 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Output calculator(@PathVariable int param1, @PathVariable int param2) {
		Output res = new Output();
		res.setSum(param1 + param2);
		res.setSub(param1 - param2);
		res.setMul(param1 * param2);
		res.setDiv(param1 / param2);
		return res;
	}
	
	
	@RequestMapping(value = "/areaService", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AreaOutput areaService(@RequestBody MathInput mi) {
		AreaOutput result=new AreaOutput();
		result.areaOfCircle =(int) 3.142 * mi.radius * mi.radius;
		result.areaOfRectangle = mi.length * mi.breadth;
		result.areaOfSquare = mi.sides * mi.sides;
		return result;
	}
	
	
	
}