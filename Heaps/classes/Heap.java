public class Heap {

    //heapElements stores the elements of a heap in an Object array
    private int[] heapElements;
    //heapSize stores the size of the heap, meaning how many elements are in a given heap
    private int heapSize;

    //Heap EVC that takes in an Object array that represents the elements of a Heap and heapSize represents the size of the Heap
    public Heap(int[] arr) {
        this.heapElements = arr;
        this.heapSize = arr.length -1;
    }

    //minHeapify method rearranges the element at a given heap in order to maintain heap order. This is a minHeap, so it ensures that the given
    //element at param index will be the largest element of the current element, right child, and left child.
    public void minHeapify(int index) {
        //if the given index is larger than the Heap's size, then throw an out-of-bounds exception
        if (index > heapSize) {
            throw new IndexOutOfBoundsException("cannot minHeapify, index larger than heap size");
        }

        //index is larger than this value, then it must be a leaf node to which we need not heapify it
        if (index > (int) Math.floor((heapSize/2) + 1)){
            return;
        };

        //this stores the index of the left child element of the current element
        int leftIndex = 2 * index + 1;
        //this stores the index of the right child element of the current element
        int rightIndex = 2 * index + 2;

        //a complete binary tree may have it's last element be a left child without a corresponding right child
        //this if-statement is used to deal with that case along with dealing if the current element has not children.
        if (rightIndex > heapSize) {
            //if leftIndex is also found to be larger than the Heap's size, then that means that the current element is a
            //leaf node. A leaf node cannot be heapified further so we do not have to take any action.
            if (leftIndex > heapSize) {
                return;
            }
            //if the element at the element is not null, we must check if it is smaller than the current element
            //to check if we need to swap the elements. We have no need to go further down into the tree because
            //a single left child element is a way to indicate the last node in a complete binary tree
            if (heapElements[index] > this.getLeftChild(index)) {
                swapElements(index, leftIndex);
            }
        }
        //else-statement handles the general case that an element is within the heap, guaranteeing that it has a left
        //and right child element
        else {
            //checking whether the left child of the current element is the smallest of the current and right child
            //element. If it is, then we need to swap it with the current element and then go into the left subtree and
            //continue to fix the Heap
            if (heapElements[index] > heapElements[leftIndex] && heapElements[rightIndex] > heapElements[leftIndex]) {
                swapElements(index, leftIndex);
                minHeapify(leftIndex);
            }
            //checking whether the right child of the current element is the smallest element in which we will have to swap
            //it and the current element and then go deeper into the right subtree.
            if (heapElements[index] > heapElements[rightIndex] && heapElements[leftIndex] > heapElements[rightIndex]) {
                swapElements(index, rightIndex);
                minHeapify(rightIndex);
            }
        }

    }
    //buildMaxHeap() is used to convert an entire array into a Min Heap.
    public void buildMinHeap(){
        //for-loop calls minHeapify() for each element in a heap, starting at the last inner element and going backwards
        for(int i = (int) Math.floor((heapSize/2) + 1); i >= 0; i--){
            this.minHeapify(i);
        }
    }
    //This is heapfiy() method that will ensure heap order but for a max Heap
    public void maxHeapify(int index) {
        //if the given index is larger than the Heap's size, then throw an out-of-bounds exception
        if (index > heapSize) {
            throw new IndexOutOfBoundsException("cannot maxHeapify, index: "+ index +" larger than heap size: " + heapSize);
        }

        //index is larger than this value, then it must be a leaf node to which we need not heapify it
        if (index > (int) Math.floor((heapSize/2) + 1)){
            return;
        };

        //this stores the index of the left child element of the current element
        int leftIndex = 2 * index + 1;
        //this stores the index of the right child element of the current element
        int rightIndex = 2 * index + 2;

        //a complete binary tree may have it's last element be a left child without a corresponding right child
        //this if-statement is used to deal with that case along with dealing if the current element has not children.
        if (rightIndex > heapSize) {
            //if leftIndex is also found to be larger than the Heap's size, then that means that the current element is a
            //leaf node. A leaf node cannot be heapified further so we do not have to take any action.
            if (leftIndex > heapSize) {
                return;
            }
            //This just checks if the last leaf element is larger or smaller than the current element and if a swap
            //should happen.
            if (heapElements[index] < this.getLeftChild(index)) {
                swapElements(index, leftIndex);
            }
        }
        //else-statement handles the general case that an element is within the heap, guaranteeing that it has a left
        //and right child element.
        else {
            //checking if the left child of the current element is the largest of it, and its right sibling.
            if (heapElements[index] < heapElements[leftIndex] && heapElements[rightIndex] < heapElements[leftIndex]) {
                swapElements(index, leftIndex);
                maxHeapify(leftIndex);
            }
            //checking if the right child of the current element is the largest of it, and its left sibling.
            if (heapElements[index] < heapElements[rightIndex] && heapElements[leftIndex] < heapElements[rightIndex]) {
                swapElements(index, rightIndex);
                maxHeapify(rightIndex);
            }
        }

    }

    //buildMaxHeap() converts an array into a max Heap.
    public void buildMaxHeap(){
        //for-loop calls maxHeapify() for each element in a heap, starting at the last inner element and going backwards
        for(int i = (int) Math.floor((heapSize/2) + 1); i >= 0; i--){
            this.maxHeapify(i);
        }
    }

    //swapElements() swaps two elements in a Heap using their indices
    public void swapElements(int a, int b) {
        int temp = heapElements[a];
        heapElements[a] = heapElements[b];
        heapElements[b] = temp;
    }

    //getter method that returns the right child element of the element stored at index parent.
    public int getRightChild(int parent) {
        return heapElements[2 * parent + 2];
    }

    //getter method that returns the left child element of the element stored at index parent.
    public int getLeftChild(int parent) {
        return heapElements[2 * parent + 1];
    }

    //returns the array that represents the heap elements
    public int[] getHeapElements() {
        return this.heapElements;
    }

    //returns the heap element at the given param index
    public int getElement(int index) {
        return  this.heapElements[index];
    }

    public void decraseSize(){
        this.heapSize--;
    }

    public int getHeapSize(){
        return this.heapSize;
    }

    //toString method returns the Heap's string representation
    @Override
    public String toString() {
        StringBuilder heapString = new StringBuilder();
        for (Object element : heapElements) {
            heapString.append(element + " ");
        }
        return heapString.toString();
    }

}
