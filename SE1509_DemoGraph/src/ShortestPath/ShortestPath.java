/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShortestPath;

import java.io.RandomAccessFile;

/**
 *
 * @author TrungLT
 */
public class ShortestPath {

    /**
     * @param args the command line arguments
     */
    char[] v = "ABCDEFGHIJKLMNOP".toCharArray();
    int[][] a;
    int n;
    int INF=999;

    public ShortestPath() {
        try {
            RandomAccessFile raf = new RandomAccessFile("shortest.txt", "r");
            n = Integer.parseInt(raf.readLine());
            a = new int[n][n];
            String s = "";
            int k = 0;
            while ((s = raf.readLine()) != null) {
                String[] s1 = s.split("\\s+");
                for (int i = 0; i < s1.length; i++) {
                    a[k][i] = Integer.parseInt(s1[i]);
                }
                k++;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[j][i] = a[i][j];
                }
            }
        } catch (Exception e) {
        }
    }

    int floyd(int b, int e) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = a[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        return d[b][e];
    }

    void dijkstra(int fro, int to){
        int i, j, k, t, INF;
        INF = 999;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        int[] ss = new int[n]; // ss[0], ss[1], ss[2],... are vertices sequentially selected to S
        int[] pp = new int[n]; // ss[0] -> ss[1] -> ss[2],... is the shortest path
        int m, r; // m is number of vertices in S,
        // r is the number of vertices in shortest path 
        j = 0;

        // select fro into the set S
        S[fro] = true;
        ss[0] = fro;
        while (true) {// find min d[i] in the set of those vertices not selected into S
            k = -1;
            t = INF;
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) {
                return; // no solution
            }           // select k into the set S
            S[k] = true;
            j++;
            ss[j] = k;
            if (k == to) {
                break;
            }
            // Recalculate d[i]
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        m = j;
        MyStack s = new MyStack();
        i = to;
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        j = 0;
        while (!s.isEmpty()) {
            i = s.pop();
            pp[j++] = i;
        }
        r = j;
        System.out.print("" + v[pp[0]]+"("+deg(pp[i])+")");
        for (i = 1; i < r; i++) {
            System.out.print("   " + v[pp[i]]);
        }
        System.out.print("\r\n");
        System.out.print("" + d[pp[0]]);
        for (i = 1; i < r; i++) {
            System.out.println("   " + d[pp[i]]);
        }
        System.out.print("\r\n");
        
    }
    int deg(int i)
   {int s,j;
    s = 0;
    
    for(j=0;j<n;j++){
        if(a[i][j]!=0&&a[i][j]!=INF){
            s++;
        }
    }
    
    return(s);
   }
    void display() {
        System.out.println("");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ShortestPath sh = new ShortestPath();
        sh.display();
        System.out.println("Khoang cach ngan nhat tu A -> D: " + sh.floyd(0, 3));
        sh.dijkstra(0, 3);
    }
}

class MyStack{
    Node head;
    
    public MyStack(){
        head = null;
    }
   
    boolean isEmpty(){
        return head == null;
    }

    void push(int x){
        Node n = new Node(x);
        if (isEmpty()){
            head = n;
        }else{
            n.next = head;
            head = n;
        }

    }

    int pop(){
        if (isEmpty()){
            return -1;
        }
        
        int value = head.value;
        head = head.next;
        return value;
    }
}

class Node{
    int value;
    Node next;

    public Node(int value){
        next = null;
    }
}
