import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    Heap heap;

    @BeforeEach
    void setUp() {

        int[] heapElements = {100, 5, 20, 9, 7, 19, 10, 12, 16, 13};
        int heapSize = heapElements.length - 1;
        heap = new Heap(heapElements);

    }

    @AfterEach
    void tearDown() {
        heap = null;
    }

    @Test
    void minHeapify_normalBehavior() {
        System.out.println("Testing heapify() method's normal behavior");

        heap.minHeapify(0);
        assertEquals("5 7 20 9 13 19 10 12 16 100 ", heap.toString());

    }

    @Test
    void buildMinHeap_normalBehavior() {
        System.out.println("Testing buildMinHeap() method's normal behavior");

        heap.buildMinHeap();
        assertEquals("5 7 10 9 13 19 20 12 16 100 ", heap.toString());
    }

    @Test
    void maxHeapify_normalBehavior() {
        System.out.println("Testing heapify() method's normal behavior");

        heap.maxHeapify(1);
        assertEquals("100 9 20 16 7 19 10 12 5 13 ", heap.toString());

    }

    @Test
    void buildMaxHeap_normalBehavior() {
        System.out.println("Testing buildMinHeap() method's normal behavior");

        heap.buildMaxHeap();
        assertEquals("100 16 20 12 13 19 10 5 9 7 ", heap.toString());
    }
    @Test
    void swapElements_normalBehavior() {
        heap.swapElements(0, 4);
        assertEquals(7, heap.getElement(0));
        assertEquals(100, heap.getElement(4));
    }

    @Test
    void rightChild_normalBehavior() {
        assertEquals(7, heap.getRightChild(1));
        assertEquals(10, heap.getRightChild(2));
    }

    @Test
    void leftChild_normalBehavior() {
        assertEquals(5, heap.getLeftChild(0));
        assertEquals(19, heap.getLeftChild(2));
    }

    @Test
    void heapSize_test(){
        assertEquals(9, heap.getHeapSize());
    }
}