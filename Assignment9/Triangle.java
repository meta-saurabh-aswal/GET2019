import java.util.Date;
import java.math.*;

/*
 * Class Triangle that implements the interface shape and overrides its operations.
 * The class has methods to get the shape id, area, perimeter, get the origin of the triangle,
 	check if the given point is enclosed by the triangle.
 	Utility methods include method to get the distance between two points and to calculate the area of a triangle.
 	
 	Assumption: The triangle is a right angled triangle.
 	
 	@author Saurabh Aswal
 */
class Triangle implements Shape
{
	double side1, side2, side3, originX, originY;
	Date timestamp;
	int shapeId;

	Triangle(int shapeId, double x, double y, double s1, double s2, double s3)
	{
		side1 = s1;
		side2 = s2;
		side3 = s3;
		originX = x;
		originY = y;
		timestamp = new Date();
		this.shapeId = shapeId;
	}
	
	/*
	 * Overridden method of Shape interface to get the shape id of the Triangle.
	 * 
	 * @see Shape#getShapeId()
	 */
	@Override
	public int getShapeId()
	{
		return shapeId;
	}
	
	/*
	 * Overridden method of Shape interface to get the area of the Triangle.
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public double getArea()
	{
		double s = (side1 + side2 + side3)/2;		
		double result = Math.sqrt(s * (s - side1)*(s - side2)*(s - side3));
		
		return result;
	}
	
	/*
	 * Overridden method of Shape interface to get the perimeter of the Triangle.
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public double getPerimeter()
	{
		double result = side1 + side2 + side3;	
		return result;
	}
	
	/*
	 * Overridden method of Shape interface to get the origin of the Triangle.
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
	 * Overridden method of Shape interface to check if the given point is enclkosed by the Triangle.
	 * 
	 * @see Shape#isPointEnclosed()
	 */
	@Override
	public boolean isPointEnclosed(Point p)
	{
		double area1, area2, area3;
	
		area1 = findArea(getDistance(originX, originY, p), getDistance(originX+side1, originY, p), side1);
		area2 = findArea(getDistance(originX, originY, p), getDistance(originX, originY+side2, p), side2);
		area3 = findArea(getDistance(originX+side1, originY, p), getDistance(originX, originY+side2, p), side3);;
		
		if((area1 + area2 + area3) == getArea())
			return true;
		
		return false;
	}

	//Utility method to calculate the distance between two points.
	public double getDistance(double x, double y, Point p)
	{
		double s1 = Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
		return s1;
	}
	
	//Utility method to calculate the area of a triangle.
	double findArea(double s1, double s2, double s3)
	{
		double s = (s1 + s2 + s3)/2;
		double result = Math.sqrt(s * (s - s1)*(s - s2)*(s - s3));
		
		return result;
	}
}
