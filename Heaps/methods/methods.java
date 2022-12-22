public class methods {
    public static int [] HeapSortAscending(int [] arr){
        Heap heap = new Heap(arr);
        heap.buildMaxHeap();
        int [] heapElements = heap.getHeapElements();
        for(int i = heap.getHeapSize(); i >= 1; i--){
            heap.swapElements(i, 0);
            heap.decraseSize();
            heap.maxHeapify(0);
        }

        return heap.getHeapElements();

    }

    public static int [] HeapSortDescending(int [] arr){
        Heap heap = new Heap(arr);
        heap.buildMinHeap();
        int [] heapElements = heap.getHeapElements();
        for(int i = heap.getHeapSize(); i >= 1; i--){
            heap.swapElements(i, 0);
            heap.decraseSize();
            heap.minHeapify(0);
        }

        return heap.getHeapElements();

    }

}
