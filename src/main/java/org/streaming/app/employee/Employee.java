package org.streaming.app.employee;

public class Employee {

    private String name;
    private String mobile;
    private String email;
    private int age;
    private double salary;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTaxAmoount() {
        return taxAmoount;
    }

    public void setTaxAmoount(double taxAmoount) {
        this.taxAmoount = taxAmoount;
    }

    private double taxAmoount;

    public Employee(String name, String mobile, String email, int age, double salary) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
