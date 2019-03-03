package com.love2code.springdemo.dao;

import com.love2code.springdemo.entity.CargoMachine;

import java.util.List;


public interface MachineDao {

    List<CargoMachine> getMachines();

    void saveMachine(CargoMachine machine);

    CargoMachine getMachine(int machineId);

    void delete(int machineId);
}
