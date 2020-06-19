import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Assignment3 {

    public static void main(String[] args)throws IOException {
        int i;
        List<String> graphWords=new ArrayList<String>();
        List<Words> wordsList=new ArrayList<Words>();
        List<Words>pairWords1=new ArrayList<Words>();
        List<Words> pairWords2=new ArrayList<Words>();
        List<Words> graphWordsList=new ArrayList<Words>();
        List<Cluster> clusterList=new ArrayList<Cluster>();
        FileRead fileRead=new FileRead();
        Words words=new Words();
        PrintStream o = new PrintStream(new File("output1.txt"));
        System.setOut(o);
        fileRead.graphWords(args[1],graphWords);
        words.WordList(wordsList,args[0]);
        words.graphwordsList(wordsList,graphWords,graphWordsList);
        words.pairlist1(wordsList,graphWords,pairWords1,pairWords2);
        int V =graphWordsList.size();
        int E = graphWordsList.size()*graphWordsList.size();
        int E1=graphWordsList.size();
        int V1=pairWords1.size();
        Graph graph = new Graph(V, E);
        Graph pairGraph=new Graph(V1*2,V1);
        Graph MST=new Graph(V,E1);
        Graph MST1=new Graph(V,E1);
        Graph pairMST1=new Graph(V,V);
        int e=V;
        Graph.Edge MSTresult[] = new Graph.Edge[V];
        Graph.Edge pairMST[]=new Graph.Edge[V];
        graph=graph.createGraph(graphWordsList,V,E);
        pairGraph=pairGraph.pairGraph(pairWords1,pairWords2,V1,V1);
        graph.MST(MST, V1,MSTresult);

        //System.out.println("\n\n=====PAIR GRAPH======");
        for(i=0;i<V1;i++){
            // System.out.println(pairGraph.edge[i].word1+"<==>"+pairGraph.edge[i].word2+"        ===>>>"+pairGraph.edge[i].weight);
        }

        System.out.println("=====   MST     =======");
        for (i = 0; i < V-1; ++i){
            System.out.println(MSTresult[i].word1+" -- " +MSTresult[i].word2+" == " + MSTresult[i].weight);
        }
        System.out.println("\n\n\n======PAIRS COMLETE GRAPH=====");
        for(i=0;i<E;i++){
        System.out.println(graph.edge[i].word1+"<==>"+graph.edge[i].word2+"        ===>>>"+graph.edge[i].weight);
        }


        int cluster=Integer.parseInt(args[3]);
        pairGraph.cluster(MST,3,V1,graph,E,clusterList,MSTresult);
        for (i = 0; i < V-1; ++i){
            //System.out.println("adasd");
            if(MSTresult[i].weight!=0)
            System.out.println(MSTresult[i].word1+" -- " +MSTresult[i].word2+" == " + MSTresult[i].weight);
        }
    }
}
