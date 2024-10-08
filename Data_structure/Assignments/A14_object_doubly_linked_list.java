package Ch8;
/*
 * 정수 리스트 > 객체 리스트 >
 * * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject2 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?
	String no; // 회원번호
	String name; // 이름
	String expire;//  유효기간 필드를 추가

	public SimpleObject2(String sno, String sname) {
		this.no = sno;
		this.name = sname;
	}
	public SimpleObject2() {
		this.no = null;
		this.name = null;
	}
	// --- 문자열 표현을 반환 ---//
	@Override
	public String toString() {
		return "[" + no + "] " + name;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요.");

		if ((sw & NO) == NO) { //& 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}
//	// --- 회원번호로 순서를 매기는 comparator ---//
//	public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();
//
//	private static class NoOrderComparator implements Comparator<SimpleObject2> {
//		@Override
//		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
//			return (d1.no.compareTo(d2.no) > 0) ? 1 : ((d1.no.compareTo(d2.no) < 0)) ? -1 : 0;
//		}
//	}
//
//	// --- 이름으로 순서를 매기는 comparator ---//
//	public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();
//
//	private static class NameOrderComparator implements Comparator<SimpleObject2> {
//		@Override
//		public int compare(SimpleObject2 d1, SimpleObject2 d2) {
//			return (d1.name.compareTo(d2.name) > 0) ? 1 : ((d1.name.compareTo(d2.name) < 0)) ? -1 : 0;
//		}
//	}
}

class Node4 {
	SimpleObject2 data; // 데이터
	Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	Node4(SimpleObject2 so) {
		this.data = so;
		llink = rlink = this;
	}
	Node4() { //head node로 사용
		this.data = null;
		llink = rlink = this;
	}
	Node4(String sno, String sname) {
		data = new SimpleObject2(sno, sname);
		llink = rlink = this;
	}
	public int compareNode(Node4 n2) {
//		SimpleObject2 so1 = this.data;
//		if (SimpleObject2.NO_ORDER.compare(so1, n2.data) < 0) return -1;
//		else if (SimpleObject2.NO_ORDER.compare(so1, n2.data) > 0)return 1;
//		else return 0;
		if (Integer.parseInt(this.data.no)<Integer.parseInt(n2.data.no)) return -1;
		else if (Integer.parseInt(this.data.no)>Integer.parseInt(n2.data.no))return 1;
		else return 0;
	}
}

class DoubledLinkedList2 {
	private Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

	// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		SimpleObject2 data = new SimpleObject2();
		first = new Node4(data); // dummy(first) 노드를 생성
		first.llink = first;
		first.rlink = first;
	}

	// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.rlink == first;
	}

	// --- 노드를 검색 ---//
	public boolean search(SimpleObject2 obj) {
		Node4 p = first.rlink, q=null;
		Node4 temp = new Node4(obj);
		while(p!=first) { 
			q = p;
			if(q.compareNode(temp)==0) return true;
			else p = p.rlink;
		}
		if(q.compareNode(temp)==0) return true;
		return false;
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node4 p = first.rlink;
		if(p==first) {
			System.out.println("the list is empty");
		}
		else
		{
			do {
				System.out.println(p.data + " ");
				p = p.rlink;
			} while(p!=first);
		}
		System.out.println();
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(SimpleObject2 element) {
//		Node4 temp = new Node4(obj);
//		Node4 ptr = first;
		Node4 p = first.rlink, q=first;
		Node4 newNode = new Node4(element);
		if(p==first) { // executed at first
			first.rlink = newNode;
			first.llink = newNode;
			newNode.rlink = first;
			newNode.llink = first;
		}
		else
		{	
			while(p!=first) {
				if(p.compareNode(newNode)==1){
					newNode.rlink = p;
					if(q==first) { // inserted as the first node
						first.rlink = newNode;
						first.llink = p;
						newNode.llink = first;
						p.llink = newNode;
					}
					else {
						q.rlink = newNode;
						newNode.llink = q;
						p.llink = newNode;
					}
					break;
				} else { // mark the current position(q) go to the next(p)
					q = p;
					p = p.rlink;
				}
			} //p==first
			
		if(q!=first) {	
			if(q.compareNode(newNode)==-1) { // insert a new node at the end of the chain
			q.rlink = newNode;
			first.llink=newNode;
			newNode.llink=q;
			newNode.rlink = first;
			}
		}
		}

	}

	public void Append(SimpleObject2 obj) {
		Node4 newNode = new Node4(obj);
		Node4 p = first.rlink, q=null;
		if(p==first) {
			first.rlink = newNode;
			newNode.rlink = first;
			newNode.llink = first;
			}
		else
		{	
			do {
				q = p;
				p = p.rlink; // move forward
			} while(p!=first);
			
			q.rlink = newNode;
			newNode.rlink = first;
			newNode.llink = q;
		}

	}
	
	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public boolean delete(SimpleObject2 obj) {	
		Node4 p = first.rlink, q=first;
		Node4 temp = new Node4(obj);
		while(p!=first) { 
			if(p.compareNode(temp)==0) {
				q.rlink = p.rlink; 
				p.rlink.llink = q;
				return true;
			}
			q = p;
			p = p.rlink;
		}
		return false;
	}
	
	public DoubledLinkedList2 merge(DoubledLinkedList2 lst2) {
		//l3 = l1.merge(l2); 실행하도록 리턴 값이 리스트임 
		//l.add(객체)를 사용하여 구현
		//기존 리스트의 노드를 변경하지 않고 새로운 리스트의 노드들을 생성하여 구현 
		DoubledLinkedList2 lst3 = new DoubledLinkedList2();
		Node4 ai = this.first.rlink, bi = lst2.first.rlink;


		return lst3;

	}
}

public class ObjectDoublyLinkedList {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("병합"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc1 = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc1.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Scanner sc2 = new Scanner(System.in);
		DoubledLinkedList2 lst1 = new DoubledLinkedList2(), lst2 = new DoubledLinkedList2(),lst3 = new DoubledLinkedList2();
		String sno1 = null, sname1 = null;
		SimpleObject2 so;
		boolean result = false;
		int count = 3;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 객체들의 올림차순으로 정렬되도록 구현
				so =  new SimpleObject2();
				so.scanData("입력", 3);
				lst1.add(so);
				break;
			case Delete: // 임의 객체를 삭제
				so =  new SimpleObject2();
				so.scanData("삭제", SimpleObject2.NO);
				boolean deletion = lst1.delete(so);
				if (deletion) System.out.println("삭제되었습니다.");
				else System.out.println("유효하지 않은 값입니다.");
				lst1.show();
				break;
			case Show: // 리스트 전체를 출력
				lst1.show();
				break;
			case Search: // 회원 번호 검색
				so =  new SimpleObject2();
				so.scanData("탐색", SimpleObject2.NO);
				result = lst1.search(so);
				if (result)
					System.out.println("검색 성공");
				else
					System.out.println("검색 실패");
				break;
			case Merge://기존 2개의 리스트를 합병하여 새로운 리스트를 생성(새로운 노드를 생성하여 추가)
//				for (int i = 0; i < count; i++) {
//					so =  new SimpleObject2();
//					so.scanData("입력", 3);
//					lst2.add(so, SimpleObject2.NO_ORDER);
//				}
//				lst3 = lst1.merge(lst2);
//				System.out.println("list1: ");
//				lst1.show();
//				System.out.println("list2: ");
//				lst2.show();
//				System.out.println("list3: ");
//				lst3.show();
				break;
			case Exit: // 
				break;
			}
		} while (menu != Menu.Exit);
	}
}
