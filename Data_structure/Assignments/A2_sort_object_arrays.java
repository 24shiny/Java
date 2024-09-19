package Ch2;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	public PhyscData(String name, int height, double vision) { //constructor
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + height + ", " + vision + "]";
	}

	@Override
	public int compareTo(PhyscData p) {
        if (this.height == p.height) {
            return 0;
        } else if(this.height < p.height) {
            return -1;
        } else {
            return 1;
        }
    }
	
	public boolean equals(PhyscData p) {
        if(this.compareTo(p)==0) return true;
        return false;
	}
}

public class Assgn2 {
	static void swap(PhyscData[] arr, int ind1, int ind2) {
		PhyscData temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	static void sortData(PhyscData[] arr) { //sort by height in the ascending order
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i].compareTo(arr[j])>0) { //use compareTo() 
					swap(arr,i,j);
				}
			}
		}
	}
	static void showData(PhyscData[]arr) {
		for(PhyscData str:arr) {
			System.out.print(str+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		PhyscData myObj = new PhyscData("홍길", 152, 0.7);
		
		showData(data);
		sortData(data);
		//Arrays.sort(null, null);//comparator가 필요하다 
		showData(data);
		System.out.println(data.equals(myObj));
	}
}
