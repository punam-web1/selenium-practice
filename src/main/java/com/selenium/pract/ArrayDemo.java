package day2;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 5, 9, 5, 7, 8, 3 };
		
		
		for(int i = 0 ; i < arr.length ; i++ ) {
			System.out.println(arr[i]);
		}
		/*
		for( int ele   : arr) {
			System.out.println(ele);
			
		}*/
		//
		
		String[] starr = {"india", "japan", "China", "USA"};
		
		for(String country : starr) {
			System.out.println(country);
		}
		
		Student st1 = new Student(101, "Virat") ;
		Student st2 = new Student(102, "Rohit");
		Student st3 = new Student(104, "Shikhar") ;
		Student st4 = new Student(106, "Rahul");
		
		Student[]  arrst = {st1, st2, st3, st4};
		for(Student st : arrst) {
			System.out.println(st);
		}
		Student st5 = new Student(206, "Harbhajan");
		arrst[1] = st5;
		for(Student st : arrst) {
			System.out.println(st);
		}
		
		
		
		
		

	}

}
