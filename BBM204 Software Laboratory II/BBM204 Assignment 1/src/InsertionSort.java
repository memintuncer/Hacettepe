import java.util.List;

public class InsertionSort {


    void insertionSort(List<Item> itemlist) {
        int i, j;
        Item newValue;
        for (i = 1; i < itemlist.size(); i++) {
            newValue =itemlist.get(i);
            j = i;
            while (j > 0 && itemlist.get(j-1).value  > newValue.value) {
                itemlist.set(j,itemlist.get(j-1));
                j--;
            }
            itemlist.set(j,newValue);
        }
    }

}
