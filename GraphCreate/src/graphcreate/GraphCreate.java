/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcreate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Vertex{
    private ArrayList<Edge> neighborhood; 
    private String label;

    public Vertex(String label) {
    this.label=label;
    neighborhood=new ArrayList<>();
    }
    public void addNeighbor(Edge edge){
        if(this.neighborhood.contains(edge))
            return;
        this.neighborhood.add(edge);
    }
    public boolean containsNeighbor(Edge edge){
        return this.neighborhood.contains(edge);
    }
    public Edge getNeighbor(int i){
        return this.neighborhood.get(i);
    }
    Edge removeNeighbor(int i){
        return this.neighborhood.remove(i);
        }
    public void removeNeighbor(Edge e){
        this.neighborhood.remove(e);
    }
    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    public String getLabel(){
        return this.label;
    }
    @Override
    public String toString(){
        return "Vertex "+label;
    }
    public ArrayList<Edge> getNeighbors(){

        return new ArrayList<Edge>(this.neighborhood);

    }
    

    
    
}
class Edge implements Comparable<Edge>{
    private Vertex one,two;
    private int weight;

    public Edge(Vertex one, Vertex two) {
        this(one,two,1);
    }

    public Edge(Vertex one, Vertex two, int weight) {
        this.one = (one.getLabel().compareTo(two.getLabel())<=0)?one:two;
        this.two = (this.one==one)?two:one;
        this.weight = weight;
    }
    public Vertex getNeighbor(Vertex current){
        if(!(current.equals(one))|| current.equals(two))
            return null;
        return current.equals(one)?two:one;
    }
    public Vertex getOne(){
        return this.one;
    }
    public Vertex getTwo(){
        return this.two;
    }
    public void setWeight(int weight){
        this.weight=weight;
    }
    public int getWeight(){
        return this.weight;
    }
    @Override
    public int compareTo(Edge other){
        return this.weight-other.weight;
       }
    @Override
     public String toString(){
        return "({" + one + ", " + two + "}, " + weight + ")";

    }
    @Override
    public int hashCode(){
        return (one.getLabel() + two.getLabel()).hashCode();}
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Edge))
        return false;
          Edge e = (Edge)other;
        return e.one.equals(this.one) && e.two.equals(this.two);
        
    }

    
}
class Graph{
    private HashMap<String,Vertex> vertices;
    private HashMap<Integer,Edge> edges;

    public Graph() {
        this.vertices=new HashMap<>();
        this.edges=new HashMap<>();
    }
    public Graph(ArrayList<Vertex> vertices){
        this.vertices=new HashMap<>();
        this.edges=new HashMap<>();
        for(Vertex v:vertices){
            this.vertices.put(v.getLabel(), v);
        }
    }
    public boolean addEdge(Vertex one,Vertex two){
        return addEdge(one,two,1);
    }
     public boolean addEdge(Vertex one,Vertex two,int weight){
        if(one.equals(two))
            return false;
        
        Edge e=new Edge(one,two,weight);
       if(edges.containsKey(e.hashCode())) {
           return false;
        }
       else if(one.containsNeighbor(e) || two.containsNeighbor(e))
           return false;
       edges.put(e.hashCode(), e);
       one.addNeighbor(e);
       two.addNeighbor(e);
       return true;
    }
     public boolean containsEdge(Edge e){
         if(e.getOne()==null || e.getTwo()==null)
             return false;
         return this.edges.containsKey(this.hashCode());
     }
     
     public Edge removeEdge(Edge e){
         e.getOne().removeNeighbor(e);
         e.getTwo().removeNeighbor(e);
         return this.edges.remove(e.hashCode());
     }
     public boolean containsVertex(Vertex v){
         return this.vertices.get(v.getLabel())!=null;
     }
     public Vertex getVertex(String label){
         return vertices.get(label);
     }
     public boolean addVertex(Vertex v,boolean overwriteExisting){
         Vertex current=this.vertices.get(v.getLabel());
         if(current!=null){
             if(!overwriteExisting)
                 return false;
             while(current.getNeighborCount()>0){
                 this.removeEdge(current.getNeighbor(0));
             }
             
         }
         vertices.put(v.getLabel(), v);
         return true;
     }
     public Vertex removeVertex(String label){
        Vertex v= vertices.remove(label);
        while(v.getNeighborCount()>0){
        this.removeEdge(v.getNeighbor(0));
        }
        return v;
     }
        public Set<String> vertexKeys(){
            return this.vertices.keySet();
        }
        public Set<Edge> getEdges(){
            return new HashSet<>(this.edges.values());
        } 
     }
     
    
    

public class GraphCreate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph graph=new Graph();
        Vertex[] vertices=new Vertex[5];
        for(int i=0;i<vertices.length;i++){
            vertices[i]=new Vertex(""+i);
            graph.addVertex(vertices[i], true);
    }
        for(int i=0;i<vertices.length-1;i++){
            for(int j=i+1;j<vertices.length;j++){
                   graph.addEdge(vertices[i], vertices[j]);
               graph.addEdge(vertices[i], vertices[j]);
               graph.addEdge(vertices[j], vertices[i]);

            }
        }
        for(int i=0;i<vertices.length;i++){
            System.out.println(vertices[i]);
            for(int j=0;j<vertices[i].getNeighborCount();j++){
                System.out.println(vertices[i].getNeighbor(j));
            }
            System.out.println();
        }
        
    
    
}
}