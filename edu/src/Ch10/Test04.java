package Ch10;

import java.io.FileInputStream;

public class Test04 {
	
	public static void test() throws Exception{
	FileInputStream fi = new FileInputStream("hello.txt");
	int c=fi.read();
	System.out.println((char)c);
	
//	catch(Exception e){
//		e.getMessage();
//	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		}
}