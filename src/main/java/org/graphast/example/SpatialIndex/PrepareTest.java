package org.graphast.example.SpatialIndex;

import java.io.IOException;
import java.util.List;

import org.graphast.config.Configuration;
import org.graphast.model.Graph;
import org.graphast.model.GraphImpl;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;

public class PrepareTest {
	public static final Point cenario1 = Geometries.point(52.50188, 13.41572); //lugar simples
	public static final Point cenario2 = Geometries.point(52.5046, 13.41996); //lugar esparsso

	public static void main(String[] args) throws IOException {
		String dir = Configuration.USER_HOME + "/graphast/berlin";
		
		Graph graph = new GraphImpl(dir);
		graph.load();
		
		RTree<Long, Point> tree = RTree.star().create();
		
		for (long node = 0; node < graph.getNumberOfNodes(); node++) {
			Point p = Geometries.point(graph.getNode(node).getLatitude(), graph.getNode(node).getLongitude());
			tree = tree.add(node, p);
		}
		
		List<Entry<Long, Point>> list = tree.nearest(cenario1, 1, 15).toList().toBlocking().single();
		
		for (Entry<Long, Point> i : list) {
			System.out.println(i.value() + " / " + i.geometry().x() + " / " + i.geometry().y());
		}
	}
}