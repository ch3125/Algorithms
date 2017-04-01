/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activityselection;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Home
 */
public class ActivitySelection {
    static void printMaxActivities(int[] s,int[] f,int n ){
        int i,j;
        System.out.println("The selected activities are: ");
        i=0;
        System.out.print(i+" ");
        for( j=1;j<n;j++){
            if(s[j]>=f[i]){
                System.out.print(j+" ");
                i=j;
            }
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,Integer> mappy=new HashMap<>();
        System.out.println("Enter the number of activities ");
        int n=sc.nextInt();
        System.out.println("Enter the starting and ending time of activities in ascending order of ending time");
        int s[]=new int[n];
        int f[]=new int[n];
        for(int i=0;i<n;i++){
            s[i]=sc.nextInt();
            f[i]=sc.nextInt();
        }
        printMaxActivities(s,f,n);
       
        
   
        
        
        
    }
    
}
