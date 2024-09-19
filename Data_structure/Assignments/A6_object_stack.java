package Ch4;
/*
 * 원형 큐로서 큐에 Point 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;
//
//import Ch4.IntQueue3.EmptyQueueException;
//import Ch4.IntQueue3.OverflowQueueException;
//import Ch4Revised.Point5;


class Point5 {
	private int ix;
	private int iy;

	public Point5(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point5)p).ix) && (this.iy == ((Point5)p).iy))
			return true;
		else return false;
	}
}


class CircularQueue {
	static int capacity = 0;
	Point5[] que;//배열로 객체원형 큐 구현
	int front, rear;
	int num;
	static boolean isEmptyTag;
	//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public EmptyQueueException(String message) {
			super(message);
		}
	}
	//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public OverflowQueueException(String message) {
			super(message);
		}
	}
	
	public CircularQueue(int maxlen) {
		capacity = maxlen;
		front = rear = 0;
		try {
			que = new Point5[capacity];
		} catch(OutOfMemoryError e) {
			capacity=0;
		}
	}
	void push(Point5 x) throws OverflowQueueException{
		if(isFull())
			throw new OverflowQueueException("error in this push; stack overflow");
		que[rear++] = x;
		System.out.println("푸시한 데이터는" + x + "입니다.");
		System.out.println("front :" + front + "rear : " + rear + "입니다.");
		if(rear==capacity) rear=0;
	}

	Point5 pop() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("error in this pop; stack is empty");
		Point5 returnVal = que[front++];
		System.out.println("front :" + front + "rear : " + rear + "입니다.");
		if(front == capacity) front=0;
		return returnVal;
	}

	 void clear() throws EmptyQueueException{
			if(isEmpty())
				throw new EmptyQueueException("error in this clear; stack is empty");
			for(int i = 0; i < que.length; i++) {// clear que
				que[i] = null;
			}
			front = rear = num = 0;
	}


	//--- 큐의 크기를 반환 ---//
		public int getCapacity() {
			return capacity;
		}

	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
		public int size() {
			ArrayList<Point5> queList = new ArrayList<>(que.length);
			for(Point5 item:que) {
				queList.add(item);
			}
			if(rear>front) return rear-front;
			else if(rear<front) return (rear+capacity)-front;
			else if(queList.isEmpty()==true) return 0;
			else return capacity;
		}
		//--- 원형 큐가 비어있는가? --- 수정 필요//
		public boolean isEmpty() {
			return size() <= 0;
		}

	//--- 원형 큐가 가득 찼는가? --- 수정 필요//
		public boolean isFull() {
			return size() >= capacity;
		}

		public void dump() throws EmptyQueueException{
			if(isEmpty()) 
				throw new EmptyQueueException("error in this dump; stack is empty");
			else {
				ArrayList<Point5> queList = new ArrayList<>(que.length);
				Collections.reverse(queList);
				Stream<Point5> queStream = queList.stream();
				queStream.forEach((n)->System.out.println(n));
			}
		}
		public Point5 peek() throws EmptyQueueException {
			if(isEmpty())
				throw new EmptyQueueException("error in this peek; stack is empty");
			return que[front];
		}
}

public class Assgn7New {
public static void main(String[] args) {
	Scanner stdIn = new Scanner(System.in);
	CircularQueue oq = new CircularQueue(4); // 최대 64개를 인큐할 수 있는 큐
	Random random = new Random();
	int rndx = 0, rndy = 0;
	Point5 p = null;
	while (true) {
		System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
		System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
		System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5)clear  (0)종료: ");
		int menu = stdIn.nextInt();
		if (menu == 0)
			break;
		switch (menu) {
		case 1: // 인큐
			rndx = random.nextInt(20);
			rndy = random.nextInt(20);
			System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
			p = new Point5(rndx,rndy);
			try {
				oq.push(p);
			} catch(CircularQueue.OverflowQueueException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;

		case 2: // 디큐
			try {
				p = oq.pop();
				System.out.println("디큐한 데이터는 " + p + "입니다.");
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;

		case 3: // 피크
			try {
				p = oq.peek();
				System.out.println("peek한 데이터는 " + p + "입니다.");
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;

		case 4: // 덤프
			try {
				oq.dump();
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;
		case 5: //clear
			try {
				oq.clear();
			} catch (CircularQueue.EmptyQueueException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		default:
			break;
		}
	}
	}
}
