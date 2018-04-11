package com.jlhuang9.bam.entry;

/**
 * 信用账户
 */
public class CreditAccount extends Account{
    public CreditAccount(String password, String name, String personId, double balance, byte type) {
        super(password, name, personId, balance, type);
    }


}
