package com.love2code.springdemo.entity;

import java.math.BigDecimal;

/**
 * Башня.
 */
public class Tower {

    private Block firstBlock;

    private Block secondBlock;

    private Block commonBlock;

    private int commonBlockAmount;

    private int allBlocksAmount;

    private BigDecimal distanceFromMachine;

    public Tower(
            Block firstBlock,
            Block secondBlock,
            Block commonBlock,
            int commonBlockAmount,
            BigDecimal distanceFromMachine) {
        this.firstBlock = firstBlock;
        this.secondBlock = secondBlock;
        this.commonBlock = commonBlock;
        this.commonBlockAmount = commonBlockAmount;
        this.allBlocksAmount = commonBlockAmount + 2;
        this.distanceFromMachine = distanceFromMachine;
    }

    public BigDecimal getHigh() {
        return firstBlock.getHigh()
                .add(secondBlock.getHigh())
                .add(commonBlock.getHigh().multiply(new BigDecimal(commonBlockAmount)));
    }

    public Block getFirstBlock() {
        return firstBlock;
    }


    public Block getSecondBlock() {
        return secondBlock;
    }


    public Block getCommonBlock() {
        return commonBlock;
    }

    public int getCommonBlockAmount() {
        return commonBlockAmount;
    }

    public int getAllBlocksAmount() {
        return allBlocksAmount;
    }

    public BigDecimal getDistanceFromMachine() {
        return distanceFromMachine;
    }
}
