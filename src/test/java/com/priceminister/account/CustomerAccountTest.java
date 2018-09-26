package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;
import com.priceminister.accountfunctionalexception.IllegalBalanceException;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    	//setUp appelée avant chaque appel de test, un compte vide
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
    		assertNotEquals(customerAccount.getBalance(),null);
    		assertEquals(Double.compare(customerAccount.getBalance(),0.0),0);
    	    }
    
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	customerAccount.setBalance(100.0) ;
    	assertEquals(customerAccount.getBalance().compareTo(100.0), 0);
    	customerAccount.add(200.0);
    	assertEquals(customerAccount.getBalance().compareTo(300.0), 0);
    	assertEquals(true, true);
    }
      
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
    	customerAccount.setBalance(1000.0) ;
    	try {
    		assertEquals(customerAccount.getBalance().compareTo(1000.0), 0);
    		assertEquals(customerAccount.withdrawAndReportBalance(800.0, rule ).compareTo(200.0),0);
			assertEquals(customerAccount.withdrawAndReportBalance(800.0, rule ), new IllegalBalanceException(1000.0));
			
		} catch (IllegalBalanceException e) {
			System.out.println(e.toString());
		}
    	
    } 
  
  
}
