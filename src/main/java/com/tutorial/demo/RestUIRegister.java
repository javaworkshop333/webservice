package com.tutorial.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RestUIRegister {

	Logger log=Logger.getLogger("RestUIRegister");
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost")
	public String register(@RequestParam("reguid") String userid,
			@RequestParam("regpwd") String password,
			@RequestParam("regfname") String fname,
			@RequestParam("reglname") String lname) {
		Connection con=null;
		try {
			
			log.debug("1");
			log.info("2");
			log.warn("3");
			log.error("4");
			// all - debug - info - error -warn - none
			// log4j.rootLogger=ERROR, stdout, file
			// ERROR = print all messages log.error and log.warn
			// INFO = print all messages log.info, log.error and log.warn
			// DEBUG = print all messages log.debug, log.info, log.error and log.warn
			log.debug("customer "+userid+" tried to register");
			con=DatabaseConnection.getDBConnection();
			UsersTable ut=new UsersTable();
			ut.registerUser(userid, password,fname,lname, con);
			log.debug("customer "+userid+" registeration is success");
		}catch(Exception e) { 
			log.error("customer "+userid+" registeration failed",e);
			e.printStackTrace(); 
			return "redirect:"+"http://localhost/regerror.html";
		}
		return  "thankyou.jsp";
	}
	
}
