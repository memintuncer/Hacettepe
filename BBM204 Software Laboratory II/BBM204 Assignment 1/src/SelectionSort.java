
import java.util.List;
public class SelectionSort {

    public void selectionSort(List<Item> itemlist){
        int i, j, minIndex;
        Item tmp;
        int n =itemlist.size();
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                if (itemlist.get(j).value <itemlist.get(minIndex).value)
                    minIndex = j;

            if (minIndex != i) {
                tmp =itemlist.get(i);
                itemlist.set(i,itemlist.get(minIndex));
                itemlist.set(minIndex,tmp);
            }

        }

    }
}
