package Ch12;

class Bag<T>{ // T ~ class
	private T thing;
	
	public Bag() {}
	
	public Bag(T thing) {
		this.thing = thing;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("a type of T is : " + thing.getClass().getName());
	}
}

class book{}
class pencilcase{}
class notebook{}

public class Bagpack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag<book> bag1 = new Bag<>();
		bag1.setThing(new book());
		Bag<pencilcase> bag2 = new Bag<>(new pencilcase());
		Bag<notebook> bag3 = new Bag<>(new notebook());
		
		bag1.showType();
		bag2.showType();
		bag3.showType();
		
	}

}
