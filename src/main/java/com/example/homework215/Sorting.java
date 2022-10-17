package com.example.homework215;

import java.util.Random;
import java.util.function.Consumer;

public class Sorting {

    private static final Random RANDOM = new Random();



    public static void main(String[] args){
        double timeForBubblesSort = timeForSort(5, array -> sortBubble(array));
        System.out.println("Средняя время сортировки пузырьков " + timeForBubblesSort + " мс.");
        double timeForSelectionSort = timeForSort(5, array -> sortSelection(array));
        System.out.println("Средняя время сортировки выбором " + timeForSelectionSort + " мс.");
        double timeForInsertionSort = timeForSort(5, array -> sortInsertion(array));
        System.out.println("Средняя время сортировки вставками " + timeForBubblesSort + " мс.");
        
    }

    private static double timeForSort(int Iteration,
                                      Consumer<int[]> arrayConsumer){
        double sum = 0;
        for(int i = 0; i < iteration; i++){
            int[] array = generateArray(100_000);
            long start = System.currentTimeMillis();
            arrayConsumer.accept(array);
            long end = System.currentTimeMillis() - start;
            sum += end;
        }
        return sum / iteration;
    }

    private static int[] generateArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = RANDOM.nextInt (-100, 100);
        }
        return array;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
