package org.graphast.example.SpatialIndex;

import java.io.IOException;
import java.util.List;

import org.graphast.config.Configuration;
import org.graphast.model.Graph;
import org.graphast.model.GraphImpl;
import org.graphast.model.Node;
import org.graphast.model.NodeImpl;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;

public class RTreeTeste {
	public static final Point berlin = Geometries.point(52.50188, 13.41573); //lugar simples
	public static final Point monaco = Geometries.point(43.7402, 7.42197); //lugar esparsso id=439
	
	public static <T> Node getNearestNode(RTree <T, Point> tree, double latitude, double longitude) {
		double maxDistance = 0.001;
		int maxCount = 1;
		Point query = Geometries.point(latitude, longitude);
		List<Entry<T, Point>> list = tree.nearest(query, maxDistance, maxCount).toList().toBlocking().single();
		
		while(list.isEmpty()){
			maxDistance = maxDistance * 2;
			list = tree.nearest(query, maxDistance, maxCount).toList().toBlocking().single();
		}
		
		Node nearestNode = new NodeImpl();
		nearestNode.setLatitude(list.get(0).geometry().x());
		nearestNode.setLongitude(list.get(0).geometry().y());
		nearestNode.setId((Long) (list.get(0).value()));

		return nearestNode;
	}

	public static void main(String[] args) throws IOException {
		String dir = Configuration.USER_HOME + "/graphast/berlin";
		//String dir = Configuration.USER_HOME + "/graphast/monaco
		
		Graph graph = new GraphImpl(dir);
		graph.load();
		
		RTree <Long, Point> tree = RTree.create();
		
		for (long node = 0; node < graph.getNumberOfNodes(); node++) {
			Point p = Geometries.point(graph.getNode(node).getLatitude(), graph.getNode(node).getLongitude());
			tree = tree.add(node, p);
		}
		
		long tempoInicial = System.currentTimeMillis();
		Node nearestNode = getNearestNode(tree, berlin.x(), berlin.y());
		//Node nearestNode = getNearestNode(tree, monaco.x(), monaco.y());
		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		
		System.out.println(nearestNode);
		System.out.println("O metodo executou em " + tempoFinal + " milissegundos.");
	}
}