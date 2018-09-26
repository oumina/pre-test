package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private double balance;

	public void add(Double addedAmount) {
       balance+=addedAmount ;
    }

    public Double getBalance() {
        // TODO Auto-generated method stub
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
        // TODO Auto-generated method stub
        return null;
    }

	public void setBalance(double balance) {
		this.balance=balance;
		
	}

}
