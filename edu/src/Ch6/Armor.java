package Ch6;

public class Armor {
	
	private String name;
	private int height;
	
	/* alt+shift+s */ 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; // this variable : store an input variable to the variable above
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height; // this variable
	}
	
	@Override
	public String toString() {
		return "Armor [name=" + name + ", height=" + height + "]";
	}
	
	public static void main(String[] args) {
		
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		
	
		suit1.setName("optimus");
		suit1.setHeight(1200);
		
		suit2.setName("bumbleBee");
		suit2.setHeight(500);
		
//		System.out.println("name:" + suit1.getName());
//		System.out.println("height:" + suit1.getHeight());
		
		System.out.println(suit1.toString());
		System.out.println(suit2.toString());
	}


	
}
 
