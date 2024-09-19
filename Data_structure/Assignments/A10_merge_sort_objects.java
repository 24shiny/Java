package Ch6;

import java.util.Arrays;

class Polynomial implements Comparable<Polynomial>{
    double coef;           // 계수
    int    exp;            // 지수
	    
    public Polynomial(double coef, int exp) {
		super();
		this.coef = coef;
		this.exp = exp;
	}

	@Override
	public int compareTo(Polynomial p) { // compare exponents
		// TODO Auto-generated method stub
        if (this.exp == p.exp) {
            return 0;
        } else if(this.exp < p.exp) {
            return -1;
        } else {
            return 1;
        }
	}

	@Override
	public String toString() {
		return coef + "x^" + exp;
	}
	

}
public class Assgn11 {
	
	static Polynomial[] buff;
	
	static void merge(Polynomial[] a, int lefta, int righta, int leftb, int rightb ) {
		int ix = 0;
		int p = lefta, q = leftb;
		while (p <= righta && q <= rightb) {
			if (a[p].exp < a[q].exp) buff[ix++].exp = a[p++].exp;
			else if (a[p].exp > a[q].exp) buff[ix++].exp = a[q++].exp;
			else {
				buff[ix++].exp = a[p++].exp; buff[ix++].exp = a[q++].exp;
			}
		}
		while (p > righta && q <= rightb) buff[ix++].exp = a[q++].exp;
		while (q > rightb && p <= righta) buff[ix++].exp = a[p++].exp;
		for (int j = 0; j < ix; j++) {
			a[lefta+ j].exp = buff[j].exp;
//			System.out.print(" "+ a[lefta+j].exp);
		}
//			System.out.println();

	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial[] a, int left, int right) {
		int mid = (left+right)/2;
		buff = new Polynomial[a.length];
		for(int i=0; i<a.length; i++) {
			buff[i] = new Polynomial(0,0);
		}
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	
	public static void ShowPolynomial(Polynomial[] x) {
		for(Polynomial element : x) {
			System.out.println(element.toString());
		}
	}
	
	public static Polynomial[] initPolynomial(Polynomial[] p) {
		for(int i=0; i<p.length; i++) {
			p[i] = new Polynomial(0,i);
		}
		return p;
	}
	
	public static void AddPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] z) {
		for(int i=0; i<x.length; i++) {
			z[x[i].exp].coef += x[i].coef;
		}
		for(int i=0; i<y.length; i++) {
			z[y[i].exp].coef += y[i].coef;
		}
	}
	
	public static void MultiplyPolynomial(Polynomial[] x, Polynomial[] y, Polynomial[] m) {
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<y.length; j++) {
				m[x[i].exp+y[j].exp].coef += (y[i].coef*x[i].coef);
			}
		}
	}
	
	public static double EvaluatePolynomial(Polynomial[] m, int input) {
		double result = 0;
		for(int i=0; i<m.length; i++) {
			result += m[i].coef * Math.pow(input, m[i].exp);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Polynomial[] x = {
		         new Polynomial(1.5, 3),
		         new Polynomial(2.5, 7),
		         new Polynomial(3.3, 2),
		         new Polynomial(4.0, 1),
		         new Polynomial(2.2, 0),
		         new Polynomial(3.1, 4),
		         new Polynomial(3.8, 5),
		     };
		Polynomial[] y = {
		         new Polynomial(1.5, 1),
		         new Polynomial(2.5, 2),
		         new Polynomial(3.3, 3),
		         new Polynomial(4.0, 0),
		         new Polynomial(2.2, 4),
		         new Polynomial(3.1, 5),
		         new Polynomial(3.8, 6),
		     };
		int nx = x.length;

		System.out.println("polynomial x reads : ");
		ShowPolynomial(x);
		System.out.println("\npolynomial y reads : ");
		ShowPolynomial(y);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		System.out.println("\nsorted polynomial x reads : ");
		ShowPolynomial(x);
		System.out.println("\nsorted polynomial y reads : ");
		ShowPolynomial(y);
		
		Polynomial[] z = new Polynomial[8];
		z = initPolynomial(z);
		AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		System.out.println("\npolynomial z=x+y reads : ");
		ShowPolynomial(z);
		
		Polynomial[] m = new Polynomial[14];
		m = initPolynomial(m);
		MultiplyPolynomial(x,y,m);//다항식 곱셈 m = x * y
		System.out.println("\npolynomial m=x*y reads : ");
		ShowPolynomial(m);
		
		double result = EvaluatePolynomial(z, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println("\nresult of the evaluation = " + result );
		
	}


}
