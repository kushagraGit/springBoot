package com.example.ec;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CalcResultDTO;
import com.example.dto.UserDetailsDTO;
import com.example.obj.CalcResult;
import com.example.obj.UserDetails;

@SpringBootApplication
@RestController
@RequestMapping(path="/test/application")
public class ExplorecaliApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExplorecaliApplication.class, args);
	}
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String test(){
		return "My First Microservice on AWS!";
	}
	
	@RequestMapping(path="/userDetails",method=RequestMethod.POST,consumes = "application/json",produces="application/json")
	@ResponseBody
	public UserDetails userDetails(@RequestBody UserDetailsDTO userdetails){
		UserDetails udobj = new UserDetails();
		udobj.setFirstname(userdetails.getFirstname());
		udobj.setSecondname(userdetails.getSecondname());
		return udobj;
	}
	
	@RequestMapping(path="/simpleCalc",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public CalcResult simpleCalc(@RequestBody CalcResultDTO calcObj){
		CalcResult calcResp = new CalcResult();
		int firstDigit = 0, secondDigit = 0, result = 0;
		firstDigit = Integer.parseInt(calcObj.getFirstDigit());
		secondDigit = Integer.parseInt(calcObj.getSecondDigit());
		switch(calcObj.getOperator()){
		case "+":
			result = firstDigit + secondDigit;
			break;
			
		case "-":
			result = firstDigit - secondDigit;
			break;
			
		case "*":
			result = firstDigit * secondDigit;
			break;
			
		case "/":
			result = firstDigit/secondDigit;
			break;
			
		default:
			result = 0;
			break;
		}
		calcResp.setFirstDigit(calcObj.getFirstDigit());
		calcResp.setOperator(calcObj.getOperator());
		calcResp.setSecondDigit(calcObj.getSecondDigit());
		calcResp.setResult(result);
		return calcResp;
	}
}
