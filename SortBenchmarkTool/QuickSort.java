/**
 * =============================================
 *  Class: QuickSort
 *  Project: SortBenchmarkTool / Sorting Algorithms
 *  Author: Vladimir K. (@vkir090)
 *  Date:   2025-10-17
 * =============================================
 *
 * Description:
 * Implementation of the QuickSort algorithm using
 * the divide-and-conquer paradigm. The array is
 * partitioned around a pivot element:
 *  - Elements smaller than the pivot go to the left,
 *  - Elements greater than the pivot go to the right.
 * The algorithm then recursively sorts the sub-arrays.
 *
 * Key Concepts:
 * - Divide and Conquer
 * - Recursion and pointer movement
 * - Runtime behavior and pivot selection
 *
 * Example:
 * int[] arr = {8, 3, 5, 2, 9, 1, 4, 7, 6};
 * QuickSort.quickSort(arr, 0, arr.length - 1);
 *
 * License:
 * MIT License – free for educational and commercial use.
 */

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // Beispiel-Array (unsortiert)
        int[] nichtSortiert = {8, 3, 5, 2, 9, 1, 4, 7, 6};

        // Zeitmessung starten
        long start = System.nanoTime();
        quickSort(nichtSortiert, 0, nichtSortiert.length - 1);
        long end = System.nanoTime();

        // Ergebnis ausgeben
        System.out.println("QuickSort Ergebnis:");
        for (int a : nichtSortiert) {
            System.out.print(a + " ");
        }

        System.out.println("\nZeit: " + (end - start) + " ns");
    }

    /**
     * QuickSort-Algorithmus (rekursiv)
     *
     * @param arr   Array, das sortiert werden soll
     * @param start Startindex
     * @param end   Endindex
     */
    public static void quickSort(int[] arr, int start, int end) {
        // Abbruchbedingung: nur ein oder kein Element
        if (start >= end) return;

        // Pivot wählen – mittleres Element
        int pivotPos = start + (end - start) / 2;
        int pivot = arr[pivotPos];

        // Zeiger für linke und rechte Seite
        int l = start;
        int r = end;

        // Partitionierung: Werte kleiner/ größer als Pivot anordnen
        while (l <= r) {
            // Linken Zeiger bewegen, bis Element >= Pivot
            while (arr[l] < pivot) l++;

            // Rechten Zeiger bewegen, bis Element <= Pivot
            while (arr[r] > pivot) r--;

            // Elemente tauschen, wenn Zeiger sich noch nicht überkreuzt haben
            if (l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        // Rekursion auf die beiden Teilbereiche
        if (start < r) quickSort(arr, start, r);
        if (l < end) quickSort(arr, l, end);
    }
}
