/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Student implements Comparable<Student> {

    public String name;
    public double PT1;         	//progress test
    public double PT2;
    public double Lab1;        	//lab
    public double Lab2;
    public double Pres1;       	//presentation
    public double Pres2;
    public double FE;           //final exam

    public Student(String name, double PT1, double PT2, double Lab1, double Lab2, double Pres1, double Pres2, double FE) {
        this.name = name;
        this.PT1 = PT1;
        this.PT2 = PT2;
        this.Lab1 = Lab1;
        this.Lab2 = Lab2;
        this.Pres1 = Pres1;
        this.Pres2 = Pres2;
        this.FE = FE;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPT1() {
        return PT1;
    }

    public void setPT1(double PT1) {
        this.PT1 = PT1;
    }

    public double getPT2() {
        return PT2;
    }

    public void setPT2(double PT2) {
        this.PT2 = PT2;
    }

    public double getLab1() {
        return Lab1;
    }

    public void setLab1(double Lab1) {
        this.Lab1 = Lab1;
    }

    public double getLab2() {
        return Lab2;
    }

    public void setLab2(double Lab2) {
        this.Lab2 = Lab2;
    }

    public double getPres1() {
        return Pres1;
    }

    public void setPres1(double Pres1) {
        this.Pres1 = Pres1;
    }

    public double getPres2() {
        return Pres2;
    }

    public void setPres2(double Pres2) {
        this.Pres2 = Pres2;
    }

    public double getFE() {
        return FE;
    }

    public void setFE(double FE) {
        this.FE = FE;
    }

    public double FR(){
        double Result = (Lab1+Lab2)*0.2/2 + (PT1+PT2)*0.3/2 + (Pres1+Pres2)*0.1/2 + FE*0.4; 
        return Result;
    }
    
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

}
