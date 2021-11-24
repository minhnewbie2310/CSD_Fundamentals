
import java.io.RandomAccessFile;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Solve {

    int n = 9;
    int[][] a;
    
    public Solve() {
        a = new int[n][n];
        try {
            RandomAccessFile raf = new RandomAccessFile("input.txt", "r");
            String line = "";
            int i = 0;
            while ((line = raf.readLine()) != null) {
                String[] s = line.split("\\s+");
                for (int j = 0; j < s.length; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
                i++;
            }
        } catch (Exception e) {
        }
    }

    void solve(int x, int y) {
        if (y == 9) {
            if (x == 8) {
                display();
            } else {
                solve(x + 1, 0);
            }
        } else {
            if (a[x][y] == 0) {
                boolean[] b = new boolean[10];
                Arrays.fill(b, true);
                for (int i = 0; i < n; i++) {
                    b[a[x][i]] = false;  //phuong phap mang chi so
                    b[a[i][y]] = false;
                }
                for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
                    for (int j = x / 3 * 3; j < x / 3 * 3 + 3; j++) {
                        b[a[i][j]] = false;
                    }
                }
                for (int i = 0; i <= n; i++) {
                    if (b[i]) {
                        a[x][y] = i;
                        solve(x, y + 1);
                        a[x][y] = 0;
                    }
                }
            } else {
                solve(x, y + 1);
            }
        }
    }

    void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Solve solve = new Solve();
        solve.display();
        System.out.println("");
        solve.solve(0, 0);
        
    }
}
