package recursive.model;

public class RecursionTool
{
	public double fibonacciNumber(double position)
	{
		//Bounds Check
		if (position < 0)
		{
			return Integer.MIN_VALUE;
		}
		
		//BaseCase
		if(position == 0 || position == 1)
		{
			return 1;
		}
		else
		{
			return fibonacciNumber(position - 1) + fibonacciNumber(position - 2);
		}
	}
	
	public double factorialNumber(double position)
	{
		//Bounds Check
		if (position < 0)
		{
			return Integer.MIN_VALUE;
		}
		
		if(position == 0)
		{
			return 1;
		}
		else
		{
			return position * factorialNumber(position - 1);
		}
	}	
}
