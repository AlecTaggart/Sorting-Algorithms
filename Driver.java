
public class Driver {

    public static void main(String[] args) {
        Comparable[] test = new Comparable[]{14, 7, 11, 30, 1};
        Comparable[] array = new Comparable[]{8, 24, 6, 12, 20, 14, 7};
        Comparable[] array2 = new Comparable[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array3 = new int[]{824, 246, 624, 126, 201, 149, 756, 111, 307, 107};
        System.out.println("Original Array");
      

        SortingAlgorithms sort = new SortingAlgorithms();
        //sort.externalSort("inputFile", "outputFile", 1000000, 100000);

     



// BUCKET
       Record one = new Record(8, "test");
       Record two = new Record(24, "test");
       Record three = new Record(6, "test");
       Record four = new Record(12, "test");
       Record five = new Record(20, "test");
       Record six = new Record(14, "test");
       Record seven = new Record(7, "test");
       Record eight = new Record(11, "test");
       Record nine = new Record(30, "test");
       Record ten = new Record(1, "test");
       // SortingAlgorithms sort = new SortingAlgorithms();
       Record[] records = new Record[]{one, two, three, four, five, six, seven, eight, nine, ten};
       for(int i = 0; i < records.length; i++){
           System.out.print(records[i].getKey() + " ");
       }
       sort.bucketSort(records, 0, 9, false);
       System.out.println("\nSorted Array");
       for(int i = 0; i < records.length; i++){
           System.out.print(records[i].getKey() + " ");
       }System.out.println("");





    }
}
