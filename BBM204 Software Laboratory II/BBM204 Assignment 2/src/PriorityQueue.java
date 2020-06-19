import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    public int size;
    List<String> queue_List = new ArrayList<String>();
    public void enqueue(List<String> commandlist, int size1, PriorityQueue queue, BinarySearchTree tree){
        int pf=0,index=0,size=0;
        for (String command:commandlist) {

            if(size<queue.size){
                if(tree.search2(tree.root,command)){
                    System.out.print("                  ");
                    for(String commands: queue.queue_List){
                        System.out.print(commands+" ");
                    }
                    System.out.println();
                }
                else  {
                    size++;
                    System.out.print("Page Fault        ");
                    pf++;
                    queue.queue_List.add(command);
                    String[] simpleArray = new String[ queue.queue_List.size() ];
                    queue.queue_List.toArray(simpleArray);
                    MaxHeap maxHeap=new MaxHeap(simpleArray);
                    maxHeap.buildMaxHeap();
                    tree.insert(command);

                    for(String commands: queue.queue_List){
                        System.out.print(commands+" ");
                    }
                    System.out.println();
                }
            }
            else if(size>=queue.size){
                if(tree.search2(tree.root,command)){
                    System.out.print("                  ");
                    for(String commands: queue.queue_List){
                        System.out.print(commands+" ");
                    }
                    System.out.println();
                }
                else {
                    String[] simpleArray = new String[ queue.queue_List.size() ];
                    queue.queue_List.toArray(simpleArray);
                    MaxHeap maxHeap=new MaxHeap(simpleArray);
                    maxHeap.buildMaxHeap();
                    int index1=maxHeap.maxind(queue,maxHeap);
                    queue.queue_List.set(index1,command);
                     simpleArray = new String[ queue.queue_List.size() ];
                    queue.queue_List.toArray(simpleArray);

                    MaxHeap maxHeap1=new MaxHeap(simpleArray);
                    maxHeap=maxHeap1;
                    if(index<queue.size){
                        index++;
                    }
                    if(index==queue.size){
                        index=0;
                    }
                    tree.deleteTree(tree.root);
                    tree.root=null;
                    for(String s:queue.queue_List){
                        tree.insert(s);
                    }
                    System.out.print("Page Fault        ");
                    pf++;

                    for(String commands: queue.queue_List){
                        System.out.print(commands+" ");
                    }
                    System.out.println();

                }
            }
        }
        System.out.println(pf);
    }
    }









