
public class Book extends OfficeSupplies {
	public String authors;
	public String page_number;
	
	
	public Book(String name,double cost,String rDate,String coverTitle,String pName,String authors,String pageNo,int id){
		super(name,cost,rDate,pName,coverTitle,id);
		this.authors=authors;
		this.page_number=pageNo;
	}
	public static void main(String[] args){
		
	}
	/**
	 * Overrides toString() method.
	 */
	public String toString(){	
		return "Type: "+name+"\nItem ID: "+items_id+"\nPrice: "+cost+" $\nRelease Date: "+rDate+"\nTitle: "+coverTitle+"\nPublisher: "+pName+"\nAuthor: "+authors+"\nPage: "+page_number+" pages"+"\n-----------------------";
	}
	
	}
