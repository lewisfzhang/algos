package Sorting;

import java.util.Arrays;
import java.util.Random;

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
        // sort(arr, 0, arr.length-1); 
        quicksort(arr, 0, arr.length-1); 
    }

    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
       static int partition2(int arr[], int low, int high) 
       { 
           int pivot = arr[high];  
           int i = (low-1); // index of smaller element 
           for (int j=low; j<high; j++) 
           { 
               // If current element is smaller than the pivot 
               if (arr[j] < pivot) 
               { 
                   i++; 
     
                   // swap arr[i] and arr[j] 
                   int temp = arr[i]; 
                   arr[i] = arr[j]; 
                   arr[j] = temp; 
               } 
           } 
     
           // swap arr[i+1] and arr[high] (or pivot) 
           int temp = arr[i+1]; 
           arr[i+1] = arr[high]; 
           arr[high] = temp; 
     
           return i+1; 
       } 
     
     
       /* The main function that implements QuickSort() 
         arr[] --> Array to be sorted, 
         low  --> Starting index, 
         high  --> Ending index */
       static void sort(int arr[], int low, int high) 
       { 
           if (low < high) 
           { 
               /* pi is partitioning index, arr[pi] is  
                 now at right place */
               int pi = partition2(arr, low, high); 
     
               // Recursively sort elements before 
               // partition and after partition 
               sort(arr, low, pi-1); 
               sort(arr, pi+1, high); 
           } 
       } 

    static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quicksort(arr, 0, pivot-1);
            quicksort(arr, pivot+1, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int idx = left, pivot = arr[right];  // pivot = last element
        for (int i=left; i<right; i++) {
            if (arr[i] < pivot) {
                // swap(arr, i, idx);
                int swp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = swp;
                idx++;
            }
        }
        // swap(arr, idx, right);
        int swp = arr[idx];
        arr[idx] = arr[right];
        arr[right] = swp;
        return idx;
    }

    static void swap(int[] arr, int i, int j) {
        int swp = arr[i];
        arr[i] = arr[j];
        arr[j] = swp;
    }

}