package Ch5;

//해가 256개 확인 필요 23.12.12
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Ch5.Stack4.EmptyGenericStackException;

//import Ch4.Point2;
//import Ch4.objectStack;
//import Ch4.objectStack.EmptyGenericStackException;
//import Ch4.objectStack.OverflowGenericStackException;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
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
		if ((this.ix == ((Point) p).ix) && (this.iy == ((Point) p).iy))
			return true;
		else
			return false;
	}
}

class Stack4 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		top = 0;
		this.capacity = capacity;
		try {
			data = new ArrayList<>(this.capacity);
		} catch (OutOfMemoryError e) {
			this.capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public void push(Point x) throws OverflowGenericStackException {
		if (isFull())
			throw new OverflowGenericStackException("Warning : overflow");
		this.data.add(top++, x);
		System.out.println("푸시한 데이터는" + x + "입니다.");
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("Warning : empty");
		System.out.println("팝한 데이터는" + this.data.get(top - 1) + "입니다.");
		Point removedata = data.remove(--top);
		return removedata;
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("Warning : empty");
		return this.data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
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

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException("Warning : empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
		}
	}

}

public class Assgn8 {

	public static void EightQueen(int[][] d) {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0;
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		st.push(p);// 스택에 현 위치 객체를 push
		ix++;

		while (true) { // p175
			if (count == 8) {
				showQueens(d);
				break;
			}
			int newCol = nextMove(d, ix, iy);
			System.out.println("newcol=" + newCol);
			if (newCol != -1) {
				Point pNew = new Point(ix, newCol);
				st.push(pNew);
				d[ix][newCol] = 1;
				count++;
				ix++;
				iy = 0;
				continue;
			} else {
				try {					
					while(true) {
						p = st.pop();
						ix = p.getX();
						iy = p.getY();
						d[ix][iy] = 0;
						count--;
						iy++;
						if(iy>=d.length) continue;
						else break;
					}
					
				} catch (EmptyGenericStackException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}

		}

	}

//	}
//
	// 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int tempX1 = cx, tempY1 = cy;

		while (0 <= tempX1 & tempX1 <= 7 & 0 <= tempY1 & tempY1 <= 7) {
			if (d[tempX1][tempY1] == 1) return false;
			tempX1++; tempY1++;				
		}

		tempX1 = cx; tempY1 = cy;
		while (0 <= tempX1 & tempX1 <= 7 & 0 <= tempY1 & tempY1 <= 7) {
			if (d[tempX1][tempY1] == 1) return false;
			tempX1--; tempY1--;
		}
	return true;
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		int tempX1 = cx, tempY1 = cy;

		while (0 <= tempX1 & tempX1 <= 7 & 0 <= tempY1 & tempY1 <= 7) {
			if (d[tempX1][tempY1] == 1) return false;
			tempX1++; tempY1--;				
		}

		tempX1 = cx; tempY1 = cy;
		while (0 <= tempX1 & tempX1 <= 7 & 0 <= tempY1 & tempY1 <= 7) {
			if (d[tempX1][tempY1] == 1) return false;
			tempX1--; tempY1++;
		}
	return true;
	}

	public static boolean checkRow(int[][] d, int col) {// (x,y)로 이동 가능한지를 check
		for (int i = 0; i < d[0].length; i++) {
			if (d[i][col] == 1) return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int row) {// (x,y)로 이동 가능한지를 check
		for (int j = 0; j < d.length; j++) {
			if (d[row][j] == 1) return false;
		}
		return true;
	}

//	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, y) & checkCol(d, x) & checkDiagSW(d, x, y) & checkDiagSE(d, x, y) == true)
			return true;
		return false;
	}

//	
//	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		for (int j = col; j < d[0].length; j++) {
			if(checkMove(d, row, j) == true)
				return j;
		}
		return -1;
	}

//
	static void showQueens(int[][] data) {// 배열 출력
		System.out.println("=".repeat(10));
		for (int[] row : data) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		System.out.println("=".repeat(10));
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);
		

//		check stack
//		Scanner stdIn = new Scanner(System.in);
//		Stack4 s = new Stack4(8); // 최대 8 개를 push할 수 있는 stack
//		Random random = new Random();
//		int rndx = 0, rndy = 0;
//		Point p = null;
//		
//		while (true) {
//			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
//			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
//			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(5) clear (0)종료: ");
//
//			int menu = stdIn.nextInt();
//			if (menu == 0)
//				break;
//
//			switch (menu) {
//			case 1: // 푸시
//				System.out.print("데이터: ");
//				rndx = random.nextInt(20);
//				rndy = random.nextInt(20);
//				p = new Point(rndx,rndy);
//				try {
//					s.push(p);
//				} catch(Stack4.OverflowGenericStackException e) {
//					System.out.println(e.getMessage());
//					e.printStackTrace();
//				}
//				break;
//
//			case 2: // 팝
//				try {
//					p = s.pop();
//					System.out.println("pop한 데이터는 " + p + "입니다.");
//				} catch(Stack4.EmptyGenericStackException e) {
//					System.out.println(e.getMessage());
//					e.printStackTrace();
//				}
//				break;
//
//			case 3: // 피크
//				try {
//					p = s.peek();
//					System.out.println("peek한 데이터는 " + p + "입니다.");
//				} catch (Stack4.EmptyGenericStackException e) {
//					System.out.println(e.getMessage());
//					e.printStackTrace();
//				}
//				break;
//
//			case 4: // 덤프
//				try {
//					s.dump();
//				} catch (Stack4.EmptyGenericStackException e) {
//					// TODO Auto-generated catch block
//					System.out.println(e.getMessage());
//					e.printStackTrace();
//				}
//				break;
//				
//			case 5: //clear
//				s.clear();
//			
//			default:
//					break;
//			}	
//		}
	}
}