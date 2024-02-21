package edu;

import java.util.Scanner;

public class primeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("a :");
		int a = sc.nextInt();
		boolean flag = true;
		
		for(int i=2; i<a; i++) {
			if((a%i)==0) flag = false;
		}
		System.out.println(flag==true ? "prime number" :"not a prime number");
		*/

		Scanner sc = new Scanner(System.in);
		System.out.print("enter digit : ");
		int digit = sc.nextInt();
		boolean flag = true;
				
		int lower = (int)Math.pow(10.0, (double)(digit-1));
		int upper = (int)Math.pow(10.0, (double)(digit));
		
		System.out.println("prime numbers between " + lower + " and " + upper + " are as follows:");
	
		for(int i=lower; i<upper; i++) {
			
			for(int j=2; j<lower ;j++)
			{
				if((i%j)==0) flag = false;
			}
			
			if(flag == true) System.out.println(lower);
			
			lower++;
			flag = true;
		}
	}

}
