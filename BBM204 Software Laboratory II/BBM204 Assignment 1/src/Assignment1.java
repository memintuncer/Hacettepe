import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Assignment1 {
    public static void main(String[] args)  {
        int index=Integer.parseInt(args[1])-1;
        FileRead fileRead=new FileRead();
        QuickSort quickSort=new QuickSort();
        SelectionSort selectionSort=new SelectionSort();
        InsertionSort insertionSort=new InsertionSort();
        WriteToFile writeToFile=new WriteToFile();
        List<Item> itemList=new ArrayList<Item>();
        List<Item> quickList=new ArrayList<Item>();
        List<Item> insertionList=new ArrayList<Item>();
        List<Item> selectList=new ArrayList<Item>();
        fileRead.getLines(args[0]);
        List<String> lines2 =  fileRead.getLines(args[0]);
        List<String> sortedfinal=new ArrayList<String>();
        fileRead.setItems(lines2,itemList,index);
        fileRead.setItems(lines2,quickList,index);
        fileRead.setItems(lines2,insertionList,index);
        fileRead.setItems(lines2,selectList,index);

        double startTime = System.nanoTime();
        quickSort.quickSort1(itemList,0,itemList.size()-1);
        double endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        double startTime1 = System.nanoTime();
        selectionSort.selectionSort(selectList);
        double endTime1   = System.nanoTime();
        double totalTime1 = endTime1 - startTime1;
        double startTime2 = System.nanoTime();
        insertionSort.insertionSort(insertionList);
        double endTime2   = System.nanoTime();
        double totalTime2 = endTime2 - startTime2;
        quickSort.quickSort1(quickList,0,quickList.size()-1);

         writeToFile.getFinalList(lines2,itemList,sortedfinal);

         if(Objects.equals(args[2], "T")){
             try {
                 writeToFile.writeCsv(sortedfinal,args[0]);
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
         }


    }
}
