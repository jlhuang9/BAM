package com.jlhuang9.bam.entry;

/**
 * 储蓄账户
 */
public class SavingAccount extends Account {


    private static final double OVERDRAFT_VALUE = 10000.0;

    public SavingAccount(String password, String name, String personId, double balance, byte type) {
        super(password, name, personId, balance, type);
    }
}
