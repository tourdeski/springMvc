package com.love2code.springdemo.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Результат подбора кранов.
 */
public class ComputeResult {

    private Collection<Pair> result = new ArrayList<>();
    private int blocks;

    public static class Pair {
        private Collection<MachineDayNode> nodes;
        private BigDecimal cost;
        private int size;

        public Pair(Collection<MachineDayNode> nodes, BigDecimal cost) {
            this.nodes = nodes;
            this.cost = cost;
            this.size = nodes.size();
        }

        public Collection<MachineDayNode> getNodes() {
            return nodes;
        }

        public BigDecimal getCost() {
            return cost;
        }

        public int getSize() {
            return size;
        }
    }

    public static class MachineDayNode {
        private CargoMachine machine;
        private int beginningHigh;
        private int endingHigh;
        private int beginningBlock;
        private int endingBlock;

        public MachineDayNode(CargoMachine machine, int beginningHigh, int endingHigh,
                              int beginningBlock, int endingBlock) {
            this.machine = machine;
            this.beginningHigh = beginningHigh;
            this.endingHigh = endingHigh;
            this.beginningBlock = beginningBlock;
            this.endingBlock = endingBlock;
        }

        public BigDecimal getCost() {
            return machine.getPrice().multiply(new BigDecimal(endingBlock - beginningBlock));
        }

        public CargoMachine getMachine() {
            return machine;
        }

        public int getBeginningHigh() {
            return beginningHigh;
        }

        public int getEndingHigh() {
            return endingHigh;
        }

        public int getBeginningBlock() {
            return beginningBlock;
        }

        public int getEndingBlock() {
            return endingBlock;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MachineDayNode node = (MachineDayNode) o;

            if (beginningHigh != node.beginningHigh) return false;
            if (endingHigh != node.endingHigh) return false;
            if (beginningBlock != node.beginningBlock) return false;
            if (endingBlock != node.endingBlock) return false;
            return machine.equals(node.machine);
        }

        @Override
        public int hashCode() {
            int result = machine.hashCode();
            result = 31 * result + beginningHigh;
            result = 31 * result + endingHigh;
            result = 31 * result + beginningBlock;
            result = 31 * result + endingBlock;
            return result;
        }
    }

    public Collection<Pair> getResult() {
        return result;
    }

    public void setResult(Map<Collection<MachineDayNode>, BigDecimal> result) {
        for (Map.Entry<Collection<MachineDayNode>, BigDecimal> entry : result.entrySet()) {
            this.result.add(new Pair(entry.getKey(), entry.getValue()));
        }
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }
}
