/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package min.cost.path;

import java.util.Scanner;


public class MinCostPath {
    
public static int min(int a,int b,int c){
    if(a<b && a<c) return a;
    else if(b<a && b<c) return b;
    else return c;
}
   public static int minCost(int cost[][],int m,int n){
       int[][] tc=new int[m+1][n+1];
       tc[0][0]=cost[0][0];
       for(int i=1;i<=m;i++){
           tc[i][0]=tc[i-1][0]+cost[i][0];
       }
       for(int j=1;j<=n;j++){
           tc[0][j]=tc[0][j-1]+cost[0][j];
       }
       
       for(int i=1;i<=m;i++){
           for(int j=1;j<=n;j++){
              tc[i][j]=min(tc[i-1][j-1],tc[i][j-1],tc[i-1][j])+cost[i][j];
             
           }
       }
       return tc[m][n];

}
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the matrix");
        int x=sc.nextInt();
        int y=sc.nextInt();
        int[][] cost=new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                cost[i][j]=sc.nextInt();
                }
        }
        System.out.println("Enter the position to which min cost path is to be found ");
        int m=sc.nextInt();
        int n=sc.nextInt();
        if(m<x && n<y){
            System.out.println("Minimum cost distance from (0,0) to ("+m+","+n+") is : "+minCost(cost,m,n));
        }
        
                
        
        
    }
    
}
