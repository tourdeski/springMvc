package com.love2code.springdemo.service;

import com.love2code.springdemo.dao.MachineDao;
import com.love2code.springdemo.entity.Block;
import com.love2code.springdemo.entity.CargoMachine;
import com.love2code.springdemo.entity.ComputeResult;
import com.love2code.springdemo.entity.Tower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineDao machineDao;

    @Transactional
    @Override
    public List<CargoMachine> getMachines() {
        return machineDao.getMachines();
    }

    @Transactional
    @Override
    public void saveMachine(CargoMachine machine) {
        machineDao.saveMachine(machine);
    }

    @Transactional
    @Override
    public CargoMachine getMachine(int machineId) {
        return machineDao.getMachine(machineId);
    }

    @Transactional
    @Override
    public void delete(int machineId) {
        machineDao.delete(machineId);
    }

    @Transactional
    @Override
    public ComputeResult calculate(Tower tower) {
        Collection<CargoMachine> machines = getMachines();
        Block firstBlock = tower.getFirstBlock();
        Block secondBlock = tower.getSecondBlock();
        Block commonBlock = tower.getCommonBlock();
        int amountOfCommonBlocks = tower.getCommonBlockAmount();
        BigDecimal distance = tower.getDistanceFromMachine();

        Collection<Set<CargoMachine>> combinations = buildCombinations(machines);

        ComputeResult result = new ComputeResult();
        result.setBlocks(tower.getAllBlocksAmount());
        Map<Collection<ComputeResult.MachineDayNode>, BigDecimal> res = new HashMap<>();

        for (Set<CargoMachine> combination : combinations) {
            BigDecimal high = BigDecimal.ZERO;
            int nextBlock = 1;
            boolean capableToUp = false;

            boolean firstSavePoint = false;
            boolean secondSavePoint = false;

            int commonBlocksUpped = 0;
            Collection<ComputeResult.MachineDayNode> nodes = new ArrayList<>();
            // TODO переписать на итерацию по блокам башни ?.
            for (CargoMachine machine : combination) {
                int beginningHigh = high.intValue();
                int beginningBlock = nextBlock;
                if (!firstSavePoint) {
                    if (machine.canPullUp(firstBlock, BigDecimal.ZERO, distance)) {
                        high = firstBlock.getHigh();
                        nextBlock++;
                        firstSavePoint = true;
                    } else {
                        continue;
                    }
                }
                if (!secondSavePoint) {
                    if (machine.canPullUp(secondBlock, high, distance)) {
                        high = firstBlock.getHigh().add(secondBlock.getHigh());
                        nextBlock++;
                        secondSavePoint = true;
                    } else {
                        if (beginningHigh != high.intValue()) {
                            ComputeResult.MachineDayNode node =
                                    new ComputeResult.MachineDayNode(machine, beginningHigh, high.intValue(),
                                            beginningBlock, nextBlock);
                            nodes.add(node);
                        }
                        continue;
                    }
                }
                for (int i = commonBlocksUpped; i < amountOfCommonBlocks; i++) {
                    if (machine.canPullUp(commonBlock, high, distance)) {
                        high = high.add(commonBlock.getHigh());
                        nextBlock++;
                        commonBlocksUpped++;
                        capableToUp = true;
                        continue;
                    } else if (beginningHigh != high.intValue()) {
                        ComputeResult.MachineDayNode node =
                                new ComputeResult.MachineDayNode(machine, beginningHigh, high.intValue(),
                                        beginningBlock, nextBlock);
                        nodes.add(node);
                    }
                    capableToUp = false;
                    break;
                }
                if (capableToUp && beginningHigh != high.intValue()) {
                    ComputeResult.MachineDayNode node =
                            new ComputeResult.MachineDayNode(machine, beginningHigh, high.intValue(),
                                    beginningBlock, nextBlock);
                    nodes.add(node);
                }
            }
            if (capableToUp) {
                res.put(nodes, getCost(nodes));
            }
        }
        result.setResult(res);
        return result;
    }

    private static BigDecimal getCost(Collection<ComputeResult.MachineDayNode> nodes) {
        return nodes.stream()
                .map(ComputeResult.MachineDayNode::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Collection<Set<CargoMachine>> buildCombinations(Collection<CargoMachine> machines) {
        Collection<Set<CargoMachine>> result = new ArrayList<>();
        int size = machines.size();
        if (size < 1) {
            return result;
        }
        Object[] array = machines.toArray();

        int combinations = (int) Math.pow(2, size);
        for (int i = 1; i < combinations; i++) {
            Set<CargoMachine> combo = new TreeSet<>((o1, o2) -> o1.getCapacity().compareTo(o2.getCapacity()));

            String s = Integer.toBinaryString(i);
            while (s.length() != size) {
                s = 0 + s;
            }
            int arrayIndex = machines.size() - 1;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    combo.add((CargoMachine) array[arrayIndex]);
                }
                arrayIndex--;
            }
            result.add(combo);
        }
        return result;
    }
}
