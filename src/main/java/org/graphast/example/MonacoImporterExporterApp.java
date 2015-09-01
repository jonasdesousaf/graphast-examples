package org.graphast.example;

import java.io.PrintWriter;

import org.graphast.config.Configuration;
import org.graphast.importer.OSMImporterImpl;
import org.graphast.model.Edge;
import org.graphast.model.Graph;

public class MonacoImporterExporterApp {
	public static void main( String[] args ) {
		String osmFile = MonacoImporterExporterApp.class.getResource("/monaco-150112.osm.pbf").getPath();
		String graphastMonacoDir = Configuration.USER_HOME + "/graphast/monaco";
		
		Graph graph = new OSMImporterImpl(osmFile, graphastMonacoDir).execute();
		System.out.println("Number of nodes:" + graph.getNumberOfNodes());
		System.out.println("Number of edges:" + graph.getNumberOfEdges());

		String path = Configuration.USER_HOME + "/" + "monaco-graph.csv";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(path);
			long n = graph.getNumberOfEdges();
			for (long i=0; i < n; i++) {
				Edge e = graph.getEdge(i);
				long fromNode = e.getFromNode();
				long toNode = e.getToNode();
				pw.print(fromNode);
				pw.print(",");
				pw.println(toNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
