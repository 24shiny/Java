
public class ListArray {

	static int getList(int[]data) {
		int count = 0;
		int mid = data.length/2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5; 
			count++;
		}
		return count;
	}
	
	static void showList(int[]data) {
		System.out.println();
		for (int i=0; i < data.length; i++)
			System.out.print(" " + i + " ");
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i]+ " ");
		}
	}
	static int insertList(int[] data, int count, int x) { 
//		int indx = 0;
		if(data[count-1]<x) {
			data[count] = x;
		}
		else
		{
			for(int i=0; i<data.length-2; i++) {
			if(data[i]<x && data[i+1]>x) {
				int temp = data[i+1];
				data[i+1]=x;
				x = temp;
				} 
			else if (data[i]<x && data[i+1]==0) 
			{
				data[i+1]=x;
			}
			}
		}
		return count;}
	
	////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트:");
		count = getList(list); //6
		System.out.println(list[count-1]);
		showList(list);
		count = insertList(list, count, 30);
		showList(list);
		count = insertList(list, count, 3);
		showList(list);
		count = insertList(list, count, 7);
		showList(list);
	}

}
