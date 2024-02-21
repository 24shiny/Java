package edu;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			char num = '\u0200';
			String greeting = "good morning";
			System.out.print("hoee" + num + "\n");
			System.out.println("\fhoew\b");
			System.out.println(greeting);
			
			long d = 2147483648L;
			float e = 0.5F;
			int dSize = Long.SIZE;
			System.out.println(dSize);
			
			short a = 12;
			int b = -a; //부호변경은 int타입으로 처리됨

			String aBit = Integer.toBinaryString(a);
			System.out.println("bBit = " + aBit);
			
			String bBit = Integer.toBinaryString(b);
			System.out.println("bBit = " + bBit);
			
			int c = 0x30;
			System.out.println("c = " + c);
			
			int h = 123;
			String hBit = Integer.toHexString(h);
			System.out.println("hBit = " + hBit);
			
			byte a1 = 0b1001;
			byte b1 = 0b0010;
			int c1 = a1 & b1;
			System.out.println(c);
			
			int score = 50;
			String result1 = "";
			
			// way1
			if(score>=60) {
				result1 = "pass";
			}
			else
			{
				result1 = "fail";
			}
				
			System.out.println(result1);
			
			// way2
			System.out.println(score>=50 ? "pass" : "fail");
			
	}

}
