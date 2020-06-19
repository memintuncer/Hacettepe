import java.util.ArrayList;
import java.util.List;

public class Perfume extends PersonalCare {
	public String lastingDuration;
	public int id;
	public Perfume(String name,double cost,String manufactor,String brand,String isorganic,String expYear,String weight,String lastingDuration,int id){
		super(name,cost,manufactor,brand,isorganic,expYear,weight,id);
		this.lastingDuration=lastingDuration;
	
	}
	public static void main(String[] args){
	
		
	}
/**
 *  Override toStringmethod()
 */
	public String toString(){
		if(isorganic.equals("1")){
			this.isorganic="Yes";
		}
		else if(isorganic.equals("0")){
			this.isorganic="No";
		}
		return "Type: "+name+"\nItem ID: "+items_id+"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor
				+"\nBrand: "+brand+"\nOrganic: "+isorganic+"\nExpiration Date: "+expYear+"\nWeight: "
		+weight+" g.\nLasting Duration: "+lastingDuration+" min.\n-----------------------";
	}
}
