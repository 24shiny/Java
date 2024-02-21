package ch02;

import java.util.Scanner;

public class ObjectEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
		
		int num = getNum();
		int sum = 0;
		int count = 0;
		int max = 10;
		
		if(num==0) break;
		
		for(int i=1; i<=max; i++) {
			for(int j=1;j<=max;j++) {
				for(int k=1; k<=max; k++) {
					if(sumMethod(i,j,k)==num) {
						System.out.print("("+ i +"," + j +","+k+")"+" ");
						count += 1;
					}
				}
			}
		}
		
		System.out.println("the number of such cases :" + count);
		}
	}
	
	public static int getNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number(10 to 100) :");
		int num = sc.nextInt();
		return num;
	}
	
	
	public static int sumMethod(int a, int b, int c) {
		return 2*a+3*b+5*c;
	}

}
