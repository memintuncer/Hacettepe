import java.text.ParseException;

public class Employee extends Users {
	public String salary;
	
	public Employee(String name,String birthDate,String email,String salary){
		super(name,birthDate,email);
		this.salary=salary;
	}
	
	
}

