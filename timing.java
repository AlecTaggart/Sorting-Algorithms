import java.util.Random;

public class timing {
    public static void main(String[] args) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        Comparable[] array = new Comparable[1000];
        Comparable[] array2 = new Comparable[1000];
        Random rand = new Random();


        for (int i = 0; i < 1000; i++)
            array[i] = (rand.nextInt(300));

        for (int i = 0; i < 1000; i++)
            array2[i] = (i);



        //QUICK SORT RUN TIMES

        long startTime = System.nanoTime();
        sortingAlgorithms.randomizedQuickSort(array, 0, array.length-1, false);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);//divide by 1000000 to get milliseconds.
        System.out.println("RandomizedQuickSort RunTime Random Non Reversed = " + duration);

        long startTime2 = System.nanoTime();
        sortingAlgorithms.randomizedQuickSort(array, 0, array.length-1, true);
        long endTime2 = System.nanoTime();

        long duration2 = (endTime2 - startTime2);//divide by 1000000 to get milliseconds.
        System.out.println("RandomizedQuickSort RunTime Random Reversed = " + duration2);


        long startTime6 = System.nanoTime();
        sortingAlgorithms.randomizedQuickSort(array2, 0, array2.length-1, false);
        long endTime6 = System.nanoTime();

        long duration6 = (endTime6 - startTime6);//divide by 1000000 to get milliseconds.
        System.out.println("RandomizedQuickSort RunTime SORTED non reversed = " + duration6);

        long startTime5 = System.nanoTime();
        sortingAlgorithms.randomizedQuickSort(array2, 0, array2.length-1, true);
        long endTime5 = System.nanoTime();

        long duration5 = (endTime5 - startTime5);//divide by 1000000 to get milliseconds.
        System.out.println("RandomizedQuickSort RunTime SORTED Reversed = " + duration5);





        //HYBRID SORT RUN TIMES

        long startTime3 = System.nanoTime();
        sortingAlgorithms.hybridSort(array, 0, array.length-1, false);
        long endTime3 = System.nanoTime();

        long duration3 = (endTime3 - startTime3);//divide by 1000000 to get milliseconds.
        System.out.println("HybridSort RunTime random Non Reversed = " + duration3);

        long startTime4 = System.nanoTime();
        sortingAlgorithms.hybridSort(array, 0, array.length-1, true);
        long endTime4 = System.nanoTime();

        long duration4 = (endTime4 - startTime4);//divide by 1000000 to get milliseconds.
        System.out.println("HybridSort RunTime random Reversed = " + duration4);


        long startTime7 = System.nanoTime();
        sortingAlgorithms.hybridSort(array2, 0, array2.length-1, false);
        long endTime7 = System.nanoTime();

        long duration7 = (endTime7 - startTime7);//divide by 1000000 to get milliseconds.
        System.out.println("HybridSort RunTime SORTED Non Reversed = " + duration7);

        long startTime8 = System.nanoTime();
        sortingAlgorithms.hybridSort(array2, 0, array2.length-1, true);
        long endTime8 = System.nanoTime();

        long duration8 = (endTime8 - startTime8);//divide by 1000000 to get milliseconds.
        System.out.println("HybridSort RunTime SORTED Reversed = " + duration8);
    }
}
