/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoSort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Sort {
    static void display(int []a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input size of Array: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            a[i]=rd.nextInt(1000);
        }
        RadixSort m =new RadixSort();

        display(a);

        m.sort(a);
        display(a);
    }
           
}
