package com.love2code.springdemo.service;

import com.love2code.springdemo.entity.CargoMachine;
import com.love2code.springdemo.entity.ComputeResult;
import com.love2code.springdemo.entity.Tower;

import java.util.List;

public interface MachineService {

    List<CargoMachine> getMachines();

    void saveMachine(CargoMachine machine);

    CargoMachine getMachine(int machineId);

    void delete(int machineId);

    ComputeResult calculate(Tower tower);
}
