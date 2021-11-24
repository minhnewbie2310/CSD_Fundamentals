/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoGraph;

import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class MyGraph {
    int n;
    int [][]a;
    
    public MyGraph(){
        try {
            RandomAccessFile raf = new RandomAccessFile("inputGraph.txt", "r");
            n = Integer.parseInt(raf.readLine());
            a = new int[n][n];
            String line ="";
            int i=0;
            while((line=raf.readLine())!=null){
                String []s = line.split("\\s+");
                for (int j = 0; j < 10; j++) {
                    a[i][j]=Integer.parseInt(s[j]);
                }
                i++;
            }
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    a[k][j]=a[j][k];
                }
            }
        } catch (Exception e) {
            
        }
    }
    void display(){
        System.out.println("");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    char convert(int x){
        return (char)(x+65);
    }
    void BreadthFirst(char x){
        int vertex = (int)(x-65);
        boolean[] p = new boolean[n];
        Arrays.fill(p, true);
        MyQueue q = new MyQueue();
        p[vertex]=false;
        q.EnQueue(vertex);
        while(!q.isEmpty()){
            int v=q.DeQueue();
            visit(v);
            for (int i = 0; i < n; i++) {
                if(p[i]&&a[v][i]!=0){
                    q.EnQueue(i);
                    p[i]=false;
                }
            }
        }
    }
    void depthFirst(char x){
        boolean []p = new boolean[n];
        Arrays.fill(p,true);
        int vertex = (int)(x-65);
        p[vertex]=false;
        depth(vertex,p);
    }
    void depth(int x,boolean []p){
        for(int i=0;i<n;i++){
            if(p[i]&&a[x][i]!=0){
                p[i]=false;
                depth(i,p);
            }
        }
    }    
    private void visit(int x){
        System.out.println(convert(x)+"-->");
    }   
    public static void main(String[] args) {
        MyGraph my = new MyGraph();
        my.display();
        System.out.println("");
        my.BreadthFirst('A');
        
    }
}
