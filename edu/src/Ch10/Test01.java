package Ch10;

import java.io.FileInputStream;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fi = new FileInputStream("hello.txt")){
		int c;
		while((c=fi.read())!=-1) {
			System.out.print((char)c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
