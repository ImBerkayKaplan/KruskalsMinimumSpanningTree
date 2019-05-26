package main;

public class UnionFind {
int vertices[];
int size;
	UnionFind(int length){
		vertices = new int[length];
		size = 0;
	}
	
	void MakeSet(){
		vertices[size] = size;
		size++;
	}
	
	int FindSet(int vertex){
		int result;
		if(vertex == vertices[vertex]){
			result = vertex;
		}else{
		    result = FindSet(vertices[vertex]);
		}
		return result;
	}
	
	void Union(int x, int y){
		int x1 = FindSet(x);
		int y1 = FindSet(y);
		vertices[y1] = x1;
	}
}
