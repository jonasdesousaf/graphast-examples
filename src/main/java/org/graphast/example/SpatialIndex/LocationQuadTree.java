package org.graphast.example.SpatialIndex;

import org.graphast.config.Configuration;

import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;
import com.graphhopper.routing.util.EdgeFilter;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.storage.GraphBuilder;
import com.graphhopper.storage.GraphStorage;
import com.graphhopper.storage.RAMDirectory;
import com.graphhopper.storage.index.Location2IDQuadtree;
import com.graphhopper.storage.index.LocationIndex;
import com.graphhopper.storage.index.QueryResult;

public class LocationQuadTree {
	public static final Point cenario1 = Geometries.point(52.50188, 13.41572); //lugar simples id=2145 / idExt=4642
	public static final Point cenario2 = Geometries.point(52.5046, 13.41996); //lugar esparsso

	public static void main(String[] args) {
		String dir = Configuration.USER_HOME + "/graphhopper/berlin";
		EncodingManager em = new EncodingManager("car");
		GraphBuilder gb = new GraphBuilder(em).setLocation(dir).setStore(true);
		GraphStorage gstorage = gb.create();
		gstorage = gb.load();
		
		LocationIndex locationIndexQuad = new Location2IDQuadtree(gstorage, new RAMDirectory(dir, true));
		if (!locationIndexQuad.loadExisting()) {
			locationIndexQuad.prepareIndex();
		}

		long tempoInicial = System.currentTimeMillis();
		QueryResult point = locationIndexQuad.findClosest(cenario1.x(), cenario1.y(), EdgeFilter.ALL_EDGES);
		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		locationIndexQuad.close();

		System.out.println(point.getClosestNode());

		System.out.println("O metodo executou em " + tempoFinal + " milissegundos.");
		System.out.println("========================================================");
	}
}