import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Technician extends Employee{
	String status;
	public Technician(String name,String email,String birthDate,String salary,String status) {
		super(name,email,birthDate,salary);
		this.status=status;
	}
	
	public static void main(String[] args){
		
	}
	/**
	 * Create a object list contains technician object
	 * @param args
	 * @return
	 */
	public static ArrayList<Technician> gettechList(String[] args) {
		List<String> linesList1 =  FileReader.GetLines(args[0]);
		 ArrayList<Technician> tech_infoList = new ArrayList<Technician>();
		for(String i:linesList1){
			
			String words[]=i.split("\t");
			if(words[0].equals("TECH")){
				Technician t=new Technician(words[1],words[2],words[3],words[4],words[5]);
				tech_infoList.add(t);
				}
			}	
		return tech_infoList;
	}
	/**
	 * Create a list cotains technicans name
	 * @param args
	 * @return
	 */
	public static List tech_nameList(String[] args){
		List<String> techList = new ArrayList<String>();
		List<String> linesList1 =  FileReader.GetLines(args[0]);
			for(String i:linesList1){
			
			String words[]=i.split("\t");
			if(words[0].equals("TECH")){
				techList.add(words[1]);
			}
	}
			return techList;
	}
	/**
	 * Add items objects to object itemlist. 
	 * @param techname
	 * @param arguments
	 * @param technamelist
	 * @param allitems
	 * @param itemsNameList
	 * @param itemsnumbers
	 */
public static  void Additem(String techname,String arguments,List<String> technamelist,List<Items> allitems,ArrayList<String> itemsNameList,Set<String> itemsnumbers){
	int items_id=allitems.size()+1;
	String words[]=arguments.split(":");
	String Itemtype=words[0];
	double cost=Double.parseDouble(words[1]);
	if(technamelist.contains(techname)){
			if(Itemtype.equals("BOOK")){	
				Book b=new Book(words[0],cost,words[2],words[3],words[4],words[5],words[6],items_id);
				allitems.add(b);
				itemsNameList.add(Itemtype);
			}
			else if(Itemtype.equals("CDDVD")){
				CDDVD cd=new CDDVD(words[0],cost,words[2],words[3],words[4],words[5],items_id);
				allitems.add(cd);
				itemsNameList.add(Itemtype);
			}
			else if(Itemtype.equals("LAPTOP")){
				Laptop l=new Laptop(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],words[8],words[9],words[10],items_id);
				allitems.add(l);
				itemsNameList.add(Itemtype);
			}
			else if(Itemtype.equals("TABLET")){
				Tablet t=new Tablet(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],words[8],words[9],words[10],items_id);
				allitems.add(t);
				itemsNameList.add(Itemtype);
			}
			else if(Itemtype.equals("SMARTPHONE")){
				Smartphone s=new Smartphone(words[0],cost,words[2],words[3],words[4],words[5],words[6],items_id);
				allitems.add(s);
				itemsNameList.add(Itemtype);
				
			}
			else if(Itemtype.equals("TV")){
				TV tv=new TV(words[0],cost,words[2],words[3],words[4],words[5],words[6],items_id);
				allitems.add(tv);
				itemsNameList.add(Itemtype);
				
			}
			else if(Itemtype.equals("DESKTOP")){
				Desktop d=new Desktop(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],words[8],words[9],words[10],items_id);
				allitems.add(d);
				itemsNameList.add(Itemtype);
			}
			else if(Itemtype.equals("PERFUME")){
				Perfume p=new Perfume(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],items_id);
				allitems.add(p);
				itemsNameList.add(Itemtype);
			}
		    else if(Itemtype.equals("SKINCARE")){
				 Skincare s=new Skincare(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],items_id);
					allitems.add(s);
					itemsNameList.add(Itemtype);
					
					}
		    else if(Itemtype.equals("HAIRCARE")){
				HairCare h=new HairCare(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],items_id);
				allitems.add(h);
				itemsNameList.add(Itemtype);		
			}
			itemsnumbers.clear();
			for(String items:itemsNameList){
				int number_ofitems=Collections.frequency(itemsNameList,items);
				itemsnumbers.add(items+" :"+" "+number_ofitems);
			}	
		}
	}
/**
 * Shows spesific items in stock
 * @param name
 * @param type
 * @param techNameList
 * @param allitems
 */
public static void dispItems(String name,String type,List<String> techNameList,List<Items> allitems){
	String items[]=type.split(":");
 if(techNameList.contains(name)){
		for(int i=0;i<items.length;i++){
			for(Items item:allitems){
				if(item.name.equals(items[i])){
					System.out.println(item);
				}
			}
		}
	}
	else{
		System.out.println("No technician person named "+name+"  exists!");
	}
}
/**
 * Show customer's orders.
 * @param techname
 * @param techNameList
 * @param custolist
 * @param tech
 */
public static void showOrders(String techname,List<String> techNameList,List<Customer> custolist,Technician tech){
	if(techname.equals(tech.name)){
		if(techNameList.contains(techname)){
			Date date = Calendar.getInstance().getTime();
		for(Customer c:custolist){
			if(c.costMoney>0){
				System.out.println("Order date: "+date+"\tCustomer ID: "+c.id+"\tTotal Cost: "+c.costMoney+"\tNumber of purchased items: "+c.pursItems);
			}
		}
		}
	}
	}
	
}

