/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class CoinChange {
   public static int cp(int amount, int[] coins) {
		int[] coinReq = new int[amount+1]; 
		int[] CC = new int[coins.length]; 
		coinReq[0] = 0; 
		for (int amt = 1; amt <= amount; amt++) {
			for (int j = 0; j < CC.length; j++) {
				CC[j] = -1;
			}
			
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= amt) { 
					CC[j] = coinReq[amt - coins[j]] + 1; 
											
					
				}
			}
		
			coinReq[amt]=-1;
			for(int j=1;j<CC.length;j++){
				if(CC[j]>0 && (coinReq[amt]==-1 || coinReq[amt]>CC[j])){
					coinReq[amt]=CC[j];
				}
			}
		}
		//return the optimal solution for amount
		return coinReq[amount];
		
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Enter the total sum: ");
       Scanner sc=new Scanner(System.in);
       int p=sc.nextInt();
       System.out.println("Enter the number of changes available");
       int k=sc.nextInt();
        int[] change=new int[k];
       System.out.println("Enter the denominations of the change");
      
       for(int i=0;i<k;i++){
           change[i]=sc.nextInt();
       }
     
       System.out.println(cp(p,change));
    }
    
}
