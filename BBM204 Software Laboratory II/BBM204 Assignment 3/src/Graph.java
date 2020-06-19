// Java program for Kruskal's algorithm to find Minimum
// Spanning Tree of a given connected, undirected and 
// weighted graph

import java.util.*;
import java.lang.*;
import java.io.*;

public class Graph
{

    class Edge implements Comparable<Edge>
    {
        int src, dest;
        String word1,word2;
        double weight;

       public int  compareTo(Edge compareEdge)
        {
            if(this.weight<compareEdge.weight)
                return -1;
            else if(compareEdge.weight<this.weight)
                return 1;
            return 0;

        }
    };


    class subset
    {
        int parent, rank;
    };

    int V, E;
    Edge edge[];

    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void MST(Graph MST, int e1,Edge result[])
    {
        e1=0;

        int e = 0;
        int i = 0;
        for (i=0; i<V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);
        List<Object> list = Arrays.asList(edge);
        Collections.reverse(list);

        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();

        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;


        while (e < V - 1)
        {

            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }

        }

        e1=e;

        for (i = 0; i < e; ++i){
            MST.edge[i].src = result[i].src;
            MST.edge[i].dest = result[i].dest;
            MST.edge[i].weight =result[i].weight;
            MST.edge[i].word1 =result[i].word1;
            MST.edge[i].word2=result[i].word2;
        }

    }





    public Graph createGraph(List<Words> graphWordsList, int Vertex, int Edges){
        Graph graph = new Graph(V, E);
        int i=0;
        for (Words words1 : graphWordsList) {
            for (Words words2 : graphWordsList) {
                double cos = cosSim(words1, words2);

                graph.edge[i].src = words1.id;
                graph.edge[i].dest = words2.id;
                graph.edge[i].weight = cosSim(words1,words2);
                graph.edge[i].word1 = words1.Name;
                graph.edge[i].word2=words2.Name;

                i++;


            }
        }
        return graph;
    }
    public Graph pairGraph(List<Words> pairs1,List<Words> pairs2,int Vertex,int Edge){

        Graph graph = new Graph(V, E);
        int i=0;
        int j;
        for(j=0;j<pairs1.size();j++){
            Words words1=pairs1.get(j);
            Words words2=pairs2.get(j);
            graph.edge[i].src = pairs1.get(j).id;
            graph.edge[i].dest = pairs2.get(j).id;
            graph.edge[i].weight = cosSim(words1,words2);
            graph.edge[i].word1 = words1.Name;
            graph.edge[i].word2=words2.Name;

            i++;

        }

        return graph;
    }

    public static  double cosSim(Words words1, Words words2) {
        double cossim = 0;
        for (int i = 0; i < words1.Vectors.size(); i++) {

            cossim += words1.Vectors.get(i) * words2.Vectors.get(i);
        }

        cossim /= words1.vec * words2.vec;
        if (words1.Name.equals(words2.Name)) {
            cossim = 1;
        }

        return cossim;
    }


    public void cluster(Graph graph,int cluster,int V1,Graph graph1,int V2,List<Cluster> clusterList,Edge edge1[]){
        int i=V1/2;
        int k=V1/cluster;
        int cluster1=cluster;
        int j,l;
        Graph.Edge e=graph.edge[i];
        List<String> clus=new ArrayList<>();
        List<Edge> edgeList=new ArrayList<Edge>();
        List<Edge> edgeList1=new ArrayList<Edge>();
        int ind=graph.edge.length;
        for(l=0;l<V;l++){
            edgeList1.add(graph.edge[i]);
        }
        while (cluster!=1){
            Cluster cluster2=new Cluster();
            //Edge edge=new Edge();
            Edge edge=edge1[ind-2];
            graph.removeelement(edge1,graph.edge[ind-2]);
            //graph.edge[ind-2]=null;
            edgeList.add(edge);
            cluster--;
            ind --;
        }

        for(Edge e1:edgeList){
           // System.out.println(e1.word1+"--"+e1.word2);
        }

    }


    public void removeelement(Edge edge[],Edge edge1){
        int i, j;
        for (i = j = 0; j < edge.length; ++j)
            if (edge1.weight!=edge[j].weight) edge[i++] = edge[j];
        edge = Arrays.copyOf(edge, i);
    }

}
