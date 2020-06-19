import java.util.ArrayList;
import java.util.List;

public class TV extends Electronic{
	public String screensize;
	public TV(String name,double cost,String manufactor,String brand,String maxVolt,String maxWatt,String screensize,int id){
		super(name,cost,manufactor,brand,maxVolt,maxWatt,id);
		this.screensize=screensize;
	}
	
	public static void main(String[] args){

		
	}
	/**
	 *  Override toStringmethod()
	 */
	public String toString(){
		return "Type: "+name+ "\nItem ID: "+items_id +"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor+"\nBrand: "+brand+
				"\nMax Volt: "+maxVolt+" V.\nMax Watt: "	+maxWatt+" W.\nScreen size: "+screensize+'"'+"\n-----------------------";
	}
}
