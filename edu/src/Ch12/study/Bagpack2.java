package Ch12.study;

class Bag{ // T ~ class
	private Object thing;
	
	public Bag() {}
	
	public Bag(Object thing) {
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("a type of Object is : " + thing.getClass().getName());
	}
}

class book{}
class pencilcase{}
class notebook{}

public class Bagpack2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag bag1 = new Bag(new book());
		Bag bag2 = new Bag(new pencilcase());
		Bag bag3 = new Bag(new notebook());
		
		bag1.showType();
		bag2.showType();
		bag3.showType();
		
	}

}
