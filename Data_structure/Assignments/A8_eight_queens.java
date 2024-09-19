package Ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Directions2 {N, NE, E, SE, S, SW, W, NW}

class Items3 {
	int x;
	int y;
	int dir;
	public Items3(int x, int y, int d) {
		this.x = x; this.y = y; this.dir = d;
	}
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y + ", dir = " + dir;
	}
}
class Offsets3 {
	int a;
	int b;
	public Offsets3(int a, int b) {
		this.a = a; this.b = b;
	}
	@Override
	public String toString() {
		return "Offsets3 [a=" + a + ", b=" + b + "]";
	}
	
}
	class StackList {
	private List<Items3> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException(String message) {
			super(message);
		}
	}

	// --- 생성자(constructor) ---//
	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(0); // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public void push(Items3 p) throws OverflowIntStackException {
		if (isFull()) // 스택이 가득 참
			throw new OverflowIntStackException("overflow");
		data.add(p);top++;
		return;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items3 pop() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("empty");
		return data.remove(--top);
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Items3 peek() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("empty");
		return data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Items3 x) {
		for (int i = top - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

	public class Assgn9 {

		static Offsets3[] moves = new Offsets3[8];//static을 선언하는 이유를 알아야 한다
		
		public static void fillMoves() {
			int[] a = {-1, -1, 0, 1, 1, 1, 0, -1};
			int[] b = {0, 1, 1, 1, 0, -1, -1, -1};
			
			for (int ia = 0; ia < 8; ia++) {
				moves[ia] = new Offsets3(a[ia], b[ia]); //배열에 offsets 객체를 치환해야 한다.
			}
//			System.out.println(Arrays.toString(moves).toString());
		}
		
		public static void path(int[][] maze, int[][] mark, int ix, int iy) {

			mark[1][1] = 1;
			StackList st = new StackList(50);
			Items3 temp = new Items3(1, 1, 2);//N :: 0
			mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시
			st.push(temp);
			
			while (!st.isEmpty()) // stack not empty
			{
				Items3 tmp = st.pop(); // unstack
				int i = tmp.x;
				int j = tmp.y;
				int d = tmp.dir;
				mark[i][j] = 1;//backtracking 궤적은 1로 표시
				
				while (d < 8) // moves forward
				{	
					int g = i + moves[d].a;
					int h = j + moves[d].b;
					if ((g == ix) && (h == iy)) { // reached exit // output path
						mark[i][j] = 2; mark[g][h] = 2;
						st.clear();
						break;
					}
					if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
						mark[i][j] = 2; mark[g][h] = 2;
						Items3 newTemp = new Items3(i, j, d);
						st.push(newTemp);
						i = g; j = h; d = 0;//update its position
						// keep going on
					} else {
						mark[i][j] = 1;
						d++; // try another direction
						continue;
					}
				}
			}
		}
		
		static void showMatrix(int[][] d) {
			for(int[] row : d) {
				for(int col : row) {
					System.out.print(col + " ");
				}
				System.out.println();
			}
		}
		
		static void fillMaze(int[][] input, int[][] maze) {
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
//					 input[][]을 maze[][]로 변환
					if(i==0 || i==maze.length-1 || j==0 || j==maze[0].length-1)
						maze[i][j] = 1;
					else maze[i][j] = input[i-1][j-1];
				}
			}
		}
		
		public static void main(String[] args) {
			int[][] maze = new int[14][17]; // filled with zeros
			int[][] mark = new int[14][17];
			
			int input[][] = { // 12 x 15
					{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
					{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
					{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
					{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
					{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
			
			fillMaze(input,maze);
			fillMoves();
//			System.out.println(moves[0].a);
//			System.out.println(moves[0].b);
//			moves[0].a = -1;	moves[0].b = 0;
			
//			showMatrix(maze);
			
//			//Directions d;
//			//d = Directions.N;
//			//d = d + 1;//java는 지원안됨
//
			System.out.println("maze : ");
			showMatrix(maze);
////		
//			System.out.println("mark at the beginning :");
//			showMatrix(mark);
//
			path(maze, mark, 12, 15);
			System.out.println("mark after exiting : ");
			showMatrix(mark);
		}
	}

