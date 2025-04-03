package com.example.employee.controller;
import com.example.employee.service.empservice;
import com.example.employee.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class controller {
    @Autowired
    private empservice EmpService;

    @GetMapping("/")
    public String home() {
        return "Welcome.";
    }

    @GetMapping("/findbyid/{id}")
    public employee findempById(@PathVariable int id) {
        return EmpService.findempById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addemp(@RequestBody employee emp){
        if(EmpService.findempById(emp.getEmpid()) == null){
            EmpService.addemp(emp.getEmpid(),emp);
            return ResponseEntity.ok("Employee added Succesfully");
        }
        else{
            return ResponseEntity.badRequest().body("Employee ID already exists!");
        }
    }
    @GetMapping("/totalsal")
    public ResponseEntity<Double> getTotalSal(){
        double totalsalary= EmpService.getTotalSal();
        return ResponseEntity.ok(totalsalary);
    }

    @GetMapping("/sort")
    public List<employee> findAllBooks() {
        List<employee> sortedemp=EmpService.sort();
        return sortedemp;
    }

    @PutMapping("/updatesal/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestParam double newsal ){
        String response= EmpService.Update(id,newsal);
        if(response.contains("Successfully")){
            return ResponseEntity.ok(response);
        }
        else{
            return ResponseEntity.badRequest().body(response);
        }
    }
}
