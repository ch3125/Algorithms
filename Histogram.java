/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monk2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author home
 */
public class Histogram {
      static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args){
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int[] histogram=new int[n];
        for(int i=0;i<n;i++){
            histogram[i]=sc.nextInt();
        }
        Stack<Integer> height=new Stack<>();
        Stack<Integer> position=new Stack<>();
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
        //    System.out.println(largest);
            if(height.isEmpty() || height.peek()<histogram[i]){
                height.push(histogram[i]);
                position.push(i);
                
            }else if(height.peek()>histogram[i]){
                int htemp,ptemp=0;
                while(!height.isEmpty() && height.peek()>histogram[i]){
                     htemp=height.pop();
                 ptemp=position.pop();
                int tempsize=htemp*((i)-ptemp);
            //    System.out.println("looping"+largest+" "+tempsize+" "+height.size());
                largest=Math.max(tempsize, largest);
                }
                    height.push(histogram[i] );
                    position.push(ptemp);
                
            }
        }
        while(!height.isEmpty()){
            int temp=height.pop()*((n)-position.pop());
            largest=Math.max(temp,largest);
        }
        System.out.println(largest);
    }
    
}
