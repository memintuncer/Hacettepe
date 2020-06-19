
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Users {
	public static ArrayList<Customer> customerList = new ArrayList<Customer>();
	public String name;
	public String birthDate;
	public String email;
	public String id; 
	
	public Users(String name,String email,String birthDate)  {
		SimpleDateFormat dateofBirth=new SimpleDateFormat( "dd.mm.yyyy");
		this.birthDate= birthDate;
		this.email=email;
		this.name=name;
		
	}
	 
	public static void main(String[] args){
	
	}	
}
