/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoSort;

/**
 *
 * @author User
 */
public class RadixSort {
    void sort(int []a){
        int exp=1;//so chu so co trong so lon nhat cu mang a
        int n=a.length;
        int []c=new int[n];
        int max = a[0];
        for(int i=1;i<n;i++){
            max=a[i]>max?a[i]:max;  
        }
        while((max/exp)!=0){
            int []b=new int [10];
            for (int i=0;i<n;i++){
                (b[a[i]/exp%10])++;
            }
            for (int i = 1; i < 10; i++) {
                b[i]+=b[i-1];
            }
            for (int i = n-1; i >= 0; i--) {
                c[--b[a[i]]/exp%10]=a[i];
            }
            for (int i = 0; i < n; i++) {
                a[i]=c[i];
            }
            exp*=10;
        }
    }
}
