package com.curd.api.controller;


import com.curd.api.Entity.Employe;
import com.curd.api.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("/employe")
    public String saveEmploye(@RequestBody Employe employe){
      Employe employe1=  employeService.saveEmploye(employe);
        return "employ saved succesfully "+employe1;
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable("id") int id){
         return employeService.getEmployeById(id).get();
    }

    @GetMapping("/getAll")
    public List<Employe> getAllEmployes(){
        return employeService.getAllEmployes();
    }

    @PutMapping("/upadte/{id}")
    public Employe upadetEmploye(@RequestBody Employe employe, @PathVariable("id") int id){
        return employeService.updateEmploye(employe,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable("id") int id){
        return  employeService.deleteEmploye(id);
    }
}
