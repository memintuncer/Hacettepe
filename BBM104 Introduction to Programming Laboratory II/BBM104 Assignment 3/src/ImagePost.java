import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ImagePost extends TextPost {
    private String filepath;
    private String resolution;

    public ImagePost(String textContent,double longitude,double latitude,String filepath,String resolution,UUID id){
        super(textContent,longitude,latitude,id);
        this.filepath=filepath;
        this.resolution=resolution;

    }


    public String getFilepath(){
        return this.filepath;
    }
    public void setFilepath(String path){
        this.filepath=path;
    }
    public String getResolution(){
        return this.resolution;
    }
    public void setResolution(String resolution1){
        this.resolution=resolution1;
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

            return this.getTextContent()+"\nDate: "+df.format(dateobj)+"\nLocation: "+this.getLongitude()+", "+this.getLatitude()+"\nImage: "+this.getFilepath() +  "\nImage resolution: "+this.getResolution()+"\nFriends tagged in this post: "+s;

        }
        else if(this.getTaglist().size()==0){
            return this.getTextContent()+"\nDate: "+df.format(dateobj)+"\nLocation: "+this.getLongitude()+", "+this.getLatitude()+"Image: "+this.getFilepath() +  "\nImage resolution: "+this.getResolution();
        }
        return "";
    }

}
