import java.util.Date;
 
/*
 * Class Rectangle that implements the interface shape and overrides its operations.
 * The class has methods to get the shape id, area, perimeter, get the origin of the rectangle,
 	check if the given point is enclosed by the rectangle.
 	
 	@author Saurabh Aswal
 */
class Rectangle implements Shape
{
	double originX, originY, length, width;
	Date timestamp;
	int shapeId;

	Rectangle(int shapeId, double x, double y, double length, double width)
	{
		this.length = length;
		this.width = width;
		originX = x;
		originY = y;
		timestamp = new Date();
		this.shapeId = shapeId;
	}
	
	/*
	 * Overridden method of Shape interface to get the id of the Rectangle.
	 * 
	 * @see Shape#getShapeId()
	 */
	@Override
	public int getShapeId()
	{
		return shapeId;
	}
	
	/*
	 * Overridden method of Shape interface to get the area of the Rectangle.
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public double getArea()
	{
		double area = length*width;
		return area;
	}

	/*
	 * Overridden method of Shape interface to get the perimeter of the Rectangle.
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public double getPerimeter()
	{
		double perimeter = 2*(length+width);
		return perimeter;
	}

	/*
	 * Overridden method of Shape interface to get the origin of the Rectangle.
	 * 
	 * @see Shape#getOrign()
	 */
	@Override
	public double[] getOrigin()
	{
		double[] origin = new double[] {originX, originY};
		return origin;
	}

	/*
	 * Overridden method of Shape interface to check if the point is enclosed by the Rectangle.
	 * 
	 * @see Shape#isPointEnclosed()
	 */
	@Override
	public boolean isPointEnclosed(Point p)
	{
		if(originX <= p.x && originY <= p.y && originX+length >= p.x && originY+width >= p.y)
			return true;
		
		return false;
	}

}
