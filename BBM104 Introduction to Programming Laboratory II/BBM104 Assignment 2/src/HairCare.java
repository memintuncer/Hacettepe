import java.util.ArrayList;
import java.util.List;

public class HairCare extends PersonalCare {
	public String isMedic;
	public int id;
	public HairCare(String name,double cost,String manufactor,String brand,String isorganic,String expYear,String weight,String isMedic,int id){
		super(name,cost,manufactor,brand,isorganic,expYear,weight,id);
		this.isMedic=isMedic;
		
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
		if(isMedic.equals("1")){
			this.isMedic="Yes";
		}
		else if(isMedic.equals("0")){
			this.isMedic="No";
		}
		return "Type: "+name+"\nItem ID: "+items_id+"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor
				+"\nBrand: "+brand+"\nOrganic: "+isorganic+"\nExpiration Date: "+expYear+"\nWeight: "
		+weight+" g.\nMedicated: "+isMedic+"\n-----------------------";
		}
}
