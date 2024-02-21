package edu;

import java.util.Random;
import java.util.Arrays;

public class Ch4_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		int arr[] = new int[5];
		// the order can be changed like: int[] arr = new int[5];
		for(int i=0; i<arr.length; i++) { // array.length
		System.out.println(arr[i]);
		}

		int arry2[] = {10, 20, 30, 40, 50};
		for(int j=0; j<arry2.length; j++) {
			System.out.println(arry2[j]);
		}
		
		for(int num : arry2) {
			System.out.println(num);
		}
		
		String str1 = "m orning";
		System.out.println(str1.length()); // class.length()
			
		String[] str2 = {"apple","banana"};
		for(String stx : str2) {
			System.out.println(stx);
		}
		
		char letter = 'a';
		char[] alphabet = new char[26];
		for(int i=0; i<alphabet.length; i++) {
			alphabet[i] = (char) ((int)letter+i);
		}
		for(char c : alphabet) {
			System.out.println(c);
		}
		
		//generate random numbers
		Random rnd = new Random();
		rnd.setSeed(100);
		
		int score[] = new int[20];
		for(int i=0; i<score.length; i++) {
			score[i] = rnd.nextInt(100); // random numbers ranging from 1 to 20
		}
		
		System.out.println(Arrays.toString(score)); // print the whole array
		Arrays.sort(score);
		System.out.println(Arrays.toString(score));
		
		int max = Arrays.stream(score).max().getAsInt();
		int min = Arrays.stream(score).min().getAsInt();
		int sum = Arrays.stream(score).sum();
		double avg = Arrays.stream(score).average().getAsDouble();
		
		System.out.println(max + "\t" +  min + "\t" + sum + "\t" + avg);
		
		int arry3[][] = {{10,20},{30,40},{50,60}};
		System.out.println(Arrays.deepToString(arry3)); // print a 2d array
		System.out.println("the number of rows is " + arry3.length);
		System.out.println("the number of columns is " + arry3[0].length);
		
		int arry4[][] = new int[5][6];
		for(int i=0; i<arry4.length; i++) {
			for(int j=0; j<arry4[0].length; j++) {
				arry4[i][j] = rnd.nextInt(10);
			}
		}
		System.out.println(Arrays.deepToString(arry4));
		*/
		
		Random rnd = new Random();
		rnd.setSeed(100);
		
		int A[][] = new int[3][4]; // fill A and B with random numbers
		int B[][] = new int[4][5];
		int C[][] = new int[3][5]; //A*B
		int D[][] = new int[5][3];
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				A[i][j] = rnd.nextInt(10);
			}
		}
		
		for(int i=0; i<B.length; i++) {
			for(int j=0; j<B[0].length; j++) {
				B[i][j] = rnd.nextInt(5);
			}
		}
		
		System.out.println(Arrays.deepToString(A));
		System.out.println(Arrays.deepToString(B));
				
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B[0].length; j++) {
				for(int k=0; k<A[0].length; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		System.out.println(Arrays.deepToString(C));
		
		/*
		for(int i=0; i<C.length; i++) {
			for(int j=0; j<C[0].length; j++) {
				if(i==j) {
					System.out.print(C[i][j]);
				}
				else
				{
					System.out.print("\t");
				}
			}
			System.out.print("\n");
			}
		*/
		for(int i=0; i<C[0].length;i++) {
			for(int j=0; j<C.length;j++) {
				D[i][j] = C[j][i];
				}
			}
		System.out.println(Arrays.deepToString(D));
				
		}

}
