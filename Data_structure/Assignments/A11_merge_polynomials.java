package Ch6;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		MaxSize = sz; n = 0;
		heap = new int[MaxSize+1];
	}

	public void display() {
		for(int elem : heap) {
			System.out.print(elem + " ");
		}
	}
	@Override
	public void Insert(int x) {
		int i;
		if(n == MaxSize) {HeapFull(); return;}
		n++;
		for(i=n; true; ){
			if(i==1) break;
			if(x<=heap[i/2]) break;
			heap[i] = heap[i/2];
			i /= 2;
		}
		System.out.println("inserted is " + x);
		heap[i] = x;
	}
	@Override
	public int DeleteMax() {
		int i,j;
		if(n==0) {HeapEmpty(); return 0;}
		int x = heap[1]; //root
		int k = heap[n]; n--; //current
		for(i=1, j=2; j<=n; ) {
			if(j<n) if(heap[j]<heap[j+1]) j++;
			if(k>=heap[j]) break;
			heap[i] = heap[j];
			i=j; j*=2;
		}
		heap[i] = k;
		heap[n+1] = 0; // last element <- 0
		return x; 
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class Assgn12 {
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	     System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
//	    final int count = 10;
//	    int[] x = new int[count+1];
//	    int[] sorted = new int[count];
	    
		do {
			System.out.println("\nMax Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1: //insert
				heap.Insert(rnd.nextInt(100));
				heap.display();
				break;
			case 2: //display
				heap.display();
				break;
			case 3: //sort
				int deletedEle = heap.DeleteMax();
				if(deletedEle != 0) {
					System.out.println("deleted is : " + deletedEle);
				}
				System.out.println("after the deletion : ");
				heap.display();
				break;

			case 4:
				break;
			}
		} while (select < 5);
	}
}
