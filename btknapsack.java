import java.util.Scanner;

public class btknapsack {

    private int n,W;  //number of items and maximum capacity
    private int w[],v[];  //weights and values of items
    private int V[][];  //table to store results of sub-problems


    public btknapsack(int n, int W,int[] weightArray, int[] profitArray){
        this.n=n;
        this.W=W;
        w = new int[n];
        v = new int[n];
        for(int i = 0; i < n; i++){
            w[i] = weightArray[i];  //weight of item
            v[i] = profitArray[i];  //profit of item
        }
        V = new int[n+1][W+1];  //initializing the table to hold results
        for(int i = 0; i <= W; i++) V[0][i] = 0;
    }


    public void knapsack(){
        //table for backtracking to get the items chosen
        int x[][] = new int[n+1][W+1];
        //filling tables
        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= W; j++)
                if((w[i-1] <= j) && (v[i-1]+V[i-1][j-w[i-1]] > V[i-1][j])){
                    V[i][j] = v[i-1] + V[i-1][j-w[i-1]];
                    x[i][j] = 1;
                }
                else{
                    V[i][j] = V[i-1][j];
                    x[i][j] = 0;
                }
        //backtracking
        System.out.printf("chosen\n%5s%7s%7s\n", "Item","Weight","Profit");
        int K = W;
        for(int i = n; i >= 1; i--)
            if(x[i][K] == 1){
                System.out.printf("%5d%7d%7d\n",i,w[i-1],v[i-1]);
                K -= w[i-1];
            }
        System.out.println("Maximum profit : "+V[n][W]);
    }
}