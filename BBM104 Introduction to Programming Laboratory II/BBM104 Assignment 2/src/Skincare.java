import java.util.ArrayList;
import java.util.List;

public class Skincare extends PersonalCare {
	public String babySens;
	public int id;
	public Skincare(String name,double cost,String manufactor,String brand,String isorganic,String expYear,String weight,String babySens,int id){
		super(name,cost,manufactor,brand,isorganic,expYear,weight,id);
		this.babySens=babySens;
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
		if(babySens.equals("1")){
			this.babySens="Yes";
		}
		else if(babySens.equals("0")){
			this.babySens="No";
		}
		return "Type: "+name+"\nItem ID: "+items_id+"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor
				+"\nBrand: "+brand+"\nOrganic: "+isorganic+"\nExpiration Date: "+expYear+"\nWeight: "
		+weight+" g.\nBaby Sensitive: "+babySens+"\n-----------------------";
	}

}
