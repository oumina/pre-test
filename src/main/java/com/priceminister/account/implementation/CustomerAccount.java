package com.priceminister.account.implementation;

import com.priceminister.account.*;
import com.priceminister.accountfunctionalexception.IllegalBalanceException;


public class CustomerAccount implements Account {

    private double balance;

	public void add(Double addedAmount) {
       balance+=addedAmount ;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	if (!rule.withdrawPermitted(balance)){
    		throw new IllegalBalanceException(balance);
    	}else {
    		if(balance >withdrawnAmount){
                balance -= withdrawnAmount ;
            }else{
            	throw new IllegalBalanceException(balance);
            }	
    	}
        return balance;
    }

	public void setBalance(double balance) {
		this.balance=balance;
		
	}

}
