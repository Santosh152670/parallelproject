package com.cg.payment.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.payment.bean.Payment;

public class Paymentdb {
	private static HashMap<String,Payment> 
				paymentDb=new HashMap<String,Payment>();
	public static HashMap<String,Payment> getpaymentMap() {
	return paymentDb;
	}
	Payment obj=new Payment();
	static{
		 
		paymentDb.put("9440275672",new Payment("9440275672","Santosh","santu247908@gmail.com",5000.0,LocalDateTime.now()));
		paymentDb.put("9848275672",new Payment("9848275672","Subha","subha@gmail.com",6000.0,LocalDateTime.now()));
		paymentDb.put("8985102604",new Payment("8985102604","Navya","ushasainavyasri5031@gmail.com",7000.0,LocalDateTime.now()));
		paymentDb.put("9441087028",new Payment("9441087028","Dady","dady@gmail.com",8000.0,LocalDateTime.now()));
		paymentDb.put("9966469107",new Payment("9966469107","Amma","amma@gmail.com",9000.0,LocalDateTime.now()));
		paymentDb.put("9848216090",new Payment("9848216090","Thammu","thammu@gmail.com",10000.0,LocalDateTime.now()));
		}
}