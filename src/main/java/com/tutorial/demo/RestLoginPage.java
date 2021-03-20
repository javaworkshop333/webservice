package com.tutorial.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(description="This webservice helps with Login page activities")
public class RestLoginPage {

	// http://localhost:5050/usercheck/john
	// http://localhost:5050/usercheck?userid=john	
	
	@ApiOperation(value = "allows customer to check userid availability",
	notes = "check user availability")
	@ApiResponses
	(value = 
		{@ApiResponse(code = 200, message = "Successfully checked user"), 
				@ApiResponse(code = 404, message = "invalid request"),
				@ApiResponse(code = 400, message = "Missing or invalid request input"),
				@ApiResponse(code = 500, message = "service error")})

	
	@RequestMapping(value = "/usercheck", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("http://localhost")
	public UserData userCheck(
			@ApiParam(value = "userid required for this test", required = true)
			@RequestParam("userid") String userid) {
		UserData result=new UserData();
		Connection con=null;
		try {
			con=DatabaseConnection.getDBConnection();
			UsersTable ut=new UsersTable();
			result=ut.userCheck(userid, con);
		}catch(Exception e) { e.printStackTrace();
		}
		return result;
	}
	
}
