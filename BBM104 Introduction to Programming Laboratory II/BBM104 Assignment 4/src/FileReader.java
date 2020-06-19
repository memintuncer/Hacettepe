import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	public static void ReadUser(String args){
		try {          
			 Scanner scanner = new Scanner(new File("users.txt"));          
			 while(scanner.hasNextLine()){ 
				 String line = scanner.nextLine();
				 String k[]=line.split("\t");
				User user=new User(k[0],k[1],k[2],k[3],k[4],k[5]);
						UserCollection.userList.add(user);
						UserCollection.userNameList.add(user.getUsername());
				 }         
			 scanner.close(); 
			
			 }          
		 catch (FileNotFoundException ex) {
			 System.out.println("No File Found!");
		
			 }  	
	}
	public static void ReadCommands(String args){
		try {          
			 Scanner scanner = new Scanner(new File("commands.txt"));          
			 while(scanner.hasNextLine()){ 
				 String line = scanner.nextLine();
				 String k[]=line.split("\t");
				 if(k[0].equals("ADDFRIEND")){
					 for(User user:UserCollection.userList){
						 user.addFriend(user, k[1], k[2]);
					 }
				 }
				 else if (k[0].equals("BLOCKFRIEND")){
	                    for(User user:UserCollection.userList){
	                        user.blockFriend(user,k[1],k[2]);
	                    }
	                }
				 
				 else if(k[0].equals("ADDPOST-TEXT")){
	                    for (User user:UserCollection.userList){
	                        user.addText(user,k[1],k[2],k[3],k[4],k[5]);
	                    }
	                }
				 else if(k[0].equals("ADDPOST-IMAGE")){
					 for (User user:UserCollection.userList){
						 user.addImage(user,k[1], k[2], k[3], k[4], k[5], k[6], k[7]);
					 }
				 }
				 else if(k[0].equals("ADDPOST-VIDEO")){
					 for (User user:UserCollection.userList){
						 user.addVideo(user, k[1],k[2], k[3],k[4], k[5], k[6], k[7]);
					 }
				 }
			 
			 
			 }
				 scanner.close(); 
					
			 }          
		 catch (FileNotFoundException ex) {
			 System.out.println("No File Found!");
		
			 }  	
	}
}
