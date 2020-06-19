
import java.util.*;
/**
 * Reads the file and calls the methods from other classes.
 */
public class Main {
    public static void main(String[] args){
        UserCollection userCollection=new UserCollection();
        List<String> linesList =  FileReader.GetLines(args[1]);
        List<String> linesList1 =  FileReader.GetLines(args[0]);
        List<User> userList=userCollection.getuserList(args);
        List<String> userNameList=userCollection.getuserNameList(args);
        ArrayList<String> singList=new ArrayList<String>();
        Set<String> allBlockedusers = new HashSet<>();
        System.out.println("-----------------------");
        for(String lines:linesList){
            String command[]=lines.split("\t");
            if (command[0].equals("ADDUSER")) {
                System.out.println("Command: "+command[0]+"\t"+command[1]+"\t"+command[2]+"\t"+command[3]+"\t"+command[4]+"\t"+command[5]+"\t");
                userCollection.addUser(command[1],command[2],command[3],command[4],command[5],userList,userNameList);
                System.out.println("-----------------------");
            }
            else if (command[0].equals("REMOVEUSER")){
                System.out.println("Command: "+command[0]+"\t"+command[1]);
                userCollection.removeUser(command[1],userList,userNameList);
                System.out.println("-----------------------");
            }
            else if (command[0].equals("SIGNIN")){
                System.out.println("Command: "+command[0]+"\t"+command[1]+"\t"+command[2]);
                userCollection.userSign(command[1],command[2],userList,userNameList,singList);
                System.out.println("-----------------------");
            }
            else if (command[0].equals("UPDATEPROFILE")){
                System.out.println("Command: "+command[0]+"\t"+command[1]+"\t"+command[2]+"\t"+command[3]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if ( singList.size()>0){
                    for (User user:userList){
                        user.updateProfile(command[1],command[2],command[3],user,userNameList);
                    }System.out.println("-----------------------");
                }
            }
            else if (command[0].equals("SIGNOUT")){
                System.out.println("Command: "+command[0]);

                for (User user:userList){
                    user.signOut(user);
                }System.out.println("-----------------------");
                singList.clear();
            }
            else if(command[0].equals("CHPASS")){
                System.out.println("Command: "+command[0]+"\t"+command[1]+"\t"+command[2]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if ( singList.size()>0){
                    for (User user:userList){
                        user.changePass(command[1],command[2],user);
                    }System.out.println("-----------------------");
            }
        }
        else if(command[0].equals("ADDFRIEND")){
                System.out.println("Command: "+command[0]+"\t"+command[1]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if ( singList.size()>0){
                    for (User user:userList){
                        user.addFriend(command[1],user,userList,userNameList);
                    }System.out.println("-----------------------");
                }
            }

        else if (command[0].equals("REMOVEFRIEND")){
                System.out.println("Command: "+command[0]+"\t"+command[1]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if ( singList.size()>0){
                    for (User user:userList){
                        user.removeFriend(command[1],user);
                    }System.out.println("-----------------------");
                }
            }
            else if (command[0].equals("LISTUSERS")){
                System.out.println("Command: "+command[0]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if ( singList.size()>0){
                    for (User user:userList){
                        user.listUsers(user,userList);
                    }System.out.println("-----------------------");
                }
            }
         else if (command[0].equals("LISTFRIENDS")){
                System.out.println("Command: "+command[0]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if ( singList.size()>0){
                    for (User user:userList){
                        user.listFriends(user);
                    }System.out.println("-----------------------");
                }
            }
            else if(command[0].equals("REMOVELASTPOST")){
             System.out.println("Command: "+command[0]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if (singList.size()>0){
                    for (User user:userList){
                        user.removeLastPost(user);
                    }System.out.println("-----------------------");
                }
         }
         else if (command[0].equals("BLOCK")){
                System.out.println("Command: "+command[0]+"\t"+command[1]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if ( singList.size()>0){
                    for (User user:userList){
                       user.blockUser(command[1],user,userNameList,userList);
                    }System.out.println("-----------------------");
            }
         }
            else if (command[0].equals("SHOWBLOCKEDFRIENDS")){
                System.out.println("Command: "+command[0]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if (singList.size()>0){
                    for (User user: userList){
                        user.showBlockedFriends(user);
                    }System.out.println("-----------------------");
                }
            }
           else if (command[0].equals("SHOWBLOCKEDUSERS")){
                System.out.println("Command: "+command[0]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if (singList.size()>0){
                    for (User user: userList){
                        user.showBlockUsers(user);
                    }System.out.println("-----------------------");
                }
            }
         else if (command[0].equals("UNBLOCK")){
                System.out.println("Command: "+command[0]+"\t"+command[1]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if (singList.size()>0){
                    for (User user:userList){
                        user.unBlock(command[1],user);
                    }System.out.println("-----------------------");
                }
            }
         else if (command[0].equals("ADDPOST-IMAGE")){
                System.out.println("Command: "+command[0]+"\t"+command[1]+"\t"+command[2]+"\t"+command[3]+"\t"+command[4]+command[5]+"\t"+command[6]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if (singList.size()>0){
                    for (User user:userList){
                        user.addImageText(user,command[1],command[2],command[3],command[5],command[6],command[4]);
                    }System.out.println("-----------------------");
                }
         }
        else if (command[0].equals("ADDPOST-TEXT")){
                System.out.println("Command: "+command[0]+"\t"+command[1]+"\t"+command[2]+"\t"+command[3]+"\t"+command[4]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if (singList.size()>0){
                    for (User user:userList){
                        user.addTextPost(user,command[1],command[2],command[3],command[4]);
                    }System.out.println("-----------------------");
                }
            }
        else if (command[0].equals("ADDPOST-VIDEO")){
                System.out.println("Command: "+command[0]+"\t"+command[1]+"\t"+command[2]+"\t"+command[3]+"\t"+command[4]+command[5]+"\t"+command[6]);
                if ( singList.size()==0){
                    System.out.println("Error: Please sign in and try again.");
                }
                else if (singList.size()>0){
                    for (User user:userList){
                        user.addVideo(user,command[1],command[2],command[3],command[5],command[6],command[4]);
                    }System.out.println("-----------------------");
                }
            }
        else if (command[0].equals("SHOWPOSTS")){
                System.out.println("Command: "+command[0]+"\t"+command[1]);
                    userCollection.showPosts(command[1],userNameList,userList);
            }
        }
   }
}
