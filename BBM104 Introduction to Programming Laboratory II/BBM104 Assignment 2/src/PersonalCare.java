
public class PersonalCare extends Items {
	public String manufactor,brand,isorganic,expYear,weight;
	public PersonalCare(String name,double cost,String manufactor,String brand,String isorganic,String expYear,String weight,int id){
		super(name,cost,id);
		this.manufactor=manufactor;
		this.brand=brand;
		this.isorganic=isorganic;
		this.expYear=expYear;
		this.weight=weight;
	}

	public static void main(String[] args){

	}

}
