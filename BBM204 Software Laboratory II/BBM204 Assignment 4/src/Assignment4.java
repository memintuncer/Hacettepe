import java.util.ArrayList;
import java.util.List;

public class Assignment4 {
    public static void main(String[] args) {
        Graph graph = new Graph();
        FileRead fileRead=new FileRead();
        List<String> lines=fileRead.getLines(args[1]);
        Commands commands=new Commands();
        List<String> commandlist=fileRead.getLines(args[2]);
        List<Graph.Vertex> maintainList=new ArrayList<Graph.Vertex>();
        List<Graph.Edge> brokenRailsList=new ArrayList<Graph.Edge>();
        for(String s:lines){
            String dis[]=s.split(" ");
            String ver[]=dis[0].split("-");
            double distance=Double.parseDouble(dis[1]);
            graph.add(ver[0],ver[1],distance);
            graph.add(ver[1],ver[0],distance);
        }
        graph.topological(args[0]);
        commands.callCommands(commandlist,graph,maintainList, brokenRailsList,args[3]);


    }
}
