import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileReader {
    public static List GetLines(String args){
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
    public static void main(String[] args){
        List<String> lines2 =GetLines(args[0]);
        //System.out.print(lines2);
    }
}
