/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author Hector Felix
 */
public class Knapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] w = new int[]{1, 2, 3, 4};
        int[] v = new int[]{6, 8, 9, 10};
        int W = 7;

        knap knap = new knap();
        for (int i = 0; i <= W; i++) {
            if (i < 10) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        knap.knapsackDP(w, v, w.length, W);
        System.out.println();
        System.out.println();
        System.out.println("OPTIMUM SOLUTION: "+ (knap.knapsackRec(w, v, w.length, W)));
    }
}
