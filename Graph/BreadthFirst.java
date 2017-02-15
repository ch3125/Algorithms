/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breadthfirst;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Home
 */
public class BreadthFirst {

    private int V;
    private LinkedList<Integer> adj[];
    BreadthFirst(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }
    void addEdge(int a,int b){
        adj[a].add(b);
    }
    void BFS(int s){
        boolean visited[]=new boolean[V];
        //create a queue for BFS
        LinkedList<Integer> queue=new LinkedList<>();
        visited[s]=true;
                queue.add(s);
                while(queue.size()!=0){
                    s=queue.poll();
                    System.out.print(s+" ");
                    
                    Iterator<Integer> i=adj[s].listIterator();
                    while(i.hasNext()){
                        int n=i.next();
                        if(!visited[n]){
                            visited[n]=true;
                            queue.add(n);
                        }
                    }
                
        
        
        
    };
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BreadthFirst bf=new BreadthFirst(4);
        bf.addEdge(0,1);
         bf.addEdge(0, 2);
        bf.addEdge(1, 2);
        bf.addEdge(2, 0);
        bf.addEdge(2, 3);
        bf.addEdge(3, 3);
        System.out.println("Results: ");
        bf.BFS(2);
        
        
    }
    
}
