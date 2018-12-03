package com.example.dto;

public class CalcResultDTO {

	protected String firstDigit;
	protected String operator;
	protected String secondDigit;
	
	public String getFirstDigit() {
		return firstDigit;
	}
	public void setFirstDigit(String firstDigit) {
		this.firstDigit = firstDigit;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSecondDigit() {
		return secondDigit;
	}
	public void setSecondDigit(String secondDigit) {
		this.secondDigit = secondDigit;
	}
}
