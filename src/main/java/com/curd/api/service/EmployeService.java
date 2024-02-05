package com.curd.api.service;

import com.curd.api.Entity.Employe;
import com.curd.api.exception.UserNotFoundException;
import com.curd.api.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile( value = {"test","dev","prod"})
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public Employe saveEmploye(Employe employe){
        return employeRepository.save(employe);
    }

    public Optional<Employe> getEmployeById(int id){
       Optional<Employe> opsEmploye= Optional.ofNullable(employeRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
       return opsEmploye;
    }

    public List<Employe> getAllEmployes(){
        return employeRepository.findAll();
    }

    public Employe updateEmploye(Employe employe, int id){

        Employe employe2=null;
        Optional<Employe> oldEmploye=employeRepository.findById(id);
        if(oldEmploye.isPresent()){
            Employe employe1=oldEmploye.get();
            employe1.setName(employe.getName());
            employe1.setDepartment(employe.getDepartment());
            employe1.setSalary(employe.getSalary());
             employe2=employeRepository.save(employe1);
        }else {
            throw new UserNotFoundException(id);
        }
        return employe2;
    }

    public String deleteEmploye(int id){
        Optional<Employe> opsEmploye=employeRepository.findById(id);
        if(opsEmploye.isPresent()){
            Employe employe= opsEmploye.get();
            employeRepository.delete(employe);
        }else {
            throw new UserNotFoundException(id);
        }

        return "employe with provided as been deleted successfully"+id;
    }


}
