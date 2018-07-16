package com.cg.payment.service;

import com.cg.payment.bean.Payment;
import com.cg.payment.exception.PaymentException;

public interface IPaymentService {
	String createAccount(Payment account) throws PaymentException ;
	double viewBalance(String mobileNo) throws PaymentException;
	Payment deposit(String mobileNo,double depositAmount) throws PaymentException;
	Payment withdraw(String mobileNo,double withdrawAmount) throws PaymentException;
	boolean fundTransfer(String sourceMobileNo,String destinationMobileNo,double transferAmt) throws PaymentException;
	Payment printDetailsOfTranscation(String mobileNo) throws PaymentException;
}
