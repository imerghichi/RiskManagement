package com.management.risk.Exception;

import java.util.function.Supplier;

/**
 * The type Business exception.
 */
public class BusinessException extends Throwable {
    /**
     * Instantiates a new Business exception.
     */
    public BusinessException() {
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param s the s
     */
    public BusinessException(String s) {
        super(s);
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param s         the s
     * @param throwable the throwable
     */
    public BusinessException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
