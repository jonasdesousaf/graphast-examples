package org.graphast.example.SpatialIndex;

import org.graphast.config.Configuration;

import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;
import com.graphhopper.routing.util.EdgeFilter;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.storage.GraphBuilder;
import com.graphhopper.storage.GraphStorage;
import com.graphhopper.storage.index.Location2IDFullIndex;
import com.graphhopper.storage.index.LocationIndex;
import com.graphhopper.storage.index.QueryResult;

public class Location2IdFullIndex {
	public static final Point cenario1 = Geometries.point(52.50188, 13.41572); //lugar simples
	public static final Point cenario2 = Geometries.point(52.5046, 13.41996); //lugar esparsso

	public static void main(String[] args) {
		String dir = Configuration.USER_HOME + "/graphhopper/berlin";
		EncodingManager em = new EncodingManager("car");
		GraphBuilder gb = new GraphBuilder(em).setLocation(dir).setStore(true);
		GraphStorage gstorage = gb.create();
		gstorage = gb.load();
		
		LocationIndex location2IDFullIndex = new Location2IDFullIndex(gstorage);
		if (!location2IDFullIndex.loadExisting()){
			location2IDFullIndex.prepareIndex();
		}
		
		long tempoInicial = System.currentTimeMillis();
		QueryResult point = location2IDFullIndex.findClosest(cenario1.x(), cenario1.y(), EdgeFilter.ALL_EDGES);
		long tempoFinal = System.currentTimeMillis()-tempoInicial;
		
		location2IDFullIndex.close();
		
		System.out.println(point.getClosestNode());
		
		System.out.println("O metodo executou em " + tempoFinal + " milissegundos.");
		System.out.println("========================================================");

	}
}