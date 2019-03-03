package com.love2code.springdemo.entity;

import java.math.BigDecimal;

/**
 * Блок башни.
 */
public class Block {

    /**
     * м
     */
    private BigDecimal high;

    /**
     * тонн
     */
    private BigDecimal weigh;

    private Block(BigDecimal high, BigDecimal weigh) {
        this.high = high;
        this.weigh = weigh;
    }

    public static Block of(String high, String weigh) {
        return new Block(new BigDecimal(high), new BigDecimal(weigh));
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getWeigh() {
        return weigh;
    }
}
