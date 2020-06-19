
public class OfficeSupplies extends Items{
	public String rDate,pName,coverTitle;
	public OfficeSupplies(String name,double cost,String rDate,String coverTitle,String pName,int id){
		super(name,cost,id);
		this.rDate=rDate;
		this.pName=pName;
		this.coverTitle=coverTitle;
		
	}
}
