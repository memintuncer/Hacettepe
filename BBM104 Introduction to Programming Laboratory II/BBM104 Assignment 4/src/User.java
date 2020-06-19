import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

public class User {
	private String name;
	private String username;
	private String password;
	private Date birthDate;
	private String date;
	private String school;
	private String relationship;
	private ArrayList<User> friendList=new ArrayList<>();
	private ArrayList<User> blockedList=new ArrayList<>();
	private ArrayList<User> tagList;
	private ArrayList<String> tag_Name;
	private  Boolean Login=false;
	private ArrayList<Post> postList=new ArrayList<>();
	private ArrayList<String> friendName=new ArrayList<>();
	public User(String name,String username,String password,String birthdate,String school,String relationship){
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
		this.setDate(birthdate);
		this.setSchool(school);
		this.setRelationship(relationship);
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public ArrayList<User> getFriendList() {
		return friendList;
	}

	public void setFriendList(User friend) {
		this.friendList.add(friend);
	}

	public ArrayList<User> getTagList() {
		return tagList;
	}

	public void setTagList(ArrayList<User> tagList) {
		this.tagList = tagList;
	}

	public ArrayList<User> getBlockedList() {
		return blockedList;
	}

	public void setBlockedList(User friend) {
		this.blockedList.add(friend);
	}

	public ArrayList<String> getTag_Name() {
		return tag_Name;
	}

	public void setTag_Name(ArrayList<String> tag_Name) {
		this.tag_Name = tag_Name;
	}

	public Boolean getLogin() {
		return Login;
	}

	public void setLogin(Boolean a) {
		Login = a;
	}
	public ArrayList<String> getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName.add(friendName);
	}

	public void addFriend(User user,String username,String friendname){
		if(user.getUsername().equals(username)){
			for(User friend:UserCollection.userList){
				if(friend.getUsername().equals(friendname)){
					user.setFriendList(friend);
					user.setFriendName(friendname);
				}
			}
		}
		
	}
	
	public void blockFriend(User user,String username,String friendname){
		 if (user.getUsername().equals(username)){
			
			 user.getFriendName().remove(friendname);
	            Iterator<User> itr = user.getFriendList().iterator();
	            while (itr.hasNext()) {
	                User f1 = itr.next();
	                if (f1.getUsername().equals(friendname)) {
	                    itr.remove();
	                }
	            }
	            for(User friend:UserCollection.userList){
	                if(friend.getUsername().equals(friendname)){
	                    user.setBlockedList(friend);
	                }
	                
	            }
	        }
    }

	public ArrayList<Post> getPostList() {
		return postList;
	}

	public void setPostList(Post post) {
		this.postList.add(post);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	 public void addText(User user,String username,String textContent,String longitude,String latitude,String tags){      
	        if(user.getUsername().equals(username)){
	        	UUID id=UUID.randomUUID();
	 	        double longi=Double.parseDouble(longitude);
	 	        double lati=Double.parseDouble(latitude);
	 	        Location loc=new Location(longi,lati);
	 	        String tagFriends[]=tags.split(":");
	 	        Post textpost=new TextPost(textContent,loc.getLongitude(),loc.getLatitude(),id);
	 	        for (int i=0;i<tagFriends.length;i++){
	 	        	for(User friend:user.getFriendList()){
		 	    		   if(friend.getUsername().equals(tagFriends[i])){
		 	    			  textpost.setTagList(friend.getName());
		 	    			 textpost.setTagf(textpost.getTaglist());
		 	    		   }
		 	    	   }
	 	        }
	 	        user.setPostList(textpost);
	        }
	    }
	 public void addImage(User user,String username,String textContent,String longitude,String latitude,String tags,String filePath,String resolution){
		 if(user.getUsername().equals(username)){
			 UUID id=UUID.randomUUID();
	 	        double longi=Double.parseDouble(longitude);
	 	        double lati=Double.parseDouble(latitude);
	 	        Location loc=new Location(longi,lati);
	 	        String tagFriends[]=tags.split(":");
	 	        Post image=new ImagePost(textContent,loc.getLongitude(),loc.getLatitude(),filePath,resolution,id);
	 	       for (int i=0;i<tagFriends.length;i++){
	 	    	  for(User friend:user.getFriendList()){
	 	    		   if(friend.getUsername().equals(tagFriends[i])){
	 	    			  image.setTagList(friend.getName());
	 	    			 image.setTagf(image.getTaglist());
	 	    		   }
	 	    	   }
	 	        }
	 	       user.setPostList(image);
		 }
	 }
	 
	 public void addVideo(User user,String username,String textContent,String longitude,String latitude,String tags,String filePath,String duration){
		 if(user.getUsername().equals(username)){
			 UUID id=UUID.randomUUID();
	 	        double longi=Double.parseDouble(longitude);
	 	        double lati=Double.parseDouble(latitude);
	 	        Location loc=new Location(longi,lati);
	 	        String tagFriends[]=tags.split(":");
	 	        Post video=new VideoPost(textContent,loc.getLongitude(),loc.getLatitude(),filePath,duration,id);
	 	       for (int i=0;i<tagFriends.length;i++){
	 	    	   for(User friend:user.getFriendList()){
	 	    		   if(friend.getUsername().equals(tagFriends[i])){
	 	    			  video.setTagList(friend.getName());
	 	    			 video.setTagf(video.getTaglist());
	 	    		   }
	 	    	   }
	 	    	
	 	       }
	 	      user.setPostList(video);			 
		 }

	 }
	 
	 public void addText1(User user,String textContent,String longitude,String latitude){
		 	UUID id=UUID.randomUUID();
	        double longi=Double.parseDouble(longitude);
	        double lati=Double.parseDouble(latitude);
	        Location loc=new Location(longi,lati);
	        Post textpost=new TextPost(textContent,loc.getLongitude(),loc.getLatitude(),id);
	        user.setPostList(textpost); 
	 }
	 
	public void addImage1(User user,String textContent,String longitude,String latitude,String filePath,String resolution){
		UUID id=UUID.randomUUID();
        double longi=Double.parseDouble(longitude);
        double lati=Double.parseDouble(latitude);
        Location loc=new Location(longi,lati);
        Post image=new ImagePost(textContent,loc.getLongitude(),loc.getLatitude(),filePath,resolution,id);
        user.setPostList(image);
	}

	public void addVideo1(User user,String textContent,String longitude,String latitude,String filePath,String duration){
			UUID id=UUID.randomUUID();
	        double longi=Double.parseDouble(longitude);
	        double lati=Double.parseDouble(latitude);
	        Location loc=new Location(longi,lati);
	        Post video=new VideoPost(textContent,loc.getLongitude(),loc.getLatitude(),filePath,duration,id);
	        user.setPostList(video);
	}


}
