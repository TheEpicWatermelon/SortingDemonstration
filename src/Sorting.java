/* [Sorting.java]
 * This program is a template for a comparing sorting algorithms
 * Random numbers are generated and tested with various sorting algorithms
 */

import java.util.Random;
import java.util.Arrays;

class Sorting {

    /** Main method *******************************************
     * @param args
     */
    public static void main(String[] args) {

        int data[] = generateNumberArray(10);
        int[] tempArray; // a temp holder for data as it is passed to methods
        long startTime, endTime;
        double elapsedTime;

        System.out.println("Array generated: ");
        displayArray(data);


        //Testing Selection Sort -----------------
        System.out.println("\nSorting with Selection sort:");
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        startTime = System.nanoTime();     //start time

        tempArray = selectionSort(tempArray);

        endTime = System.nanoTime();  //end time
        elapsedTime = (endTime - startTime) / 1000000.0;

        displayArray(tempArray);
        System.out.println("The sort took: " + elapsedTime + "ms");


        //Testing Bubble Sort -----------------
        System.out.println("\nSorting with Bubble sort:");
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        startTime = System.nanoTime();     //start time

        tempArray = bubbleSort(tempArray);

        endTime = System.nanoTime();  //end time
        elapsedTime = (endTime - startTime) / 1000000.0;

        displayArray(tempArray);
        System.out.println("The sort took: " + elapsedTime + "ms");

        //Testing Insertion Sort -----------------
        System.out.println("\nSorting with Insertion sort:");
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        startTime = System.nanoTime();     //start time

        tempArray = insertionSort2(tempArray);

        endTime = System.nanoTime();  //end time
        elapsedTime = (endTime - startTime) / 1000000.0;

        displayArray(tempArray);
        System.out.println("The sort took: " + elapsedTime + "ms");

        //Testing Merge Sort -----------------
        System.out.println("\nSorting with Merge sort:");
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        startTime = System.nanoTime();     //start time

        tempArray = mergeSort(tempArray);

        endTime = System.nanoTime();  //end time
        elapsedTime = (endTime - startTime) / 1000000.0;

        displayArray(tempArray);
        System.out.println("The sort took: " + elapsedTime + "ms");

        //Testing Quick Sort -----------------
        System.out.println("\nSorting with Quick sort:");
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        startTime = System.nanoTime();     //start time

        quickSort(tempArray, 0 , tempArray.length-1);

        endTime = System.nanoTime();  //end time
        elapsedTime = (endTime - startTime) / 1000000.0;

        displayArray(tempArray);
        System.out.println("The sort took: " + elapsedTime + "ms");


        //Testing Arrays.sort -----------------
        System.out.println("\nSorting with Arrays.sort sort:");
        tempArray = Arrays.copyOf(data,data.length);  //to keep original arrays safe from modification
        startTime = System.nanoTime();     //start time

        tempArray = javaBuiltInSort(tempArray);

        endTime = System.nanoTime();  //end time
        elapsedTime = (endTime - startTime) / 1000000.0;

        displayArray(tempArray);
        System.out.println("The sort took: " + elapsedTime + "ms");

    } //end of main method


    /** generateNumberArray *******************************************
     * Creates a random array on integers
     * @param numOfElements size of array
     * @return the generated integer array
     */
    public static int[] generateNumberArray(int numOfElements) {

        int[] generated = new int[numOfElements];

        //add unique numbers into array in order
        for (int i = 0 ; i< generated.length;i++)
            generated[i]=i;

        //shuffle the numbers randomly
        Random randomNumber = new Random();
        for (int i = 0 ; i< generated.length;i++) {
            //swap to random positions
            int temp;
            int first = randomNumber.nextInt(generated.length);
            int second = randomNumber.nextInt(generated.length);
            temp = generated[first];
            generated[first]=generated[second];
            generated[second]=temp;
        }

        return generated;
    } //end of generateNumberArray


    /** displayArray *******************************************
     * displays an array to the console
     * @param numbers integer array
     */
    public static void displayArray(int[] numbers) {
        for (int i = 0 ; i< numbers.length;i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println("");
    }

    /** selectionSort *******************************************
     * Sorts a random array of integers using selection sort
     * @param numbers unsorted integer array
     * @return the sorted integer array
     */
    public static int[] selectionSort(int[] numbers) {
        //******* Your code here *************
        return numbers;

    }

    /** bubbleSort *******************************************
     * Sorts a random array of integers using bubble sort
     * @param numbers unsorted integer array
     * @return the sorted integer array
     */
    public static int[] bubbleSort(int[] numbers) {
        //******* Your code here *************
        return numbers;
    }

    /** insertionSort *******************************************
     * Sorts a random array of integers using insertion sort
     * @param numbers unsorted integer array
     * @return the sorted integer array
     */
    public static int[] insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int index = i -1;
            int item = numbers[i];
            while( (index>=0) && (numbers[index]>item)){
                numbers[index+1] = numbers[index];
                index --;
            }
            numbers[index+1] = item;
        }
        return numbers;
    }

    public static int[] insertionSort2(int[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            int item = numbers[i];
            int position = i-1;
            insert(numbers, item, position);
        }

        return numbers;
    }

    private static void insert(int[] numbers, int item, int position) {
        if (position == 0){
            if (item < numbers[position]){
                numbers[position+1] = numbers[position];
                numbers[position] = item;
                return;
            }else {
                return;
            }
        } else if (item > numbers[position]){
            return;
        }

        numbers[position + 1] = numbers[position];
        numbers[position] = item;
        insert(numbers,item, position-1);
    }

    /** mergeSort *******************************************
     * Sorts a random array of integers using merge sort
     * @param numbers unsorted integer array
     * @return the sorted integer array
     */
    public static int[] mergeSort(int[] numbers){
        int[] tempArray = new int[numbers.length];
        merge(numbers,0, numbers.length, tempArray);
        return tempArray;
    }

    public static void merge(int[] numbers, int start, int end, int[] tempArray){
        if( (end - start) < 2){
            return;
        }
        int mid = (start + end)/2;
        merge(numbers,start,mid, tempArray);
        merge(numbers,mid,end, tempArray);
        combine(numbers, start, mid, end, tempArray);
    }

    public static void combine(int[] numbers, int start, int mid, int end, int[] newNumbers){
        int count = start;
        int firstIndex = start;
        int secondIndex = mid;

        while(count < end){
            if (firstIndex >= mid && secondIndex<end){
                newNumbers[count] = numbers[secondIndex];
                count++;
                secondIndex++;
            } else if (firstIndex < mid && secondIndex >= end){
                newNumbers[count] = numbers[firstIndex];
                count++;
                firstIndex++;
            } else if (numbers[firstIndex] > numbers[secondIndex]){
                newNumbers[count] = numbers[secondIndex];
                count++;
                secondIndex++;
            } else if (numbers[firstIndex] < numbers[secondIndex]){
                newNumbers[count] = numbers[firstIndex];
                count++;
                firstIndex++;
            } else{
                return;
            }
        }

        for(int i = start; i<end;i++){
            numbers[i]=newNumbers[i];
        }
    }




    /** quickSort *******************************************
     * Sorts a random array of integers using quick sort
     * @param numbers unsorted integer array
     * @return the sorted integer array
     */
    static void quickSort(int[] numbers, int start, int end) {
        int pivot = (start+end)/2;

        int i = start;
        int j = end;


        while (i <= j) {
            while (numbers[i] < numbers[pivot]) {
                i++;
            }
            while (numbers[j] > numbers[pivot]) {
                j--;
            }
            if (i <= j) {
                int temp = numbers[i];
                numbers[i]=numbers[j];
                numbers[j]=temp;
                i++;
                j--;
            }
        }
        if(start < j)
            quickSort(numbers,start,j);
        if(i < end)
            quickSort(numbers,i,end);

    }


    /** javaBuiltInSort *******************************************
     * Sorts a random array of integers using Arrays.sort
     * @param numbers unsorted integer array
     * @return the sorted integer array
     */
    public static int[] javaBuiltInSort( int[] numbers) {
        Arrays.sort(numbers);  //sort
        return numbers;
    }

}