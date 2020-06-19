import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Customer extends Users {
	public double balance;
	private String password;
	public  int id;
	public String status;
	private ArrayList<String> cardList;
	public double costMoney;
	public int pursItems;
	public Date birthDate1;
	String Birthdate;
	/**
	 * 
	 * @param name
	 * @param email
	 * @param birthDate
	 * @param balance
	 * @param password
	 * @param Status
	 * @param id
	 * @throws ParseException
	 * Creates an object as an customer.
	 */
	
	public Customer(String name,String email,String birthDate,double balance,String password,String Status,int id) throws ParseException {
		super(name,email,birthDate);
		ArrayList<String> cardlist5=new ArrayList<String>();
		this.Birthdate=birthDate;
		SimpleDateFormat dateofBirth=new SimpleDateFormat( "dd.mm.yyyy");
		this.birthDate1= dateofBirth.parse(birthDate);
		this.password=password;
		this.balance=balance;
		this.id=id;
		this.status="CLASSIC";
		this.cardList=cardlist5;
	}
	public static void main(String[] args) {
	
	}
		/**
		 * Returns customers password.
		 * @return
		 */
		
		public String getPass(){
			return this.password;
		}
		/**
		 * Changes customer's password.
		 * @param pass
		 */
		public void setPass(String pass){
			this.password=pass;
		}
		/**
		 * Get customer's cardlist.
		 * @return
		 */
		public ArrayList<String>  getCardlist(){
			return this.cardList;
		}
		/**
		 * Changes customer's cardlist.
		 * @param cardlist2
		 */
		public void setCardlist(List<String> cardlist2){
			this.cardList=(ArrayList<String>) cardlist2;
		}
		/**
		 * It checks given customer is in customerlist or not.If it is calls the method changePass.
		 * @param id
		 * @param olpas
		 * @param newpas
		 * @param custolist
		 * @param c
		 */
		public void chPass(String id,String olpas,String newpas,List<Customer> custolist,Customer c){
			
			if(c.id==Integer.parseInt(id)){
				c.changePass(id, olpas, newpas,c);
			}
		}
		/**
		 * Create a list  customerlist as an objectlist.Customerlist is contains customer object.
		 * @param args
		 * @return
		 */
		public static ArrayList<Customer> getcustoms(String[] args) {
			int cus_id=1;
			List<String> linesList1 =  FileReader.GetLines(args[0]);
			ArrayList<Customer> listem=new ArrayList<Customer>();
			for(String i:linesList1){
				
				String words[]=i.split("\t");
				if(words[0].equals("CUSTOMER")){
				double balance=Double.parseDouble(words[4]);
				Customer c;
				try {
					c = new Customer(words[1],words[2],words[3],balance,words[5],"CLASSIC",cus_id);
					listem.add(c);
					cus_id++;	
					} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
					
			}
				}
			return listem;
		}

		/**
		 * Changes balance of customer object
		 * @param id
		 * @param money
		 * @param custolist
		 */
		
		public static void loadMoney(int id,double money,List<Customer> custolist){
			if(id>custolist.size()){
				System.out.println("No customer with ID number "+id+" exists!");
			}
			for(Customer c:custolist){
				if(c.id==id){
					c.balance=c.balance+money;
				}			
			}
		}
		/**
		 * change Customer's password.
		 * @param id
		 * @param oldpass
		 * @param newpass
		 * @param c
		 */
		public  void changePass(String id,String oldpass,String newpass,Customer c){
			int c_id=Integer.parseInt(id);
			String oldpass1=getPass();
				if(c_id==c.id){
					if(oldpass.equals(oldpass1)){
						System.out.println("The password has been successfully changed.");						
						this.password=newpass;					
					}
					else if(!oldpass.equals(c.password)){
						System.out.println("The given password does not match the current password. Please try again.");
					}					
				}				
			}
		/**
		 * Method checks customer is in customerlist or not
		 * If customer in customerlist checks items is in stock or not.
		 * If item is in stock method adds Customer's cardlist to item. 
		 * @param id
		 * @param itemid
		 * @param allitems
		 * @param itemsname
		 * @param c
		 */
		public void addtoCard(String id,String itemid,List<Items> allitems,List<String> itemsname,Customer c){
			for(Items item:allitems){
				if(item.items_id==Integer.parseInt(itemid)){
						if(Collections.frequency(itemsname,item.name )>0){
							c.cardList.add(itemid);
							System.out.println("The item "+item.name+"  has been successfully added to your cart.");	
					}
						else if(!itemsname.contains(item.name)){
							System.out.println("We are sorry. The item is temporarily unavailable.");
						}
				}
			}
		}
	/**
	 * This method checks Customer's id,password,balance and cardlist.
	 * If the balance is enough and items is available customer can order.
	 * @param id
	 * @param pass
	 * @param itemsname
	 * @param allitems
	 * @param itemsnumbers1
	 * @param campList
	 * @param camplist1
	 * @param c
	 */
public void Order(String id,String pass,List<String> itemsname,List<Items> allitems,Set<String> itemsnumbers1,Set<String> campList,Set<String> camplist1 ,Customer c){
	int cid=Integer.parseInt(id);
	double cost=0;
	Items itemler;
	if(cid==c.id){
		if(c.getCardlist().size()!=0){
			this.pursItems=+c.getCardlist().size();
		for(String item1:c.cardList){
			for(Items item:allitems){				
				if(item.items_id==Integer.parseInt(item1)){
					for(String camp:campList){
						String camp1[]=camp.split(" ");
						if(camp1[0].equals(item.name)){
							cost+=item.cost-((item.cost*Integer.parseInt(camp1[1]))/100);
						}					
					}
					if(c.balance<cost){
						System.out.println("Order could not be placed. Insufficient funds.");
						return;
					}
					if(!camplist1.contains(item.name)){
						cost+=item.cost;
					}
					itemsname.remove(item.name);
				}
			}
		}
	}
		if(this.getCardlist().size()==0){
			System.out.println("You should add some items to your cart before order request!");
			return;
		}
	this.balance=this.balance-cost;
	System.out.println("Done! Your order will be delivered as soon as possible. Thank you!");
	if(this.status.equals("SILVER")){
		this.balance=this.balance-(cost*10)/100;
	}
	if(this.status.equals("GOLDEN")){
		this.balance=this.balance-(cost*15)/100;
	}
	this.costMoney+=cost;
	if(this.status.equals("CLASSIC")){
		if(1000<=this.costMoney&this.costMoney<5000){
			this.status="SILVER";
			System.out.println("Congratulations! You have been upgraded to a SILVER MEMBER! You have earned a discount of 10% on all purchases.");
			System.out.println("You need to spend "+(5000-cost)+" more TL to become a GOLDEN MEMBER.");
		}
		else if(this.costMoney>=5000){
			this.status="GOLDEN";
			System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! You have earned a permanent discount of 15% on all purchases.");
		}
	if(this.status.equals("SILVER")){
		if(this.costMoney>5000){
			this.status="GOLDEN";
			System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! You have earned a permanent discount of 15% on all purchases.");
		}
	}
	}
}
this.cardList.clear();
}		
		/**
		 * It checks customer id and if customerList has the customer,Customer can see the campaigns.
		 * @param custid
		 * @param custolist
		 * @param campList
		 * Method takes three arguments.
		 */
		public static void showCamp(String custid,List<Customer> custolist,Set<String> campList){
			int cid=Integer.parseInt(custid);
			Date campdate1;
			if(cid>custolist.size()){
				System.out.println("No customer with ID number "+custid+" exists!");
			}
			for(Customer c:custolist){
				if(cid==c.id){
					if(campList.size()==0){
						System.out.println("No campaign has been created so far!");
					}
					else if(campList.size()!=0){
						System.out.println("Active campaigns:");
						for(String camp:campList){
							String k[]=camp.split(" ");	
							SimpleDateFormat dateofBirth=new SimpleDateFormat( "dd.mm.yyyy");
							SimpleDateFormat capmdate=new SimpleDateFormat( k[2]);
							try {
								campdate1=dateofBirth.parse(k[2]);
								System.out.println(k[1]+"%"+" sale of "+k[0]+" until "+campdate1);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
		}
		/**
		 * This method clears the customer's card. 
		 * @param id
		 * @param c
		 * Takes customer id and customer object as parameters.
		 */
		public void emptyCard(String id,Customer c){
			int cid=Integer.parseInt(id);
				c.cardList.clear();
				System.out.println("The cart has been emptied.");			
		}
		/**
		 * Overrides toString method.
		 */
		public  String toString(){
			return "Customer name: "+name+"\tID: "+id+"\te-mail: "+email+"\tDate of Birth: "+birthDate1+"\tStatus: "+status;
		}
}
