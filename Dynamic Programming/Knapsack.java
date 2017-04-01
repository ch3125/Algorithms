/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class Knapsack {

  static int max(int a,int b){
      return (a>b?a:b);
  }
  static int knapSack(int W,int[] wt,int[] val,int n){
      int i,w;
      int B[][]=new int[n+1][W+1];
      //build the table in bottom-up fashion
      for(i=0;i<=n;i++){
          for(w=0;w<=W;w++){
              if(i==0 || w==0){
                  B[i][w]=0;
              }
              else if(wt[i-1]<=w){
                  B[i][w]=max(val[i-1]+B[i-1][w-wt[i-1]],B[i-1][w]);
              }
              else
                  B[i][w]=B[i-1][w];
              
          }
      }
  return B[n][W];
  }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of objects");
        int n=sc.nextInt();
        System.out.println("Enter the weight of each object");
        int[] wt=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        System.out.println("Enter the value of each object");
        int val[]=new int[n];
         for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
         System.out.println("Enter the maximum weight that can be there in the knapsack");
         int W=sc.nextInt();
         System.out.println("Maximum value of items that can be filledin the knapsack : "+knapSack(W,wt,val,n));
        
        
    }
    
}
