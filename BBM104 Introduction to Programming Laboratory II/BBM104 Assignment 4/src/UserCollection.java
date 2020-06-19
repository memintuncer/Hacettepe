import java.util.ArrayList;
import java.util.Iterator;

public class UserCollection {
	public static ArrayList<User> userList=new ArrayList<>();
	public static ArrayList<String> userNameList=new ArrayList();
	
	public UserCollection(){	
	}
	
	public void addUser(String[] userinfo){
		User user=new User(userinfo[0],userinfo[1],userinfo[2],userinfo[3],userinfo[4],userinfo[5]);
		userList.add(user);
		userNameList.add(user.getUsername());
	}

	public void addUser(ArrayList<User> userlist, ArrayList<String> lines,ArrayList<String> userNames){
		for(String i:lines){
			String k[]=i.split("\t");
			User user=new User(k[0],k[1],k[2],k[3],k[4],k[5]);
			userlist.add(user);
			userNames.add(user.getUsername());
		}
	
	}
	
	 public static void removeUser(String username){
		 	UserCollection.userNameList.remove(username);
	       Iterator<User> itr = UserCollection.userList.iterator();
	       while(itr.hasNext()){
	           User user=itr.next();
	          if(user.getUsername().equals(username)){
	              itr.remove();
	          }
	       }
	   } 
}
