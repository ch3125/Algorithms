/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancode;

import java.util.*;
/**
 *
 * @author Home
 */

 class HeapNode{
     int val;
    char chars ;
   HeapNode left,right;

    public HeapNode(int data, char chars) {
        this.val = data;
        this.chars = chars;
        this.left=null;
        this.right=null;
    }

    

    public HeapNode(int data, char chars, HeapNode left, HeapNode right) {
        this.val = data;
        this.chars = chars;
        this.left = left;
        this.right = right;
    }

    public void setLeft(HeapNode left) {
        this.left = left;
    }

    public void setRight(HeapNode right) {
        this.right = right;
    }
    

    
    
    }
 class MinHeap {
   
    public HeapNode[] Heap;
    public int size;
    public int capacity;
   

    public MinHeap(int capacity) {
        this.size=0;
        Heap=new HeapNode[capacity];
        this.capacity=capacity;
        }
    private int parent(int pos)
    {
        return pos / 2;
    }
 
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    private boolean isLeaf(int pos){
        if(pos >= size/2 && pos<size)
            return true;
        return false;
    }
    boolean isLeaf(HeapNode root)
{
    return (root.left==null) && (root.right==null) ;
}
    private void swap(int pos1,int pos2){
       HeapNode k=Heap[pos1];
        Heap[pos1]=Heap[pos2];
        Heap[pos2]=k;
        
    }
    private void minHeapify(int idx){
        int smallest=idx;
        int left=2*idx;
        int right=2*idx+1;
        if(left<size && Heap[left].val<Heap[smallest].val){
            smallest=left;
        }
        if(right<size && Heap[right].val<Heap[smallest].val)
            smallest=right;
        if(smallest!=idx){
        swap(idx,smallest);
        minHeapify(smallest);}
    }
    boolean isSizeOne()
{
    return (size == 1);
}
    public void insert(HeapNode element)
    {
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current].val < Heap[parent(current)].val)
        {
            swap(current,parent(current));
            current = parent(current);
        }	
}
    
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            minHeapify(pos);
        }
    }
    
    
    public HeapNode extractMin(){
        HeapNode req=Heap[0];
        Heap[0]=Heap[size-1];
        --size;
        minHeapify(0);
        return req;
    }
    
    // The main function that builds Huffman tree
 HeapNode buildHuffmanTree(char data[], int freq[], int size)
{
 HeapNode left, right, top;
 
    minHeap();
 
    // Iterate while size of heap doesn't become 1
    while (!isSizeOne())
    {
        // Step 2: Extract the two minimum freq items from min heap
        left = extractMin();
        right = extractMin();
 
        // Step 3:  Create a new internal node with frequency equal to the
        // sum of the two nodes frequencies. Make the two extracted node as
        // left and right children of this new node. Add this node to the min heap
        // '$' is a special value for internal nodes, not used
        top = new HeapNode( left.val + right.val,'$');
        top.left = left;
        top.right = right;
        insert(top);
    }
 
    // Step 4: The remaining node is the root node and the tree is complete.
    return extractMin();
}
 // Prints huffman codes from the root of Huffman Tree.  It uses arr[] to
// store codes
void printCodes(HeapNode root, int arr[], int top)
{
    // Assign 0 to left edge and recur
    if (root.left!=null)
    {
        arr[top] = 0;
        printCodes(root.left, arr, top + 1);
    }
 
    // Assign 1 to right edge and recur
    if (root.right!=null)
    {
        arr[top] = 1;
        printCodes(root.right, arr, top + 1);
    }
 
    // If this is a leaf node, then it contains one of the input
    // characters, print the character and its code from arr[]
    if (isLeaf(root))
    {
        System.out.println(root.val);
        printArr(arr, top);
    }
}
    void HuffmanCodes(char data[], int freq[], int size)
{
   //  Construct Huffman Tree
   HeapNode root = buildHuffmanTree(data, freq, size);
 
   // Print Huffman codes using the Huffman tree built above
   int arr[]=new int[size], top = 0;
   printCodes(root, arr, top);
}

     
// A utility function to print an array of size n
void printArr(int arr[], int n){
    int i;
    for (i = 0; i < n; ++i)
        System.out.print(arr[i]);
    System.out.println();
   
}

    
}
public class HuffmanCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);

         char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
    int freq[] = {5, 9, 12, 13, 16, 45};
    int size = 6;
    MinHeap min=new MinHeap(size);
    min.HuffmanCodes(arr, freq, size);
        
                }
        
    }
    

