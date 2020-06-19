
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
    
  

}
