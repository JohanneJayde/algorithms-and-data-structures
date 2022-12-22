public class Main {

    public static void printArray(int [] arr){
        for(int element : arr){
            System.out.print( element + " ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {6,5,4,3,2,1};
        int [] arr2 = {1,2,3,4,5,6};

        int [] sortedArray = methods.HeapSortDescending(arr);
        int [] sortedArray2 = methods.HeapSortAscending(arr2);

        printArray(sortedArray);
        System.out.println();
        printArray(sortedArray2);

    }
}