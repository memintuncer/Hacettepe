import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileRead {

    public List<String> getLines(String args){
        List<String> lineList = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(args));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                lineList.add(line);
            }
            scanner.close();
            return lineList;
        }
        catch (FileNotFoundException ex) {
            System.out.println("No File Found!");
            return null;
        }
    }

    public void setItems(List<String> lines2,List<Item> itemlist,int index) {
        for (String word : lines2) {
            String commads[] = word.split(",");
            double j;

            try {
                j = Double.parseDouble(commads[index]);
                Item item = new Item(j, word);
                itemlist.add(item);

            } catch (NumberFormatException ignored) {
            }
        }
    }
}