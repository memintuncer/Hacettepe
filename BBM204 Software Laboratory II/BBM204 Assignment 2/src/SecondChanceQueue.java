import java.util.ArrayList;
import java.util.List;

public class SecondChanceQueue {
    List<String> queue_List = new ArrayList<String>();

    public void enqueue(List<String> commandlist, int size1,int size2,SecondChanceQueue queue,BinarySearchTree tree ,List<String> seconchance){
        int pf=0;
        int index=0;
        List<String> outlist=new ArrayList<String>();
        int sec=0;
        for (String command:commandlist) {

            if (size1 < size2) {
                if (tree.search2(tree.root, command)) {
                    tree.second_chance(tree.root,command);
                    seconchance.add(command);

                    System.out.print("                  ");
                    for (String commands : queue.queue_List) {
                        System.out.print( commands + " ");
                    }
                    System.out.println();

                } else {
                    size1++;
                    System.out.print("Page Fault        ");

                    pf++;
                    queue.queue_List.add(command);

                    tree.insert(command);
                    for (String commands : queue.queue_List) {
                        System.out.print(commands + " ");
                    }
                    System.out.println();

                }

            }
            else if(size1>=size2){
                if(tree.search2(tree.root,command)){
                    seconchance.add(command);
                    System.out.print("                  ");
                    for(String commands: queue.queue_List){
                        System.out.print(commands+" ");
                    }
                    System.out.println();

                }
                else {

                    while (seconchance.size()!=0){
                        if(seconchance.contains(queue.queue_List.get(index))){
                            outlist.add(queue.queue_List.get(index));
                            seconchance.remove(queue.queue_List.get(index));
                            index++;
                            sec=1;
                        }
                        else {
                            break;
                        }
                    }

                    index=index%4;
                    queue.queue_List.set(index,command);
                    if(index<size2){
                        index++;
                    }
                    if(index>=size2){
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
                    if(sec==1){
                        System.out.print("      Second Chance"+"    ");
                        for(String s:outlist){
                            System.out.print(s+" ");
                        }
                        outlist.clear();
                    }
                    sec=0;
                    System.out.println();

                }
            }
        }
        System.out.println(pf);
    }

}


