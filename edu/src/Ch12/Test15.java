package Ch12;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean("Andy","Andrew","010-123-4568","UK");
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.txt")))
		{
			out.writeObject(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
