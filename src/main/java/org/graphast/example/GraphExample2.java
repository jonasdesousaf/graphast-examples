package org.graphast.example;

import org.graphast.config.Configuration;
import org.graphast.model.Graph;
import org.graphast.model.GraphImpl;

public class GraphExample2 {
	public static void main( String[] args ) {
		// The graph in ${USER_HOME}/graphast/example must already exist.
		Graph graph = new GraphImpl(Configuration.USER_HOME + "/graphast/example");
		graph.load();
		System.out.println("Number of nodes:" + graph.getNumberOfNodes());
		System.out.println("Number of edges:" + graph.getNumberOfEdges());
		System.out.println(graph.getEdge(1).getLabel());
		
	}
}
