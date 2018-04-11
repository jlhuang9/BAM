package com.jlhuang9.bam.biz;

import com.jlhuang9.bam.entry.Account;
import com.jlhuang9.bam.exception.RegisterException;

public interface TextView {
    Account register(String[] args, int type) throws RegisterException;
}
