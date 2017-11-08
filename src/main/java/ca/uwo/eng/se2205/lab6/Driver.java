package ca.uwo.eng.se2205.lab6;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by Jake on 2017-03-22.
 */
public class Driver {

    public static DelayedList<Integer> fastList = DelayedList.create(Delayed.Time.Fast, RandomNumbers.get(40));
    public static DelayedList<Integer> normalList = DelayedList.create(Delayed.Time.Normal, RandomNumbers.get(40));
    public static DelayedList<Integer> slowList = DelayedList.create(Delayed.Time.Slow, RandomNumbers.get(40));

    public static DelayedComparator<Integer> fastComparator = DelayedComparator.create(Integer::compareTo, Delayed.Time.Fast);
    public static DelayedComparator<Integer> normalComparator = DelayedComparator.create(Integer::compareTo, Delayed.Time.Normal);
    public static DelayedComparator<Integer> slowComparator = DelayedComparator.create(Integer::compareTo, Delayed.Time.Slow);

    public static String[] compare(Sorter sort, DelayedList list, DelayedComparator comparator){
        String[] array = new String[6];

        long startTime = System.nanoTime();
        sort.sort(list, comparator);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        array[0] = sort.toString();//getName(); had to comment out to run code normally
        array[1] = Long.toString(duration);
        array[2] = list.getTime().toString();
        array[3] = Long.toString(list.getOperationsPerformed());
        array[4] = comparator.getTime().toString();
        array[5] = Long.toString(comparator.getComparisonsPerformed());

        return array;
    }

    public static class selectionSortAnonymousClasses{

        SelectionSorter selectionSort = new SelectionSorter();


        public String[] fastListfastCompare() {
            return compare(selectionSort, fastList, fastComparator);
        }

        public String[] normalListfastCompare() {
            return compare(selectionSort, normalList, fastComparator);
        }

        public String[] slowListfastCompare() {
            return compare(selectionSort, slowList, fastComparator);
        }

        public String[] fastListnormalCompare(){
            return compare(selectionSort, fastList, normalComparator);
        }

        public String[] normalListnormalCompare(){
            return compare(selectionSort, normalList, normalComparator);
        }

        public String[] slowListnormalCompare(){
            return compare(selectionSort, slowList, normalComparator);
        }

        public String[] FLSC(){
            return compare(selectionSort, fastList,slowComparator);
        }

        public String[] NLSC(){
            return compare(selectionSort, normalList, slowComparator);
        }

        public String[] SLSC(){
            return compare(selectionSort, slowList,slowComparator);
        }
    }

    public static class mergeSortAnonymousClass{
        MergeSorter merge = new MergeSorter();

        public String[] fastListfastCompare() {
            return compare(merge, fastList, fastComparator);
        }

        public String[] normalListfastCompare() {
            return compare(merge, normalList, fastComparator);
        }

        public String[] slowListfastCompare() {
            return compare(merge, slowList, fastComparator);
        }

        public String[] fastListnormalCompare(){
            return compare(merge, fastList, normalComparator);
        }

        public String[] normalListnormalCompare(){
            return compare(merge, normalList, normalComparator);
        }

        public String[] slowListnormalCompare(){
            return compare(merge, slowList, normalComparator);
        }

        public String[] FLSC(){
            return compare(merge, fastList,slowComparator);
        }

        public String[] NLSC(){
            return compare(merge, normalList, slowComparator);
        }

        public String[] SLSC(){
            return compare(merge, slowList,slowComparator);
        }

    }

    public static class insertionSortAnonymousClasses{

        InsertionSorter insertionsort = new InsertionSorter();


        public String[] fastListfastCompare() {
            return compare(insertionsort,fastList, fastComparator);
        }

        public String[] normalListfastCompare() {
            return compare(insertionsort, normalList, fastComparator);
        }

        public String[] slowListfastCompare() {
            return compare(insertionsort, slowList, fastComparator);
        }

        public String[] fastListnormalCompare(){
            return compare(insertionsort, fastList, normalComparator);
        }

        public String[] normalListnormalCompare(){
            return compare(insertionsort, normalList, normalComparator);
        }

        public String[] slowListnormalCompare(){
            return compare(insertionsort, slowList, normalComparator);
        }

        public String[] FLSC(){
            return compare(insertionsort, fastList,slowComparator);
        }

        public String[] NLSC(){
            return compare(insertionsort, normalList, slowComparator);
        }

        public String[] SLSC(){
            return compare(insertionsort, slowList,slowComparator);
        }
    }

    public static class quickSortAnonymousClass{
        QuickSorter quickSorter = new QuickSorter();

        public String[] fastListfastCompare() {
            return compare(quickSorter,fastList, fastComparator);
        }

        public String[] normalListfastCompare() {
            return compare(quickSorter, normalList, fastComparator);
        }

        public String[] slowListfastCompare() {
            return compare(quickSorter, slowList, fastComparator);
        }

        public String[] fastListnormalCompare(){
            return compare(quickSorter, fastList, normalComparator);
        }

        public String[] normalListnormalCompare(){
            return compare(quickSorter, normalList, normalComparator);
        }

        public String[] slowListnormalCompare(){
            return compare(quickSorter, slowList, normalComparator);
        }

        public String[] FLSC(){
            return compare(quickSorter, fastList,slowComparator);
        }

        public String[] NLSC(){
            return compare(quickSorter, normalList, slowComparator);
        }

        public String[] SLSC(){
            return compare(quickSorter, slowList,slowComparator);
        }

    }

    public static synchronized void writeValues (String [] values) {
        //checkNotNull(values);
        //assertTrue(values.length > 0);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(String.join(",", values) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String FILENAME = "Lab 06 results.csv";

    public static void main(String[] args) {

        BatchRunner selection = new BatchRunner();
        BatchRunner insert = new BatchRunner();
        BatchRunner quick = new BatchRunner();
        BatchRunner merge = new BatchRunner();

        /**
         * Selection sort
         */
        selectionSortAnonymousClasses SelectionSort = new selectionSortAnonymousClasses();

        Runnable SS = () -> writeValues(SelectionSort.fastListfastCompare());
        Runnable SS2 = () -> writeValues(SelectionSort.normalListfastCompare());
        Runnable SS3 = () -> writeValues(SelectionSort.slowListfastCompare());
        Runnable SS4 = () -> writeValues(SelectionSort.fastListnormalCompare());
        Runnable SS5 = () -> writeValues(SelectionSort.normalListnormalCompare());
        Runnable SS6 = () -> writeValues(SelectionSort.slowListnormalCompare());
        Runnable SS7 = () -> writeValues(SelectionSort.FLSC());
        Runnable SS8 = () -> writeValues(SelectionSort.NLSC());
        Runnable SS9 = () -> writeValues(SelectionSort.SLSC());


        selection.enqueue(SS);
        selection.enqueue(SS2);
        selection.enqueue(SS3);
        selection.enqueue(SS4);
        selection.enqueue(SS5);
        selection.enqueue(SS6);
        selection.enqueue(SS7);
        selection.enqueue(SS8);
        selection.enqueue(SS9);

        /**
         * Insertion Sort
         */
        insertionSortAnonymousClasses insertion = new insertionSortAnonymousClasses();

        Runnable IS = () -> writeValues(insertion.fastListfastCompare());
        Runnable IS2 = () -> writeValues(insertion.normalListfastCompare());
        Runnable IS3 = () -> writeValues(insertion.slowListfastCompare());
        Runnable IS4 = () -> writeValues(insertion.fastListnormalCompare());
        Runnable IS5 = () -> writeValues(insertion.normalListnormalCompare());
        Runnable IS6 = () -> writeValues(insertion.slowListnormalCompare());
        Runnable IS7 = () -> writeValues(insertion.FLSC());
        Runnable IS8 = () -> writeValues(insertion.NLSC());
        Runnable IS9 = () -> writeValues(insertion.SLSC());


        insert.enqueue(IS);
        insert.enqueue(IS2);
        insert.enqueue(IS3);
        insert.enqueue(IS4);
        insert.enqueue(IS5);
        insert.enqueue(IS6);
        insert.enqueue(IS7);
        insert.enqueue(IS8);
        insert.enqueue(IS9);

        /**
         * Merge Sort
         */
        mergeSortAnonymousClass mergeSort = new mergeSortAnonymousClass();

        Runnable MS = () -> writeValues(mergeSort.fastListfastCompare());
        Runnable MS2 = () -> writeValues(mergeSort.normalListfastCompare());
        Runnable MS3 = () -> writeValues(mergeSort.slowListfastCompare());
        Runnable MS4 = () -> writeValues(mergeSort.fastListnormalCompare());
        Runnable MS5 = () -> writeValues(mergeSort.normalListnormalCompare());
        Runnable MS6 = () -> writeValues(mergeSort.slowListnormalCompare());
        Runnable MS7 = () -> writeValues(mergeSort.FLSC());
        Runnable MS8 = () -> writeValues(mergeSort.NLSC());
        Runnable MS9 = () -> writeValues(mergeSort.SLSC());

        merge.enqueue(MS);
        merge.enqueue(MS2);
        merge.enqueue(MS3);
        merge.enqueue(MS4);
        merge.enqueue(MS5);
        merge.enqueue(MS6);
        merge.enqueue(MS7);
        merge.enqueue(MS8);
        merge.enqueue(MS9);

        /**
         * Quick Sort
         */
        quickSortAnonymousClass quickSort = new quickSortAnonymousClass();

        Runnable QS = () -> writeValues(quickSort.fastListfastCompare());
        Runnable QS2 = () -> writeValues(quickSort.normalListfastCompare());
        Runnable QS3 = () -> writeValues(quickSort.slowListfastCompare());
        Runnable QS4 = () -> writeValues(quickSort.fastListnormalCompare());
        Runnable QS5 = () -> writeValues(quickSort.normalListnormalCompare());
        Runnable QS6 = () -> writeValues(quickSort.slowListnormalCompare());
        Runnable QS7 = () -> writeValues(quickSort.FLSC());
        Runnable QS8 = () -> writeValues(quickSort.NLSC());
        Runnable QS9 = () -> writeValues(quickSort.SLSC());

        quick.enqueue(QS);
        quick.enqueue(QS2);
        quick.enqueue(QS3);
        quick.enqueue(QS4);
        quick.enqueue(QS5);
        quick.enqueue(QS6);
        quick.enqueue(QS7);
        quick.enqueue(QS8);
        quick.enqueue(QS9);


        String[] array = new String[6];
        array[0] = "Algorithm";
        array[1] = "Time(ns)";
        array[2] = "List Speed";
        array[3] = "List Operations/Sort";
        array[4] = "Comparator Speed";
        array[5] = "Compare Operations/Sort";

        String[] empty = new String[6];
        empty[0] = "";
        empty[1] = "";
        empty[2] = "";
        empty[3] = "";
        empty[4] = "";
        empty[5] = "";

        writeValues(array);
        selection.run();
        writeValues(empty);
        insert.run();
        writeValues(empty);
        merge.run();
        writeValues(empty);
        quick.run();


    }


}

