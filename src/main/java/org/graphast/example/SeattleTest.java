package org.graphast.example;

import java.io.IOException;
import java.text.ParseException;

import org.graphast.model.Graph;
import org.graphast.query.route.shortestpath.AbstractShortestPathService;

public class SeattleTest {

	private static Graph seattleGraph;
	protected static AbstractShortestPathService serviceSeattle;
	
	public static void main( String[] args ) throws NumberFormatException, IOException, ParseException {
		
////		seattleGraph = generateSeattle();
//		
//		
//		
//		seattleGraph = new GraphImpl(Configuration.USER_HOME + "/graphast/test/seattle");
//		seattleGraph.load();
//		
//		System.out.println(seattleGraph.getNumberOfNodes());
//		System.out.println(seattleGraph.getNumberOfEdges());
//		
////		seattleGraph.logNodes();
//		
//		
//		serviceSeattle = new DijkstraLinearFunction(seattleGraph);
//		
//		
//		Long source = seattleGraph.getNodeId(47.650698,-122.393716);
//		Long target = seattleGraph.getNodeId(47.555501,-122.283506);
//		Date time = DateUtils.parseDate(8, 0, 0);
//
//		StopWatch sw = new StopWatch();
//
//		sw.start();
//		Path shortestPath = serviceSeattle.shortestPath(source, target,time);
//		sw.stop();
//
//		
//		System.out.println(shortestPath.toString());
//		System.out.println("Execution Time of shortestPathWashintonTest(): {}ms" + sw.getTime());
//		System.out.println("Path Total Distance: {}" + shortestPath.getTotalDistance());
//		System.out.println("Path Total Cost: {}"+ shortestPath.getTotalCost());
//
//		for(Point point : shortestPath.getGeometry()) {
//			System.out.println(point.getLatitude() + "," + point.getLongitude());
//		}
		
		
	}
	
//	public static GraphBounds generateSeattle() throws NumberFormatException, IOException {

//		String osmFile = SeattleTest.class.getResource("/seattle.osm.pbf").getPath();
//		String graphHopperSeattleDir = Configuration.USER_HOME + "/graphhopper/test/seattle";
//		String graphastSeattleDir = Configuration.USER_HOME + "/graphast/test/seattle";
//
//		GraphBounds graph = new OSMImporterImpl(osmFile, graphHopperSeattleDir, graphastSeattleDir).execute();
//		
//		System.out.println("Importação de POIS iniciada!");
//		POIImporter.importPoIList(graph, SeattleTest.class.getResource("/seattlepois.csv").getPath());
//		System.out.println("Importação de POIS finalizada!");
//		
//		System.out.println("Geração de custos aleatórios iniciada!");
//		CostGenerator.generateAllSyntheticEdgesCosts(graph);
//		System.out.println("Geração de custos aleatórios finalizada!");
//		
//		graph.save();
//		return graph;
//
//	}
}
