import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class User {
    private String username;
    private String password;
    private String birthdate;
    private String school;
    private int id;
    private String name;
    private boolean sign ;
    private ArrayList<User> friendList;
    private ArrayList<User> blockedFriendList;
    private ArrayList<User> blockedUserList;
    private ArrayList<String> friendnameList;
    private ArrayList<String> blockFriendName;
    private ArrayList<String> blockUserName;
    private ArrayList<Post> postList;
    private Date date1;

    public User(String name,String username,String password,String birthdate,String school,int id){
        ArrayList<User> friendList1=new ArrayList<User>();
        ArrayList<User> blockedFriendList1=new ArrayList<User>();
        ArrayList<User> blockedUserList1=new ArrayList<User>();
        ArrayList<String> friendnameList1=new ArrayList<String>();
        ArrayList<String> blockFriendName1=new ArrayList<String>();
        ArrayList<String> blockUserName1=new ArrayList<String>();
        ArrayList<Post> postList1=new ArrayList<Post>();
        //DateFormat dateofBirth=new SimpleDateFormat( "dd/MM/yyyy");
        Date date = new Date(birthdate);
        //this.birthDate1= dateofBirth.format(date);
        this.date1=date;
        //this.birthdate=birthdate;
        this.id=id;
        this.username=username;
        this.password=password;
        this.school=school;
        this.name=name;
        this.friendList=friendList1;
        this.blockedFriendList=blockedFriendList1;
        this.friendnameList=friendnameList1;
        this.blockFriendName=blockFriendName1;
        this.blockedUserList=blockedUserList1;
        this.blockUserName=blockUserName1;
        this.sign=false;
        this.postList=postList1;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name1){
        this.name=name1;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getBirthdate(){
        return this.birthdate;
    }
    public void setBirthdate(String birthdate1){
        this.birthdate=birthdate1;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password1){
        this.password=password1;
    }
    public String getSchool(){
        return this.school;
    }
    public void setSchool(String school1){
        this.school=school1;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id1){
        this.id=id1;
    }
    public boolean getSign(){
        return this.sign;
    }
    public void setSignin(){
        this.sign=true;
    }
    public void setSignout(){
        this.sign=false;
    }
    public List getfirendName(){
        return this.friendnameList;
    }
    public void addFriendnameList(String name){
        this.friendnameList.add(name);
    }
    public void removeFriendnameList(String name){
        Iterator<String> itr2=this.getfirendName().iterator();
        while (itr2.hasNext()){
            String f2=itr2.next();
            if(f2.equals(name)){
                itr2.remove();
            }
        }
    }
    public Date getDate1() {
        return date1;
    }
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
    public ArrayList<User> getFriendList() {
        return this.friendList;
    }
    public void setFriendList(User friend){
        this.friendList.add(friend);
    }
    public ArrayList<User> getBlockedFriendList(){
        return this.blockedFriendList;
    }
   public void setBlockedFriendList(User buser){
        this.blockedFriendList.add(buser);
   }
    public ArrayList<User> getBlockedUserList(){
       return this.blockedUserList;
    }
   public void setBlockedUserList(User user){
        this.blockedUserList.add(user);
   }
   public ArrayList<String> getBlockFriendName(){
       return this.blockFriendName;
   }
   public void setBlockFriendName(String name){
       this.blockFriendName.add(name);
   }
   public ArrayList<String> getBlockUserName(){
       return this.blockUserName;
   }
   public void setBlockUserName(String name){
       this.blockUserName.add(name);
   }
   public ArrayList<Post> getPostList(){
       return this.postList;
   }
   public void setPostList(Post post){
       this.postList.add(post);
   }
    /**
     * Update the user's profile.
     * @param name is user's new username.
     * @param dateofBirth is user's birthdate.
     * @param schoolGraduated is user's school.
     * @param user is user object.
     * @param userNameList is Stringlist which contains user's username.
     */
    public void updateProfile(String name, String dateofBirth, String schoolGraduated , User user, List<String> userNameList){

         if(user.getSign()==true){
             String oldname=user.getUsername();
             Iterator<String> itr2=userNameList.iterator();
             while (itr2.hasNext()){
                 String s=itr2.next();
                 if (s.equals(oldname)){
                     itr2.remove();
                 }
             }
            user.setUsername(name);
            user.setBirthdate(dateofBirth);
            user.setSchool(schoolGraduated);
            System.out.println("Your user profile has been successfully updated.");
             userNameList.add(name);
        }
    }
    /**
     * Changes user's password.
     * @param oldpass is given old password.
     * @param newpass is new password.
     * @param user is user object.
     */
    public void changePass(String oldpass,String newpass, User user){
    if(user.getSign()==true){
        if (!oldpass.equals(user.getPassword())){
            System.out.println("Password mismatch! Please, try again.");
            //System.out.println(user.getPassword());
        }
        else if(oldpass.equals(user.getPassword())){
            user.setPassword(newpass);
            //System.out.println(user.getPassword());
        }
    }
}

    /**
     * User will sign out.
     * @param user is the user object.
     */
    public void signOut(User user){

        if (user.getSign()==true){
            user.setSignout();
            System.out.println("You have successfully signed out.");
        }

    }

    /**
     *Adds a new friend to user's friendlist.
     * @param friendname is user's friends username.
     * @param user is user object.
     * @param userList is object list which contains user objects.
     * @param userNameList is Stringlist which contains user's username.
     */
    public void addFriend(String friendname,User user,List<User> userList,List<String> userNameList){
        if(user.getSign()==true){
            if(!userNameList.contains(friendname)){
                System.out.println("No such user!");
            }
            for (User user1:userList){
                if (user1.getUsername().equals(friendname)){
                    if (!user.getFriendList().contains(user1)){
                        System.out.println(friendname+" has been successfully added to your friend list.");
                        user.setFriendList(user1);
                        user.addFriendnameList(friendname);
                    }
                    else if (user.getFriendList().contains(user1)){
                        System.out.println("This user is already in your friend list!");
                    }
                }
            }
        }
    }

    /**
     * Removes friend from user's friendlist.
     * @param friendname is user's friends username.
     * @param user is user object.
     */
    public void removeFriend(String friendname,User user){
    if (user.getSign()==true){
        if(!user.getfirendName().contains(friendname)){
            System.out.println("No such friend!");
        }
        Iterator<User> itr=user.getFriendList().iterator();

        while (itr.hasNext()){
            User f1=itr.next();
            if (f1.getUsername().equals(friendname)){
                itr.remove();
                System.out.println(friendname+" has been successfully removed from your friend list.");
            }
        if (user.friendnameList.contains(friendname)){

            user.removeFriendnameList(friendname);

        }
        }
    }
    }

    /**
     * Shows all users.
     * @param user is user object.
     * @param userList is object list which contains user objects.
     */
    public void listUsers(User user,List<User> userList){
    if (user.getSign()==true){
        for (User user1:userList){
            System.out.println(user1);
            System.out.println("-----------------------");
        }
    }
}

    /**
     *Shows user's friends.
     * @param user is user object.
     */
    public void listFriends(User user){
    if (user.getSign()==true){
        if (user.getFriendList().size()==0){
            System.out.println("You  haven’t added any friends yet!");
        }
        else if (user.getFriendList().size()>0){
            for (User friend:user.getFriendList()){
                System.out.println(friend);
                System.out.println("-----------------------");
            }
        }
    }
}

    /**
     *  Bloeck users.
     * @param username is string which is user's username.
     * @param user is user object
     * @param userNameList is Stringlist which contains user's username.
     * @param userList is object list which contains user objects.
     */
    public void blockUser(String username,User user,List<String> userNameList,List<User> userList){
    if(user.getSign()==true){
        if (!userNameList.contains(username)){
            System.out.println("No such user!");
        }
        else if (userNameList.contains(username)){
            for (User blocked:userList){
                if (blocked.getUsername().equals(username)){
                    user.setBlockedUserList(blocked);
                    user.setBlockUserName(username);
                    System.out.println(username+" has been successfully blocked.");
                }
            }

            for (User friend:user.getFriendList()){
                if (friend.getUsername().equals(username)){
                    user.setBlockedFriendList(friend);
                    user.setBlockFriendName(username);
                }
            }
        }
    }
}

    /**
     * Shows user's blocked friends.
     * @param user is user object.
     */
    public void showBlockedFriends(User user){
    if (user.getSign()==true){
        if (user.getBlockedUserList().size()==0){
            System.out.println("You  haven’t blocked any users yet!");
        }
        else if (user.getBlockedFriendList().size()==0){
            System.out.println("You  haven’t blocked any friends yet!");
        }

        else if (user.getBlockedFriendList().size()>0){
            for (User blocked: user.getBlockedFriendList()){
                System.out.println(blocked);
                System.out.println("-----------------------");
            }
        }
    }
}

    /**
     * Shows user's blocked users.
     * @param user is user object.
     */
    public void showBlockUsers(User user){
    if (user.getSign()==true){
        if (user.getBlockedUserList().size()==0){
            System.out.println("You  haven’t blocked any users yet!");
        }
        else if (user.getBlockedUserList().size()>0){
            for (User blocked:user.getBlockedUserList()){
                System.out.println(blocked);
            }
        }
    }
}

    /**
     *Unblock users which is in the user's blocklist.
     * @param username is blocked user's name.
     * @param user is user object.
     */

public void unBlock(String username,User user){
    if (user.getSign()==true){
        if (!user.getBlockUserName().contains(username)){
            System.out.println("No such user in your blocked users list!");
        }
        else if (user.getBlockUserName().contains(username)){
            Iterator<User> itr=user.getBlockedUserList().iterator();
            while (itr.hasNext()){
                User f1=itr.next();
                if (f1.getUsername().equals(username)){
                    itr.remove();
                    System.out.println(username+" has been successfully unblocked.");
                }
            }
            Iterator<String> itr2=user.getBlockUserName().iterator();
            while (itr2.hasNext()){
                String block=itr2.next();
                if (block.equals(username)){
                    itr2.remove();
                }
            }
            Iterator<User> itr3=user.getBlockedFriendList().iterator();
            while (itr3.hasNext()){
                User f2=itr3.next();
                if (f2.getUsername().equals(username)){
                    itr3.remove();
                }
            }
            Iterator<String> itr4=user.getBlockFriendName().iterator();
            while (itr4.hasNext()){
                String block1=itr4.next();
                if (block1.equals(username)){
                    itr4.remove();
                }
            }

        }
    }
}

    /**
     * Add a new TextPost to user's posts.
     * @param user is user object.
     * @param textContent is Text post's text.
     * @param longitude post's longitude.
     * @param latitude post's latitude.
     * @param tags friends name which will be tagged.
     */
    public void addTextPost(User user,String textContent,String longitude,String latitude,String tags){
    if (user.getSign()==true){
        UUID id=UUID.randomUUID();
        double longi=Double.parseDouble(longitude);
        double lati=Double.parseDouble(latitude);
        Location loc=new Location(longi,lati);
        Post textpost=new TextPost(textContent,loc.getLongitude(),loc.getLatitude(),id);
        String tagFriends[]=tags.split(":");
        for (int i=0;i<tagFriends.length;i++){
            if (!user.getfirendName().contains(tagFriends[i])){
                System.out.println("Username "+tagFriends[i]+" is not your friend, and will not be tagged!");

            }
            else if (user.getfirendName().contains(tagFriends[i])){
                for (User friends: user.getFriendList()){
                    if (friends.username.equals(tagFriends[i])){
                       // System.out.println(friends.getUsername());
                        textpost.setTagList(friends.getName());
                        textpost.setTagf(friends.getName());

                    }
                }
            }
        }
        System.out.println("The post has been successfully added.");
        user.setPostList(textpost);
    }

    }

    /**
     * Add a new ImageText to user's posts.
     * @param user is user object.
     * @param textContent is post's text.
     * @param longitude post's longitude.
     * @param latitude post's latitude.
     * @param filePath post's filepath.
     * @param resolution images resolutaion.
     * @param tags friends name which will be tagged.
     */
    public void addImageText(User user,String textContent,String longitude,String latitude,String filePath,String resolution,String tags){
    if (user.getSign()==true){
        UUID id=UUID.randomUUID();
        double longi=Double.parseDouble(longitude);
        double lati=Double.parseDouble(latitude);
        Location loc=new Location(longi,lati);
        Post image=new ImagePost(textContent,loc.getLongitude(),loc.getLatitude(),filePath,resolution,id);
        String tagFriends[]=tags.split(":");

        for (int i=0;i<tagFriends.length;i++){
            if (!user.getfirendName().contains(tagFriends[i])){
                System.out.println("Username "+tagFriends[i]+" is not your friend, and will not be tagged!");
            }
            else if (user.getfirendName().contains(tagFriends[i])){
                for (User friends: user.getFriendList()){
                    if (friends.username.equals(tagFriends[i])){
                        image.setTagList(friends.getName());
                        image.setTagf(friends.getName());

                    }
                }
            }
        }
        System.out.println("The post has been successfully added.");
        user.setPostList(image);
    }
    }


    /**
     * Add videopost.
     * @param user is userobject.
     * @param textContent post's text.
     * @param longitude post's longitude.
     * @param latitude post's latitude.
     * @param filePath post's filepath.
     * @param duration video duration.
     * @param tags friends name which will be tagged.
     */
    public void addVideo(User user,String textContent,String longitude,String latitude,String filePath,String duration,String tags){
    if (user.getSign()==true){
        UUID id=UUID.randomUUID();
    double longi=Double.parseDouble(longitude);
    double lati=Double.parseDouble(latitude);
    Location loc=new Location(longi,lati);
    Post video=new VideoPost(textContent,loc.getLongitude(),loc.getLatitude(),filePath,duration,id);
    String tagFriends[]=tags.split(":");
    for (int i=0;i<tagFriends.length;i++){
        if (!user.getfirendName().contains(tagFriends[i])){
            System.out.println("Username "+tagFriends[i]+" is not your friend, and will not be tagged!");

        }
        else if (user.getfirendName().contains(tagFriends[i])){
            for (User friends: user.getFriendList()){
                if (friends.username.equals(tagFriends[i])){
                    // System.out.println(friends.getUsername());
                    video.setTagList(friends.getName());
                    video.setTagf(friends.getName());

                }
            }
        }
    }
    System.out.println("The post has been successfully added.");
    user.setPostList(video);
}}

    /**
     * Remove user's last post
     * @param user is user object.
     */
    public void removeLastPost(User user){
    if (user.getSign()==true){
        if (user.getPostList().size()==0){
            System.out.println("Error: You don't have any posts.");
        }
        else if (user.getPostList().size()>0){
            int index=user.getPostList().size();
            user.getPostList().remove(index-1);
            System.out.println("Your last post has been successfully removed. ");
        }

    }
}

    /**
     * override toString method.
     * @return String as user's informations.
     */
    public String toString(){
        DateFormat dateofBirth=new SimpleDateFormat( "dd/MM/yyyy");
        return "Name: "+this.getName()+"\nUsername: "+this.getUsername()+"\nDate of Birth: "+dateofBirth.format(this.getDate1())+"\nSchool: "+this.getSchool()+"\n";
    }
}
