package com.jlhuang9.bam.biz;

import com.jlhuang9.bam.entry.Account;
import com.jlhuang9.bam.entry.CreditAccount;
import com.jlhuang9.bam.entry.SavingAccount;
import com.jlhuang9.bam.exception.RegisterException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank implements TextView {

    private Bank() {
    }

    private static final Bank bank = new Bank();

    public static final long DEFAULT_ID = 100000;

    public static long id = DEFAULT_ID;

    public static Bank getInstance() {
        return bank;
    }

    private final int DEFAULT_SIZE = 100;
    private List<Account> accounts = new ArrayList<>(DEFAULT_SIZE);
    private Set<String> userNames = new HashSet<>();
    @Override
    public synchronized Account register(String[] args,int type) throws RegisterException {
        if(args==null){
            throw new RegisterException("参数错误！");
        }
        judge(args[0]);
        Account account;
        if (type == 0) {
            account = new SavingAccount(args[0], args[1], args[3], 0.0, (byte) type);
        }else {
            account = new CreditAccount(args[0], args[1], args[3], 0.0, (byte) type);
        }
        account.setId(getUserId());
        accounts.add(account);
        return account;
    }

    private long getUserId() {
        return ++id;
    }

    private void judge(String userName) throws RegisterException{
        if (userName == null || "".equals(userName)) {
            throw new RegisterException("用户名不能为空！");
        } else if (userNames.contains(userName)) {
            throw new RegisterException("用户名重复！");
        }
    }

    public int getAccountSize() {
        return accounts.size();
    }
}
