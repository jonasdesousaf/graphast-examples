package org.graphast.example;

import org.graphast.config.Configuration;
import org.graphast.importer.OSMImporterImpl;
import org.graphast.model.Graph;

public class ImporterApp {
	public static void main( String[] args ) {
		String osmFile = ImporterApp.class.getResource("/monaco-150112.osm.pbf").getPath();
		String graphastMonacoDir = Configuration.USER_HOME + "/graphast/monaco";
		
		Graph graph = new OSMImporterImpl(osmFile, graphastMonacoDir).execute();
		System.out.println("Number of nodes:" + graph.getNumberOfNodes());
		System.out.println("Number of edges:" + graph.getNumberOfEdges());
	}
}
