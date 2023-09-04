package com.example.demo.JavaClasses;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
@Component
@Entity
public class User {

    @Id
    int id;

    @Column(name="UserName")
    String name;

    @Column(name = "salary")
    double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Column(name="Propertyvalue")
    double propertyValue;

    public double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Column(name="shareValue")
    double shareValue;

    public double getShareValue() {
        return shareValue;
    }

    public void setShareValue(double shareValue) {
        this.shareValue = shareValue;
    }

    @Column(name="NetIncome")
    double netIncome;

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }

    @ManyToOne
    @JoinColumn(name = "lawyerID")
    Lawyer lawyer;

    public Lawyer getLawyer() {
        return lawyer;
    }
    @ManyToOne
    @JoinColumn(name = "adminID")
    Admin admin;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLawyer(Lawyer lawyer){
        this.lawyer=lawyer;
        lawyer.addUsers(this);
    }


   /* @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/
}