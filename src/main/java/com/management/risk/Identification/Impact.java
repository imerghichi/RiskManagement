package com.management.risk.Identification;

public enum Impact {
    ACCEPATBLE("acceptable",1),
    TOLERABLE("tolerable",2),
    UNACCEPTABLE("unacceptable",3),
    INTOLERABLE("intolerable",4);

    private final String key;
    private final Integer value;

    Impact(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
