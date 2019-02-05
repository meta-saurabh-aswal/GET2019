import java.util.Date;

/*
 * Class CIrcle that implements the interface shape and overrides its operations.
 * The class has methods to get the shape id, area, perimeter, get the origin of the circle,
 	check if the given point is enclosed by the Circle.
 	Utility methods include method to find the centre of the circle.
 	
 	@author Saurabh Aswal
 */
class Circle implements Shape
{
	double originX, originY, radius;
	Date timestamp;
	int shapeId;
	final double pi = 3.14;
	
	Circle(int shapeId, double x, double y, double radius)
	{
		originX = x;
		originY = y;
		this.radius = radius;
		timestamp = new Date();
		this.shapeId = shapeId;
	}
	
	//Utility method to find the distance between two points.
	public double getDistance(double x, double y, Point p)
	{
		double s1 = Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
		return s1;
	}
	
	/*
	 * Overridden method of Shape interface to get the id of the Circle.
	 * 
	 * @see Shape#getShapeId()
	 */
	@Override
	public int getShapeId()
	{
		return shapeId;
	}
	
	/*
	 * Overridden method of Shape interface to get the area of the Circle.
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public double getArea()
	{
		double area = (radius*radius)*pi;
		return area;
	}

	/*
	 * Overridden method of Shape interface to get the perimeter of the Circle.
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public double getPerimeter()
	{
		double perimeter = radius*2*pi;
		return perimeter;
	}

	/*
	 * Overridden method of Shape interface to get the origin of the Circle.
	 * 
	 * @see Shape#getOrigin()
	 */
	@Override
	public double[] getOrigin()
	{
		double origin[] = new double[] {originX, originY};
		return origin;
	}

	/*
	 * Overridden method of Shape interface to check if the point is enclosed by the Circle.
	 * 
	 * @see Shape#isPointEnclosed()
	 */
	@Override
	public boolean isPointEnclosed(Point p)
	{
		double[] centre = circleCentre();
		double distance = Math.sqrt((centre[0] - p.x)*(centre[0] - p.x) + (centre[1] - p.y)*(centre[1] - p.y));
		
		if(distance <= radius)
			return true;
		
		return false;
	}
	
	/*
	 * Utility method to find the centre of the circle.
	 * 
	 * @return centre coordinates of the circle in a double array.
	 */
	double[] circleCentre()
	{
		double toOriginLength = Math.sqrt(originX*originX + originY*originY);
		double toCentreLength = toOriginLength + radius;
		
		double[] centrePoint = new double[2];
		
		centrePoint[0] = (toCentreLength * originX)/toOriginLength;
		centrePoint[1] = (toCentreLength * originY)/toOriginLength;
		
		return centrePoint;
	}

}
