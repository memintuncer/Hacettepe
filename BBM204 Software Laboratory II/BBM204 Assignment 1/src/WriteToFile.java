import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class WriteToFile {

    public void getFinalList(List<String> lines2,List<Item> sorteditems,List<String> finalSorted){
        finalSorted.add(lines2.get(0));
        for(Item item : sorteditems){
            finalSorted.add(item.word);
        }
    }

    public void writeCsv(List<String> sortedfinal,String args)throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(args));
        StringBuilder sb = new StringBuilder();
        for(String s:sortedfinal){
            sb.append(s);
            sb.append("\n");
        }
        pw.write(sb.toString());
        pw.close();
    }

}
