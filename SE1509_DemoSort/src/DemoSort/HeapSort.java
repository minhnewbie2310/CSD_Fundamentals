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
public class HeapSort {
    void heap(int []a){
        int n=a.length;
        for (int i = 1; i < n; i++) {
            int x=a[i];
            int f=i;
            while(f>0&&x>a[(f-1)/2]){
                a[f]=a[(f-1)/2];
                f=(f-1)/2;
            }
            a[f]=x; 
        }
    }
    void sort(int []a){
        heap(a);
        int n = a.length;
        for (int i = n-1; i > 0; i--) {
            int x=a[i];
            a[i]=a[0];
            int f=0;
            int c=2*f+1;
            if(c+1<i&&a[c+1]<a[c]){
                c=c+1;
            }
            while(c<i&&x<a[c]){
                a[f]=a[c];
                f=c;
                c=2*c+1;
                if(c+1<i&&a[c+1]>a[c]){
                    c=c+1;
                }
            }
            a[f]=x;
        }
                
    }
}
