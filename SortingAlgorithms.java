
import java.io.*;
import java.util.*;

public class SortingAlgorithms implements SortInterface {
    public SortingAlgorithms(){

    }


    @Override
    public void insertionSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {
        if(reversed == false) {
            for (int i = lowindex + 1; i <= highindex; i++) {
                Comparable temp = array[i];
                int j = i;
                while ((j > lowindex) && (temp.compareTo(array[j - 1]) < 0)) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }else{
            for (int i = lowindex + 1; i <= highindex; i++) {
                Comparable temp = array[i];
                int j = i;
                while ((j > lowindex) && (temp.compareTo(array[j - 1]) > 0)) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }

        }
    }

    @Override
    public void shakerSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {
        int i, j; Comparable tmp;

        for (i = lowindex; i < highindex; i++) {
            if(reversed == false) {
                for (j = lowindex; j < highindex; j++)
                    if (array[j].compareTo(array[j]) > 0) {
                        tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }


                for (j = highindex; j > lowindex; j--)
                    if (array[j].compareTo(array[j - 1]) < 0) {
                        tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }
            }else{
                for (j = lowindex; j < highindex; j++)
                    if (array[j].compareTo(array[j]) < 0) {
                        tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }


                for (j = highindex; j > lowindex; j--)
                    if (array[j].compareTo(array[j - 1]) > 0) {
                        tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }

            }
        }
    }


    //START OF HEAP FUNCTIONS _________________________________________________________________________________________

    @Override
    public void heapSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {
        int size = array.length;
        System.out.println("size = "+ size);
        Comparable[] Heap = array;
        int i;
        Comparable temp;

        for (i = (size / 2)-1; i >= 0; i--) {
            //System.out.println("Build heap loop = " + i);
            pushdown(i, size, Heap);
        }
        System.out.println("built heap");
        for(int c = 0; c <=6; c++) {
            System.out.print(array[c] + " ");
        }

        System.out.println(" \n\n\n");
        int index = highindex+1;
        for (i = highindex; i >= lowindex; i--) {
            //System.out.println("sort loop variable = " + i);
            index = removeMAX(index, lowindex, highindex, Heap);
        }
    }

    private int leftchild(int pos) {
        return 2 * pos + 1;
    }
    private int rightchild(int pos) {
        return 2 * pos + 2;
    }

    private boolean isLeaf(int pos, int size) {
//        return ((pos > size / 2) && (pos <= size));
        if(leftchild(pos) >= size && rightchild(pos) >= size)
            return true;
        else
            return false;
    }

    //swap first int with second int
    private void swap(int pos1, int pos2, Comparable[]Heap) {
        Comparable tmp;
        tmp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = tmp;
    }

    public int removeMAX(int size, int low, int high, Comparable[] Heap) {
        swap(low, size-1, Heap);
        size = size - 1;
        //System.out.println(size);

        if (size != low) {
            //System.out.println("getting here");
            pushdown(low, size, Heap);
        }
        return size;
    }

    private void pushdown(int position, int size, Comparable[] Heap) {
        //System.out.println("Position for push down = " + position);
        int largestChild;
//        boolean cunt = !isLeaf(position, size);
//        System.out.println("while condition = " + cunt);
        while (!isLeaf(position, size)) {
            largestChild = leftchild(position);
            //System.out.println("largest child = " + largestChild);
            if ((largestChild < size) && (largestChild+1 < size) && (Heap[largestChild].compareTo(Heap[largestChild + 1]) < 0))
                largestChild = largestChild + 1;

            //System.out.println(Heap[position]);
            if (Heap[position].compareTo(Heap[largestChild]) > 0)
                return;
            swap(position, largestChild, Heap);
            position = largestChild;
        }
    }

    // END OF HEAP FUNCTIONS __________________________________________________________________________


    //START OF QUICKSORT FUNCTIONS_____________________________________________________________________
    @Override
    public void randomizedQuickSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {

        int index = partition(array, lowindex, highindex, reversed);
        //left
        if (lowindex < index - 1)
            randomizedQuickSort(array, lowindex, index - 1, reversed);
        //low to i
        //right
        if (index < highindex)
            randomizedQuickSort(array, index, highindex, reversed);
        //i to high
    }


    private static int partition(Comparable[] arr,int left, int right, boolean rev) {


        Comparable tmp;

        int i = left, j = right;
        Random randy = new Random();
        Comparable pivot = arr[left + randy.nextInt(right - left)];

        while (i <= j) {
            if(rev == false) {
                while (arr[i].compareTo(pivot) < 0)
                    i++;
                while (arr[j].compareTo(pivot) > 0)
                    j--;
            }else{
                while (arr[i].compareTo(pivot) > 0)
                    i++;
                while (arr[j].compareTo(pivot) < 0)
                    j--;
            }
            //if we need to swap
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }


    //END OF QUICK SORT FUNCTIONS_________________________________________________________________________


    //START OF HYBRID FUNCTIONS___________________________________________________________________________
    @Override
    public void hybridSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {
        double percent = array.length*.10;

        this.hybridQuickSort(percent, array, lowindex, highindex, reversed);

    }

    public void hybridQuickSort(double percent, Comparable[] array, int lowindex, int highindex, boolean reversed) {
        int x = highindex-lowindex;
        //System.out.println("percent = " + percent + " size = " + x);
        if(highindex-lowindex > percent) {
            int index = partition(array, lowindex, highindex, reversed);
            //left
            if (lowindex < index - 1)
                hybridQuickSort(percent, array, lowindex, index - 1, reversed);
            //low to i
            //right
            if (index < highindex)
                hybridQuickSort(percent, array, index, highindex, reversed);
            //i to high
        }else{
            //System.out.println("here");
            this.insertionSort(array, lowindex, highindex, reversed);
        }
    }

    //END OF HYBRID FUNCTIONS_______________________________________________________________________________

    @Override//BUCKET WORKS FOR LOW TO HIGH NEEDS TO BE INSERTED SO IT IS SORTED THEN ADDED TO AN ARRAY FOR PRINTING ALSO NEEDS REVERSE
    public void bucketSort(Record[] arr, int lowindex, int highindex, boolean reversed) {
        int N= (highindex-lowindex+1)/2;
        int largest = -1;
        System.out.println(" ");
        //System.out.println("Number of Buckets = " + N);
        LinkedList<Record>[] bucket = new LinkedList[N+1];

        //find largest key
        for(int i = 0; i < arr.length; i++){
            if(arr[i].getKey()>largest)
                largest = arr[i].getKey();
        }
        //System.out.println("Largest Number = " + largest);
        int range = (largest+1)/N;
       
        //give buckets linked lists and fill them with keys

        for(int i = lowindex; i <= highindex; i++){
            int j = arr[i].getKey()/range;
            //System.out.println("curr num = " + arr[i] + " goes inside bucket = " + j);
            if(bucket[j] == null){
                bucket[j] = new LinkedList<Record>();
                bucket[j].add(arr[i]);
                //System.out.println("adding = " + arr[i] + " to bucket = " + j);

            }else if(bucket[j].size() == 1){
                if(arr[i].getKey() <= bucket[j].get(0).getKey()){
                    bucket[j].add(0, arr[i]);
                    //System.out.println("adding = " + arr[i] + " to bucket = " + j);
                }else{
                    bucket[j].add(arr[i]);
                    //System.out.println("adding = " + arr[i] + " to bucket = " + j);
                }
            }else {
                //System.out.println("GETTING HERE FAM");
                for (int s = 0; s < bucket[j].size()-1; s++) {
                    //System.out.println("loop = " + s + " bucket = " + bucket[j].get(s));
                    if (bucket[j].get(s).getKey() >= arr[i].getKey()) {
                        bucket[j].add(s, arr[i]);
                        //System.out.println("adding = " + arr[i] + " to bucket = " + j);
                        break;
                    } else if (bucket[j].get(s).getKey() < arr[i].getKey() && bucket[j].get(s + 1).getKey() > arr[i].getKey()) {
                        bucket[j].add(s + 1, arr[i]);
                        //System.out.println("adding = " + arr[i] + " to bucket = " + j);
                        break;
                    } else if (s == bucket[j].size()-2) {
                        bucket[j].add(arr[i]);
                        //System.out.println("adding = " + arr[i] + " to bucket = " + j);
                        break;
                    }
                }
            }
        }

        if(reversed == false){
            int start = lowindex;
            for(int a = 0 ; a < bucket.length; a++){
                if(bucket[a] == null){
                    continue;
                }else{
                    for(int i = 0; i < bucket[a].size(); i++){
                        arr[start] = bucket[a].get(i);
                        start++;
                    }
                }
            }
        }else{
            int start = lowindex;
            for(int a = bucket.length-1 ; a >= 0; a--){
                if(bucket[a] == null){
                    continue;
                }else{
                    for(int i = bucket[a].size()-1; i >= 0; i--){
                        arr[start] = bucket[a].get(i);
                        start++;
                    }
                }
            }

        }

    }

    @Override
    public void radixSort(int[] array, int lowindex, int highindex, boolean reversed) {

        int i, j, rtok, temp;
        int r = 10;
        int numDigits = 3;
        int[] count = new int[r];

        for (i = 0, rtok = 1; i < numDigits; i++, rtok *= r) {
            for (j = 0; j < r; j++)
                count[j] = 0;

            for (j = lowindex; j <= highindex; j++) {
                count[(array[j] / rtok) % r]++;
            }

            for (j = 1; j < r; j++) {
                count[j] = count[j - 1] + count[j];
            }

            int[] b = new int[highindex-lowindex+1]; // temporary array

            for (j = highindex; j >= lowindex; j--) {
                temp = --count[(array[j] / rtok) % r];
                b[temp] = array[j];
            }
            System.out.println(" ");
            for(int p = 0; p < b.length; p++)
                System.out.print(" " + b[p]);

            int x, y;
            for (x = 0, y = lowindex; y <= highindex; x++, y++) {
                array[y] = b[x];
            }

        }
        if(reversed) {
            int start=lowindex,end=highindex;
            while(start<=end) {
                int hold=array[start];
                array[start]=array[end];
                array[end]=hold;
                start++;
                end--;
            }
        }
    }



    //START OF EXTERNAL FUNCTIONS_____________________________________________________________________________
    @Override
    public void externalSort(String inputFile, String outputFile, int n, int m) {


        String tfile = "temp_file_";
        int[] buffer = new int[m];

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            int numChucks = (int) Math.ceil(n / m);

            int i, j;
            i = j = 0;
            // move through file elements
            for (i = 0; i < numChucks; i++) {
                // read chuck from file
                for (j = 0; j < m; j++) {
                    String t = br.readLine();
                    if (t != null)
                        buffer[j] = Integer.parseInt(t);
                    else
                        break;
                }
                //sort each chunk
                quicksort(buffer, 0, buffer.length-1);
                // write sorted chuck to file
                FileWriter fw = new FileWriter(tfile + i + ".txt");
                PrintWriter pw = new PrintWriter(fw);
                for (int k = 0; k < j; k++)
                    pw.println(buffer[k]);

                pw.close();
                fw.close();
            }

            br.close();
            fr.close();

            //open and merge temp files
            int[] nums = new int[numChucks];
            BufferedReader[] reader = new BufferedReader[numChucks];

            for (i = 0; i < numChucks; i++){
                //make new reader for file array
                reader[i] = new BufferedReader(new FileReader(tfile + i + ".txt"));
                String currLine = reader[i].readLine();

                if (currLine != null)
                    nums[i] = Integer.parseInt(currLine);
                else
                    //
                    nums[i] = Integer.MAX_VALUE;
            }
//            System.out.println(" ");
//            for(int u = 0; u < nums.length; u++){
//                System.out.print(nums[u]+ " ");
//            }
//            System.out.println(" ");

            FileWriter fwOutput = new FileWriter("outputFile");
            PrintWriter outputWriter = new PrintWriter(fwOutput);

            for (i = 0; i < n; i++) {
                int minValue = nums[0];
                //file we will progress with after adding minValue
                int minFile = 0;
                //get smallest num form nums
                for (j = 0; j < numChucks; j++) {
                    if (minValue > nums[j]) {
                        minValue = nums[j];
                        minFile = j;
                    }
                }

                outputWriter.println(minValue);
                String t = reader[minFile].readLine();
                if (t != null)
                    nums[minFile] = Integer.parseInt(t);
                else
                    nums[minFile] = Integer.MAX_VALUE;

            }
            //close reader for each file
            for (i = 0; i < numChucks; i++)
                reader[i].close();

            outputWriter.close();
            fwOutput.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    static void quicksort(int A[], int low, int high) {
        int pivot; if (low < high) {
            pivot = partition2(A, low, high);
            quicksort(A, low, pivot - 1);
            quicksort(A, pivot + 1, high);
        }
    }
    static int partition2(int A[], int low, int high) {
        int pivot; int tmp; int max = high; int mid = (low + high) / 2;
        tmp = A[mid]; A[mid] = A[high]; A[high] = tmp; pivot = A[high]; low--; do { while (A[++low] < pivot)
            ;
            while ((low < high) && (A[--high] > pivot))
                ; tmp = A[low]; A[low] = A[high]; A[high] = tmp; } while (low < high); tmp = A[low]; A[low] = A[max]; A[max] = tmp; return low;
    }
//END OF EXTERNAL FUNCTIONS__________________________________________________________________________________________________
}




