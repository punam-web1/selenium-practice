package utils;

public class UtilityClass {

	public UtilityClass() {
		// TODO Auto-generated constructor stub
	}

	public static int reverseNumber(int a)
	{
		int rev=0;
		int sum=0;
		while(a!=0)
		{
			rev=a%10;
			sum=sum*10+rev;
			a=a/10;
		//	System.out.println("rev " + rev +" sum " + sum +"  a " +a);
		}
		return sum;

	}
	
}
