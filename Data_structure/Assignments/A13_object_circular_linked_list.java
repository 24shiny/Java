package Ch8;

/*
 * 정수 리스트 > 객체 리스트> 객체 원형 리스트 
 * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

import Ch8.ObjectLinkedList.Menu;

class SimpleObject3 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름
	String expire;//  유효기간 필드를 추가
	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "[" + no + "] " + name;
	}

	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}
	public SimpleObject3() {// head node를 만들 때 사용
		this.no = null;
		this.name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요.");

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class Node3 {
	SimpleObject3 data;
	Node3 link;

	public Node3(SimpleObject3 element) {
		data = element;
		link = null;
	}
}

class CircularList {
	Node3 first;

	public CircularList() { //head node
		SimpleObject3 data = new SimpleObject3();
		first = new Node3(data);
		first.link = first;
	}

	/*
	 * static void sortData(Fruit []arr, Comparator<Fruit> cc) { for (int i = 0; i <
	 * arr.length; i++) { for (int j = i; j < arr.length; j++) if
	 * (cc.compare(arr[i], arr[j])> 0) swap(arr, i, j); } }
	 */
	public boolean Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) // delete the element
	{
		if(!Search(element, cc)) return false; // 삭제할 대상이 없다.
		else { // find the element
			Node3 q=first.link, p = first.link;
			while(p!=first) {
				q = p;
				p = p.link; 
				if(p==first) break;
				if(cc.compare(p.data,element)==0) {
					q.link = p.link;
					return true;
				}
				else p = p.link; 
			}
		}
		return false;
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node3 p = first.link;
		if(p==first) {
			System.out.println("the list is empty");
		}
		else
		{
			do {
				System.out.println(p.data + " ");
				p = p.link;
			} while(p!=first);
		}
		System.out.println();
	}

	public void Add(SimpleObject3 element, Comparator<SimpleObject3> cc) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node3 p = first.link, q=first;
		Node3 newNode = new Node3(element);
		if(p==first) { // executed at first
			first.link = newNode;
			newNode.link = first;		
		}
		else
		{	
			while(p!=first) {
				if(cc.compare(p.data,element)==1){
					newNode.link = p;
					if(q==first) { // inserted as the first node
						first.link = newNode;
					}
					else {
						q.link=newNode;
					}
					break;
				} else { // mark the current position(q) go to the next(p)
					q = p;
					p = p.link;
				}
			} //p==first
			
			if(q!=first) {
				if(cc.compare(q.data,element)==-1) { // insert a new node at the end of the chain
				q.link = newNode;
				newNode.link = first;
				}
			}
		}
	}
	
	public void Append(SimpleObject3 element, Comparator<SimpleObject3> cc) // for testing the code
	{
		Node3 p = first.link, q=null;
		Node3 newNode = new Node3(element);
		if(p==first) {
			first.link = newNode;
			newNode.link = first;		}
		else
		{	
			do {
				q = p;
				p = p.link;
			} while(p!=first);
			q.link = newNode;
			newNode.link = first;
		}
	}
	
	public boolean Search(SimpleObject3 element, Comparator<SimpleObject3> cc) { // 전체 리스트를 순서대로 출력한다.
		Node3 p = first.link, q=first.link;
		while(p!=first) { 
			q = p;
			if(cc.compare(q.data,element)==0) return true;
			p = p.link;
		}
		if(cc.compare(q.data,element)==0) return true;
		return false;
	}
	void Merge(LinkedList1 b) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
		System.out.println("merge");
	}
}

public class ObjectCircularLinkedList {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("합병"), Exit("종료");

		private final String message; // 표시할 문자열

        static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
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
		Scanner sc = new Scanner(System.in);
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 &&
                      m.ordinal() != Menu.Exit.ordinal())
                    System.out.println();
            }
            System.out.print(" : ");
            key = sc.nextInt();
        } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
        return Menu.MenuAt(key);
    }

	public static void main(String[] args) {
		Menu menu; // 메뉴
		CircularList l = new CircularList();
		CircularList l2 = new CircularList();
		Scanner sc = new Scanner(System.in);
		SimpleObject3 data;
		int count = 3;//l2 객체의 숫자를 3개로 한다 

		do {
			switch (menu = SelectMenu()) {
			case Add:
				data = new SimpleObject3();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject3.NO_ORDER);
				break;
			case Delete: // 
				data = new SimpleObject3();
				data.scanData("삭제", SimpleObject3.NO);
				boolean deletion = l.Delete(data, SimpleObject3.NO_ORDER);
				if (deletion) System.out.println("삭제되었습니다.");
				else System.out.println("유효하지 않은 값입니다.");
				l.Show();
					break;
			case Show: 
				l.Show();
					break;
			case Search: // 회원 번호 검색
				data = new SimpleObject3();
				data.scanData("탐색", SimpleObject3.NO);
				boolean result = l.Search(data, SimpleObject3.NO_ORDER);
				if (result)
					System.out.println("검색 성공");
				else
					System.out.println("검색 실패");
				break;
			case Merge:
//				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
//					data = new SimpleObject3();
//					data.scanData("병합", 3);
//					l2.Add(data, SimpleObject3.NO_ORDER );				
//				}
//				l.Merge(l2);
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
