package Ch10;

//public class nagativeNumException() extends Exception{
//	public nagativeNumException() {
//	super("negative numbers are not allowed");
//}
//}

public class Test05 {
	
	int battery = 0;
	
	public void charge(int time){
		if(time<0) {	
			time=0;
		try {
			throw new negativeNumException();}
		catch(negativeNumException e) {
			System.out.println(e.getMessage());
			}
		}
		
		battery += time;
		System.out.println("current battery status : "+ battery);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test05 test = new Test05();
		test.charge(30);
		test.charge(20);
		test.charge(-10);
	}

}
