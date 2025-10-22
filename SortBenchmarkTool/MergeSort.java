/**
 * =============================================
 *  Class: MergeSort
 *  Project: SortBenchmarkTool / Sorting Algorithms
 *  Author: Vladimir K. (@vkir090)
 *  Date:   2025-10-10
 * =============================================
 *
 * Description:
 * Implementation of the MergeSort algorithm based on
 * the divide-and-conquer paradigm. The array is recursively
 * divided into halves and merged back into a sorted sequence.
 * Includes an optional runtime comparison with Arrays.sort().
 *
 * Key Concepts:
 * - Recursion and divide-and-conquer thinking
 * - Splitting and merging subarrays efficiently
 * - Benchmarking against Java's built-in sorting
 *
 * Example:
 * int[] arr = {8, 3, 5, 2, 9, 1, 4, 7, 6};
 * int[] sorted = MergeSort.divide(arr);
 *
 * License:
 * MIT License – free for educational and commercial use.
 */

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nichtSortiert = {8, 3, 5, 2, 9, 1, 4, 7, 6};

        // Sortierung mit selbstgeschriebener Methode
        int[] sortiert = divide(nichtSortiert);

        System.out.println("MergeSort Ergebnis:");
        for (int a : sortiert) System.out.print(a + " ");
        System.out.println("\n");

        // Vergleich mit Java Arrays.sort()
        long start = System.nanoTime();
        Arrays.sort(nichtSortiert);
        long end = System.nanoTime();

        System.out.println("Arrays.sort Zeit: " + (end - start) + " ns");
    }

    // --- Rekursive Division ---
    public static int[] divide(int[] arr) {
        if (arr.length == 1) return arr;

        int mitte = arr.length / 2;
        int[] links = Arrays.copyOfRange(arr, 0, mitte);
        int[] rechts = Arrays.copyOfRange(arr, mitte, arr.length);

        return merge(divide(links), divide(rechts));
    }

    // --- Zusammenführung (Merge) ---
    public static int[] merge(int[] links, int[] rechts) {
        int[] merged = new int[links.length + rechts.length];
        int l = 0, r = 0, m = 0;

        while (l < links.length && r < rechts.length) {
            if (links[l] <= rechts[r]) merged[m++] = links[l++];
            else merged[m++] = rechts[r++];
        }

        while (l < links.length) merged[m++] = links[l++];
        while (r < rechts.length) merged[m++] = rechts[r++];

        return merged;
    }
}
