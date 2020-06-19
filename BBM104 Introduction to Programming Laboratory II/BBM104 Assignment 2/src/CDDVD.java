
public class CDDVD extends OfficeSupplies{
	public String songs;
	
	public CDDVD(String name,double cost,String rDate,String coverTitle,String pName,String songs,int id){
		super(name,cost,rDate,pName,coverTitle,id);
		this.songs=songs;
	}
public static void main(String[] args){
		
	}
/**
 * Overrides toString() method.
 */
	public String toString(){
		return "Type: "+name+"\nItem ID: "+items_id+"\nPrice: "+cost+" $\nRelease Date: "+rDate+"\nTitle: "+coverTitle+"\nSongs: "+songs+"\nComposer: "+pName+"\n-----------------------";
	}
}
