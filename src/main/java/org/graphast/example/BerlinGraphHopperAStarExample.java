package org.graphast.example;

import org.graphast.config.Configuration;
import org.graphast.importer.OSMToGraphHopperReader;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.util.StopWatch;

public class BerlinGraphHopperAStarExample {

	public static void main(String[] args) {
		String graphhopperMonacoDir = Configuration.USER_HOME + "/graphhopper/berlin";
		GraphHopper hopper = OSMToGraphHopperReader.createGraph(null, graphhopperMonacoDir, false, false);

		StopWatch sw = new StopWatch();
		sw.start();
		GHRequest req = new GHRequest(52.535926,13.192974, 52.52651,13.493285).setVehicle("car").setAlgorithm("astar");
		GHResponse res = hopper.route(req);
		sw.stop();
		System.out.println("execution time(ms):" + sw.getTime());
		System.out.println("distance:" + res.getDistance());
		System.out.println("points:" + res.getPoints().getSize());
		System.out.println("time(min):" + res.getMillis() / 1000.0 / 60.0);
		System.out.println(res.getInstructions());
	}

}
