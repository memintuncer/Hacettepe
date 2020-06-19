import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

public class TextPost extends Post {



    public TextPost(String textContent,double longitude,double latitude,UUID id){
        super(textContent,longitude,latitude,id);
    }

    /**
     * override toString method.
      * @return String which is post's informaitons.
     */
  

}
