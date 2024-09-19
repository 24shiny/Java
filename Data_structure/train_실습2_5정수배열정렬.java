package Chap2_기본자료구조;

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class train_실습2_5정수배열정렬 {

	public static void main(String[] args) {
		int []data = new int[10];
		
		Arrays.sort(data);
		inputData(data);
		showData(data);
		/*
		sortData(data);
		showData(data);
		*/
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData(data);

		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		showData(data);
	}
	static void showData(int[]data) {

	}
	static void inputData(int []data) {

	}
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		
	}
	static void sortData(int []arr) { //ascending order
		for(int i=0; i<arr.length;i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					swap(arr,arr[i],arr[j]);
				}
			}
		}
	}
	static void reverse(int[] a) {//교재 67페이지, descending order

	}
	static void reverseSort(int []arr) {

	}

}
