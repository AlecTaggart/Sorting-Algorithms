
public interface SortInterface {
    public void insertionSort(Comparable[] array, int lowindex, int highindex, boolean reversed);

    public void shakerSort(Comparable[] array, int lowindex, int highindex, boolean reversed);

    public void heapSort(Comparable[] array, int lowindex, int highindex, boolean reversed);

    public void randomizedQuickSort(Comparable[] array, int lowindex, int highindex, boolean reversed);

    public void hybridSort(Comparable[] array, int lowindex, int highindex, boolean reversed);

    public void bucketSort(Record[] array, int lowindex, int highindex, boolean reversed);

    public void radixSort(int[] array, int lowindex, int highindex, boolean reversed);

    public void externalSort(String inputFile, String outputFile, int n, int m);
}
