/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disjointset;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Home
 */
public class DisjointSet {
    private Map<Long,Node> map=new HashMap<>();
    public class Node{
        long data;
        Node parent;
        int rank;
    }
    //function to create a set
    public void makeSet(long data){
        Node node=new Node();
        node.data=data;
        node.parent=node;
        node.rank=0;
        
    }
    //combines two sets to one,does union by rank
    public void Union(long data1,long data2){
        Node node1=map.get(data1);
        Node node2=map.get(data2);
        
        Node parent1=findSet(node1);
        Node parent2=findSet(node2);
        //if they belong to same set,do nothing
        if(parent1.data==parent2.data)
            return;
        
        //else whose ever rank is higher becomes the parent of other
        if(parent1.rank>=parent2.rank){
           //increment rank only if both sets have same rank
           parent1.rank=(parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
           parent2.parent=parent1;
        }
        else{
            parent1.parent=parent2;
        }
        
        
    }
    //finds representative of set
    public long findSet(long data){
        return findSet(map.get(data).data);
    }
    //finding the set of a node and also doing compression
    public Node findSet(Node node){
        Node parent=node.parent;
        if(parent==node){
            return parent;
        }
        node.parent=findSet(parent);
        return node.parent;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        DisjointSet ds=new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);
        
        ds.Union(1, 2);
        ds.Union(2, 3);
        ds.Union(4, 5);
        ds.Union(5, 6);
        ds.Union(6, 7);
        
       System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
         System.out.println(ds.findSet(3));
          System.out.println(ds.findSet(4));
           System.out.println(ds.findSet(5));
            System.out.println(ds.findSet(6));
             System.out.println(ds.findSet(7));
        
        
    }
    
}
