/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.ArrayList;

/**
 *
 * @author Hector Felix
 */
public class knap {

    public int knapsackRec(int[] w, int[] v, int n, int W) {
        if (n <= 0) {
            return 0;
        } else if (w[n - 1] > W) {
            return knapsackRec(w, v, n - 1, W);
        } else {
            return Math.max(knapsackRec(w, v, n - 1, W), v[n - 1] + knapsackRec(w, v, n - 1, W - w[n - 1]));
        }
    }

    int knapsackDP(int[] w, int[] v, int n, int W) {
        ArrayList<Integer> al = new ArrayList<>();
        
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                    al.add(w[n-1]);
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - w[i - 1]] + v[i - 1]);
                    al.add(w[n-1]);
                }
//                al.add(n);
            }
            //al.add(w[n-1]);
        }
        print2D(m);
        
        //System.out.println("\n\n"+al);

        return m[n][W];
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows 
        for (int i = 0; i < mat.length; i++) {
            System.out.println();
            // Loop through all elements of current row 
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] < 10) {
                    System.out.print(mat[i][j] + "  ");
                }
                else
                System.out.print(mat[i][j] + " ");
            }
        }
    }
}
