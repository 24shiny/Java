package Ch6;

import java.util.ArrayList;
import java.util.List;

/*
 * 6장 구현 실습과제1 
 */
class PhyscData implements Comparable<PhyscData>{
    String name;              // 이름
    int    height;            // 키
    double vision;            // 시력
    
	public PhyscData(String name, int height, double vision) { //constructor
		this.name = name;
		this.height = height;
		this.vision = vision;
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

}
public class Assgn10 {
	
	static PhyscData[] buff;
	
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb ) {
		
		int ix = 0;
		int p = lefta, q = leftb;
		while (p <= righta && q <= rightb) {
			if (a[p].height < a[q].height) buff[ix++].height = a[p++].height;
			else if (a[p].height > a[q].height) buff[ix++].height = a[q++].height;
			else {
				buff[ix++].height = a[p++].height; buff[ix++].height = a[q++].height;
			}
		}
		while (p > righta && q <= rightb) buff[ix++].height = a[q++].height;
		while (q > rightb && p <= righta) buff[ix++].height = a[p++].height;
		System.out.println();
		for (int j = 0; j < ix; j++) {
			a[lefta+ j].height = buff[j].height;
			System.out.print(" "+ a[lefta+j].height);
		}
			System.out.println();

	}

	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left+right)/2;
		buff = new PhyscData[a.length];
		for(int i=0; i<a.length; i++) {
			buff[i] = new PhyscData("name",0,0);
		}
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = {
		         new PhyscData("강민하", 162, 0.3),
		         new PhyscData("김찬우", 173, 0.7),
		         new PhyscData("박준서", 171, 2.0),
		         new PhyscData("유서범", 171, 1.5),
		         new PhyscData("이수연", 168, 0.4),
		         new PhyscData("장경오", 171, 1.2),
		         new PhyscData("황지안", 169, 0.8),
		     };
		int nx = x.length;

		   MergeSort(x, 0, nx - 1); 
			System.out.println("키 기준 오름차순으로 정렬했습니다.");
		     System.out.println("■ 신체검사 리스트 ■");
		     System.out.println(" 이름     키  시력");
		     System.out.println("------------------");
		     for (int i = 0; i < x.length; i++)
		         System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
