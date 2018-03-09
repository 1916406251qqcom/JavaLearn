package com.xdl.dao;

import java.util.List;

import com.xdl.bean.BankAccount;

public interface BankAccountDAO {
     List<BankAccount>  listBankAccount();
     /** �����˺� ɾ���˻� */
     int   deteleAccountByAno(String ano);
     /** �����˺� ��ѯ�˻� */
     BankAccount   getAccountByAno(String ano);
     /** ���������˻����� */
     int   insertAccount(BankAccount  account);
     /** ���·��� */
     int   updateAccount(BankAccount  account);
}
