package org.graphast.example;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import javax.sound.midi.Sequence;

import org.graphast.model.Edge;
import org.graphast.model.EdgeImpl;
import org.graphast.model.Graph;
import org.graphast.model.GraphImpl;
import org.graphast.model.NodeImpl;
import org.graphast.util.DateUtils;

public class RioBusOSRExample {
	
	public Graph generateExample() {
		// Graph formation
		Graph graph = new GraphImpl("rioBus");
		//Nodes:
		// Stops
		NodeImpl v;
		v = new NodeImpl(0, -22.9839, -43.1917);
		graph.addNode(v);
		v = new NodeImpl(1, -22.9862, -43.1954);
		graph.addNode(v);
		v = new NodeImpl(2, -22.9867, -43.1997);
		graph.addNode(v);
		v = new NodeImpl(3, -22.9865, -43.2032);
		graph.addNode(v);
		v = new NodeImpl(4, -22.9863, -43.2065);
		graph.addNode(v);
		v = new NodeImpl(5, -22.9862, -43.2094);
		graph.addNode(v);
		v = new NodeImpl(6, -22.9861, -43.211);
		graph.addNode(v);
		v = new NodeImpl(7, -22.986, -43.2146);
		graph.addNode(v);
		v = new NodeImpl(8, -22.9863, -43.217);
		graph.addNode(v);
		v = new NodeImpl(9, -22.9867, -43.2207);
		graph.addNode(v);
		v = new NodeImpl(10, -22.9838, -43.2233);
		graph.addNode(v);
		v = new NodeImpl(11, -22.9827,-43.2236);
		graph.addNode(v);
		v = new NodeImpl(12, -22.9821,-43.2237);
		graph.addNode(v);
		v = new NodeImpl(13, -22.9807,-43.2238);
		graph.addNode(v);
		v = new NodeImpl(14, -22.9788,-43.2243);
		graph.addNode(v);
		v = new NodeImpl(15, -22.9764, -43.2251);
		graph.addNode(v);
		v = new NodeImpl(16, -22.9751, -43.2258);
		graph.addNode(v);
		v = new NodeImpl(17, -22.9735, -43.2255);
		graph.addNode(v);
		v = new NodeImpl(18, -22.9701, -43.2225);
		graph.addNode(v);
		v = new NodeImpl(19, -22.9671, -43.22);
		graph.addNode(v);
		v = new NodeImpl(20, -22.966, -43.2191);
		graph.addNode(v);
		v = new NodeImpl(21, -22.9649, -43.2182);
		graph.addNode(v);
		v = new NodeImpl(22, -22.9622, -43.2155);
		graph.addNode(v);
		v = new NodeImpl(23, -22.9612, -43.2132);
		graph.addNode(v);
		v = new NodeImpl(24, -22.9609, -43.2103);
		graph.addNode(v);
		v = new NodeImpl(25, -22.9606, -43.2072);
		graph.addNode(v);
		v = new NodeImpl(26, -22.9603, -43.2046);
		graph.addNode(v);
		v = new NodeImpl(27, -22.958, -43.1994);
		graph.addNode(v);
		v = new NodeImpl(28, -22.9824, -43.191);
		graph.addNode(v);
		v = new NodeImpl(29, -22.9762, -43.1901);
		graph.addNode(v);
		v = new NodeImpl(30, -22.9729, -43.1882);
		graph.addNode(v);
		v = new NodeImpl(31, -22.9694, -43.1849);
		graph.addNode(v);
		v = new NodeImpl(32, -22.9688, -43.186);
		graph.addNode(v);
		v = new NodeImpl(33, -22.9689, -43.1872);
		graph.addNode(v);
		v = new NodeImpl(34, -22.9673, -43.1884);
		graph.addNode(v);
		v = new NodeImpl(35, -22.9659, -43.1897);
		graph.addNode(v);
		v = new NodeImpl(36, -22.9586, -43.1912);
		graph.addNode(v);
		v = new NodeImpl(37, -22.957, -43.1894);
		graph.addNode(v);
		v = new NodeImpl(38, -22.9564, -43.1912);
		graph.addNode(v);
		v = new NodeImpl(39, -22.9575, -43.1941);
		graph.addNode(v);
		v = new NodeImpl(40, -22.9582, -43.1965);
		graph.addNode(v);
		v = new NodeImpl(41, -22.959, -43.2006);
		graph.addNode(v);
		
		//POI
		
		// Categories:
		//1 - HOTEL
		//2 - HOSPITAL
		//3 - CHURCH
		//4 - RESTAURANT 
		//5 - CAFE
		//6 - SUPERMARKET
		//7 - SCHOOL
		//8 - CLUB
		//9 - PARK
		//10 - HELIPORT
		//11 - STORE
		//12 - MENEJE(EQUESTRIAN PLACE)
		//13 - BANK
		//14 - CORREIOS(POST OFFICE)
		//15 - GAS STATION
		
		v = new NodeImpl(42, -22.986785, -43.222121, 1);
		v.setLabel("MARINA PALACE HOTEL");
		graph.addNode(v);
		v = new NodeImpl(43, -22.986785, -43.222121, 1);
		v.setLabel("MARINA SUITES HOTEL");
		graph.addNode(v);
		v = new NodeImpl(44, -22.984464, -43.222475, 2);
		v.setLabel("CPDI LEBLOM HOSPITAL");
		graph.addNode(v);
		v = new NodeImpl(45, -22.984222, -43.221354, 3);
		v.setLabel("PAROQUIA SANTA MONICA");
		graph.addNode(v);
		v = new NodeImpl(46, -22.984010, -43.221750, 4);
		v.setLabel("FRONTEIRA LEBLOM RESTAURANTE");
		graph.addNode(v);
		v = new NodeImpl(47, -22.983659, -43.222882, 4);
		v.setLabel("GIUSEPPE GRILL");
		graph.addNode(v);
		v = new NodeImpl(48, -22.984538, -43.224717, 5);
		v.setLabel("CAFÉ HUM LEBLOM" );
		graph.addNode(v);
		v = new NodeImpl(49, -22.982691, -43.223188, 4);
		v.setLabel("RESTAURANTE GONZALO");
		graph.addNode(v);
		v = new NodeImpl(50, -22.982128, -43.224293, 1);
		v.setLabel("LEBLOM SPOT DESIGN HOTEL");
		graph.addNode(v);
		v = new NodeImpl(51, -22.981551, -43.224229, 4);
		v.setLabel("DOMINO'S PIZZA");
		graph.addNode(v);
		v = new NodeImpl(52, -22.980908, -43.222314, 6);
		v.setLabel("PÃO DE AÇUCAR");
		graph.addNode(v);
		v = new NodeImpl(53, -22.980839, -43.224135, 7);
		v.setLabel("PROF. ANTONIO MARIA TEIXEIRA");
		graph.addNode(v);
		v = new NodeImpl(54, -22.980569, -43.224187, 6);
		v.setLabel("SUPERMERCADO ZONA SUL");
		graph.addNode(v);
		v = new NodeImpl(55, -22.978333, -43.220665, 8);
		v.setLabel("CLUBE DE REGATAS FLAMENGO");
		graph.addNode(v);
		v = new NodeImpl(56, -22.976990, -43.218262, 5);
		v.setLabel("QUADRIFOGLIO CAFFÈ - LAGOON");
		graph.addNode(v);
		v = new NodeImpl(57, -22.973206, -43.217157, 9);
		v.setLabel("PARQUE TOM JOBIM");
		graph.addNode(v);
		v = new NodeImpl(58, -22.971221, -43.216377, 10);
		v.setLabel("HELIPONTO DA LAGOA");
		graph.addNode(v);
		v = new NodeImpl(59, -22.964766, -43.218421, 6);
		v.setLabel("PÃO DE AÇUCAR");
		graph.addNode(v);
		v = new NodeImpl(60, -22.964870, -43.219284, 11);
		v.setLabel("BANCA LOPES QUINTA");
		graph.addNode(v);
		v = new NodeImpl(61, -22.964899, -43.216103, 7);
		v.setLabel("COLÉGIO DE APLICAÇÃO DA UFRJ");
		graph.addNode(v);
		v = new NodeImpl(62, -22.963319, -43.216387, 7);
		v.setLabel("CE IGNACIO AZEVEDO DO AMARAL");
		graph.addNode(v);
		v = new NodeImpl(63, -22.963151, -43.213153, 12);
		v.setLabel("SOCIEDADE HIPICA BRASILEIRA");
		graph.addNode(v);
		v = new NodeImpl(64, -22.962662, -43.207842, 4);
		v.setLabel("MR LAM RESTAURANTE");
		graph.addNode(v);
		v = new NodeImpl(65, -22.960498, -43.207118, 6);
		v.setLabel("SUPERMERCADO CRIS MAR");
		graph.addNode(v);
		v = new NodeImpl(66, -22.960456, -43.206503, 13);
		v.setLabel("ITAÚ");
		graph.addNode(v);
		v = new NodeImpl(67, -22.959288, -43.201434, 13);
		v.setLabel("BRADESCO");
		graph.addNode(v);
		v = new NodeImpl(68, -22.959096, -43.200787, 14);
		v.setLabel("CORREIOS");
		graph.addNode(v);
		v = new NodeImpl(69, -22.958881, -43.200406, 13);
		v.setLabel("SUDAMERIS");
		graph.addNode(v);
		v = new NodeImpl(70, -22.958703, -43.200484, 13);
		v.setLabel("SANTANDER");
		graph.addNode(v);
		v = new NodeImpl(71, -22.958673, -43.199596, 15);
		v.setLabel("POSTO 4 ESTRELAS BR");
		graph.addNode(v);
		v = new NodeImpl(72, -22.958132, -43.199254, 16);
		v.setLabel("TEATRO SERGIO PORTO");
		graph.addNode(v);
		v = new NodeImpl(73, -22.957871, -43.199667, 4);
		v.setLabel("PANIFICAÇÃO UNIÃO");
		graph.addNode(v);
		v = new NodeImpl(74, -22.970726, -43.185842, 4);
		v.setLabel("SUBWAY");
		graph.addNode(v);
		v = new NodeImpl(75, -22.970577, -43.183768, 4);
		v.setLabel("DECK RESTAURANTE");
		graph.addNode(v);
		v = new NodeImpl(76, -22.970056, -43.183692, 4);
		v.setLabel("SIQUEIRA GRILL");
		graph.addNode(v);
		v = new NodeImpl(77, -22.969520, -43.185339, 13);
		v.setLabel("BANCO DO BRASIL");
		graph.addNode(v);
		v = new NodeImpl(78, -22.968710, -43.184926, 13);
		v.setLabel("CAIXA ECONOMICA FEDERAL");
		graph.addNode(v);
		v = new NodeImpl(79, -22.968572, -43.183290, 6);
		v.setLabel("PÃO DE AÇUCAR");
		graph.addNode(v);
		
		//Edges:
		Edge e;
		// Path 1
		int[] cost = new int[]{45, 60};
		e = new EdgeImpl(0, 1, 562, cost);
		graph.addEdge(e);
		e = new EdgeImpl(1, 2, 451, cost);
		graph.addEdge(e);
		e = new EdgeImpl(2, 3, 360, cost);
		graph.addEdge(e);
		e = new EdgeImpl(3, 4, 345, cost);
		graph.addEdge(e);
		e = new EdgeImpl(4, 5, 300, cost);
		graph.addEdge(e);
		e = new EdgeImpl(5, 6, 165, cost);
		graph.addEdge(e);
		e = new EdgeImpl(6, 7, 370, cost);
		graph.addEdge(e);
		e = new EdgeImpl(7, 8, 250, cost);
		graph.addEdge(e);
		e = new EdgeImpl(8, 9, 385, cost);
		graph.addEdge(e);
		e = new EdgeImpl(9, 10, 543, cost);
		graph.addEdge(e);
		e = new EdgeImpl(10, 11, 129, cost);
		graph.addEdge(e);
		e = new EdgeImpl(11, 12, 70, cost);
		graph.addEdge(e);
		e = new EdgeImpl(12, 13, 155, cost);
		graph.addEdge(e);
		e = new EdgeImpl(13, 14, 222, cost);
		graph.addEdge(e);
		e = new EdgeImpl(14, 15, 285, cost);
		graph.addEdge(e);
		e = new EdgeImpl(15, 16, 157, cost);
		graph.addEdge(e);
		e = new EdgeImpl(16, 17, 130, cost);
		graph.addEdge(e);
		e = new EdgeImpl(17, 18, 482, cost);
		graph.addEdge(e);
		e = new EdgeImpl(18, 19, 423, cost);
		graph.addEdge(e);
		e = new EdgeImpl(19, 20, 150, cost);
		graph.addEdge(e);
		e = new EdgeImpl(20, 21, 150, cost);
		graph.addEdge(e);
		e = new EdgeImpl(21, 22, 400, cost);
		graph.addEdge(e);
		e = new EdgeImpl(22, 23, 275, cost);
		graph.addEdge(e);
		e = new EdgeImpl(23, 24, 300, cost);
		graph.addEdge(e);
		e = new EdgeImpl(24, 25, 320, cost);
		graph.addEdge(e);
		e = new EdgeImpl(25, 26, 270, cost);
		graph.addEdge(e);
		e = new EdgeImpl(26, 27, 625, cost);
		graph.addEdge(e);
		// total cost: 1215(20,25 minutes)/ 1620(27 minutes)
		
		//Path 2
		cost = new int[]{120, 60};
		e = new EdgeImpl(28, 29, 720, cost);
		graph.addEdge(e);
		e = new EdgeImpl(29, 30, 404, cost);
		graph.addEdge(e);
		e = new EdgeImpl(20, 31, 525, cost);
		graph.addEdge(e);
		e = new EdgeImpl(21, 32, 227, cost);
		graph.addEdge(e);
		e = new EdgeImpl(32, 33, 160, cost);
		graph.addEdge(e);
		e = new EdgeImpl(33, 34, 220, cost);
		graph.addEdge(e);
		e = new EdgeImpl(34, 35, 210, cost);
		graph.addEdge(e);
		e = new EdgeImpl(35, 36, 920, cost);
		graph.addEdge(e);
		e = new EdgeImpl(36, 37, 336, cost);
		graph.addEdge(e);
		e = new EdgeImpl(37, 38, 280, cost);
		graph.addEdge(e);
		e = new EdgeImpl(38, 39, 320, cost);
		graph.addEdge(e);
		e = new EdgeImpl(39, 40, 260, cost);
		graph.addEdge(e);
		e = new EdgeImpl(40, 41, 545, cost);
		graph.addEdge(e);
		// total cost: 1560(26 minutes)/ 780(13 minutes)
		
		//conecting beginning and ending
		cost = new int[]{180};
		e = new EdgeImpl(1, 28, 258, cost);
		graph.addEdge(e);
		e = new EdgeImpl(28, 1, 258, cost);
		graph.addEdge(e);
		cost = new int[]{300};
		e = new EdgeImpl(27, 41, 125, cost);
		graph.addEdge(e);
		e = new EdgeImpl(41, 27, 125, cost);
		graph.addEdge(e);
		
		// Paths to POI
		cost = new int[]{120, 120};
		e = new EdgeImpl(9, 42, 128, cost);
		graph.addEdge(e);
		e = new EdgeImpl(9, 43, 210, cost);
		graph.addEdge(e);
		e = new EdgeImpl(10, 44, 100, cost);
		graph.addEdge(e);
		e = new EdgeImpl(10, 45, 280, cost);
		graph.addEdge(e);
		e = new EdgeImpl(10, 46, 175, cost);
		graph.addEdge(e);
		e = new EdgeImpl(10, 47, 25, cost);
		graph.addEdge(e);
		e = new EdgeImpl(10, 48, 270, cost);
		graph.addEdge(e);
		e = new EdgeImpl(11, 49, 5, cost);
		graph.addEdge(e);
		e = new EdgeImpl(12, 50, 70, cost);
		graph.addEdge(e);
		e = new EdgeImpl(12, 51, 60, cost);
		graph.addEdge(e);
		e = new EdgeImpl(12, 52, 160, cost);
		graph.addEdge(e);
		e = new EdgeImpl(13, 53, 70, cost);
		graph.addEdge(e);
		e = new EdgeImpl(13, 54, 65, cost);
		graph.addEdge(e);
		e = new EdgeImpl(14, 55, 260, cost);
		graph.addEdge(e);
		e = new EdgeImpl(14, 56, 706, cost);
		graph.addEdge(e);
		e = new EdgeImpl(19, 57, 900, cost);
		graph.addEdge(e);
		e = new EdgeImpl(19, 58, 710, cost);
		graph.addEdge(e);
		e = new EdgeImpl(21, 59, 5, cost);
		graph.addEdge(e);
		e = new EdgeImpl(21, 60, 170, cost);
		graph.addEdge(e);
		e = new EdgeImpl(21, 61, 290, cost);
		graph.addEdge(e);
		e = new EdgeImpl(22, 62, 145, cost);
		graph.addEdge(e);
		e = new EdgeImpl(22, 63, 400, cost);
		graph.addEdge(e);
		e = new EdgeImpl(25, 64, 280, cost);
		graph.addEdge(e);
		e = new EdgeImpl(25, 65, 5, cost);
		graph.addEdge(e);
		e = new EdgeImpl(25, 66, 70, cost);
		graph.addEdge(e);
		e = new EdgeImpl(27, 67, 275, cost);
		graph.addEdge(e);
		e = new EdgeImpl(27, 68, 200, cost);
		graph.addEdge(e);
		e = new EdgeImpl(27, 69, 145, cost);
		graph.addEdge(e);
		e = new EdgeImpl(27, 70, 150, cost);
		graph.addEdge(e);
		e = new EdgeImpl(27, 71, 95, cost);
		graph.addEdge(e);
		e = new EdgeImpl(27, 72, 25, cost);
		graph.addEdge(e);
		e = new EdgeImpl(27, 73, 30, cost);
		graph.addEdge(e);
		e = new EdgeImpl(31, 74, 200, cost);
		graph.addEdge(e);
		e = new EdgeImpl(31, 75, 235, cost);
		graph.addEdge(e);
		e = new EdgeImpl(31, 76, 195, cost);
		graph.addEdge(e);
		e = new EdgeImpl(31, 77, 50, cost);
		graph.addEdge(e);
		e = new EdgeImpl(31, 78, 95, cost);
		graph.addEdge(e);
		e = new EdgeImpl(31, 79, 180, cost);
		graph.addEdge(e);
		e = new EdgeImpl(41, 70, 90, cost);
		graph.addEdge(e);
		e = new EdgeImpl(41, 72, 35, cost);
		graph.addEdge(e);
		
		return graph;
	}
	
	public void main(String[] args) {
		Graph graph = generateExample();
		OSRSearch osr = new OSRSearch(graphBoundsPoI, bounds, graphBoundsPoIReverse);
		ArrayList<Integer> categories = new ArrayList<Integer>();
		categories.add(2);
		categories.add(1);
		
    	Date date = DateUtils.parseDate(0, 550, 0);
    	
    	graph = osr.getGraphAdapter();
    	
    	Sequence seq = osr.search(graph.getNode(1), graph.getNode(7), date, categories);
    	
    	assertEquals(7980000, seq.getDistance());
    	assertEquals(37679450, seq.getTimeToService());
    	assertEquals(29699450, seq.getWaitingTime());
    	
	}
}
