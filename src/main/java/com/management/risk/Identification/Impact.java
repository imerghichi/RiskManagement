package com.management.risk.Identification;

/**
 * The enum Impact.
 */
public enum Impact {
    /**
     * Accepatble impact.
     */
    ACCEPATBLE("acceptable",1),
    /**
     * Tolerable impact.
     */
    TOLERABLE("tolerable",2),
    /**
     * Unacceptable impact.
     */
    UNACCEPTABLE("unacceptable",3),
    /**
     * Intolerable impact.
     */
    INTOLERABLE("intolerable",4);

    /**
     * The Key.
     */
    private final String key;
    /**
     * The Value.
     */
    private final Integer value;

    /**
     * Instantiates a new Impact.
     *
     * @param key   the key
     * @param value the value
     */
    Impact(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Integer getValue() {
        return value;
    }
}
