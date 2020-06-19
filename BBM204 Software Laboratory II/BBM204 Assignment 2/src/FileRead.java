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

    public void getcommands(List<String> linelist,List<String> commandlist){
        for(int i=3;i<linelist.size();i++){
            String command[]=linelist.get(i).split(" ");
            commandlist.add(command[1]);
        }

    }
    public int createEmptyFifoqueue(List<String> linelist,int size){
        String input_size[]=linelist.get(0).split(" ");
        size=Integer.parseInt(input_size[1]);
        return size;
    }
    public int createEmptyPrQueue(List<String> linelist,int size){
        String input_size[]=linelist.get(0).split(" ");
        size=Integer.parseInt(input_size[1]);
        return size;
    }
    public int createSeconChanceQue(List<String> linelist,int size){
        String input_size[]=linelist.get(0).split(" ");
        size=Integer.parseInt(input_size[1]);
        return size;
    }
}
