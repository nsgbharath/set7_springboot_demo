package com.marolix.set7.springbootdemo.exception;

public class BillingAppException extends RuntimeException {

	public BillingAppException(Exception e) {
		super(e);

	}

	public BillingAppException(String excpMsg) {
		super(excpMsg);

	}
}
