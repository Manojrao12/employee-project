package com.example.employee.service;
import com.example.employee.model.employee;
import java.util.List;

public interface empservice {
    List<employee> sort();
    void addemp(int id,employee emp);
    employee findempById(int id);
    double getTotalSal();
    String Update(int id,double newSal);
}
