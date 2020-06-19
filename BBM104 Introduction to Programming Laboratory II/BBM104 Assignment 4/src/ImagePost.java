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
   
}
