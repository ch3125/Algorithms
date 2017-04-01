
package lcs;

import java.util.Scanner;

public class Lcs {
    public static int max(int a,int b){
       return (a>b)?a:b;
    }

    public static int lcsa(String[] x,String[] y){
        int m=x.length;
        int n=y.length;
        int[][] l=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    l[i][j]=0;
                }
                else if(x[i-1] == null ? y[j-1] == null : x[i-1].equals(y[j-1])){
                    l[i][j]=1+l[i-1][j-1];
                }
                else{
                    l[i][j]=max(l[i-1][j],l[i][j-1]);
                }
            }
        }
        
      return l[m][n];  
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the strings to be compared");
        String x=sc.next();
        String y=sc.next();
        String[] xa=x.split("");
        String[] ya=y.split("");
        System.out.println("Longest common subsequence for the provided strings are: "+lcsa(xa,ya));
        
    }
    
}
