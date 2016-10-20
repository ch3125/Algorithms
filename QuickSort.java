/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class QuickSort {
public static int partition(int[] arr,int p,int r){
    int x=arr[r];
    int i=p;
    for(int j=p;j<r;j++){
        if(arr[j]<x){
            
            swap(arr,i,j);
               i++;
           
          
    }
    }
    swap(arr,r,i);
    return i;
}
public static void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
public static void quicksort(int[] arr,int p,int r){
    if(p<r){
      int q=  partition(arr,p,r);
      quicksort(arr,p,q-1);
      quicksort(arr,q+1,r);
    }
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
           }
        System.out.println("Elements before sorting");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
       
        quicksort(arr,0,n-1);
         System.out.println("Elements after sorting");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
