package Ch10;

public class GG {
		// TODO Auto-generated method stub
		public void print(int i) {
			System.out.println(i + "단");
			for(int j=1 ; j<=9; j++) {
					System.out.println(i + "*" + j + "=" + i*j);
				}
			}
		
		
		public void printall() {
			for(int i=1; i<10; i++) {
				for(int j=2; j<10; j++) {
					System.out.print(j + "*" + i + "=" + i*j + "\t");
				}
					System.out.println();
			}
		}
		
		public void printall3() {
			for(int k=0; k<3; k++) {
				for(int i=1; i<10; i++) {
					for(int j=2; j<5; j++) {
						System.out.print((3*k+j) + "*" + i + "=" + i*(3*k+j) + "\t");
					}
					System.out.println();
					if(i==9) System.out.println();
				}
			}
		}
		
		public void printColum(int col) {
			for(int k=0; k<col; k++) {
				for(int i=1; i<10; i++) {
					for(int j=2; j<5; j++) {
						if(((col*k+j)==10)) break;
						System.out.print((col*k+j) + "*" + i + "=" + i*(col*k+j) + "\t");
					}
					System.out.println();
					if(i==9) System.out.println();
				}
			}	
		}
}
