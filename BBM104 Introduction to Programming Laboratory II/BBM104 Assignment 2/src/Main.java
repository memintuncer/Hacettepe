import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws ParseException {
		List<String> lines2 =  FileReader.GetLines(args[2]);
		ArrayList<String> cardlist=new ArrayList<String>();
		List<Customer> custolist=Customer.getcustoms(args);
		List<String> adminName= Admin.admin_nameList(args);
		List<Admin> admin_info=Admin.getadminList(args);
		List<Technician> techlist=Technician.gettechList(args);
		List<String> technameList=Technician.tech_nameList(args);
		List<Items> allitems=Items.get_allItems(args[1]);
		ArrayList<String> itemsname=Items.getItemsName(args[1]);
		Set<String> camplist1 = new HashSet<>();
		Set<String> campList = new HashSet<>();		
		Set<String> itemsnumbers = new HashSet<>();
		Set<String> itemsnumbers1 = new HashSet<>();
		for(String i:lines2){
			String commads[]=i.split("\t");
			if(commads[0].equals("ADDCUSTOMER")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+ "\t"+commads[2]+"\t"+commads[3]+"\t"+commads[4]+"\t"+commads[5]+"\t"+commads[6]+">");
				System.out.println();
				Admin.Addcustomer(commads[1],commads[2],commads[3],commads[4],commads[5],commads[6],custolist,args,cardlist);
				System.out.println();
			}	
			else if(commads[0].equals("SHOWCUSTOMER")){
				int id=Integer.parseInt(commads[2]);
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				System.out.println();
				Admin.showCustomer(commads[1], id,adminName , custolist);
				System.out.println();
				
			}
			else if(commads[0].equals("SHOWCUSTOMERS")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+">");
				System.out.println();
				Admin.showCustomerList(commads[1], adminName, custolist);
				System.out.println();
			}
			else if(commads[0].equals("ADDADMIN")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+"\t"+commads[3]+"\t"+commads[4]+"\t"+commads[5]+"\t"+commads[6]+">");
				Admin.Addadmin(commads[1], commads[2], commads[3], commads[4], commads[5], commads[6], adminName,admin_info);
				System.out.println();
			}
			else if(commads[0].equals("ADDTECH")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+"\t"+commads[3]+"\t"+commads[4]+"\t"+commads[5]+"\t"+commads[6]+">");
				System.out.println();
				Admin.addTech(commads[1], commads[2], commads[3], commads[4], commads[5], commads[6],adminName, techlist,technameList);
				System.out.println();
			}
			else if(commads[0].equals("LISTITEM")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+">");
				System.out.println();
				System.out.println("-----------------------");
				Admin.Listitems(commads[1], adminName, technameList, allitems);
				System.out.println();
			}
			else if(commads[0].equals("ADDITEM")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				System.out.println();
				Technician.Additem(commads[1], commads[2], technameList, allitems,itemsname, itemsnumbers);
				System.out.println();
			}
			else if(commads[0].equals("DISPITEMSOF")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				System.out.println();
				Technician.dispItems(commads[1], commads[2], technameList, allitems);
				System.out.println();
			}
			
			else if(commads[0].equals("SHOWADMININFO")){
				System.out.println();
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+">");
				System.out.println();
				
				Admin.showAdmin_info(commads[1], adminName,admin_info);
				System.out.println();
			}
			else if(commads[0].equals("CREATECAMPAIGN")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+"\t"+commads[3]+"\t"+commads[4]+"\t"+commads[5]+">");
				System.out.println();
				Admin.createCampaign(commads[1], commads[2], commads[3], commads[4],commads[5], adminName, allitems,campList,camplist1);
				System.out.println();
			}
			else if(commads[0].equals("SHOWITEMSLOWONSTOCK")){
				 Set<String> itemsnumbers10= new HashSet<>();
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				int number=Integer.parseInt(commads[2]);
				System.out.println();
				if(adminName.contains(commads[1])){
					itemsnumbers10 =Admin.showItemsStock(commads[1], adminName, number, technameList, itemsname,itemsnumbers1);
					System.out.println(itemsnumbers10);
					for(String numbers:itemsnumbers10){
						System.out.println(numbers);
					}
				}
				else if(technameList.contains(commads[1])){
					itemsnumbers10 =Admin.showItemsStock(commads[1], adminName, number, technameList, itemsname,itemsnumbers);
					for(String numbers:itemsnumbers10){
						System.out.println(numbers);
					}
				}
				else{
					System.out.println("No admin or technician person named "+commads[1] +" exists!");
				}
				
			}
			else if(commads[0].equals("DEPOSITMONEY")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				System.out.println();
				int id=Integer.parseInt(commads[1]);
				double money=Double.parseDouble(commads[2]);
				Customer.loadMoney(id, money, custolist);
				
			}
			else if(commads[0].equals("CHPASS")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				System.out.println();
				for(Customer cus:custolist){
					cus.chPass(commads[1], commads[2], commads[3], custolist, cus);		
				}System.out.println();
			}
			else if(commads[0].equals("SHOWORDERS")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+">");
				System.out.println();
				for(Technician tech:techlist){
					if(tech.name.equals(commads[1])){
						if(tech.status.equals("0")){
							System.out.println(commads[1]+" not authorized to display orders!");
					}
						else if(tech.status.equals("1")){
							Technician.showOrders(commads[1], technameList, custolist,tech);
						}
					}
				}	System.out.println();
			}
			else if(commads[0].equals("SHOWCAMPAIGNS")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+">");
				System.out.println();
				Customer.showCamp(commads[1], custolist, campList);
				System.out.println();
			}
			else if(commads[0].equals("ADDTOCART")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				System.out.println();
				if(Integer.parseInt(commads[1])>custolist.size()){
					System.out.println("No customer with ID number "+commads[1]+" exists!");
				
				}
			for(Customer cus:custolist){
	
				if(cus.id==Integer.parseInt(commads[1])){
					cus.addtoCard(commads[1], commads[2],allitems,itemsname, cus);
				}
				
				}System.out.println();
			}
			else if(commads[0].equals("ORDER")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+commads[2]+">");
				System.out.println();
				if(Integer.parseInt(commads[1])>custolist.size()){
					System.out.println("No customer with ID number "+commads[1]+" exists!");
				}
				
				for(Customer cus:custolist){
					if(cus.id==Integer.parseInt(commads[1])){
						if(!commads[2].equals(cus.getPass())){
							System.out.println("Order could not be placed. Invalid password. ");
						}
						else if(commads[2].equals(cus.getPass())){
							cus.Order(commads[1], commads[2], itemsname, allitems, itemsnumbers1,campList,camplist1, cus);
							
						}
					}
				}System.out.println();
			}
			else if(commads[0].equals("SHOWVIP")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+"\t"+">");
				System.out.println();
				Admin.showVip(commads[1], adminName, technameList, custolist);
				System.out.println();
			}
			else if(commads[0].equals("EMPTYCART")){
				System.out.println("COMMAND TEXT: <"+commads[0]+"\t"+commads[1]+">");
				System.out.println();
				for(Customer cus:custolist){
					if(Integer.parseInt(commads[1])==cus.id){
						cus.emptyCard(commads[1], cus);
					}
					else if(Integer.parseInt(commads[1])>custolist.size()){
						System.out.println("No customer with ID number "+commads[1]+" exists!");
					}
				}System.out.println();
			}			
	}
}
	}
