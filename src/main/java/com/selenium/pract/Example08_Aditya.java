package day01;

import utils.UtilityClass;

public class Example08_Aditya {

	public Example08_Aditya() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char ch = 'a';
		char ch1 = '1';
		char ch2 = 'b';
		char ch3 = ' ';
		
		System.out.println(UtilityClass.isVowel(ch));
		System.out.println(UtilityClass.isVowel(ch1));
		System.out.println(UtilityClass.isVowel(ch2));

		System.out.println("************");
		
		System.out.println(UtilityClass.isNumber(ch));
		System.out.println(UtilityClass.isNumber(ch1));
		System.out.println(UtilityClass.isNumber(ch2));

		System.out.println("************");

		System.out.println(UtilityClass.isConsonant(ch));
		System.out.println(UtilityClass.isConsonant(ch1));
		System.out.println(UtilityClass.isConsonant(ch2));

		System.out.println("************");

		System.out.println(UtilityClass.isConsonant(ch3));
		
	}

}
