package com.xdl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xdl.bean.BankAccount;
import com.xdl.dao.BankAccountDAO;

@Service
public class BankAccountService {
	 @Resource
     private   BankAccountDAO  bankDao;

	public BankAccountDAO getBankDao() {
		return bankDao;
	}

	public void setBankDao(BankAccountDAO bankDao) {
		this.bankDao = bankDao;
	}
	/** ��ʾ���������б� */
	public  List<BankAccount>  listBankAccount(){
		return  bankDao.listBankAccount();
	}
	/** �����˺� ɾ���˻�  */
	public  boolean  removeAccountByAno(String ano){
		return  bankDao.deteleAccountByAno(ano)==1?true:false;
	}
	/** �����˺� ��ȡ�˻���Ϣ */
	public  BankAccount  accountInfoByAno(String ano){
		return  bankDao.getAccountByAno(ano);
	}
	/** �������� */
	public  boolean   createAccount(BankAccount account){
		return  bankDao.insertAccount(account)==1?true:false;
	}
	/** ���·��� */
	public  boolean   updateAccount(BankAccount account){
		return  bankDao.updateAccount(account)==1?true:false;
	}
}



