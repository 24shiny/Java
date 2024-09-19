package Ch9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import Ch9.ObjectStack5;
import Ch9.ObjectQueue5;

class TreeNode5 {
	TreeNode5 LeftChild;
	TreeNode5 RightChild;
	int data;

	public TreeNode5() {
		LeftChild = RightChild = null;
	}
	
	public TreeNode5(int data) {
		this.data = data;
		LeftChild = RightChild = null;
	}
}

class Tree5 {
	TreeNode5 root;

	Tree5() {
		root = null;
	}

	TreeNode5 inorderSucc(TreeNode5 current) {//find a inorder successor
		TreeNode5 temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		System.out.println("inordersucc:: temp.data = "+temp.data);
		return temp;
	}

	boolean isLeafNode(TreeNode5 current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode5 CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode5 CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode5 CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	void NonrecInorder()//void Tree5::inorder(TreeNode5 *CurrentNode)와 비교
	//stack을 사용한 inorder 출력
	{
		ObjectStack5 s = new ObjectStack5(20);
		TreeNode5 CurrentNode = root;
		while (true) {
			while (CurrentNode != null) {
				s.push(CurrentNode);
				CurrentNode = CurrentNode.LeftChild;
			}
			if (!s.isEmpty()) {
				try {
					CurrentNode = s.pop();
				} catch (ObjectStack5.EmptyGenericStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" " + CurrentNode.data);
				CurrentNode = CurrentNode.RightChild;
			}
			else break;  
		}
	}
	void levelOrder() //level 별로 출력한다. level이 증가하면 다음줄에 출력한다 
	//난이도: 최상급 구현 
	{
		ObjectQueue5 q = new ObjectQueue5(20);
		Queue<Integer> que = new LinkedList<>();
		int oldLevel = 0,  newLevel=0;
		que.add(oldLevel+1);
		
		TreeNode5 CurrentNode = root;
		newLevel = que.remove();
		
	}

	void insert(int x) {// binary search tree를 만드는 입력 : left subtree < 노드 x < right subtree
		//inorder traversal시에 정렬된 결과가 나와야 한다
		TreeNode5 p = root, q=null;
		TreeNode5 temp = new TreeNode5(x);
		if(p==null) { // first node 
			root = temp;
		} else {
			while(p!=null) {
				q = p;				
				if(isLeafNode(q)) {
					if(x<q.data) q.LeftChild = temp;
					else q.RightChild = temp;
					break;
				}
				else { //go forward until..
					if(x<q.data) {
						if(q.LeftChild==null) {q.LeftChild = temp; break;}
						else p = p.LeftChild;
					} else if(q.data<x) {
						if(q.RightChild==null) {q.RightChild = temp; break;}
						else p = p.RightChild; // 비교를 위해 이동
					} else break;
				}			
			}
			if(x<q.data) q.LeftChild = temp; // may not be used
			else q.RightChild = temp;
		}
		
	}

	boolean delete(int num) {//binary search tree에서 임의 값을 갖는 노드를 찾아 삭제한다.
		//삭제 대상이 leaf node인 경우, non-leaf node로 구분하여 구현한다 		
		TreeNode5 p = root, q = root;
		int branchMode = 0; // 1은 left, 2는 right
		while(p!=null) {
			if(p.data==num) { // when the value is found,
				if(isLeafNode(p)) { // DONE
					System.out.println("leaf node");
					switch(branchMode) { // branchMode concerns p-q relation
					case 1: {q.LeftChild = null; break;}
					case 2: {q.RightChild = null; break;}
					}
					return true;
				} 
				else { // as for non-leaf nodes 
					if(p.LeftChild != null && p.RightChild != null) { //자식 노드가 2개인 경우
						System.out.println("2 children");
						if(p.LeftChild != null && p.RightChild != null) {
							TreeNode5 inSucc = inorderSucc(q);
							int inSuccData = inSucc.data;
							delete(inSuccData);
							q.data = inSuccData;
						}
						else { // 부모가 노드 한 개일 경우 간단하게 처리 가능
						q.LeftChild = p.LeftChild;
						q.RightChild = p.RightChild;
						}
						return true;
					} else { //자식 1개인 경우, 어느 쪽의 자식인지 파악해야함
						System.out.println("one child");
						switch(branchMode) { // branchMode concerns parent-q relation
						case 0: { // remove root 
							System.out.println("remove a root"); //DONE
							if(p.LeftChild!=null) root = p.LeftChild;
							else root = p.RightChild;
							break; }
						case 1: { // q.left = p
							System.out.println("case 1");
							if(p.LeftChild!=null) {q.LeftChild = p.LeftChild; System.out.println("LL");}
							else {q.LeftChild = p.RightChild; System.out.println("LR");}
							break; }
						case 2: { //q.right = p
							System.out.println("case 2");
							if(p.LeftChild!=null) {q.RightChild = p.LeftChild; System.out.println("RL");}
							else {q.RightChild = p.RightChild; System.out.println("RR");}
							break; }
						}
						return true;
					}
				}	
			} 
			else if (num < p.data) {branchMode = 1; q = p; p = p.LeftChild; }
			else {branchMode = 2; q = p; p = p.RightChild;}
		}
		return false;
	}

	boolean search(int num) {//num 값을 binary search tree에서 검색
		TreeNode5 p = root;
		while(true) {
			if(p==null) return false;
			if(p.data==num) return true;
			else if (num < p.data) p = p.LeftChild;
			else p = p.RightChild;
		}
	}
}

public class IntegerBinaryTree {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("정렬출력"), 
		LevelorderPrint("레벨별출력"), StackInorderPrint("스택정렬출력"), 
		PreorderPrint("prefix출력"), PostorderPrint("postfix출력"), Exit("종료");

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
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}
	
	static int[] nonDuplicatedArray(int count) {
		Random rand = new Random();
		rand.setSeed(0);
		HashSet<Integer> nonDupSet = new HashSet<Integer>();
		for (int i = 0; i < count; i++) {
			nonDupSet.add(rand.nextInt(49)+1);
		}
		List<Integer> nonDupList = new ArrayList<Integer>(nonDupSet);
		int[] nonDupArr = new int[nonDupList.size()];
		for(int j=0; j<nonDupList.size(); j++) {
			nonDupArr[j] = nonDupList.get(j).intValue();
		}
		return nonDupArr;
	}

	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		Tree5 t = new Tree5();
		Menu menu; // 메뉴
		int count = 10;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 
				int[] nonDupArr = nonDuplicatedArray(count);
				System.out.println(Arrays.toString(nonDupArr));
				for(int i=0; i<nonDupArr.length; i++) {
					t.insert(nonDupArr[i]);
				}
				break;

			case Delete: //임의 정수 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num))
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");
				
				num = stdIn.nextInt();
				result = t.search(num);
				if (result)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				//t.NonrecInorder();
				break;
			case LevelorderPrint: // 
				t.levelOrder();
				System.out.println();
				//t.NonrecInorder();
				break;
			case StackInorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.NonrecInorder();
				break;
			case PreorderPrint://prefix 출력
				t.preorder();
				System.out.println();
				break;
			case PostorderPrint://postfix로 출력
				t.postorder();
				System.out.println();
				break;
			default:
				break;
			}
		} while (menu != Menu.Exit);
	}
}
