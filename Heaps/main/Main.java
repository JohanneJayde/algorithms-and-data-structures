public class Main {

    public static void printArray(int [] arr){
        for(int element : arr){
            System.out.print( element + " ");
        }
    }
    
    public static void main(String[] args) {
        int [] arr = {2,5,6,1,4,3};



        System.out.print("unsorted array: ");
        printArray(arr);
        int [] sortedArray = methods.HeapSortAscending(arr);
        System.out.println();
        System.out.print("array after HeapSort in ascending order: ");
        printArray(sortedArray);


        int [] sortedArray2 = methods.HeapSortDescending(arr);
        System.out.println();
        System.out.print("array after HeapSort in descending order: ");
        printArray(sortedArray2);
        System.out.println();

    }
}