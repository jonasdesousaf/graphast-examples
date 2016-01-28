package org.graphast.example.SpatialIndex;

import org.graphast.config.Configuration;

import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;
import com.graphhopper.routing.util.EdgeFilter;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.storage.GraphBuilder;
import com.graphhopper.storage.GraphStorage;
import com.graphhopper.storage.RAMDirectory;
import com.graphhopper.storage.index.LocationIndex;
import com.graphhopper.storage.index.LocationIndexTree;
import com.graphhopper.storage.index.QueryResult;

public class LocationIndexTreeTeste {
	public static final Point berlin = Geometries.point(52.50188, 13.41573); //lugar simples
	public static final Point monaco = Geometries.point(43.7402, 7.42197); //lugar esparsso id=439
	
	public static void main(String[] args) {
		String dir = Configuration.USER_HOME + "/graphhopper/berlin";
		//String dir = Configuration.USER_HOME + "/graphhopper/monaco";
		EncodingManager em = new EncodingManager("car");
		GraphBuilder gb = new GraphBuilder(em).setLocation(dir).setStore(true);
		GraphStorage gstorage = gb.create();
		gstorage = gb.load();
		
		LocationIndex locationIndexTree = new LocationIndexTree(gstorage, new RAMDirectory(dir, true));
		if (!locationIndexTree.loadExisting()) {
			locationIndexTree.prepareIndex();
		}

		long tempoInicial = System.currentTimeMillis();
		QueryResult point = locationIndexTree.findClosest(berlin.x(), berlin.y(), EdgeFilter.ALL_EDGES);
		//QueryResult point = locationIndexTree.findClosest(monaco.x(), monaco.y(), EdgeFilter.ALL_EDGES);
		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		locationIndexTree.close();

		System.out.println(point.getClosestNode());

		System.out.println("O metodo executou em " + tempoFinal + " milissegundos.");
		System.out.println("========================================================");

	}

}
