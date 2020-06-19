import java.util.List;

public class QuickSort {

    public int partition1(List<Item> itemlist, int left, int right) {
        int i = left, j = right;
        Item tmp;
        double pivot =itemlist.get((left+right)/2).value;
        while (i <= j) {

            while (itemlist.get(i).value < pivot)
                i++;

            while (itemlist.get(j).value > pivot)
                j--;

            if (i <= j) {
                tmp = itemlist.get(i);
                itemlist.set(i,itemlist.get(j));
                itemlist.set(j,tmp);
                i++;
                j--;
            }
        };
        return i;
    }


    public void quickSort1(List<Item> arr, int left, int right) {
        int index = partition1(arr, left, right);
        if (left < index - 1)
            quickSort1(arr, left, index - 1);
        if (index < right)
            quickSort1(arr, index, right);

       // System.out.println("Quick sort ==> "+ totalTime);
    }
}
