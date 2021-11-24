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
public class MergeSort {
    void merge(int[] a, int begin, int end, int middle) {
        //giả sử mảng a từ begin -> middle-1 đã sort, từ middle-1 -> end đã sort
        int i = begin, j = middle, k = 0; // i thuộc begin -> middle-1; j thuộc middle -> end
        int[] c = new int[end - begin];
        while (i < middle && j < end) {
            if (a[i] < a[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = a[j];
                j++;
            }
            k++;
        }

        if (i == middle) { //nửa đầu hết, nửa sau còn
            for (; j < end; j++) {
                c[k++] = a[j];
            }
        } else { //nửa đầu còn, nửa sau hêt
            for (; i < middle; i++) {
                c[k++] = a[i];
            }
        }

        for (i = begin; i < end; i++) {
            a[i] = c[i - begin];
        }
    }

    void sort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        if (end <= begin + 2) {
            if (a[begin] > a[end - 1]) {
                a[begin] = a[begin] + a[end - 1];
                a[end - 1] = a[begin] - a[end - 1];
                a[begin] = a[begin] - a[end - 1];
            }
        } else {
            int m = (begin + end) / 2;
            sort(a, begin, m);
            sort(a, m, end);
            merge(a, begin, end, m);
        }
    }
}
