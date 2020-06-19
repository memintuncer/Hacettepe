import java.util.List;

public class Computer extends Electronic{
	public String operatingSystem,CPU,RAM,HDD;
	public Computer(String name,double cost,String manufactor,String brand,String maxVolt,String maxWatt,String operatingSystem,String CPU,String RAM,String HDD,int id){
		super(name,cost,manufactor,brand,maxVolt,maxWatt,id);
		this.operatingSystem=operatingSystem;
		this.CPU=CPU;
		this.RAM=RAM;
		this.HDD=HDD;
	}
	
	public static void main(String[] args){
		
		
		}
}
