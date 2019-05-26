package main;

public class edge implements Comparable<edge>{
			int source;
			int destination;
			int weight;
			edge(int source, int destination, int weight){
				this.source = source;
				this.destination = destination;
				this.weight = weight;
			}
			
			@Override
			public int compareTo(edge o) {
				return this.weight-o.weight;
			}
}