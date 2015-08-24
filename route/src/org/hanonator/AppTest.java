package org.hanonator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hanonator.route.MapMatrix;
import org.hanonator.route.Matrix;
import org.hanonator.route.Point;
import org.hanonator.route.Route;
import org.hanonator.route.RouteFinder;
import org.hanonator.route.RouteNotFoundException;
import org.hanonator.route.impl.AStarRouteFinder;
import org.hanonator.route.impl.DijkstraRouteFinder;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public static final int ITERATIONS = 50_000;
	private static final int MATRIX_WIDTH = 9;
	public static final Point SOURCE = new Point(0, 0);
	public static final Point VALID_DESTINATION = new Point(3, 7);
	public static final Point INVALID_DESTINATION = new Point(0, 8);
	
	private static final int[] TEST_MATRIX = {
			0, 1, 1, 0, 1, 0, 0, 0, 0,
			0, 0, 1, 0, 0, 1, 0, 1, 0,
			1, 0, 1, 1, 0, 1, 0, 1, 1,
			1, 0, 0, 0, 0, 1, 0, 1, 0,
			1, 0, 1, 0, 1, 1, 0, 1, 0,
			1, 0, 1, 0, 0, 0, 0, 1, 0,
			0, 0, 1, 0, 1, 1, 1, 1, 0,
			0, 1, 1, 0, 1, 1, 1, 1, 0,
			0, 1, 1, 0, 0, 0, 0, 0, 0,
	};
	
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * @throws RouteNotFoundException 
	 */
	public void testApp() throws RouteNotFoundException {
		Matrix matrix = new MapMatrix(TEST_MATRIX, MATRIX_WIDTH);
		
		System.out.println("----DIJKSTRA----");
		RouteFinder route_finder = new DijkstraRouteFinder();
		Route route = route_finder.find(matrix, SOURCE, VALID_DESTINATION);
		route.forEach(System.out::println);
		
		System.out.println("----A*----");
		route_finder = new AStarRouteFinder();
		route = route_finder.find(matrix, SOURCE, VALID_DESTINATION);
		route.forEach(System.out::println);
	}

}
