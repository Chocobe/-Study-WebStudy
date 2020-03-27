package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	private AccountDao accDao;
	
	
	public void setAccDao(AccountDao accDao) {
		this.accDao = accDao;
	}
	
	
	public void sendMoney() throws Exception {
		accDao.updateBalance1();
		accDao.updateBalance2();
	}
}
