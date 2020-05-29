package com.management.risk.Exception;

import java.util.function.Supplier;

public class BusinessException extends Throwable {
    public BusinessException() {
    }

    public BusinessException(String s) {
        super(s);
    }

    public BusinessException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
