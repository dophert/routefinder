package org.hanonator.route;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 
 * @author Red
 */
public interface Matrix extends Iterable<Point>, Supplier<Stream<Point>> {
	
	/**
	 * Map all the nodes to their relevant positions on the matrix
	 * 
	 * @return
	 */
	public abstract NodeQueue createTemplate();

	/**
	 * TODO
	 * 
	 * @param point
	 * @return
	 */
	public abstract Tile get(Point point);

	/**
	 * TODO
	 * 
	 * @param point
	 * @return
	 */
	public abstract void set(Point point, Tile tile);
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param tile
	 */
	default void set(int x, int y, Tile tile) {
		set(new Point(x, y), tile);
	}

	/**
	 * Represents a tile and its contents
	 * 
	 * @author Red
	 */
	public static enum Tile {
		TERRAIN, WALL;
	}

}