package com.love2code.springdemo.entity;

import java.math.BigDecimal;

/**
 * Построитель объекта башни.
 */
public class TowerBuilder {

    private String firstBlockHigh;
    private String firstBlockWeight;

    private String secondBlockHigh;
    private String secondBlockWeight;

    private String typicalBlockHigh;
    private String typicalBlockWeight;
    private String amountOfTypicalBlocks;

    private String distance;


    public Tower build() {
        Block firstBlock = Block.of(firstBlockHigh, firstBlockWeight);
        Block secondBlock = Block.of(secondBlockHigh, secondBlockWeight);
        Block typicalBlock = Block.of(typicalBlockHigh, typicalBlockWeight);
        BigDecimal amount = new BigDecimal(amountOfTypicalBlocks);
        return new Tower(firstBlock, secondBlock,
                typicalBlock, amount.intValue(), new BigDecimal(distance));
    }

    public String getFirstBlockHigh() {
        return firstBlockHigh;
    }

    public void setFirstBlockHigh(String firstBlockHigh) {
        this.firstBlockHigh = firstBlockHigh;
    }

    public String getFirstBlockWeight() {
        return firstBlockWeight;
    }

    public void setFirstBlockWeight(String firstBlockWeight) {
        this.firstBlockWeight = firstBlockWeight;
    }

    public String getSecondBlockHigh() {
        return secondBlockHigh;
    }

    public void setSecondBlockHigh(String secondBlockHigh) {
        this.secondBlockHigh = secondBlockHigh;
    }

    public String getSecondBlockWeight() {
        return secondBlockWeight;
    }

    public void setSecondBlockWeight(String secondBlockWeight) {
        this.secondBlockWeight = secondBlockWeight;
    }

    public String getTypicalBlockHigh() {
        return typicalBlockHigh;
    }

    public void setTypicalBlockHigh(String typicalBlockHigh) {
        this.typicalBlockHigh = typicalBlockHigh;
    }

    public String getTypicalBlockWeight() {
        return typicalBlockWeight;
    }

    public void setTypicalBlockWeight(String typicalBlockWeight) {
        this.typicalBlockWeight = typicalBlockWeight;
    }

    public String getAmountOfTypicalBlocks() {
        return amountOfTypicalBlocks;
    }

    public void setAmountOfTypicalBlocks(String amountOfTypicalBlocks) {
        this.amountOfTypicalBlocks = amountOfTypicalBlocks;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
