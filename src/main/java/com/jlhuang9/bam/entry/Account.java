package com.jlhuang9.bam.entry;

public class Account {
//    id:账户号码 长整数
    private long id;
//    password:账户密码
    private String password;
//    name:真实姓名
    private String name;
//    personId:身份证号码 字符串类型
    private String personId;
//    balance:账户余额
    private double balance;
//    0的时候表示储蓄账户,为1的时候表示信用账户
    private byte type;

    public Account(String password, String name, String personId, double balance, byte type) {
        this.password = password;
        this.name = name;
        this.personId = personId;
        this.balance = balance;
        this.type = type;
    }

    public final boolean deposit(double money) {
        return true;
    }

    public boolean withdrawals(double money) {
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
