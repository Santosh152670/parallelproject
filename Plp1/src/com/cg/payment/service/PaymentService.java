package com.cg.payment.service;

import java.time.LocalDateTime;

import com.cg.payment.bean.Payment;
import com.cg.payment.dao.IPaymentDao;
import com.cg.payment.dao.PaymentDao;
import com.cg.payment.exception.PaymentException;

public class PaymentService implements IPaymentService {
	IPaymentDao dao = new PaymentDao();
	@Override
	public String createAccount(Payment account) throws PaymentException {
		if (!account.getMobileNo().matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			if (account.getName().isEmpty() || account.getName() == null) {
			throw new PaymentException("Name cannot be empty");
			} else {
			if (!account.getName().matches("[A-Z][A-Za-z]{3,}")) {
			throw new PaymentException("Name should start with capital letter and should contain only alphabets");
			}
			}
			if (account.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")) {
			throw new PaymentException("Enter valid emailid");
			}
			if (account.getBalance() <= 0) {
			throw new PaymentException("Balance should be greater than zero");
			}
			return dao.createAccount(account);
	}
	@Override
	public double viewBalance(String mobileNo) throws PaymentException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			return dao.viewBalance(mobileNo);
			}
	@Override
	public Payment deposit(String mobileNo, double depositAmount) throws PaymentException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			Payment account = dao.deposit(mobileNo);
			if (depositAmount <= 0) {
			throw new PaymentException("Deposit amount must be greater than zero");
			}
			account.setBalance(account.getBalance() + depositAmount);
			account.setDate(LocalDateTime.now());
			return account;
	}
	@Override
	public Payment withdraw(String mobileNo, double withdrawAmount) throws PaymentException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
		Payment account = dao.withdraw(mobileNo);
			if (withdrawAmount > account.getBalance() || withdrawAmount <= 0) {
			throw new PaymentException(
			"The amount to be withdrawn should be greater than available balance and greater than zero");
			}
			account.setBalance(account.getBalance() - withdrawAmount);
			account.setDate(LocalDateTime.now());
			return account;
	}
	@Override
	public boolean fundTransfer(String sourceMobileNo,
			String destinationMobileNo, double transferAmt)
			throws PaymentException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			if (!destinationMobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			IPaymentService service = new PaymentService();
			Payment acc1 = service.withdraw(sourceMobileNo, transferAmt);
			Payment acc2 = service.deposit(destinationMobileNo, transferAmt);
			return true;
	}
	@Override
	public Payment printDetailsOfTranscation(String mobileNo)
			throws PaymentException {
		return dao.printDetailsOfTranscation(mobileNo);
	}

			

}
