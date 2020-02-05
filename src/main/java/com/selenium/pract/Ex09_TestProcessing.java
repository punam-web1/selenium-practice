package day01;
import day01.UtilityClass;
public class Ex09_TestProcessing {
	
	public static void main(String[] args) {
		String s="1) The stories have been translated into nearly every language in the world that has a script. 2) The story form appeals to children while the wisdom in them attracts adults. 3) The Panchatantra collection represents the earliest folk tale form in the world of literature. 4) - There are several versions of Panchatantra tales in circulation in the world but the one that is popular in India is the Sanskrit original of Vishnu Sharman.";
		char [] a=s.toCharArray();
		int count=0;
		for(int i=0;i<a.length;i++)
		{
		boolean c=UtilityClass.isVowel(a[i]);
		if(c==true)
		{
			count++;
		}
		}
		System.out.println(count);
		int count1=0;
		for(int i=0;i<a.length;i++)
		{
		boolean c=UtilityClass.isConsonant(a[i]);
		if(c==true)
		{
			count1++;
		}
		}
		System.out.println(count1);
		int count2=0;
		for(int i=0;i<a.length;i++)
		{
		boolean c=UtilityClass.isNumber(a[i]);
		if(c==true)
		{
			count2++;
		}
		}
		System.out.println(count2);


	}
}
