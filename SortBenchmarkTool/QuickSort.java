import java.util.Arrays;

/**
 * QuickSort – Eigenimplementierung
 *
 * Beschreibung:
 * Dieses Programm sortiert ein Integer-Array mit dem QuickSort-Algorithmus.
 * Es verwendet das Divide-and-Conquer-Prinzip:
 *  - Das Array wird in zwei Teilbereiche geteilt,
 *  - Elemente kleiner als das Pivot kommen nach links,
 *  - größere nach rechts.
 * Danach wird der Vorgang rekursiv auf die Teilbereiche angewendet.
  */
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
