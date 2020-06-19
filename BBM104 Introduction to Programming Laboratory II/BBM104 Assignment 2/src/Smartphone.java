import java.util.ArrayList;
import java.util.List;

public class Smartphone extends Electronic {
	public String screentype;
	public Smartphone(String name,double cost,String manufactor,String brand,String maxVolt,String maxWatt,String screentype,int id){
		super(name,cost,manufactor,brand,maxVolt,maxWatt,id);
		this.screentype=screentype;
		
	}

public static void main(String[] args){

	}
/**
 *  Override toStringmethod()
 */
public String toString(){
	return "Type: "+name+ "\nItem ID: "+items_id +"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor+"\nBrand: "+brand+
			"\nMax Volt: "+maxVolt+" V.\nMax Watt: "	+maxWatt+" W.\nScreen Type: "+screentype+"\n-----------------------";
}

}
