package Ch12;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.txt")))
		{
			UserBean user = (UserBean) in.readObject();
			System.out.println(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
