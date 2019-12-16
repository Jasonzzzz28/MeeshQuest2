package cmsc420.meeshquest.part2;

/**
 * A 2-dimensional point. We represent a point as a 2-element array of
 * type float. (This may seem like overkill, but it has the feature that
 * we can reference the splitting dimension coordinate in kd-trees by
 * invoking get(i), where i is the splitting dimension, rather than 
 * using conditional statements. It also makes the structure easier to
 * generalized to higher dimensions.
 */

public class Point2D {
	final static int DIM = 2; // spatial dimension
	float[] coord; // coordinates

	/**
	 * Default constructor.
	 * 
	 */
	public Point2D() {
		coord = new float[DIM];
		for (int i = 0; i < DIM; i++)
			coord[i] = 0;
	}

	/**
	 * Construct from coordinates.
	 * 
	 * @param coord The array of coordinates.
	 */
	public Point2D(float x, float y) {
		coord = new float[DIM];
		coord[0] = x;
		coord[1] = y;
	}

	/**
	 * Construct from a 2-element coordinate array.
	 * 
	 * @param coord The array of coordinates.
	 */
	public Point2D(float[] coord) {
		assert(coord.length == DIM);
		this.coord = new float[DIM];
		for (int i = 0; i < DIM; i++)
			this.coord[i] = coord[i];
	}

	/**
	 * Copy constructor.
	 * 
	 * @param p The point to copy.
	 */
	public Point2D(Point2D p) {
		coord = new float[DIM];
		for (int i = 0; i < DIM; i++)
			coord[i] = p.get(i);
	}

	/**
	 * Get the dimension.
	 * 
	 * @return The dimension
	 */
	public static int getDim() {
		return DIM;
	}

	/**
	 * Get the i-th coordinate (i=0 for x, i=1 for y).
	 * 
	 * @param i The coordinate index 0 or 1.
	 * @return The i-th coordinate of the point.
	 */
	public float get(int i) {
		return coord[i];
	}

	/**
	 * Get the x-coordinate.
	 * 
	 * @return The x-coordinate of the point.
	 */
	public float getX() {
		return coord[0];
	}

	/**
	 * Get the y-coordinate.
	 * 
	 * @return The y-coordinate of the point.
	 */
	public float getY() {
		return coord[1];
	}
	
	/**
	 * Express point as a string.
	 * 
	 * @return String representation of the point.
	 */
	public String toString() {
		return "(" + coord[0] + "," + coord[1] + ")";
	}

	public float dist(Point2D p) {
		if (p == null) {
			return Float.MAX_VALUE;
		} 
		else {
			float dist= 0;
			for (int x = 0; x < DIM; x++) {
				float delta = (p.get(x) - get(x));
				dist += delta* delta;
			}
			return (float) Math.sqrt(dist);
			
		}
	}
}
