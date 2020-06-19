/**
 * Created by HP-PC on 28.4.2017.
 */
public class Location {
    private double longitude;
    private double latitude;
    public Location(double longitude,double latitude){
        this.latitude=latitude;
        this.longitude=longitude;
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
}
