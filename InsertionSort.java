import java.util.Scanner;
public class InsertionSort {
    public static void main(String[] args) {
    InsertionSort insert = new InsertionSort();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the size of string array : ");
    int size = scanner.nextInt();

    String[] str = new String[size];

    System.out.println("Enter "+size+" strings in array : ");
    for(int i = 0; i < size; i++){
        str[i] = scanner.next();
    }
    System.out.println("\nStrings in array are as follows : ");
    for(int i = 0; i < size; i++){
        System.out.print(str[i]+",");
    }

    // creating object for generics class to get insertion method
    InsertionSortImplementation<String> genericsInsert = new InsertionSortImplementation(str);

    String[] sortedString = genericsInsert.insertionSort();
    System.out.println();
    System.out.println("\nSorted String is as follows : ");
    for(int i = 0; i < size; i++){
        System.out.print(sortedString[i] + ",");
    }

}


}

/**
 * Purpose : To create generics class to perform  Insertion Sort method
 * @param <T>
 */
class InsertionSortImplementation<T extends Comparable<T>>{

    //array which needs to be sorted
    T [] tArray;

    public InsertionSortImplementation(T[] tArray) {
        this.tArray = tArray;
    }

    /**
     * Purpose : To perform Insertion Sort :
     *          --> The array is virtually split into a sorted and an unsorted part.
     *          --> Values from the unsorted part are picked and placed at the correct position in the sorted part.
     *
     * @return sorted string
     */
    public T[] insertionSort(){
        int size = tArray.length;
        for ( int i = 1; i < size; i++){
            T temp = tArray[i];
            int j = i - 1;
            /**
             * Move elements of arr[0..i-1], that are greater than temp, to one position ahead
             * of their current position
             */
            while (j >= 0 && tArray[j].compareTo(temp)>0){

                tArray[j+1] = tArray[j];
                j--;

            }
            tArray[j+1] = temp;
        }
        return tArray;
    }
}