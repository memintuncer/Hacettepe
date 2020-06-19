import java.util.ArrayList;
import java.util.List;

public class Laptop extends Computer{
	public String HDMI;
	public Laptop(String name,double cost,String manufactor,String brand,String maxVolt,String maxWatt,
			String operatingSystem,String CPU,String RAM,String HDD,String HDMI,int id){
		super(name,cost,manufactor,brand,maxVolt,maxWatt,operatingSystem,CPU,RAM,HDD,id);
		this.HDMI=HDMI;
	}

	public static void main(String[] args){
		
	
	}
	/**
	 *  Override toStringmethod()
	 */
	public String toString(){
		if(HDMI.equals("1")){
			this.HDMI="Yes";
		}
		else if(HDMI.equals("0")){
			this.HDMI="No";
		}
		return "Type: "+name+ "\nItem ID: "+items_id +"\nPrice: "+cost+" $"+"\nManufacturer: "+manufactor+"\nBrand: "+brand+
				"\nMax Volt: "+maxVolt+" V.\nMax Watt: "	+maxWatt+" W.\nOperating System: "+operatingSystem+
				"\nCPU Type: "+CPU+"\nRAM Capacity: "+RAM+" GB.\nHDD Capacity: "+HDD+" GB.\nHDMI support: "+HDMI+"\n-----------------------";
	}
}
