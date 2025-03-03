package com.rupesh.bank.service;

/**
 * Hello world!
 */
public class BankService {
    public double calcSimpleIntrest(double pamt, double time,double rate) {
    	if(pamt<=0 || time<=0 || rate<=0)
    		throw new IllegalArgumentException("Invalid inputs");
    	//calc intrest amout (ptr/100) b.logic
    	double intrAmt=pamt*rate*time/100.0f;
    	return intrAmt;
    }
}
