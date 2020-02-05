package day2;

public class StudentUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st1 = new Student(101, "Virat") ;
		Student st2 = new Student(102, "Rohit");
		System.out.println(st1.getId());
		System.out.println(st1.getName());
		System.out.println(st2.getId());
		System.out.println(st2.getName());
		System.out.println(st1);
		System.out.println(st2);

	}

}
