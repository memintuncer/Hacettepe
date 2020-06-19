import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Items {
	public double cost;
	public String name;
	public int items_id;
	public Items(String name,double cost,int id){
		this.cost=cost;
		this.name=name;
		this.items_id=id;
	}

	public static void main(String[] args){

	}
	/**
	 * Read the file and create a object list contains item object.
	 * @param args
	 * @return
	 */
	public static ArrayList<Items> get_allItems(String args){
		int items_id=1;
		List<String> linesList1 =  FileReader.GetLines(args);
		ArrayList<Items> allitems=new ArrayList<Items>();
		for(String i:linesList1){{String words[]=i.split("\t");
		double cost=Double.parseDouble(words[1]);
		if(words[0].equals("HAIRCARE")){
			HairCare h=new HairCare(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],items_id);
			allitems.add(h);
			items_id++;
		}
		else if(words[0].equals("SKINCARE")){
		 Skincare s=new Skincare(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],items_id);
		allitems.add(s);
		items_id++;
		}
		else if(words[0].equals("PERFUME")){
			Perfume p=new Perfume(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],items_id);
			allitems.add(p);
			items_id ++;
			
		}
		else if(words[0].equals("DESKTOP")){
			Desktop d=new Desktop(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],words[8],words[9],words[10],items_id);
			allitems.add(d);
			items_id ++;
		}
		
		else if(words[0].equals("LAPTOP")){
			Laptop l=new Laptop(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],words[8],words[9],words[10],items_id);
			allitems.add(l);
			items_id ++;			
		}
		else if(words[0].equals("TABLET")){
			Tablet t=new Tablet(words[0],cost,words[2],words[3],words[4],words[5],words[6],words[7],words[8],words[9],words[10],items_id);
			allitems.add(t);
			items_id ++;
		}

		else if(words[0].equals("SMARTPHONE")){
			Smartphone s=new Smartphone(words[0],cost,words[2],words[3],words[4],words[5],words[6],items_id);
			allitems.add(s);
			items_id++;
		}
		else if(words[0].equals("TV")){
			TV tv=new TV(words[0],cost,words[2],words[3],words[4],words[5],words[6],items_id);
			allitems.add(tv);
			items_id++;
		}
		else if(words[0].equals("BOOK")){
			Book b=new Book(words[0],cost,words[2],words[3],words[4],words[5],words[6],items_id);
			allitems.add(b);
			items_id++;
		}
		else if(words[0].equals("CDDVD")){
			CDDVD cd=new CDDVD(words[0],cost,words[2],words[3],words[4],words[5],items_id);
			allitems.add(cd);
			items_id++;
		}
}
		
	}
		return allitems;
	
}
	/**
	 * Add items name to a list.
	 * @param args
	 * @return
	 */

	public static ArrayList<String> getItemsName(String args){
		ArrayList<String> itemsNameList= new ArrayList<String>();
		List<String> linesList1 =  FileReader.GetLines(args);
		for(String i:linesList1){{String words[]=i.split("\t");
			itemsNameList.add(words[0]);
		}
		}
		return itemsNameList;
		
	}
	/**
	 * Add to a set to items name and items numbers.
	 * @param itemsnam
	 * @param itemsnumbers
	 */
public static  void itemsNumbers(List<String> itemsnam,Set<String> itemsnumbers){
	
	for(String items:itemsnam){
		int number_ofitems=Collections.frequency(itemsnam,items);
		itemsnumbers.add(items+" :"+" "+number_ofitems);
	}	
}
/**
 * Add items name to a list.
 * @param args
 * @return
 */
public void itemsName(Items item,ArrayList<String> itemsNameList){
	itemsNameList.add(item.name);
}

}




