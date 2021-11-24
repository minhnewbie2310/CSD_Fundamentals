/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.util.Random;

/**
 *
 * @author User
 */
public class DemoRecursion {
    long fac(int n){
        if(n==0) return 1;
        else return fac(n-1)*n;
    }
    String change(int base){
        if(base<10) return base+"";
        else return (char)(base+55)+"";
    }
    String convert (int n, int base){
        if (n<base) return change(n);
        else return convert(n/base,base)+change(n%base);
    }
    String reverse(String s){
        if(s.length()==1) return s;
        else return s.charAt(s.length()-1)+reverse(s.substring(0, s.length()-1));
    }
    void move(int n, char a, char b, char c){
        if(n==1){
            System.out.println(a+"-->"+b);
        }else{
            move(n-1,a,c,b);
            move(1,a,b,c);
            move(n-1,c,b,a);
        }
    }
    void sort(int []a,int n,int index){
        if(index>=n-1) return;
        else{
            int vtmin = index;
            for (int i = vtmin+1; i < n; i++) {
                if(a[vtmin]>a[i]) vtmin=i;
            }
            int temp = a[index];
            a[index]=a[vtmin];
            a[vtmin]=temp;
            sort(a,n,index+1);
        }
    }
    void display(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        DemoRecursion demo = new DemoRecursion();
        System.out.println("10 = "+demo.fac(10));
//        int n = 51966;
        int n = 51966;
        System.out.println(n+" = "+demo.convert(n,16));
//        demo.move(5, 'A', 'B', 'C');
        Random rd = new Random();
        n=10;
        int []a = new int[n];
        for (int i = 0; i < 10; i++) {
            a[i] = rd.nextInt(100);
        }
        System.out.println("");
        demo.display(a);
        demo.sort(a,n,0);
        System.out.println("");
        demo.display(a);
    }
}
