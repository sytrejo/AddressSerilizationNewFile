package AddressSerilization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Runner {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee employee = new Employee();
		
		employee.setId(101);
		employee.setName("Silvia");
		employee.setAddress("10 Main Street");
		System.out.println("Actual emp: " + employee);
		
		File file = new File("employee.ser");
		FileOutputStream fileOutputStream;
		ObjectOutputStream oos;
		
		try {
			fileOutputStream = new FileOutputStream(file);
			oos = new ObjectOutputStream(fileOutputStream);
			oos.writeObject(employee);
			oos.close();
			
		}catch(IOException e1) {
			System.out.println(e1);
		}
		
		
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		Employee employeeDeserialized = (Employee) objectInputStream.readObject();
		System.out.println("The Deserialized employee is: " + employeeDeserialized);
		
		objectInputStream.close();
		fileInputStream.close();

	}

}
