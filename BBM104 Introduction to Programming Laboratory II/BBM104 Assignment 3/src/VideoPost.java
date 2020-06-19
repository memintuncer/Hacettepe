import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class VideoPost extends TextPost {
    private String filepath;
    private String videoDuration ;
    public VideoPost(String textContent,double longitude,double latitude,String filepath,String videoDuration,UUID id){
        super(textContent,longitude,latitude,id);
        this.filepath=filepath;
        this.videoDuration=videoDuration;
    }

    public String getFilepath(){
        return this.filepath;
    }
    public void setFilepath(String path){
        this.filepath=path;
    }
    public String getVideoDuration(){
        return this.videoDuration;
    }
    public void setVideoDuration(String videoDuration1){
        this.videoDuration=videoDuration1;
    }
    /**
     * override toString method.
     * @return String which is post's informaitons.
     */
    public String toString(){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        if (this.getTaglist().size()>0){
            ArrayList<String> k1 = new ArrayList<>();
            String s="";
            for (String user:this.getTaglist()){
                k1.add(user);
            }
            for (int k =0 ; k<k1.size();k++){
                if (k1.size()==1){
                    s += k1.get(k);
                }
                else {
                    if (k == k1.size()-1){
                        s += k1.get(k);
                    }else {
                        s+= k1.get(k)+" ,";
                    }
                }
            }

            return this.getTextContent()+"\nDate: "+df.format(dateobj)+"\nLocation: "+this.getLongitude()+", "+this.getLatitude()+"\nVideo: "+this.getFilepath() +  "\nVideo duration: "+this.getVideoDuration()+" minutes\nFriends tagged in this post: "+this.getTagf();
        }
        else if(this.getTaglist().size()==0){
            return this.getTextContent()+"\nDate: "+df.format(dateobj)+"\nLocation: "+this.getLongitude()+", "+this.getLatitude()+"Video: "+this.getFilepath() +  "\nVideo duration: "+this.getVideoDuration();
        }
        return "";
    }


}
