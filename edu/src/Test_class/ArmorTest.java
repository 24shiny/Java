package Test_class;

class ArmorTest {
	
	String name;
	int height;
	int weight;
	boolean isFly;
	
	private 
	
	int sum(int height, int weight) {
		return height+weight;
	}
	
	void fly(boolean input) {
		isFly = input;
		System.out.println(isFly==true?"fly":"can't fly");
	}
	
	void takeOff() {} // need curly brackets
	
	public void setName(String nameInput) {
		name = nameInput;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHeight(int heightInput) {
		height = heightInput;
	}
	
	public int getHeight() {
		return height;
	}

}