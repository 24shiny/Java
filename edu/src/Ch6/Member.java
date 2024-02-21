package Ch6;

public class Member {
	private String name;
	private int age;
	
	public Member() {
		this.name ="guest";
		this.age = 0;
	}
	
	public Member(String name) {
		this.name = name;
		this.age = 0;
	}
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member();
		Member m2 = new Member("Alice");
		Member m3 = new Member("Bob",26);
		
		System.out.println(m1.name + " : " + m1.age);
		System.out.println(m2.name + " : " + m2.age);
		System.out.println(m3.name + " : " + m3.age);

	}

}
