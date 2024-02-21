package Ch6;

public class Count {
	
	public static int totalCount = 10;
	int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static void print1() {
		System.out.println("hello, java");
		System.out.println(totalCount);
	}
	
	public void print2() {
		System.out.println("good bye, java");
		System.out.println(totalCount);
	}
	
	public Count() {
		System.out.println("execute the constructor");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(totalCount);
//		
//		Count c2 = new Count();
//		Count c3 = new Count();
//		
//		c1.setCount(1);
//		c2.setCount(2);
//		c3.setCount(3);
//		
//		System.out.println(c1.getCount());
//		System.out.println(c2.getCount());
//		System.out.println(c3.getCount());
//		
//		Count.print1();
//		print1(); //같은 클래스 안에서는 클래스 이름 없이 사용가능
//		
//		Count count2 = new Count(); //static이 아닌경우 인스턴트 생성 후에만 사용가능
//		count2.print2();
		
		Armor suit1 = new Armor();
//		Armor suit2 = new Armor();
//		
//	
		suit1.setName("optimus");
		suit1.setHeight(1200);
//		
//		suit1.setName("bumbleBee");
//		suit1.setHeight(500);
//		
//		System.out.println("name:" + suit1.getName());
//		System.out.println("height:" + suit1.getHeight());
		
//		System.out.println("execute the method");
//		new Count();
		
		
	}


}
