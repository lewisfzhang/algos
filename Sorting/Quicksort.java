package Sorting;

import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;

public class Quicksort {
    public static void main(String[] args) {
        int len = 50;

        int[] arr1 = randomArray(len), arr2 = new int[len];
        System.arraycopy(arr1, 0, arr2, 0, len);

        quicksort(arr1);
        Arrays.sort(arr2);

        System.out.println("Properly sorted? "+Arrays.equals(arr1, arr2));
    }

    static int[] randomArray(int len) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
            // System.out.println(arr[i]); // printing each array element
        }
        return arr;
    }

    static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length-1); 
    }

    static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quicksort(arr, 0, left-1);
            quicksort(arr, left+1, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int idx = left, pivot = arr[right];  // pivot = last element
        for (int i=left; i<right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, idx);
                idx++;
            }
        }
        swap(arr, idx, right);
        return idx;
    }

    static void swap(int[] arr, int i, int j) {
        int swp = arr[i];
        arr[i] = arr[j];
        arr[j] = swp;
    }

}