public class LinkedList2 {
	Node2 first;
	LinkedList2(){
		this.first=null;
	}
	class Node2 {
		int data;
		Node2 link;
		public Node2(int data) {
			this.data = data; link = null;
		}
	}
	void append(int data) {
		Node2 p = first, q=null;
		Node2 newNode = new Node2(data);
		if(first==null) {
			first = newNode;
		}
		else
		{
			q = p;
			while(q.link!=null) {
				q = q.link;
			}
			q.link=newNode;
		}
			
	}
	void showList() {
		Node2 p = first;
		if(first==null) {
			System.out.println("the list is empty");
		}
		else
		{
			Node2 q = p;
			while(q!=null) {
				System.out.print(q.data+" ");
				q = q.link;
			}
		}
	}
//	void insert(int data) {
//		Node2 newNode = new Node3(data);
//		Node2 p = first, q = null;
//	}
	public static void main(String[] args) {
		LinkedList2 ll = new LinkedList2();
		ll.append(5);ll.append(10);ll.append(15);ll.append(20);ll.append(25);
		ll.showList();
//		ll.insert(3);ll.showList();
//		ll.insert(7);ll.showList();
	}
	}