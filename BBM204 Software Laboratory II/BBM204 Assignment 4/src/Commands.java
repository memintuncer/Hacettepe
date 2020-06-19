import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commands {

    public void callCommands(List<String> commandsList, Graph graph, List<Graph.Vertex> maintainList, List<Graph.Edge> brokenRailsList,String args){
        for(String line: commandsList){
            String commands[] =line.split(" ");
            if(commands[0].equals("MAINTAIN")){
                System.out.println("COMMAND IN PROCESS >> "+line);
                maintainVertex(line, graph,commands[1],maintainList);
                System.out.println("    Command "+'"'+line+'"'+"    has been executed successfully!");

            }
            else if(commands[0].equals("SERVICE")){
                System.out.println("COMMAND IN PROCESS >> "+line);
                serviceVertex(line, graph,commands[1],maintainList);
                System.out.println("    Command "+'"'+line+'"'+"    has been executed successfully!");
            }
            else if(commands[0].equals("BREAK")){
                System.out.println("COMMAND IN PROCESS >> "+line);
                String[] vertex=commands[1].split(">");
                breakRail(line, graph,vertex[0],vertex[1],brokenRailsList);
                System.out.println("    Command "+'"'+line+'"'+"    has been executed successfully!");

            }
            else if(commands[0].equals("LISTMAINTAINS")){
                listMaintains(line,maintainList);
                System.out.println("\n   Command \"LISTMAINTAINS\"  has been executed successfully!");
                //System.out.println();
            }
            else if(commands[0].equals("ADD")){
                System.out.println("COMMAND IN PROCESS >> "+line);
                addVertex(graph,commands[1]);
                System.out.println("    Command "+'"'+line+'"'+"    has been executed successfully!");

            }

            else if(commands[0].equals("ROUTE")){
                System.out.println("COMMAND IN PROCESS >> "+line);
                String[] vertices=commands[1].split(">");
                route(vertices[0],vertices[1],graph,commands[2],args);
                System.out.println("    Command    "+'"'+line+ '"' + "   has been executed successfully!");

            }

            else if(commands[0].equals("LINK")){
                int i=0;
                System.out.println("COMMAND IN PROCESS >> "+line);
                String[] source=commands[1].split(":");
                String[] dest=source[1].split(">");
                String[] dest1=dest[0].split(",");
                try {
                    while (dest1[i]!=null){
                       // System.out.println(dest1[i]);
                        String[] fin=dest1[i].split("-");
                        graph.add(source[0],fin[0],Double.parseDouble(fin[1]));
                        graph.add(fin[0],source[0],Double.parseDouble(fin[1]));
                        i++;
                    }
                }
               catch (ArrayIndexOutOfBoundsException ex){
                  System.out.print("");
               }
               System.out.println("    Command:"+'"'+line+'"'+"    has been executed successfully!");

            }

           else if(commands[0].equals("LISTACTIVERAILS")){
                System.out.println("COMMAND IN PROCESS >> "+line);
                System.out.print("    Active Rails: ");
                listActives(graph);
                System.out.println("    Command \"LISTACTIVERAILS\" has been executed successfully!");

           }
           else if(commands[0].equals("LISTBROKENRAILS")){
               System.out.println("COMMAND IN PROCESS >> "+line);
               System.out.print("    Broken Rails: ");
               listBrokens(graph);
               System.out.println("    Command \"LISTBROKENRAILS\" has been executed successfully!");
           }

           else if(commands[0].equals("LISTROUTESFROM")){
               System.out.println("COMMAND IN PROCESS >> "+line);
               System.out.print("    Routes from "+commands[1]+": " );
               routesFromVertex(commands[1],graph);
               System.out.println("    Command "+'"'+line+'"'+" has been executed successfully!");

           }

           else if (commands[0].equals("LISTCROSSTIMES")){
               System.out.println("COMMAND IN PROCESS >> "+line);
               System.out.print("   # of cross times: ");
               ListCrossTimes(graph);
               System.out.println("    Command \"LISTCROSSTIMES\" has been executed successfully!");
           }

           else if(commands[0].equals("TOTALNUMBEROFRAILS")){
               System.out.println("COMMAND IN PROCESS >> "+line);
               System.out.print("   Total # of rails: "+graph.edges.size());
               System.out.println("\n   Command \"TOTALNUMBEROFRAILS\" has been executed successfully!");
           }

           else if (commands[0].equals("TOTALNUMBEROFJUNCTIONS")){
               System.out.println("COMMAND IN PROCESS >> "+line);
               System.out.print("   Total # of junctions: "+graph.vertices.size());
               System.out.println("\n   Command \"TOTALNUMBEROFJUNCTIONS\" has been executed successfully!");

           }


           else if(commands[0].equals("REPAIR")){
                System.out.println("COMMAND IN PROCESS >> "+line);
               String[] vertices=commands[1].split(">");
               reapirRail(graph,vertices[0],vertices[1],brokenRailsList);
               System.out.println("    Command "+'"'+line+'"'+" has been executed successfully!");

           }

           else {
               System.out.println("COMMAND IN PROCESS >> "+line);
               System.out.println("    Unrecognized command "+'"'+line+'"'+" !");
           }
        }
    }


    public void maintainVertex(String Line, Graph graph, String vertexName, List<Graph.Vertex> maintainList){

        Graph.Vertex temp= graph.findVertex(vertexName);
        for(Graph.Vertex vertex1: graph.vertices){
            if(vertex1.name.equals(vertexName)){
                vertex1.maintaince=1;
                maintainList.add(vertex1);
            }
        }
    }

    public void serviceVertex(String Line, Graph graph, String vertexName, List<Graph.Vertex> maintainList){
        for (Graph.Vertex vertex1: graph.vertices){
            if(vertex1.name.equals(vertexName)){
                vertex1.maintaince=0;
                maintainList.remove(vertex1);
            }
        }
    }

    public void breakRail(String Line, Graph graph, String sourceName, String destName, List<Graph.Edge> brokenRailsList){
        for(Graph.Edge edge1: graph.edges){
            if(edge1.source.name.equals(sourceName)&&edge1.destination.name.equals(destName)){
                edge1.broken=1;
                brokenRailsList.add(edge1);
            }
        }

    }

    public void reapirRail(Graph graph, String sourceName, String destName, List<Graph.Edge> brokenRailsList){
        for(Graph.Edge edge1: graph.edges){
            if(edge1.source.name.equals(sourceName)&&edge1.destination.name.equals(destName)){
                edge1.broken=0;
                brokenRailsList.remove(edge1);
            }
        }
    }


    public void addVertex(Graph graph, String vertexName){
        Graph.Vertex source= graph.findVertex(vertexName);
        if(source==null){
            source=new Graph.Vertex(vertexName);
            graph.vertices.add(source);
        }
    }

    public void route(String src,String dest,Graph graph,String speed,String args){
        int speed1=Integer.parseInt(speed);
        double swc=Double.parseDouble(args);
        graph.path1(src,dest,speed1,swc,graph);

    }
    public void ListCrossTimes(Graph graph){
        List<String> sorted=new ArrayList<String>();
        for (Graph.Vertex vertex:graph.vertices){
            if(vertex.crossTime!=0){
                sorted.add(vertex.name);
            }
        }
        Collections.sort(sorted);
        for (String s:sorted){
            for (Graph.Vertex vertex:graph.vertices){
                if (s.equals(vertex.name)){
                    System.out.print(vertex.name+":"+vertex.crossTime+" ");
                }
            }
        }
        System.out.println();
    }

    public void routesFromVertex(String src,Graph graph){
        List<String> sorted=new ArrayList<String>();
        for (Graph.Vertex vertex:graph.vertices){
            if(vertex.name.equals(src)){
                for(Graph.Vertex vertex1:vertex.outgoing){
                    sorted.add(vertex1.name);
                }
            }
        }
        Collections.sort(sorted);
        for (String s:sorted){
            System.out.print(s+" ");
        }
        System.out.println();
    }

    public void listMaintains(String Line,List<Graph.Vertex> maintainList){
        List<String> outlist=new ArrayList<String>();
        for (Graph.Vertex vertex1:maintainList){
            outlist.add(vertex1.name);
        }
        Collections.sort(outlist);
        System.out.print("COMMAND IN PROCESS >> "+Line+"\n   Intersections under maintenance: ");
        for(String o:outlist){
            System.out.print(o+" ");
        }

    }

    public  void  listActives(Graph graph){
        List<String> sorted=new ArrayList<String>();
        for(Graph.Edge edge:graph.edges){
            if(edge.isActive==1){
                sorted.add(edge.source.name);
            }
        }
        Collections.sort(sorted);
        for(String s:sorted){
            for (Graph.Edge edge : graph.edges){
                if (s.equals(edge.source.name)&&edge.isActive==1){
                    System.out.print(edge.source.name+">"+edge.destination.name+" ");
                }
            }
        }
    System.out.println();
    }
    public void listBrokens(Graph graph){
        List<String> sorted=new ArrayList<String>();
        for(Graph.Edge edge:graph.edges){
            if(edge.broken==1&&!sorted.contains(edge.source.name)){
                sorted.add(edge.source.name);
            }
        }
        Collections.sort(sorted);
        for(String s:sorted){
            for (Graph.Edge edge : graph.edges){
                if (s.equals(edge.source.name)&&edge.broken==1){
                    System.out.print(edge.source.name+">"+edge.destination.name+" ");
                }
            }
        }
    System.out.println();
    }
}
