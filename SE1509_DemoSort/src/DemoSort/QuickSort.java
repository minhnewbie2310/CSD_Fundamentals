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
public class QuickSort {
    int indexPartition(int a[], int begin, int end){
        int pivot = a[begin];
        int u=begin,d=end,temp;
        while(u<d){
            while(u<d&&a[d]>pivot) d--; //tim dc value cuoi cung nho hon pivot
            while(u<d&&a[u]<=pivot) u++; //tim dc value dau tien lon hon pivot
            if(u<d){
                temp=a[u];
                a[u]=a[d];
                a[d]=temp;
            }
            
        }
        a[begin]=a[d];
        a[d]=pivot;
        return 0;
    }
    void sort(int []a, int begin, int end){
        if(begin<end){
            int index = indexPartition(a, begin, end);
            sort(a, begin, index-1);
            sort(a, index +1 , end);
        }
            
    }
}
