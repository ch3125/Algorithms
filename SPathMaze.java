/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monk2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author chhavi
 */


public class SPathMaze {
int N=10;
   // Below arrays details all 4 possible movements from a cell
 int row[] = { -1, 0, 0, 1 };
 int col[] = { 0, -1, 1, 0 };
 // Function to check if it is possible to go to position (row, col) 
// from current position. The function returns false if the cell
// not a valid position or has value 0 or it is already visited
boolean isValid(int mat[][], boolean visited[][], int row, int col)
{
	return (row >= 0) && (row < N) && (col >= 0) && (col < N) 
		&& mat[row][col]==1 && !visited[row][col];
}
// Find Shortest Possible Route in a matrix mat from source 
// cell (i, j) to destination cell (x, y)
void BFS(int mat[][], int i, int j, int x, int y)
{
//construct a matrix to keep track of visited cells
    boolean[][] visited=new boolean[N][N];
    Queue<Node> q=new LinkedList<>();
    //mark source cell as visited and enque the source node
    visited[i][j]=true;
    q.add(new Node(i,j,0));
    int min_dist=Integer.MAX_VALUE;
    while(!q.isEmpty()){
     //   System.out.println(q.size());
        // pop front node from queue and process it
        Node curr=q.poll();
        // (i, j) represents current cell and dist stores its
		// minimum distance from the source
         int ia=curr.x,ja=curr.y,dist=curr.dist;
         	// if destination is found, update min_dist and stop
		if (ia == x && ja == y) 
		{
			min_dist = dist;
			break;
		}
                // check for all 4 possible movements from current cell
		// and enqueue each valid movement into the queue
		for (int k = 0; k < 4; k++) 
		{
			// check if it is possible to go to position
			// (i + row[k], j + col[k]) from current position
			if (isValid(mat, visited, ia + row[k], ja + col[k])) 
			{
				// mark next cell as visited and enqueue it
				visited[ia + row[k]][ja + col[k]] = true;
				q.add(new Node( ia + row[k], ja + col[k], dist + 1 ));
			}
		}
	}

	if (min_dist != Integer.MAX_VALUE)
		System.out.println( "The shortest path from source to destination has length " +min_dist);
	else
		System.out.println( "Destination can't be reached from given source");
                
    }
    
    

 
    
    public static void main(String[] args){
        //the input matrix.1 represents the positions where movement is allowed, 0 is not allowed
        
        int[][] mat=new int[][]{
		{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
		{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
		{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
		{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
		{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
		{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
		{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
		{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
		{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
		{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
	};
        SPathMaze sp=new SPathMaze();
        sp.BFS(mat, 0, 0, 7, 5);
        
    }
}
    class Node{
        
	// (x, y) represents matrix cell cordinates
	// dist represent its minimum distance from the source
    int x,y,dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
}
