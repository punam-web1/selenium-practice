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
	
	public static boolean isVowel(char ch)
	{

		boolean flag = false;
		
		ch = Character.toLowerCase(ch);
		
		if (ch == 'a' ||
			ch == 'e' ||
			ch == 'i' ||
			ch == 'o' ||
			ch == 'u') {
			flag = true;
		}
		
		return flag;
		
	}

	public static boolean isConsonant(char ch)
	{

		boolean flag = false;

		ch = Character.toLowerCase(ch);
		
		if (isVowel(ch))
		{
			flag = false;
		}
		else if (isNumber(ch))
		{
			flag = false;
		}
		else if ((ch >= 'a') && (ch <= 'z'))
		{
			flag = true;
		}
		
		return flag;
		
	}
	
	public static boolean isNumber(char ch)
	{

		boolean flag = false;
		
		ch = Character.toLowerCase(ch);
		
		if (ch == '1' ||
			ch == '2' ||
			ch == '3' ||
			ch == '4' ||
			ch == '5' ||
			ch == '6' ||
			ch == '7' ||
			ch == '8' ||
			ch == '9') {
			flag = true;
		}
		
		return flag;
		
	}
	

	
}
