/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.Random;

/**
 *
 * @author User
 */
public class Assign {
    public static void main(String[] args) {
        Random rd = new Random();
        int n=10;
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=rd.nextInt(100);
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+", ");
        }
    }
}
