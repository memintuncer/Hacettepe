import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class UserCollection {
private User usersgn;

public UserCollection(){

}
    public static void main(String[] args){

    }

    /**
     * Add a new user.
     * @param name user's name
     * @param username user's username.
     * @param pass user's password.
     * @param birth user's birthdate.
     * @param school user's school.
     * @param userList is object list which contains user objects.
     * @param userNameList is Stringlist which contains user's username.
     */
    public  void addUser(String name,String username,String pass,String birth,String school,List<User> userList,List<String> userNameList){
    int cusid=userList.size()+1;
    User user=new User(name,username,pass,birth,school,cusid);
    userList.add(user);
    userNameList.add(username);
    System.out.println(name+" has been successfully added.");
}

    /**
     * Remove user
     * @param id user's id.
     * @param userList is object list which contains user objects.
     * @param userNameList is Stringlist which contains user's username.
     */
    public void removeUser(String id,List<User> userList,List<String> userNameList){
    Iterator<User> itr = userList.iterator();
    Iterator<String> itr2 = userNameList.iterator();
    int custid=Integer.parseInt(id);
    if (custid>userList.size()){
        System.out.println("No such user!");
    }
    while (itr.hasNext()){
        User u=itr.next();
        if (u.getId()==custid){
            itr.remove();
            System.out.println("User has been successfully removed.");
        }
     while (itr2.hasNext()){
            String s=itr2.next();
            if (s.equals(u.getUsername())){
                itr2.remove();
            }
     }
    }
}

    /**
     * Create user objectlist.
     * @param args file argument.
     * @return
     */
    public List getuserList(String[] args){
    int cusid=1;
    List<String> linesList =  FileReader.GetLines(args[1]);
    List<String> linesList1 =  FileReader.GetLines(args[0]);
    ArrayList<User> userList=new ArrayList<User>();
    for(String lines:linesList1){
        String cus[]=lines.split("\t");
        User user=new User(cus[0],cus[1],cus[2],cus[3],cus[4],cusid);
        userList.add(user);
        cusid++;
    }
    return userList;
}

    /**
     * Create a string list wich contains user's username.
     * @param args is file argument.
     * @return
     */
    public List getuserNameList(String[] args){
    List<String> linesList1 =  FileReader.GetLines(args[0]);
    ArrayList<String> userNameList=new ArrayList<String>();
    for(String lines:linesList1){
        String user[]=lines.split("\t");
        userNameList.add(user[1]);
    }
    return userNameList;
}

    /**
     * Get user sign in.
     * @param username user's username.
     * @param password user's password.
     * @param userList is object list which contains user objects.
     * @param userNameList is Stringlist which contains user's username.
     * @param usersgnlist signed user's list.
     */
    public void userSign(String username,String password,List<User> userList,List<String> userNameList,List<String> usersgnlist){
    for (User user :userList){
        if (user.getUsername().equals(username)){
            if (!user.getPassword().equals(password)){
                System.out.println("Invalid username or password! Please try again.");
            }
            else if (user.getPassword().equals(password)){
                user.setSignin();
                System.out.println("You have successfully signed in.");
                usersgnlist.add(username);
            }
        }

    }if (!userNameList.contains(username)){
        System.out.println("No such user!");
    }
}

    /**
     * Show user's posts.
     * @param username is user's username.
     * @param userNameList
     * @param userList
     */
    public void showPosts(String username,List<String> userNameList,List<User> userList){
    if (!userNameList.contains(username)){
        System.out.println("No such user! ");
    }
        for (User user1:userList){
            if (user1.getUsername().equals(username)){
                //System.out.println(user1);
                if (user1.getPostList().size()==0){
                    System.out.println(username+" does not have any posts yet.");
                }
                else if (user1.getPostList().size()>0){
                    System.out.println("**************"+"\n"+username+"'s"+"Posts"+"\n**************");
                    for (Post post:user1.getPostList()){
                        System.out.println(post);
                        System.out.println("-----------------------");
                    }

                }
            }
        }
    }
}
