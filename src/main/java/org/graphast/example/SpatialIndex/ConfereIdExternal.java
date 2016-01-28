package org.graphast.example.SpatialIndex;

import java.io.IOException;

import org.graphast.config.Configuration;
import org.graphast.model.Graph;
import org.graphast.model.GraphImpl;

public class ConfereIdExternal {
	
	public static void main(String[] args) throws IOException {
		String dir = Configuration.USER_HOME + "/graphast/berlin";
		
		Graph graph = new GraphImpl(dir);
		graph.load();
		
		long id = 4642;
		
		for (int i = 0; i < graph.getNumberOfNodes(); i++) {
			if(graph.getNode(i).getExternalId() == id){
				System.out.println(graph.getNode(i));
				break;
			}
		}
	}
}