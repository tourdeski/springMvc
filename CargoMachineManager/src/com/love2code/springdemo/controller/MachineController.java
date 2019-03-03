package com.love2code.springdemo.controller;

import com.love2code.springdemo.entity.*;
import com.love2code.springdemo.service.MachineService;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/content")
    public String content(Model theModel) {
        return "content";
    }

    @GetMapping("/list")
    public String list(Model theModel) {

        List<CargoMachine> machines = machineService.getMachines();
        theModel.addAttribute("machines", machines);
        return "list-machines";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        CargoMachineBuilder builder = new CargoMachineBuilder();
        theModel.addAttribute("machine", builder);
        return "machine-form";
    }

    @PostMapping("/saveMachine")
    public String saveMachine(@ModelAttribute("machine") CargoMachineBuilder builder) {
        CargoMachine theMachine = machineService.getMachine(builder.getId());
        machineService.saveMachine(builder.build());
        return "redirect:/machine/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("machineId") int machineId,
                                    Model theModel) {
        CargoMachine theMachine = machineService.getMachine(machineId);
        CargoMachineBuilder builder = new CargoMachineBuilder(theMachine);
        theModel.addAttribute("machine", builder);
        return "machine-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("machineId") int machineId,
                         Model theModel) {
        machineService.delete(machineId);

        return "redirect:/machine/list";
    }

    @PostMapping("/compute")
    public String calculate(
            @ModelAttribute("towerBuilder") TowerBuilder builder,
            Model theModel) {

        ComputeResult result = machineService.calculate(builder.build());
        theModel.addAttribute("result", result);
        return "results";
    }

    @GetMapping("/tower")
    public String towerForm(Model model) {

        TowerBuilder builder = new TowerBuilder();
        model.addAttribute("towerBuilder", builder);
        return "tower-compute";
    }
}
