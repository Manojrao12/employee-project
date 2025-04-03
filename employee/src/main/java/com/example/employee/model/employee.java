package com.example.employee.model;

public class employee {
    private int empid;
    private String empname;
    private int age;
    private String dob;
    private double salary;

    public employee(int empid, String empname, int age ,String dob,double salary)
    {
        this.empid = empid;
        this.empname = empname;
        this.age = age;
        this.dob=dob;
        this.salary=salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
