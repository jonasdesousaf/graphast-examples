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

public class Testando {
	public static final String dir = Configuration.USER_HOME + "/graphast/berlin";
	public static final Graph graph = new GraphImpl(dir);
	
	public static final Point cenario1 = Geometries.point(52.50188, 13.41572); //lugar simples
	public static final Point cenario2 = Geometries.point(52.5046, 13.41996); //lugar esparsso
	
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
		graph.load();
		
		RTree <Long, Point> tree = RTree.create();
		
		for (long node = 0; node < graph.getNumberOfNodes(); node++) {
			Point p = Geometries.point(graph.getNode(node).getLatitude(), graph.getNode(node).getLongitude());
			tree = tree.add(node, p);
		}
		
		long tempoInicial = System.currentTimeMillis();
		Node nearestNode = getNearestNode(tree, cenario1.x(), cenario1.y());
		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		
		System.out.println(nearestNode);
		System.out.println("O metodo executou em " + tempoFinal + " milissegundos.");
	}
}