package org.graphast.example;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.graphast.config.Configuration;
import org.graphast.geometry.Point;
import org.graphast.importer.CostGenerator;
import org.graphast.importer.OSMImporterImpl;
import org.graphast.importer.POIImporter;
import org.graphast.model.Graph;
import org.graphast.model.GraphBounds;
import org.graphast.model.GraphBoundsImpl;
import org.graphast.query.route.osr.BoundsRoute;
import org.graphast.query.route.osr.OSRSearch;
import org.graphast.query.route.osr.Sequence;
import org.graphast.query.route.shortestpath.AbstractShortestPathService;
import org.graphast.query.route.shortestpath.dijkstra.DijkstraConstantWeight;
import org.graphast.query.route.shortestpath.model.Path;
import org.graphast.util.DateUtils;

public class MonacoTest {

	protected static AbstractShortestPathService serviceMonaco;

	private static OSRSearch osr;
	private static GraphBounds graphBoundsPoI, graphBoundsPoIReverse;

	public static void main( String[] args ) throws NumberFormatException, IOException, ParseException {

		graphBoundsPoI = generateMonaco();

		short graphType = 0;

		graphBoundsPoI =  new GraphBoundsImpl(Configuration.USER_HOME + "/graphast/test/monaco");
		graphBoundsPoI.load();

		graphBoundsPoIReverse = new GraphBoundsImpl(Configuration.USER_HOME + "/graphast/test/monaco");
		graphBoundsPoIReverse.load();

		graphBoundsPoIReverse.reverseGraph();

		serviceMonaco = new DijkstraConstantWeight(graphBoundsPoI);

		BoundsRoute bounds = new BoundsRoute(graphBoundsPoI, graphType);

		osr = new OSRSearch((GraphBounds)graphBoundsPoI, bounds, (GraphBounds)graphBoundsPoIReverse);

		ArrayList<Integer> categories = new ArrayList<Integer>();
		categories.add(34);
		categories.add(13);

		Date date = DateUtils.parseDate(8, 0, 0);

		Graph graph = osr.getGraphAdapter();

		Long source = graph.getNodeId(43.726669,7.417574);
		Long target = graph.getNodeId(43.749366,7.436328);

		Sequence seq = osr.search(graph.getNode(source), graph.getNode(target), date, categories);

		Path resultPath = osr.getFullPath(graph.getNode(source), graph.getNode(target), date, categories);
		int counter = 0;
		System.out.println("sequence,latitude,longitude");
		for(Point points : resultPath.getGeometry()) {
			counter ++;
			System.out.println(counter + "," + points.getLatitude() + "," + points.getLongitude());
		}


		System.out.println("seq.getDistance(): " + seq.getDistance());
		System.out.println("seq.getTimeToService(): " + seq.getTimeToService());
		System.out.println("seq.getWaitingTime(): " + seq.getWaitingTime());

	}

	public static GraphBounds generateMonaco() throws NumberFormatException, IOException {

		String osmFile = SeattleTest.class.getResource("/monaco-150112.osm.pbf").getPath();
		String graphHopperMonacoDir = Configuration.USER_HOME + "/graphhopper/test/monaco";
		String graphastMonacoDir = Configuration.USER_HOME + "/graphast/test/monaco";

		GraphBounds graph = new OSMImporterImpl(osmFile, graphHopperMonacoDir, graphastMonacoDir).execute();

		Integer[] poiFilter = new Integer[] {6,46,34,33,29,25,23,22,162,13,105};

		System.out.println("Importação de POIS iniciada!");
		POIImporter.importPoIList(graph, MonacoTest.class.getResource("/monacopois").getPath(), Arrays.asList(poiFilter));
		System.out.println("Importação de POIS finalizada!");

		System.out.println("Geração de custos aleatórios iniciada!");
		CostGenerator.generateAllSyntheticEdgesCosts(graph);
		System.out.println("Geração de custos aleatórios finalizada!");

		graph.save();
		return graph;

	}
}
