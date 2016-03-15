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


public static final Point berlin = Geometries.point(52.50188, 13.41573); //lugar simples
public static final Point monaco = Geometries.point(43.7402, 7.42197); //lugar esparsso id=439

public class RStarTree {
	
	public static <T> Node getNearestNode(RTree<T, Point> tree, double latitude, double longitude) {
		Point pontoConsultado = Geometries.point(latitude, longitude);
		double distanciaMaxima = 0.001;
		int quantidadeMaxima = 1;
		List<Entry<T, Point>> resultado = tree.nearest(pontoConsultado, distanciaMaxima, quantidadeMaxima).toList().toBlocking().single();
		
		while(list.isEmpty()){
			distanciaMaxima = distanciaMaxima * 2;
			resultado = tree.nearest(pontoConsultado, distanciaMaxima, quantidadeMaxima).toList().toBlocking().single();;
		}

		Node nearestNode = new NodeImpl();
		nearestNode.setLatitude(list.get(0).geometry().x());
		nearestNode.setLongitude(list.get(0).geometry().y());
		nearestNode.setId((Long) (list.get(0).value()));

		return nearestNode;
	}

	public static void main(String[] args) throws IOException {
		String dir = Configuration.USER_HOME + "/graphast/berlin";
		
		Graph graph = new GraphImpl(dir);
		graph.load();
		
		RTree<Long, Point> tree = RTree.star().create();
		
		for (long node = 0; node < graph.getNumberOfNodes(); node++) {
			Point p = Geometries.point(graph.getNode(node).getLatitude(), graph.getNode(node).getLongitude());
			tree = tree.add(node, p);
		}
		
		long tempoInicial = System.currentTimeMillis();
		Node nearestNode = getNearestNode(tree, berlin.x(), berlin.y());
		long tempoFinal = System.currentTimeMillis() - tempoInicial2;
		
		System.out.println(nearestNode);
		System.out.println(graph.getOutEdges(nearestNode.getId()));
		System.out.println("O metodo executou em " + tempoFinal2 + " milissegundos.");	
	}
}
