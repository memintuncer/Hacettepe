import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloJava {
	
	public static void main(String args[]){//Main  checks the input file line's words for the call other methods	
		List<String> lineList = new ArrayList<String>();
		try {// check if the input file is there        
			 Scanner scanner = new Scanner(new File(args[0]));          
			 while(scanner.hasNextLine()){ //Convert lines to string and add lines to list
				 String line = scanner.nextLine();      				 
				 lineList.add(line);				 
				 }
			 scanner.close(); 
			 }          
		 catch (FileNotFoundException ex) {
			 System.out.println("No File Found!");
			 }  				
		for(String i:lineList){
			String words[]=i.split(" ");
			if( words[0].equals("IntegrateReimann")){//If first word is "IntegrateReimann" method check second word.According to second word it calls Reimann method				
				String intremWord[]=i.split(" ");
				if(intremWord[1].equals("Func1")){
					double x = Double.parseDouble(intremWord[2]), y = Double.parseDouble(intremWord[3]);
					int z = Integer.parseInt(intremWord[4]);
					IntegrateReimann("Func1",x,y,z);				
				}			
				else if (intremWord[1].equals("Func2")){
					double x = Double.parseDouble(intremWord[2]),y = Double.parseDouble(intremWord[3]);
					int z = Integer.parseInt(intremWord[4]);
					IntegrateReimann("Func2",x,y,z);				
				}			
				else if (intremWord[1].equals("Func3")){
					double x = Double.parseDouble(intremWord[2]),y = Double.parseDouble(intremWord[3]);
					int z = Integer.parseInt(intremWord[4]);
					IntegrateReimann("Func3",x,y,z);
				}
			}			
			else if (words[0].equals("Arcsinh")){//If first word is "Arcsinh" it calls the Arcsinh() method				
				String arcWord[]=i.split(" ");
				double x=Double.parseDouble(arcWord[1]);
				System.out.println("Arcsinh "+x+" "+" Result: "+Arcsinh(x));
			}
			else if(words[0].equals("Armstrong")){//If the word is "Armstrong" it calls the ArmstrongNumbers() method				
				String armWord[]=i.split(" ");
				int x=Integer.parseInt(armWord[1]);
				Armstrong(x);
			}
		}		
	}	
	
	public static double Arcsinh(double value ){
		//This method takes an argument "double value" and  returns value of  Arcsinh(value)
		double result=0;		
		for(int n=0;n<=30;n++){
			int fac1=1;			
			for(int i=1;i<=n;i++){
			fac1*=i;
			}
			int fac2=1;
			for(int i=1;i<=2*n;i++){
				fac2*=i;
			}			
			result+=(Math.pow(-1, n)*fac2)/((Math.pow(4, n)*Math.pow(fac1, 2)*(2*n+1)))*Math.pow(value, 2*n+1);			
		}			
		return result;		
	}
	
	public static void Armstrong(int value){
		//This method puts numbers to checkArmstrongNumber() method in a loop.
		System.out.print("Armstrong "+value+ " Result: ");
		for(int i=0;i<Math.pow(10, value);i++){
			int y=i;
			String armstrongNumber=checkArmstrongNumber(y);
			if (armstrongNumber!=" "){
				//If the return string is  not the empty string method prints the ArmstrongNumbers.
				System.out.print(armstrongNumber+" ");				
			}
		}
		System.out.println(" ");					
	}

	public static String checkArmstrongNumber(int x){
		//This method check any number  it is an ArmstrongNumber or not
		//If number is an ArmstrongNumber the method returns number as a string 
		//If not the method returns an empty string		
		double sum=0;
		int number=x;
		int remainder;
		String number_string = Integer.toString(x);
		double digit=number_string.length();
		while(number!=0){
			remainder = number%10;
	         sum = sum + Math.pow(remainder, digit);
	         number = number/10;
		} if (x == sum)	
	    	  return number_string;
	      else
	      	return " " ;
	}

	public static void func1(double x,double y,int z){
		//This method calculates the  integral for  y= (x*x − x+ 3) function  from  Reimann sum 
		//The method takes three argument as integers
		//double  x and y are the interval,and integer z is for rectangle number 
		double result=0;
		int x_i=(int)x;
		int y_i=(int)y;
		double z_d=z;
		double len=(Math.abs(x-y))/z_d;		
		double mid=len/2;
		double k=x;
		for(double i=0;i<z;i++){//This loop turns rectangle numbers times for given "integer z"	
			 k+=len;
			double x_yValue=((k-mid)*(k-mid)-(k-mid)+3)*(len);
			 result+=x_yValue;
		}				
		System.out.println("IntegrateReimann Func1 "+x_i+" "+y_i+" "+z+" "+"Result: "+result);
		//Finally it prints the result to screen
	}	

	public static void func2(double x,double y,int z){
		//This method calculates the  integral for y= (3*sin(x)-4)*(3*sin(x)-4) function by Reimann sum 
		//The method takes three argument as doubles and integer
		//double x and y are the interval,and integer z is for rectangle number
		double result=0;		
		int y_i=(int)y;
		int x_i=(int)x;	
		double z_d=z;
		double len=(Math.abs(x-y))/z_d;
		double mid=len/2;
		double degree=x;
		for(double i=0;i<z;i++){//This loop turns rectangle numbers times for given "integer z"
			 degree+=len;
		      double x_yValue=(3*Math.sin(degree-mid)-4)*(3*Math.sin(degree-mid)-4);
		      double x_yValue1=x_yValue*len;
		      result+=x_yValue1;
		}
		//Finally it prints the result to screen
		System.out.println("IntegrateReimann Func2 "+x_i+" "+y_i+" "+z+" Result: "+result);
	}	

	public static void func3(double x,double y,int z){
		//This method calculates the  integral for y=arcsinh(x) function by Reimann sum 
		//The method takes three argument: x and y are double,z is integer
		//integer x and y are the interval,and integer z is for rectangle number
		double result=0;
		double y_d=y;
		double x_d=x;
		double z_d=z;
		double len=(Math.abs(x_d-y_d))/z_d;
		double mid=len/2;
		double k=x;
			
		for(double i=0;i<z;i++){//This loop turns rectangle numbers times for given "integer z"
			k+=len;			
			double x_yValue=Arcsinh(k-mid)*(len);
			result+=x_yValue;
		}
		//Finally it prints the result to screen
		System.out.println("IntegrateReimann "+"Func3 "+x+" "+y+" " +z+" "+"Result: "+result);
	}

	public static void IntegrateReimann(String name_of_function ,double a,double b,int  number_of_partitions   ){
		//This method calls to func1,func2,func3 methods according to first argument
		//First argument is the name of methods and the other arguments are which place to methods.
		if ( name_of_function .equals("Func1")){			
			func1(a,b, number_of_partitions );
		}
		else if (name_of_function .equals("Func2")){
			func2(a,b, number_of_partitions );			
		}
		else if (name_of_function .equals("Func3")){
			func3(a,b, number_of_partitions );
		}
		
	}
}