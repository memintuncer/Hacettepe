import java.util.ArrayList;
import java.util.List;

public class Desktop extends Computer {
	public String boxColor;
	public Desktop(String name,double cost,String manufactor,String brand,String maxVolt,String maxWatt,
			String operatingSystem,String CPU,String RAM,String HDD,String boxColor,int id){
		super(name,cost,manufactor,brand,maxVolt,maxWatt,operatingSystem,CPU,RAM,HDD,id);
		this.boxColor=boxColor;
	}
	public static void main(String[] args){	
	}
	/**
	 * Override toStringmethod()
	 */
	public String toString(){
		return "Type: "+name+ "\nItem ID: "+items_id+"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor+"\nBrand: "+brand+
				"\nMax Volt: "+maxVolt+" V.\nMax Watt: "	+maxWatt+" W.\nOperating System: "+operatingSystem+
				"\nCPU Type: "+CPU+"\nRAM Capacity: "+RAM+" GB.\nHDD Capacity: "+HDD+" GB.\nBox Color: "+boxColor+"\n-----------------------";
	}
	
	
}
