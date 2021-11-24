/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static final Scanner sc = new Scanner(System.in);
    public static double checkMark(){
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if(result >10 || result <0){
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine();
            if (result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Re-input.");
        }
    }
    public static void addStudent(ArrayList<Student> lt) {
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("PT1: ");
        double PT1 = checkMark();
        System.out.print("PT2: ");
        double PT2 = checkMark();
        System.out.print("Lab1: ");
        double Lab1 = checkMark();
        System.out.print("Lab2: ");
        double Lab2 = checkMark();
        System.out.print("Pres1: ");
        double Pres1 = checkMark();
        System.out.print("Pres2: ");
        double Pres2 = checkMark();
        System.out.print("FE: ");
        double FE = checkMark();
        lt.add(new Student(name,PT1,PT2,Lab1,Lab2,Pres1,Pres2,FE));
    }

    public static void print(ArrayList<Student> lt) {
        Collections.sort(lt);
        for (int i = 0; i < lt.size(); i++) {
            System.out.println("--------Student " + (i+1) + "--------");
            System.out.println("Name: " + lt.get(i).getName());
            System.out.println("FR: " + lt.get(i).FR());
        }
    }

    public static void display() {
        ArrayList<Student> lt = new ArrayList<>();
        addStudent(lt);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (checkInputYN()) {
                addStudent(lt);
            } else {
                break;
            }
        }
        print(lt);
    }

    public static void main(String[] args) {
        display();
    }
}

