/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depthfirst;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Home
 */
public class DepthFirst {

   private int V;
   private LinkedList<Integer> adj[];
   DepthFirst(int v){
       V=v;
       adj=new LinkedList[v];
       for(int i=0;i<v;i++){
           adj[i]=new LinkedList();
       }
   }
   void addNew(int v,int x){
       adj[v].add(x);
   }
   void DFSUtil(int v,boolean[] visited){
       visited[v]=true;
       System.out.print(v+" ");
       
       Iterator<Integer> i;
       i = adj[v].listIterator();
       while(i.hasNext()){
           int n=i.next();
           if(!visited[n]){
               DFSUtil(n,visited);
           }
       }
     }
   void DFS(int v){
       boolean visited[]=new boolean[V];
       DFSUtil(v,visited);
   }
   
    public static void main(String[] args) {
        // TODO code application logic here
        DepthFirst g = new DepthFirst(4);
 
        g.addNew(0, 1);
        g.addNew(0, 2);
        g.addNew(1, 2);
        g.addNew(2, 0);
        g.addNew(2, 3);
        g.addNew(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
    }
    
}
