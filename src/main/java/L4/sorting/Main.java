package L4.sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 17, 9, 100, 8, 4, 5, 0};
        System.out.println("min by double= " + Sort.getMInByDoubleSearch(arr));
        System.out.println("double pick sort= " + Arrays.toString(Sort.doublePickSort(arr)));
        arr = new int[]{1, 3, 17, 9, 100, 8, 4, 5, 0};
        System.out.println("pyramid sort= " + Arrays.toString(Sort.pyramidSort(arr)));
        System.out.println(Arrays.toString(arr));
        System.out.println("binary search= " + Sort.binarySearch(arr, 5));
        System.out.println("pow= " + Sort.getPow(10, 2));
        System.out.println("GCD=" + Sort.getGCD(7, 12));
        arr = new int[]{1, 3, 17, 9, 100, 8, 4, 5, 0};
        System.out.println("bubble sort= " + Arrays.toString(Sort.bubbleSort(arr)));
        arr = new int[]{1, 3, 17, 9, 100, 8, 4, 5, 0};
        System.out.println("input sort= " + Arrays.toString(Sort.inputSort(arr)));
        arr = new int[]{1, 3, 17, 9, 100, 8, 4, 5, 0};
        System.out.println("quick sort= " + Arrays.toString(Sort.quickSort(arr)));
    }
}