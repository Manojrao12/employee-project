package com.example.employee.service;
import com.example.employee.model.employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class empserviceimpl implements empservice{
    private final HashMap<Integer,employee> details=new HashMap<>();
    //private final List<employee> details = new ArrayList<>();

    public empserviceimpl() {
        // Sample data for books
        details.put(1,new employee(1, "sam",25, "2-3-2001",20000));
        details.put(2,new employee(2, "ram", 30,"4-5-2003",30000));
        details.put(3,new employee(3, "tom", 20,"5-6-2000",40000));
    }
    @Override
    public void addemp(int id, employee emp){
        if(!details.containsKey(id)){
            details.put(id,emp);
            System.out.println("Employee added successfully");
        }
        else{
            System.out.println("Employee id already exists!");
        }
    }
    @Override
    public List<employee> sort() {
        return details.values().stream().sorted(Comparator.comparingDouble(employee::getSalary)).collect(Collectors.toList());
    }
    @Override
    public double getTotalSal(){
        return details.values().stream().mapToDouble(employee::getSalary).sum();
    }

    @Override
    public employee findempById(int id) {
        return details.getOrDefault(id, null);
    }

    @Override
    public String Update(int id,double newSal){
        employee emp=details.get(id);
        if(emp != null){
            emp.setSalary(newSal);
            return "salary Updated Successfully";
        }
        else{
            return "Employee not found!";
        }
    }
}
