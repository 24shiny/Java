package Test_class;

public class variable_length {
	
	static void test(int...v){
		System.out.print(v.length+":");
		
		for(int x:v) {
			System.out.print(x +" ");				
		}
		System.out.println();		
	}
	
	static void testScore(String name, int...w) {
		System.out.print(name + ":");
		for(int j:w) {
			System.out.print(j + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		test(1);
		test(1,5);
		test(1,5,10);
		*/
		testScore("Jessie", 30,50,70);
		testScore("Alexxie", 80, 75);
	}

}
