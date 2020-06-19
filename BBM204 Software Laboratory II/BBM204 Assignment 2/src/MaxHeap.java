import java.util.Arrays;


public class MaxHeap {

    String[] heap;
    int size;
    public MaxHeap(String[] heap) {
        this.size = heap.length;
        this.heap = Arrays.copyOf(heap, size);
    }


    public void maxHeapify(int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && heap[index].compareTo( heap[leftIndex]) <0) {
            largest = leftIndex;
        }
        if (rightIndex < size && heap[largest].compareTo(heap[rightIndex]) <0 ) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }


    public void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        String temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }
    public int maxind(PriorityQueue priorityQueue,MaxHeap maxHeap) {
        int index=0;
        for (int i = 0; i < priorityQueue.queue_List.size(); i++) {
            if (maxHeap.heap[0].equals(priorityQueue.queue_List.get(i))) {
               index=i;
            }

        }
        return index;
    }

}