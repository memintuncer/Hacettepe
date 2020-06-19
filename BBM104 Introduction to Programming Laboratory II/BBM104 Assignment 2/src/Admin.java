import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Admin extends Employee{
	String password;
	String Birthdate;
	public Date birthDate1;
	public Admin(String name,String email,String birthDate,String salary,String password)throws ParseException {
		super(name,email,birthDate,salary);
		this.password=password;
		this.Birthdate=birthDate;
		SimpleDateFormat dateofBirth=new SimpleDateFormat( "dd.mm.yyyy");
		this.birthDate1= dateofBirth.parse(birthDate);
		
	}
	/**
	 * Get some neccasary lists for methods.
	 * @param args
	 */
	public static void main(String[] args) {

	}
	/**
	 * Create a object list Adminlist contains object admin.
	 * @param args
	 * @return
	 * @throws ParseException
	 */
	public static ArrayList<Admin> getadminList(String[] args) throws ParseException {
		List<String> linesList1 =  FileReader.GetLines(args[0]);
		ArrayList<Admin> admin_infoList1 = new ArrayList<Admin>();
		for(String i:linesList1){
			
			String words[]=i.split("\t");
			
			if(words[0].equals("ADMIN")){			
				Admin a=new Admin(words[1],words[2],words[3],words[4],words[5]);
				admin_infoList1.add(a);		
	}
	}
		return admin_infoList1;
	}
	/**
	 * Read the file named "Users.txt".Create a string list.List contains admins name.Return list.
	 * @param args 
	 * @return 
	 */
	public static List admin_nameList(String[] args){
		List<String> linesList1 =  FileReader.GetLines(args[0]);
		List<String> adminNameList = new ArrayList<String>();
		for(String i: linesList1){
			String words[]=i.split("\t");
			if(words[0].equals("ADMIN")){
				adminNameList.add(words[1]);
			}
		}	
		return adminNameList;
	}
/**
 * Add a new customer object to  object customerlist.
 * @param x
 * @param y
 * @param z
 * @param t
 * @param k
 * @param s
 * @param custolist
 * @param args
 * @param cardlist
 */
	public static void Addcustomer(String x,String y,String z,String t,String k,String s,List<Customer> custolist,String[] args, ArrayList<String> cardlist) {
		List<String> adminList=admin_nameList(args);
		int id=custolist.size()+1;
		if(adminList.contains(x)){
			double balance=Double.parseDouble(k);
			Customer c;
			try {
				c = new Customer(y,z,t,balance,s,"CLASSIC",id);
				custolist.add(c);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else{
			System.out.println("No admin person named "+x+" exists! ");
		}					
	}

	/**
	 * Shows admin information if x contains namelist.
	 * @param x
	 * @param nameList
	 * @param liste
	 */
	public static void showAdmin_info(String x,List<String> nameList,List<Admin> liste){

		if(nameList.contains(x)){
			for(Admin a:liste){
				if(a.name.equals(x)){
					System.out.println(a);
				}
			}
		}	
		else{
			System.out.println("No admin person named "+x+" exists!");
		}
		}
	/**
	 * Show a customer object's informations.
	 * @param x
	 * @param i
	 * @param nameList
	 * @param liste
	 */
	public static void showCustomer(String x,int i,List<String> nameList,List<Customer> liste){
		if(nameList.contains(x)){
			for(Customer c:liste){
				if(c.id==i){
					System.out.println(c);
				}
			}
		}
		else{
			System.out.println("No admin person named "+x+" exists!");
		}
	}
	/**
	 * Shows all customer's informaiton.
	 * @param x
	 * @param nameList
	 * @param liste
	 */
	public static void showCustomerList(String x,List<String> nameList,List<Customer> liste){
		if(nameList.contains(x)){
			for(Customer c:liste){
				System.out.println(c);
			}
		}
		else{
			System.out.println("No admin person named "+x+" exists!");
		}
	}
	/**
	 * Add a new admin object to  object adminlist
	 * @param x
	 * @param y
	 * @param z
	 * @param t
	 * @param k
	 * @param s
	 * @param nameList
	 * @param liste
	 * @throws ParseException
	 */
public static void Addadmin(String x,String y,String z,String t,String k,String s,List<String> nameList,List<Admin> liste) throws ParseException {
		
		if(nameList.contains(x)){
			Admin a=new Admin(y,z,t,k,s);
			liste.add(a);
			nameList.add(y);
		}
		else{
			System.out.println("No admin person named "+x+" exists! ");
		}
		
	}
/**
 * Add a new technician object to object techlist.
 * @param x
 * @param y
 * @param z
 * @param t
 * @param k
 * @param s
 * @param nameList
 * @param liste
 * @param nameList1
 */
	public static void addTech(String x,String y,String z,String t,String k,String s,List<String> nameList,List<Technician> liste,List<String> nameList1) {
		if(nameList.contains(x)){
			Technician tech=new Technician(y,z,t,k,s);
			liste.add(tech);
			nameList1.add(y);
		}
		else{
			System.out.println("No admin person named "+x+" exists! ");
		}
	}
	/**
	 * Shows all items information in stock.
	 * @param name
	 * @param adminNameList
	 * @param techNameList
	 * @param allitems
	 */
	public static void Listitems(String name,List<String> adminNameList,List<String> techNameList,List<Items> allitems){
		if(adminNameList.contains(name)){
			for(Items i:allitems){
				System.out.println(i);
			}
		}
		else if(techNameList.contains(name)){
			for(Items i:allitems){
				System.out.println(i);
			}
		}
		else{
			System.out.println("No admin or technician person named "+name+" exists!");
		}
	}
	/**
	 * Create a campaign for some items and returns campaignlist
	 * @param adminname
	 * @param startDate
	 * @param finishDate
	 * @param type
	 * @param rate
	 * @param adminNameList
	 * @param allitems
	 * @param campList
	 * @param camplist1
	 */
	public static void createCampaign(String adminname,String startDate,String finishDate,String type,String rate,List<String> adminNameList,List<Items> allitems,Set<String> campList,Set<String> camplist1){
		int rates=Integer.parseInt(rate);		
		if(adminNameList.contains(adminname)){
			if(rates>=50){
				System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.");
			}
			else{
				for(Items item: allitems){
					if(type.equals(item.name)){
						campList.add(item.name+" "+rate+" "+finishDate);
						camplist1.add(item.name);
					}
				}
			}
		}
		else{
			System.out.println("No admin person named "+adminname+" exists!");
		}
	
	}
	/**
	 * Show golden customers.
	 * @param name
	 * @param adminName
	 * @param technameList
	 * @param custolist
	 */
	public static void showVip(String name,List<String> adminName,List<String> technameList,List<Customer> custolist){
		if(adminName.contains(name)){
			for(Customer c:custolist){
				if(c.status.equals("GOLDEN")){
					System.out.println(c);
				}
			}
		}
		if(technameList.contains(name)){
			for(Customer c:custolist){
				if(c.status.equals("GOLDEN")){
					System.out.println(c);
				}
			}
		}
		if(!technameList.contains(name)&!adminName.contains(name)){
			System.out.println("No admin or technician person named "+name+" exists!");
		}
	}
	/**
	 * Create a set contains items numbers in stock.
	 * @param name
	 * @param adminName
	 * @param number
	 * @param technameList
	 * @param itemsname
	 * @param itemsnumbers
	 * @return
	 */
	
	public static Set showItemsStock(String name,List<String> adminName,int number,List<String> technameList,List<String> itemsname,Set<String> itemsnumbers){
		int number_ofitems;
		Set<String> itemsnumbers1 = new HashSet<>();
		if(adminName.contains(name)){
			for(String items:itemsname){
				number_ofitems=Collections.frequency(itemsname,items);
				if(number_ofitems<=number){
					itemsnumbers1.add(items+" :"+" "+number_ofitems);
				}
			}	
		}
		else if(technameList.contains(name)){
			for(String items:itemsname){
				number_ofitems=Collections.frequency(itemsname,items);
				if(number_ofitems<=number){
					itemsnumbers1.add(items+" :"+" "+number_ofitems);
					for(String numbers:itemsnumbers1){
					}
				}
				}
			}
		return itemsnumbers1;
	}
	public String toString(){
		return "----------- Admin info ----------- \n"+"Admin name: "+name+"\nAdmin e-mail: "+email+"\nAdmin date of birth: "+birthDate1;
				}
}
