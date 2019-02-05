import java.util.Date;

/*
 * Class Square that implements the interface shape and overrides its operations.
 * The class has methods to get the shape id, area, perimeter, get the origin of the Square,
 	check if the given point is enclosed by the Square.
 	
 	@author Saurabh Aswal
 */
class Square implements Shape
{
	double originX, originY, side;
	Date timestamp;
	int shapeId;
	
	Square(int shapeId, double x, double y, double side)
	{
		this.side = side;
		originX = x;
		originY = y;
		timestamp = new Date();
		this.shapeId = shapeId;
	}
	/*
	 * Overridden method of Shape interface to get the area of the Square.
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public double getArea()
	{
		double area = side*side;
		return area;
	}

	/*
	 * Overridden method of Shape interface to get the perimeter of the Square.
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public double getPerimeter()
	{
		double perimeter = 4*side;
		return perimeter;
	}

	/*
	 * Overridden method of Shape interface to get the origin coordinates of the Square.
	 * 
	 * @see Shape#getOrigin()
	 */
	@Override
	public double[] getOrigin()
	{
		double[] origin = new double[] {originX, originY};
		return origin;
	}

	/*
	 * Overridden method of Shape interface to check if the given point is enclosed by the Square.
	 * 
	 * @see Shape#isPointEnclosed()
	 */
	@Override
	public boolean isPointEnclosed(Point p)
	{
		if(originX <= p.x && originY <= p.y && originX+side >= p.x && originY+side >= p.y)
			return true;
		
		return false;
	}
	
	/*
	 * Overridden method of Shape interface to get the id of the Square.
	 * 
	 * @see Shape#getShapeId()
	 */
	@Override
	public int getShapeId()
	{
		return shapeId;
	}

}
