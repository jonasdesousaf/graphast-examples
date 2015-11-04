package org.graphast.example;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.graphast.app.AppGraph;
import org.graphast.app.GraphInfo;
import org.graphast.app.GraphService;
import org.graphast.geometry.Point;
import org.graphast.model.Graph;
import org.graphast.model.GraphBounds;
import org.graphast.query.route.osr.BoundsRoute;
import org.graphast.query.route.osr.OSRSearch;
import org.graphast.query.route.shortestpath.AbstractShortestPathService;
import org.graphast.query.route.shortestpath.dijkstra.DijkstraConstantWeight;
import org.graphast.query.route.shortestpath.model.Path;
import org.graphast.util.DateUtils;
import org.graphast.util.StringUtils;

public class MonacoTest {

	protected static AbstractShortestPathService serviceMonaco;

	private static OSRSearch osr;
	private static GraphBounds graphBoundsPoI, graphBoundsPoIReverse;

	public static void main( String[] args ) throws NumberFormatException, IOException, ParseException {

		osrMonaco();
//		dijkstraMonaco();

	}

	public static void dijkstraMonaco() throws NumberFormatException, IOException {

		GraphService service = new GraphService();
		GraphInfo gi = new GraphInfo();

		gi.setAppName("monaco-osr");
		gi.setNetwork("http://download.geofabrik.de/europe/monaco-latest.osm.pbf");
		gi.setPoiCategoryFilter(StringUtils.splitIntToList(",","6,46,34,33,29,25,23,22,162,13,105"));

		service.create(gi);
		service.load("monaco-osr");

//		System.out.println(seattleGraph.getNumberOfNodes());
//		System.out.println(seattleGraph.getNumberOfEdges());
		
//		seattleGraph.logNodes();
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

	public static void osrMonaco() throws NumberFormatException, IOException {

		GraphService service = new GraphService();
		GraphInfo gi = new GraphInfo();
		gi.setAppName("monaco-osr");
		gi.setNetwork("http://download.geofabrik.de/europe/monaco-latest.osm.pbf");
		gi.setPoiCategoryFilter(StringUtils.splitIntToList(",","6,46,34,33,29,25,23,22,162,13,105"));
		service.create(gi);
		service.load("monaco-osr");

		short graphType = 0;

		graphBoundsPoI = AppGraph.getGraph();

		serviceMonaco = new DijkstraConstantWeight(graphBoundsPoI);

		osr = new OSRSearch(graphBoundsPoI, graphType);

		ArrayList<Integer> categories = new ArrayList<Integer>();
		categories.add(23);
		categories.add(25);

		Date date = DateUtils.parseDate(16, 0, 0);

		Graph graph = osr.getGraphAdapter();

		Long source = graph.getNodeId(47.641336,-122.391472);
		Long target = graph.getNodeId(47.550811,-122.297401);

		Path resultPath = osr.getFullPath(graph.getNode(source), graph.getNode(target), date, categories);

		int counter = 0;
		System.out.println("sequence,latitude,longitude");
		for(Point points : resultPath.getGeometry()) {
			counter ++;
			System.out.println(counter + "," + points.getLatitude() + "," + points.getLongitude());
		}
		
	}
}
