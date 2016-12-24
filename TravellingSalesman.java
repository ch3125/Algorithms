/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

/**
 *
 * @author Home
 */
public class TravellingSalesman {
    private static final int INFINITY=10000;
    
    private static class Index{
        int currentVertex;
        Set<Integer> vertexSet;
        
        @Override
        public boolean equals(Object o){
            if(this==o) return true;
            if(o==null || getClass()!=o.getClass())  return false;
            Index index=(Index)o;
            if(currentVertex!=index.currentVertex)return false;
             return !(vertexSet != null ? !vertexSet.equals(index.vertexSet) : index.vertexSet != null);
        }
        
        @Override
        public int hashCode(){
            int result=currentVertex;
            result=31*result+(vertexSet!=null?vertexSet.hashCode():0);
            return result;
        }
        private static Index createIndex(int vertex,Set<Integer> vertexSet){
            Index i=new Index();
            i.currentVertex=vertex;
            i.vertexSet=vertexSet;
            return i;
        }
    }
    private static class setSizeComparator implements Comparator<Set<Integer>>{
        @Override
        public int compare(Set<Integer> o1,Set<Integer> o2){
            return o1.size()-o2.size();
        }
}
    
    public int minCost(int[][] distance){
        //stores intermediate values in map
        //stores the cost of reaching the vertex via all sets in the vertex set
        Map<Index,Integer> mincostDP=new HashMap<>();
        //stores info about the vertex before the currentvertex
        Map<Index,Integer> parent=new HashMap<>();
        //to generate all combinations of set except start vertex
        //{} {1} {2} {3} {1,2} {2,3} {1,3}
       List<Set<Integer>> allSets=generateCombination(distance.length-1);
        for(Set<Integer> set:allSets){
            for(int currentVertex=1;currentVertex<distance.length;currentVertex++){
                if(set.contains(currentVertex)){
                    continue;
                }
                Index index=Index.createIndex(currentVertex, set);
                int minCost=INFINITY;
                int minPrevVertex=0;
                //to avoid exception while iterating,we need to copy the set
                Set<Integer> copySet=new HashSet<>(set);
                for(int prevVertex:set){
                    int cost=distance[prevVertex][currentVertex]+getCost(copySet,prevVertex,mincostDP);
                    if(cost<minCost){
                        minCost=cost;
                        minPrevVertex=prevVertex;
                    }
                }
//for empty subset
if(set.size()==0){
    minCost=distance[0][currentVertex];
}
mincostDP.put(index,minCost);
parent.put(index,minPrevVertex);
            }
        }
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<distance.length;i++){
            set.add(i);
        }
        int min=Integer.MAX_VALUE;
        int prevVertex=-1;
        Set<Integer> copySet=new HashSet<>(set);
        for(int k:set){
            int cost=distance[k][0]+getCost(copySet,k,mincostDP);
            if(cost<min){
                min=cost;
                prevVertex=k;
            }
        }
        parent.put(Index.createIndex(0, set),prevVertex);
        printTour(parent,distance.length);
        return min;
        
    }
    
      private void printTour(Map<Index, Integer> parent, int totalVertices) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < totalVertices; i++) {
            set.add(i);
        } 
        Integer start = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(true) { 
            stack.push(start);
            set.remove(start);
            start = parent.get(Index.createIndex(start, set));
            if(start == null) {
                break; 
            } 
        } 
        StringJoiner joiner = new StringJoiner("->");
        stack.forEach(v -> joiner.add(String.valueOf(v)));
        System.out.println("\nTSP tour");
        System.out.println(joiner.toString());
    } 
      
    private int getCost(Set<Integer> set,int prevVertex,Map<Index,Integer> mincostDP){
        set.remove(prevVertex);
        Index index=Index.createIndex(prevVertex, set);
        int cost=mincostDP.get(index);
        set.add(prevVertex);
        return cost;
    }
    private List<Set<Integer>> generateCombination(int n){
        int[] input=new int[n];
        for(int i=0;i<input.length;i++)
        {
            input[i]=i+1;}
            List<Set<Integer>> allSets=new ArrayList<>();
            int result[]=new int[input.length];
            generateCombination(input,0,0,allSets,result);
            Collections.sort(allSets, new setSizeComparator());
            return allSets;
        }
    private void generateCombination(int[] input,int start,int pos,List<Set<Integer>> allSets,int result[]){
        if(pos==input.length){
            return;
        }
        Set<Integer> set=CreateSet(result,pos);
        allSets.add(set);
        for(int i=start;i<input.length;i++){
            result[pos]=input[i];
            generateCombination(input,i+1,pos+1,allSets,result);
        }
    }
    private static Set<Integer> CreateSet(int input[],int pos){
        if(pos==0)
            return new HashSet<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<pos;i++)
            set.add(input[i]);
        return set;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int[] cities={1,2,3,4};
        int[][] distance=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                distance[i][j]=sc.nextInt();
            }
        }
        TravellingSalesman ts=new TravellingSalesman();
        System.out.println(ts.minCost(distance));
    }
    
}
