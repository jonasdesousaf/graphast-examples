package org.graphast.example;

import org.graphast.config.Configuration;
import org.graphast.model.Graph;
import org.graphast.model.GraphImpl;
import org.graphast.query.route.shortestpath.ShortestPathService;
import org.graphast.query.route.shortestpath.dijkstra.DijkstraConstantWeight;
import org.graphast.query.route.shortestpath.model.Path;

import com.graphhopper.util.StopWatch;

public class BerlinGraphastExample {
	public static void main( String[] args ) {
		// The graph in ${USER_HOME}/graphast/example must already exist.
		Graph graph = new GraphImpl(Configuration.USER_HOME + "/graphast/berlin");
		graph.load();
		System.out.println("Number of nodes:" + graph.getNumberOfNodes());
		System.out.println("Number of edges:" + graph.getNumberOfEdges());
		System.out.println(graph.getEdge(1).getLabel());
		long from = graph.getNodeId(52.535926,13.192974);
		long to = graph.getNodeId(52.52651,13.493285);
		// 52.535926,13.192974, 52.52651,13.493285
		ShortestPathService shortestPath = new DijkstraConstantWeight(graph);
		StopWatch sw = new StopWatch();
		sw.start();
		Path path = shortestPath.shortestPath(from, to);
		sw.stop();
		System.out.println("execution time(ms):" + sw.getTime());
		System.out.println(from);
		System.out.println(to);
		System.out.println(path);
		
	}
}
