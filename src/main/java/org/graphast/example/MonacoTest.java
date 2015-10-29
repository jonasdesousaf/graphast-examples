package org.graphast.example;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.graphast.config.Configuration;
import org.graphast.importer.CostGenerator;
import org.graphast.importer.OSMImporterImpl;
import org.graphast.importer.POIImporter;
import org.graphast.model.Edge;
import org.graphast.model.Graph;
import org.graphast.model.GraphBounds;
import org.graphast.model.GraphBoundsImpl;
import org.graphast.model.Node;
import org.graphast.query.route.osr.BoundsRoute;
import org.graphast.query.route.osr.OSRSearch;
import org.graphast.query.route.osr.Sequence;
import org.graphast.query.route.shortestpath.AbstractShortestPathService;
import org.graphast.query.route.shortestpath.dijkstra.DijkstraConstantWeight;
import org.graphast.query.route.shortestpath.model.Path;
import org.graphast.util.DateUtils;

import com.graphhopper.util.StopWatch;

public class MonacoTest {

	private static Graph monacoGraph;
	protected static AbstractShortestPathService serviceMonaco;

	private static OSRSearch osr;
	private static GraphBounds graphBoundsPoI, graphBoundsPoIReverse;

	public static void main( String[] args ) throws NumberFormatException, IOException, ParseException {

//				graphBoundsPoI = generateMonaco();
	
		short graphType = 0;

		//		seattleGraph = new GraphImpl(Configuration.USER_HOME + "/graphast/test/seattle");
		//		graphBoundsPoI.load();

		graphBoundsPoI =  new GraphBoundsImpl(Configuration.USER_HOME + "/graphast/test/monaco");
		graphBoundsPoI.load();

		graphBoundsPoIReverse = new GraphBoundsImpl(Configuration.USER_HOME + "/graphast/test/monaco");
		graphBoundsPoIReverse.load();

		graphBoundsPoIReverse.reverseGraph();

		serviceMonaco = new DijkstraConstantWeight(graphBoundsPoI);
		
		//		graphBoundsPoI.logNodes();

		BoundsRoute bounds = new BoundsRoute(graphBoundsPoI, graphType);

		osr = new OSRSearch((GraphBounds)graphBoundsPoI, bounds, (GraphBounds)graphBoundsPoIReverse);


		ArrayList<Integer> categories = new ArrayList<Integer>();
		categories.add(6);
		categories.add(161);

		Date date = DateUtils.parseDate(8, 0, 0);

		Graph graph = osr.getGraphAdapter();
		
		Long source = graph.getNodeId(43.726669,7.417574);
		Long target = graph.getNodeId(43.749366,7.436328);
		

		Sequence seq = osr.search(graph.getNode(source), graph.getNode(target), date, categories);

		List<Long> result = osr.search(graph.getNode(source), graph.getNode(target), date, categories).getPath();

		List<Path> allPaths = new ArrayList<Path>();
		
		for(int i=0; i<result.size(); i++) {
			if(i==result.size()-2) {
				break;
			}
			
			source = graph.getNodeId(graph.getNode(result.get(i)).getLatitude(),graph.getNode(result.get(i)).getLongitude());
			target = graph.getNodeId(graph.getNode(result.get(i+1)).getLatitude(),graph.getNode(result.get(i+1)).getLongitude());
		
			StopWatch sw = new StopWatch();

			sw.start();
			Path shortestPath = serviceMonaco.shortestPath(source, target);
			sw.stop();
			
			allPaths.add(shortestPath);
		
		}
		
		
		int counter = 0;
		System.out.println("sequence,latitude,longitude");
		for(Long points : result) {
			counter ++;
			System.out.println(counter + "," + graph.getNode(points).getLatitude() + "," + graph.getNode(points).getLongitude());
		}
		
		
		System.out.println("seq.getDistance(): " + seq.getDistance());
		System.out.println("seq.getTimeToService(): " + seq.getTimeToService());
		System.out.println("seq.getWaitingTime(): " + seq.getWaitingTime());



		//		System.out.println(seattleGraph.getNumberOfNodes());
		//		System.out.println(seattleGraph.getNumberOfEdges());

		//		seattleGraph.logNodes();
		//		
		//		


		//		serviceSeattle = new DijkstraLinearFunction(seattleGraph);
		//		
		//		
//				Long source = seattleGraph.getNodeId(47.650698,-122.393716);
//				Long target = seattleGraph.getNodeId(47.555501,-122.283506);
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

	public static GraphBounds generateMonaco() throws NumberFormatException, IOException {

		String osmFile = SeattleTest.class.getResource("/monaco-150112.osm.pbf").getPath();
		String graphHopperMonacoDir = Configuration.USER_HOME + "/graphhopper/test/monaco";
		String graphastMonacoDir = Configuration.USER_HOME + "/graphast/test/monaco";

		GraphBounds graph = new OSMImporterImpl(osmFile, graphHopperMonacoDir, graphastMonacoDir).execute();

		System.out.println("Importação de POIS iniciada!");
		POIImporter.importPoIList(graph, MonacoTest.class.getResource("/monacopois.csv").getPath());
		System.out.println("Importação de POIS finalizada!");

		System.out.println("Geração de custos aleatórios iniciada!");
		CostGenerator.generateAllSyntheticEdgesCosts(graph);
		System.out.println("Geração de custos aleatórios finalizada!");

		graph.save();
		return graph;

	}
}
