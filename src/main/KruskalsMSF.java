package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class KruskalsMSF{

    public static void main(String[] args) throws IOException {

	// Check for errors in case the user does not enter the input file
	if(args.length != 1){
	    System.err.println("Please enter the input file as a command line arguments to construct the tree. (java main.KruskalsMSF <input-file>. input-file should be in the bin folder.)");
	    System.exit(1);
	}

    	// Get the input file and set the data structures
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        String line = input.readLine();
        int numofvertices = Integer.parseInt(line);
        PriorityQueue<edge> Q = new PriorityQueue<edge>();
        UnionFind F = new UnionFind(numofvertices);
        
	// Make a set for each vertex
        for(int counter1 = 0; counter1<numofvertices;counter1++){
        	F.MakeSet();
        }
        
	// Add all the edges to the priority queue
        while((line = input.readLine()) != null){
        	
        	// Get the position of the comma, colon, and the end.
        	int comma = line.indexOf(",");
        	int colon = line.indexOf(":");
        	int length = line.length();
        	
        	// Get the start node, end node, and the weight
        	int source = Integer.parseInt(line.substring(0, comma));
        	int destination = Integer.parseInt(line.substring(comma+1,colon));
        	int weight = Integer.parseInt(line.substring(colon+1,length));

        	edge e = new edge(source,destination,weight);
        	Q.add(e);
        }
        
        // Union the sets
        while(!Q.isEmpty() && F.vertices.length > 1){
        	edge e = Q.poll();
        	if(F.FindSet(e.source)!=F.FindSet(e.destination)){
        		System.out.println(e.source+", " + e.destination + ":" + e.weight);
        		F.Union(e.source, e.destination);
        	}
        	
        }
        input.close();
    }
}
