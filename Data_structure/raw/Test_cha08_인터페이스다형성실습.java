package com.ruby.java.ch08.polymorphism;
/*
 * 인터페이스 다형성 실습 코드
 */
interface Vehicle {
	public abstract void showVehicle();
}
class Truck implements Vehicle {
	int weight;
	public Truck(int weight) {
		this.weight=weight;
	}
	public void showVehicle() {
		System.out.println("Truck: weight="+weight);
	}
}
class Car implements Vehicle {
	int vehicleOccupants;

}
class Taxi extends Car {
	int mileage;

}
class MotorCycle implements Vehicle{
	int price;

}
public class Test_cha08_인터페이스다형성실습 {
	public static void displayVehicles(Vehicle [] a) {
		for (Vehicle v : a) {
			v.showVehicle();//v의 타입을 실행 시간에 확인하여 해당 클래스의 메소드로 바인딩
		}
	}
public static void main(String[] args) {
	Vehicle [] arr = new Vehicle[5];
	arr[0] = new Truck(33);
	arr[1] = new Car(4);
	arr[2] = new Taxi(2, 9000);//생성자가 super()를 사용
	arr[3] = new Truck(22);
	arr[4] = new MotorCycle(12000);
	displayVehicles(arr);
	Vehicle v = new Vehicle() {
		public void showVehicle() {
			System.out.println("Vehicle: 익명 클래스 ");
		}
	};
	v.showVehicle();
}
}
