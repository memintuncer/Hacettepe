import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Words {
    public String Name;
    int id;
    public List<Double> Vectors=new ArrayList<Double>() ;
    public double vec;


    public void WordList(List<Words> wordsList,String args)throws IOException {
        List<String> lineList = new ArrayList<String>();
        FileRead fileRead=new FileRead();
        lineList=fileRead.getLines(args);
        int size=fileRead.find_NumberofSpaces(lineList.get(0));
        for (String s:lineList){
            Words words=new Words();
            String[] str=s.split(" ");
            String name=str[0];
            words.Name=name.substring(1,name.length()-1);
            double d1=0;
            for (int i=1;i<size;i++){
                Double d=Double.parseDouble(str[i]);
                words.Vectors.add(d);
                d1+=Math.pow(d,2);
            }
            words.vec=Math.sqrt(d1);
            wordsList.add(words);
        }
    }

    public void graphwordsList(List<Words> wordsList,List<String> graphWords,List<Words> graphWordsList){
        List<String> pairList = new ArrayList<String>();
        for (String s:graphWords){
            Words words=new Words();
            String[] str=s.split("-");
            try {
                pairList.add(str[0]);
                pairList.add(str[1]);
            }
            catch (ArrayIndexOutOfBoundsException ex){
               break;
            }
        }
        int i=0;
        for(String name:pairList){
            for(Words words:wordsList){
                if(name.equals(words.Name)&&!graphWordsList.contains(words)){

                    graphWordsList.add(words);
                    words.id=i;
                    i++;
                }
            }
        }

        //System.out.println(i);
    }

   /* public void graphwordsList1(List<Words> wordsList1,List<Words> wordsList2,List<String> graphWords,List<Words> graphWordsList){
        List<String> pairList = new ArrayList<String>();
        for (String s:graphWords){
            Words words=new Words();
            String[] str=s.split("-");
            try {
                pairList.add(str[0]);
                pairList.add(str[1]);
            }
            catch (ArrayIndexOutOfBoundsException ex){
                break;
            }
        }
        int i=0;
        for(String name:pairList){
            for(Words words:wordsList1){
                if(name.equals(words.Name)&&!graphWordsList.contains(words)){

                    graphWordsList.add(words);
                    words.id=i;
                    i++;
                }
            }
        }

        //System.out.println(i);
    }
*/
public void pairlist1(List<Words> wordsList,List<String> graphWords,List<Words> pairWords1,List<Words> pairWords2){
    List<String> pairList = new ArrayList<String>();
    List<String> pairList1 = new ArrayList<String>();
    for (String s:graphWords){
        Words words=new Words();
        String[] str=s.split("-");
        try {
            pairList.add(str[0]);
            pairList1.add(str[1]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            break;
        }
    }
    for(String name:pairList){
        for(Words words:wordsList){
            if(name.equals(words.Name)){
               pairWords1.add(words);
            }
        }
    }
    for(String name:pairList1){
        for(Words words:wordsList){
            if(name.equals(words.Name)){
                pairWords2.add(words);
            }
        }
    }

}
}
