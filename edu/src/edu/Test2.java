package edu;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get an input
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("score :");
		int score = sc.nextInt();
		
		char grade;
		
		if(score>=90) {
			grade = 'A';
		}
		else if(score>=80) {
			grade = 'B';
		}
		else
		{
			grade = 'C';
		}
		
		System.out.println("your grade is " + grade);
		
		switch(grade) {
		case 'A':
			System.out.println("excellent"); break;
		case 'B':
			System.out.println("good"); break;
		case 'C':
			System.out.println("sufficient"); break;
		}
		*/
		
		/*
		// for
		for(int i=2; i<=10; i+=2) {
			System.out.println(i);
		}
		
		// while
		int j = 2;
		while(j<=10) {
			System.out.println(j);
			j+=2;
		}
		
		// do-while
		
		int k = 2;
		do {
			System.out.println(k);
			k+=2;
		} while(k<=10);
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("a :");
		int a = sc.nextInt();
		
		System.out.print("b :");
		int b = sc.nextInt();
		
		System.out.print("operator :");
		char operator = sc.next().charAt(0);
		
		switch(operator) {
		case '+':
			System.out.println(a+b); break;
		case '-':
			System.out.println(a-b); break;
		case '*':
			System.out.println(a*b); break;
		case '/':
			System.out.println((float)a/b); break;
		}
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("a :");
		int a = sc.nextInt();
		int odd_sum = 0;
		int even_sum = 0;
		
		for(int i = 1; i<=a; i++) {
			if(i%2==0) {
				odd_sum += i;
			}
			else
			{
				even_sum += i;
			}
		
		}
		System.out.println("the sum of even numbers is " + even_sum);
		System.out.println("the sum of odd numbers is " + odd_sum);
		*/
		
		/*
		int[] arr = {1,2,3,4,5};
		System.out.println(arr.length);
		for(int i=0 ; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
		*/
		
		/*
		int evenSum = 0;
		for(int i=1; i<=10; i++) {
			if((i%2)==1) 
				continue;
				evenSum += i;
				System.out.println(i);
		}
		System.out.println(evenSum);
		*/
		
		/*
		for(int i=1; i<10; i++){
			for(int j =2; j<10; j++) {
				System.out.print(j+ "*" + i + "=" + (i*j) + "\t");
			}
			System.out.println("\n");
		}
		*/
		
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
		System.out.print("enter digi");
		int digit = sc.nextInt();
		boolean flag = true;
				
		int lower = (int)Math.pow(10.0, (double)(digit-1));
		int upper = (int)Math.pow(10.0, (double)(digit));
		
		System.out.println("prime numbers between " + lower + " and " + upper + " are as follows");
	
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