import java.util.*;

public class Graph {
    public ArrayList<Vertex> vertices;
    public ArrayList<Edge> edges;
    Route path;

    public Graph(){
        vertices=new ArrayList<>();
        edges=new ArrayList<>();

    }

    public  void  add(String source,String destination,double distance){
        Edge temp=findEdge(source,destination);
        if(temp!=null){
            System.out.print("");
        }
        else{
            Edge e=new Edge(source,destination,distance);
            edges.add(e);
        }

    }


    private Edge findEdge(String srcname,String desname){
        for(Edge edge1: edges){
            if(edge1.source.name.equals(srcname)&&edge1.destination.name.equals(desname)){
                return edge1;
            }

        }
        return null;
    }

    public Vertex findVertex(String name){
        for(Vertex vertex1:vertices){
            if(vertex1.name.equals(name)){
                return vertex1;
            }
        }
        return null;
    }
    public void setActive(String srcname,String desname){
        for(Edge edge1: edges){
            if(edge1.source.name.equals(srcname)&&edge1.destination.name.equals(desname)){
                edge1.isActive=1;
            }
        }
    }

    public void topological(String args){
        FileRead fileRead=new FileRead();
        List<String> lines =fileRead.getLines(args);
        for(String s: lines){
            String[] s1=s.split(":");
            String[] s2=s1[1].split(">");
            setActive(s1[0],s2[1]);
        }

    }
    public void addVert(Vertex vertex1, Graph graph){
        graph.vertices.add(vertex1);

    }

    public void gettime(Route route,int speed,double swtch){
        double time=0;
        int swtime=0;
        for(int j=0;j<route.routeList.size()-1;j++){
            Vertex vertex=findVertex(route.routeList.get(j));
            Edge edge=findEdge(route.routeList.get(j),route.routeList.get(j+1));
            if(vertex.maintaince==1){
                route.time=0;
                break;
            }
            if(edge.broken==1){
                route.time=0;
                break;
            }
            else{
                if(edge.isActive==1){
                    time+=((edge.distance)/speed)*60;
                }
                if(edge.isActive==0){
                    time+=((edge.distance)/speed)*60+swtch;
                    swtime++;
                    route.switchTime=swtime;
                }
            }
            route.time=time;

        }

    }

    public void findAllRoutestimes(List<Route> routesList,int speed,double swc,Graph graph,String src,String dst){
        List<Double> times=new ArrayList<Double>();

        for(Route route:routesList){
            gettime(route,speed,swc);
            if(route.time!=0){
                times.add(route.time);
            }
            Collections.sort(times);

        }
        for(Route route:routesList){
            if(route.time==times.get(0)&&route.time!=0){
                graph.path=route;
            }
        }
    getpath(graph,src,dst);
    }
    public void getpath(Graph graph,String src,String dst){

        Edge temp;
        if(graph.path.routeList.size()!=0){
            System.out.println("    Time (in min): "+graph.path.time);
            System.out.println("    Total # of switch changes:  "+graph.path.switchTime);
            System.out.print("    Route from "+src+" to "+dst+": ");
            for (String s:graph.path.routeList){
                System.out.print(s+" ");
            }
            System.out.println();
            for(int i=0;i<graph.path.routeList.size()-1;i++){
                temp=findEdge(graph.path.routeList.get(i),graph.path.routeList.get(i+1));
                if(temp.isActive!=1){
                    temp.isActive=1;
                }
            }
        }

        if(graph.path.routeList.size()==0){
            System.out.println("    No route from "+src+" to "+dst+" found currently!");
        }
        setActivity(graph);
        setCross(graph);
        graph.path=new Route();


    }
    public void setActivity(Graph graph){
        for(int i=0;i<graph.path.routeList.size()-1;i++){
            Edge edge=findEdge(graph.path.routeList.get(i),graph.path.routeList.get(i+1));
            for(Edge edge1:graph.edges){
                if(edge1.isActive==1&&edge1.source.name.equals(edge.source.name)){
                        if(!edge1.destination.name.equals(edge.destination.name)){
                            edge1.isActive=0;
                        }
                    }
                }
            }
        }

   public void setCross(Graph graph){
        for(int i=0;i<graph.path.routeList.size();i++){
            Vertex vertex=findVertex(graph.path.routeList.get(i));
            for (Vertex vertex1:graph.vertices){
                if (vertex.name.equals(vertex1.name)){
                    vertex1.crossTime++;
                }
            }
        }

   }

    public void path1(String src,String dest,int speed,double swc,Graph graph){
        ArrayList<String> pathList=new ArrayList<>();
        List<Route> routesList=new ArrayList<Route>();
        pathList.add(src);
        printAllPathsUtil(src, dest, pathList,routesList);
        findAllRoutestimes(routesList,speed,swc, graph,src,dest);
    }

    private void printAllPathsUtil(String src,String dest, List<String> localPathlist,List<Route> routesList){
        int i=0;
        Vertex source=findVertex(src);
        for(Vertex vertex:vertices){
            if(source.name.equals(vertex.name)){
                break;
            }
            else i++;
        }
        vertices.get(i).visit=true;
        if(src.equals(dest)){
            Route route=new Route();
            for(String s:localPathlist){
                route.routeList.add(s);
            }
            routesList.add(route);

        }
        for(Vertex vertex:vertices.get(i).outgoing){
            if(!vertex.visit&&vertex.maintaince!=1){

                localPathlist.add(vertex.name);
                printAllPathsUtil(vertex.name,dest,localPathlist,routesList);
                localPathlist.remove(vertex.name);
            }
        }



    vertices.get(i).visit=false;

    }



    static class Vertex{
        String name;
       // DiGraph.Vertex prev=null;
        List<Vertex> incoming;
        List<Vertex> outgoing;
        boolean visit;
        int maintaince;
        int crossTime=0;

        public Vertex(String name){
            this.name=name;
            incoming=new ArrayList<>();
            outgoing=new ArrayList<>();
            this.visit=false;
            this.maintaince=0;

        }

        public void addOutgoing(Vertex vert)
        {
            outgoing.add(vert);
        }
    }

    class Edge{

        Vertex source;
        Vertex destination;
        double distance;
        int isActive;
        int broken;
        public Edge(String sourcename,String destname,double distance){
            source=findVertex(sourcename);
            if(source==null){
                source=new Vertex(sourcename);
                vertices.add(source);
            }
            destination=findVertex(destname);
            if(destination==null){
                destination=new Vertex(destname);
                vertices.add(destination);
            }
            this.distance=distance;
            this.broken=0;
            source.addOutgoing(destination);
        }
    }

}