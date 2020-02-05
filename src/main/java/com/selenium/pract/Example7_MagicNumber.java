package day01;

import java.util.Scanner;

import utils.UtilityClass;

public class Example7_MagicNumber {

	public Example7_MagicNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		System.out.println("Enter the number");

		Scanner p = new Scanner(System.in);
		int num=p.nextInt();
		p.close();
		
		int result=magicNumber(num);
		
		System.out.println(result);
		
	}
	
	public static int magicNumber (int value) {
		/*
		Ex06_MagicNumber
		step 1) 3 digit +ve no.  - N -> 435
		step 2) Reverse the no. - R -> 534
		step 3) find the difference -> D = 99 (should be positive)
		step 4) Reverse the D       -> RD = 99
		Step 5) sum of D + RD = 891+198 = 198
		*/
		
		if (value <= 0) {
			return value;
		}
		
		int result;
		
		int reverseN = UtilityClass.reverseNumber(value);
		
		int difference;
		if (reverseN > value) {
			
			difference = reverseN - value;
		}
		else {
			difference = value - reverseN ;
			
		}
		
		int reverseDifference = UtilityClass.reverseNumber(difference);
		
		result = difference + reverseDifference;
		
		return result;
	}

}
