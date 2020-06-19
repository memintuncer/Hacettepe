import java.util.ArrayList;
import java.util.List;

public class Tablet extends Computer{
	public String dimension;
	public Tablet(String name,double cost,String manufactor,String brand,String maxVolt,String maxWatt,
			String operatingSystem,String CPU,String RAM,String HDD,String dimension,int id){
		super(name,cost,manufactor,brand,maxVolt,maxWatt,operatingSystem,CPU,RAM,HDD,id);
		this.dimension=dimension;
	}
public static void main(String[] args){
	
	
	}
	
public String toString(){
	return "Type: "+name+ "\nItem ID: "+items_id +"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor+"\nBrand: "+brand+
			"\nMax Volt: "+maxVolt+" V.\nMax Watt: "	+maxWatt+" W.\nOperating System: "+operatingSystem+
			"\nCPU Type: "+CPU+"\nRAM Capacity: "+RAM+" GB.\nHDD Capacity: "+HDD+" GB.\nDimension: "+dimension+" in\n-----------------------";
}


}
