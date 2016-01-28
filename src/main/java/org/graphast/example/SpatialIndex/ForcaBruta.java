package org.graphast.example.SpatialIndex;

import java.io.IOException;

import org.graphast.config.Configuration;
import org.graphast.model.Graph;
import org.graphast.model.GraphImpl;
import org.graphast.model.Node;
import org.graphast.model.NodeImpl;
import org.graphast.util.DistanceUtils;

import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;

public class ForcaBruta {
	public static final Point berlin = Geometries.point(52.50188, 13.41573); //id=12732 / externalId=26120
	public static final Point monaco = Geometries.point(43.7402, 7.42197); //id=439 / 
	
	public static Node getNearestNode (Graph graph, double latitude, double longitude) {
		Node point = new NodeImpl();
		point.setLatitude(latitude);
		point.setLongitude(longitude);
		Node aproximated = graph.getNode(0);
		Node aux = new NodeImpl();
		for (long i = 0; i< graph.getNumberOfNodes(); i++) {
			aux = graph.getNode(i);
			if (DistanceUtils.distanceLatLong(point, aux) < DistanceUtils.distanceLatLong(point, aproximated)) {
				aproximated = aux;
			}
		}
		return aproximated;
	}

	public static void main(String[] args) throws IOException {
		String dir = Configuration.USER_HOME + "/graphast/berlin";
		//String dir = Configuration.USER_HOME + "/graphast/monaco";
		
		Graph graph = new GraphImpl(dir);
		graph.load();
		
		long tempoInicial = System.currentTimeMillis();
		Node nearestNodeForca = getNearestNode(graph, berlin.x(), berlin.y());
		//Node nearestNodeForca = getNearestNode(graph, monaco.x(), monaco.y());
		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		System.out.println(nearestNodeForca);
		System.out.println("O metodo executou em " + tempoFinal + " milissegundos.");
	}
}