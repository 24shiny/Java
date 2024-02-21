package Test_class;

import Test_class.ArmorTest;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArmorTest armor = new ArmorTest();
		System.out.println(armor.sum(20,30));
		
		armor.fly(false);
		armor.name = "Jessie";
		
		int avg = average(10,30);
		//System.out.println(average(10,30));
		
		ArmorTest suit1 = new ArmorTest();
		ArmorTest suit2 = new ArmorTest();
		
		suit1.setName("mark2000");
		suit1.setHeight(150);
		
		suit2.setName("mark2020");
		suit2.setHeight(200);
		
		System.out.println(suit1.getName() + ":" + suit1.getHeight() );
		System.out.println(suit2.getName() + ":" + suit2.getHeight() );
	}


	static int average(int i, int j) {
		System.out.println("your request");
		System.out.println("is in progress");
		return (i+j)/2;
	}
	
	

}



