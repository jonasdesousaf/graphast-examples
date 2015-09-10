package org.graphast.example;

import java.io.PrintWriter;

import org.graphast.config.Configuration;
import org.graphast.importer.OSMImporterImpl;
import org.graphast.model.Edge;
import org.graphast.model.Graph;

public class FortalezaImporterExporterApp {
	public static void main( String[] args ) {
		String osmFile = Configuration.USER_HOME + "/tmp/fortaleza_brazil.osm.pbf";
		String graphastMonacoDir = Configuration.USER_HOME + "/graphast/fortaleza";
		
		Graph graph = new OSMImporterImpl(osmFile, graphastMonacoDir).execute();
		System.out.println("Number of nodes:" + graph.getNumberOfNodes());
		System.out.println("Number of edges:" + graph.getNumberOfEdges());

		String path = Configuration.USER_HOME + "/tmp/" + "fortaleza-graph.csv";
		String path2 = Configuration.USER_HOME + "/tmp/" + "fortaleza-graph.txt";
		PrintWriter pw = null;
		PrintWriter pw2 = null;
		try {
			pw = new PrintWriter(path);
			pw2 = new PrintWriter(path2);
			long n = graph.getNumberOfEdges();
			for (long i=0; i < n; i++) {
				Edge e = graph.getEdge(i);
				long fromNode = e.getFromNode();
				long toNode = e.getToNode();
				pw.print(fromNode);
				pw.print(",");
				pw.println(toNode);
				
				pw2.print(graph.getNode(fromNode).getLatitude());
				pw2.print(",");
				pw2.print(graph.getNode(toNode).getLatitude());
				pw2.print(",");
				pw2.print(graph.getNode(fromNode).getLongitude());
				pw2.print(",");
				pw2.print(graph.getNode(toNode).getLongitude());
				pw2.print(",");
				pw2.println(e.getLabel());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (pw2 != null) {
				pw2.close();
			}
		}
	}
}
