import java.util.*;

/*
Area class for calculating the area of various shapes
by taking their sides or radius as input.
The shapes facilitated in the program are
Triangle, Rectangle, Square and Circle.

@author Saurabh Aswal
*/
class Area
{	
	
	double inputSide(char ch)
	{
		Scanner sc = new Scanner(System.in);
		double side=0;
		
		try
		{
			side = sc.nextDouble();
		}
		catch(InputMismatchException e)				//To handle characters other than numbers.
		{
			System.out.println("Invalid input. Input must be a postitive number.");
			option(ch);
		}
		
		if(side <= 0)					//To handle negative inputs.
		{
			System.out.println("Invalid input. Input must be greater than 0.");
			option(ch);
		}
		return side;
	}
	
	/*
	Method to calculate the area of the triangle
	by passing its width and height.
	
	@param width as side of triangle as double type.
	@param height of the triangle as double type.
	@return area of the triangle as double type.
	*/
	double triangle(double width, double height)
	{
		double area = 0.5*width*height;
		return area;
	}
	
	/*
	Method to calculate the area of the triangle
	by passing its width.
	
	@param width as side of the square as double.
	@return area of the square as double.
	*/
	double square(double width)
	{
		double area = width*width;
		return area;
	}
	
	/*
	Method to calculate the area of the rectangle
	by passing its width and height.
	
	@param width of the rectangle as double type.
	@param height of the rectangle as double type.
	@return area of the rectangle as double type.
	*/
	double rectangle(double width, double height)
	{
		double area = width*height;
		return area;
	}
	
	/*
	To calculate the area of circle by passing its radius.
	
	@param radius of the circle as double.
	@return area of the circle as double.
	*/
	double circle(double radius)
	{
		double area = 3.14*radius*radius;
		return area;
	}
	
	/*
	To display the menu to the end user.
	
	@param choice input by the user as char.
	*/
	void option(char choice)
	{
		double area;						//To store area of the respective shape.
		switch(choice)
		{
		case 'a':
			System.out.println("\nEnter the width and height of the triangle respectively");
			area = triangle(inputSide(choice), inputSide(choice));					//Passing char choice as argument for running the same case if input is invalid.
			
			System.out.println("Area of the triangle : "+area);
			break;
		case 'b':
			System.out.println("\nEnter the width and height of the rectangle respectively");
			area = rectangle(inputSide(choice), inputSide(choice));
			
			System.out.println("Area of the rectangle : "+area);
			break;
		case 'c':
			System.out.println("\nEnter the length of the side of the square");
			area = square(inputSide(choice));
			
			System.out.println("Area of the square : "+area);
			break;
		case 'd':
			System.out.println("\nEnter the redius of the circle");
			area = circle(inputSide(choice));
			
			System.out.println("Area of the circle : "+area);
			break;
		case 'e':
			System.exit(0);							//To exit the program.
		default:
			System.out.println("Invalid choice");				//To handle invalid options.
		}
	}
	
	public static void main(String args[])
	{
		Area shape = new Area();
		Scanner sc = new Scanner(System.in);
		
		while(true){					//infinite loop to display menu that exits when 0 is pressed.
		System.out.println("\nPress a for area of triangle\nPress b for area of rectangle\nPress c for area of Square\nPress d for area of Circle\nPress e to exit");
		
		char choice = sc.next().charAt(0);
		
		shape.option(choice);					//To compute the selected shape.
		}

	}
		
}