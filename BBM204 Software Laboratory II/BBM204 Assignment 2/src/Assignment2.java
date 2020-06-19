import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Assignment2 {
    public static void main(String[] args) throws IOException {
        List<String> lineList = new ArrayList<String>();
        List<String> commandList_fifo = new ArrayList<String>();
        List<String> commandList_pr = new ArrayList<String>();
        List<String> commandList_sc = new ArrayList<String>();
        List<String> queueList = new ArrayList<String>();
        List<String> seconchance = new ArrayList<String>();
        int size1 = 0;
        int size2=0;
        FileRead fileRead=new FileRead();
        lineList=fileRead.getLines(args[0]);
        FIFOqueue queue1=new FIFOqueue();
        PriorityQueue queue2=new PriorityQueue();
        SecondChanceQueue queue3=new SecondChanceQueue();
        size2=fileRead.createSeconChanceQue(lineList,size2);

        queue1.size=fileRead.createEmptyFifoqueue(lineList,size1);
        queue1.queue_List=queueList;
        queue2.size=fileRead.createEmptyPrQueue(lineList,size1);
        fileRead.getcommands(lineList,commandList_fifo);
        fileRead.getcommands(lineList,commandList_pr);
        fileRead.getcommands(lineList,commandList_sc);
        BinarySearchTree tree_fifo = new BinarySearchTree();
        BinarySearchTree tree_pr = new BinarySearchTree();
        BinarySearchTree tree_sc = new BinarySearchTree();
        String command[]=lineList.get(1).split(" ");
        PrintStream o = new PrintStream(new File("output.txt"));
        if(command[1].equals("FIFO")){
            System.setOut(o);
            System.out.println("Memory"+queue1.size);
            System.out.println("FIFO Page Replacement");
            System.out.println("Binary Search Tree");
            double startTime = System.nanoTime();
            queue1.enqueue(commandList_fifo,size2,queue1,tree_fifo);
            double endTime   = System.nanoTime();
            double totalTime = endTime - startTime;
            System.out.println("Time              "+totalTime/1000000000+ "   Seconds");
        }
        if(command[1].equals("PriorityQueue")){
            System.setOut(o);
            System.out.println("Memory"+queue1.size);
            System.out.println("PriorityQueue Page Replacement");
            System.out.println("Binary Search Tree");
            double startTime = System.nanoTime();
            queue2.enqueue(commandList_pr,size2,queue2,tree_pr);
            double endTime   = System.nanoTime();
            double totalTime = endTime - startTime;
            System.out.println("Time              "+totalTime/1000000000+ "   Seconds");
        }
        if(command[1].equals("SecondChance")){
            System.setOut(o);
            System.out.println("Memory"+queue1.size);
            System.out.println("SecondChance Page Replacement");
            System.out.println("Binary Search Tree");
            double startTime = System.nanoTime();
            queue3.enqueue(commandList_sc,size1,size2,queue3,tree_sc,seconchance);
            double endTime   = System.nanoTime();
            double totalTime = endTime - startTime;
            System.out.println("Time              "+totalTime/1000000000+ "   Seconds");
        }
    }
}
