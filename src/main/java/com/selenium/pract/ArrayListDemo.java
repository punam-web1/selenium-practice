package day2;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer>  alist = new ArrayList<Integer>();
		alist.add(12);
		alist.add(99);
		alist.add(4);
		alist.add(89);
		alist.add(105);
		
		System.out.println(alist);
		
		Collections.sort(alist);
		
		System.out.println(alist);
		
		
		ArrayList<Student>  starr = new ArrayList<Student>();
		
		
		Student st1 = new Student(101, "Virat") ;
		Student st2 = new Student(102, "Rohit");
		Student st3 = new Student(104, "Shikhar") ;
		Student st4 = new Student(106, "Rahul");
		
		starr.add(st3);
		starr.add(st1);
		starr.add(st2);
		
		starr.add(st4);
		
		System.out.println("Before Sorting  \n"+ starr);
		
		Collections.sort(starr);
		
		
		
		
	}

}
