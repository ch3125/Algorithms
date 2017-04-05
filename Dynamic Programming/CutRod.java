/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cutrod;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class CutRod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int[] lengths=new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] price=new int[]{1,5,8,9,10,17,17,20,24,30};
        int x=cut_rod(price,price.length+1);
        System.out.println(x);
        
    }
    
    public static int cut_rod(int[] price,int n){
        int[] r=new int[n];
        r[0]=0;
        int q;
        for(int i=1;i<n;i++){
            q=Integer.MIN_VALUE;
            for(int j=1;j<=i;j++){
                q=Math.max(q,price[j-1]+r[i-j]);
            }
            r[i]=q;
            
            
        }
        return r[n-1];
    }
    
}
