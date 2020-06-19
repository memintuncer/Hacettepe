import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Electronic extends Items {
	public String manufactor,brand,maxVolt,maxWatt;

	public Electronic(String name,double cost,String manufactor,String brand,String maxVolt,String maxWatt,int id){
		super(name,cost,id);
		this.manufactor=manufactor;
		this.brand=brand;
		this.maxVolt=maxVolt;
		this.maxWatt=maxWatt;
	}
public static void main(String[] args){

}
}