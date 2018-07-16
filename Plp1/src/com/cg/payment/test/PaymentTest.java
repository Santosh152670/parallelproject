package com.cg.payment.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.cg.payment.bean.Payment;
import com.cg.payment.exception.PaymentException;
import com.cg.payment.service.IPaymentService;
import com.cg.payment.service.PaymentService;

public class PaymentTest {

	private IPaymentService service=new PaymentService();
			@Test
			public void testCreateAccountForMobile() {
			Payment pay = new Payment();
			pay.setMobileNo("1234");
			pay.setName("Santosh");
			pay.setEmail("santu247908@gmail.com");
			pay.setBalance(5000.0);
			try {
			service.createAccount(pay);
			} catch (PaymentException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
			}
			 
			@Test
			public void testCreateAccountForName() {
				Payment pay = new Payment();
				pay.setMobileNo("9848275672");
				pay.setName("santu152670");
				pay.setEmail("subha@gmail.com");
				pay.setBalance(6000.0);
			try {
			service.createAccount(pay);
			} catch (PaymentException e) {
			assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
			}
			}
			 
			@Test
			public void testCreateAccountForNameIsEmpty() {
				Payment pay = new Payment();
				pay.setMobileNo("9848216090");
				pay.setName("");
				pay.setEmail("thammu@gmail.com");
				pay.setBalance(10000.0);
			try {
			service.createAccount(pay);
			} catch (PaymentException e) {
			assertEquals("Name cannot be empty", e.getMessage());
			}
			}
			 
			@Test
			public void testCreateAccountForEmailId() {
				Payment pay = new Payment();
				pay.setMobileNo("8985102604");
				pay.setName("Navya");
				pay.setEmail("ushasainavyasri5031@@23gmail.com");
				pay.setBalance(7000.0);
			try {
			service.createAccount(pay);
			} catch (PaymentException e) {
			assertEquals("Enter valid emailid", e.getMessage());
			}
			}
			
			@Test
			public void testCreateAccount() {
				Payment pay = new Payment();
				pay.setMobileNo("9440275672");
				pay.setName("Santosh");
				pay.setEmail("santu247908@gmail.com");
				pay.setBalance(5000.0);
			 
			try {
			String s=service.createAccount(pay);
			assertNotNull(s);
			} catch (PaymentException e) {			 
			}
			 
			}
			 
			@Test
			public void testShowBalanceForMobileNo() {
			try {
			service.viewBalance("95059");
			} catch (PaymentException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
			}
			}
			 

			@Test
			public void testShowBalanceForMobileNoDoesNotExist() {
			try {
			service.viewBalance("9505928505");
			} catch (PaymentException e) {
			assertEquals("The mobile number does not exist",e.getMessage());
			}
			}
			 
			@Test
			public void testShowBalanceForName() {
				Payment pay=new Payment();
				pay.setMobileNo("9848275682");
			try {
			service.viewBalance(pay.getMobileNo());
			assertEquals("Santosh", pay.getName());
			} catch (PaymentException e) {
			assertEquals("The mobile number does not exist",e.getMessage());
			}
			}
			 
			@Test
			public void testDepositForMobileNo() {
				Payment pay=new Payment();
				pay.setMobileNo("95345");
			try {
			service.deposit(pay.getMobileNo(), 230);
			} catch (PaymentException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
			}
			}
			@Test
			public void testDepositForMobileNoDoesNotExist() {
				Payment pay=new Payment();
				pay.setMobileNo("9505934512");
			try {
			service.deposit(pay.getMobileNo(), 230);
			} catch (PaymentException e) {
			assertEquals("The mobile number does not exist",e.getMessage());
			}
			}
			@Test
			public void testDepositForDepositAmt1() {
				Payment pay=new Payment();
				pay.setMobileNo("9440275672");
			try {
			service.deposit(pay.getMobileNo(), -230);
			} catch (PaymentException e) {
			assertEquals("Deposit amount must be greater than zero",e.getMessage());
			}
			}
			 
			@Test
			public void testDeposit() {
				Payment pay=new Payment();
				pay.setMobileNo("8985102604");
			try {
				Payment pay1=service.deposit(pay.getMobileNo(), 230);
			assertNotNull(pay1);
			} catch (PaymentException e) {
			 
			System.out.println(e.getMessage());
			}
			}
			 
			@Test
			public void testWithDrawForMobileNo() {
				Payment pay=new Payment();
				pay.setMobileNo("9345");
			try {
			service.withdraw(pay.getMobileNo(), 230);
			} catch (PaymentException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
			}
			}
			@Test
			public void testWithdrawForMobileNoDoesNotExist() {
				Payment pay=new Payment();
				pay.setMobileNo("9505934512");
			try {
			service.withdraw(pay.getMobileNo(), 230);
			} catch (PaymentException e) {
			assertEquals("The mobile number does not exist",e.getMessage());
			}
			}
			@Test
			public void testWithdrawForAmt() {
				Payment pay=new Payment();
				pay.setMobileNo("8985102604");
			try {
			service.withdraw(pay.getMobileNo(), -230);
			} catch (PaymentException e) {
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
			}
			}
			 

			@Test
			public void testFundTransferForMobileNo() {
				Payment pay=new Payment();
				Payment pay2=new Payment();
				pay.setMobileNo("78945620");
				pay2.setMobileNo("1234");
			try {
			service.fundTransfer(pay.getMobileNo(),pay2.getMobileNo(), 230);
			} catch (PaymentException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
			}
			}
			@Test
			public void testFundTransferForMobileNoDoesNotExist() {
				Payment pay=new Payment();
				Payment pay2=new Payment();
				pay.setMobileNo("1234567890");
				pay2.setMobileNo("0987654321");
			try {
			service.fundTransfer(pay.getMobileNo(), pay2.getMobileNo(),  230);
			} catch (PaymentException e) {
			assertEquals("The mobile number does not exist",e.getMessage());
			}
			}
			@Test
			public void testFundTransferForAmt() {
				Payment pay=new Payment();
				Payment pay2=new Payment();
				pay.setMobileNo("9440275672");
				pay2.setMobileNo("8985102604");
			try {
			service.fundTransfer(pay.getMobileNo(), pay2.getMobileNo(),  -230);
			} catch (PaymentException e) {
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
			}
			}
			@Test
			public void testFundTransfer() {
				Payment pay=new Payment();
				Payment pay2=new Payment();
				pay.setMobileNo("9505928555");
				pay2.setMobileNo("9848468242");
			try {
			assertTrue(service.fundTransfer(pay.getMobileNo(), pay2.getMobileNo(),  230));
			} catch (PaymentException e) {
			System.out.println(e.getMessage());
			}
			}
			@Test
			public void testPrinttransactionDetails() {
				Payment pay=new Payment();
				pay.setMobileNo("9848468242");
			try {
				Payment san=service.printDetailsOfTranscation(pay.getMobileNo());
			assertNotNull(san);
			} catch (PaymentException e) {
			System.out.println(e.getMessage());
			}
			 
			}
			 

}


