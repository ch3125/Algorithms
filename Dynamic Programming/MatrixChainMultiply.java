/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixchainmultiply;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class MatrixChainMultiply {

    public static int MCM(int[] p,int n){
        int[][] m=new int[n][n];
        int q;
        for(int i=1;i<n;i++){
            m[i][i]=0;
            }
        for(int l=2;l<n;l++){
            for(int i=1;i<n-l+1;i++){
               int j=i+l-1;
               if(j==n)
                   continue;
               m[i][j]=Integer.MAX_VALUE;
               for(int k=i;k<=j-1;k++){
                   //q is the cost
                   q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                   if(q<m[i][j])
                       m[i][j]=q;
               }
            }
        }
        return m[1][n-1];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] p=new int[n];
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        System.out.println("Minimum number of multiplication is "+MCM(p,n));
        
    }
    
}
