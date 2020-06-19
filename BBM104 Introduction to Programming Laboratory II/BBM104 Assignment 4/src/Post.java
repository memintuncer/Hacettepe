import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public abstract class Post implements PostInterface {
    private String textContent;
    private double longitude;
    private double latitude;
    private ArrayList<String> tagList;
    private Date date;
    private String tagf;
    private UUID id;
   

    public Post(String textContent,double longitude,double latitude,UUID id){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date1=new Date();
        ArrayList<String> tagList1=new ArrayList<String>();
        String tagfr="";
        Location loc=new Location(longitude,latitude);
        this.textContent=textContent;
        loc.setLatitude(latitude);
        loc.setLongitude(longitude);
        this.latitude=loc.getLatitude();
        this.longitude=loc.getLongitude();
        this.tagList=tagList1;
        this.id=id;
        this.tagf=tagfr;

    }
    public String getTextContent(){
        return this.textContent;
    }
    public void setTextContent(String textContent1){
        this.textContent=textContent1;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public void setLongitude(double longitude1){
        this.longitude=longitude1;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public void setLatitude(double latitude1){
        this.latitude=latitude1;
    }
    public List<String> getTaglist(){
        return this.tagList;
    }
    public void setTagList(String tagFriend){
        this.tagList.add(tagFriend);
    }
    public String getTagf(){
        return this.tagf;
    }
    public void setTagf(List<String> list){
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
            this.tagf=s;
            }
    	
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}