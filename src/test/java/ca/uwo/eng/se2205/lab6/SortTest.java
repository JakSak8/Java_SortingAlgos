package ca.uwo.eng.se2205.lab6;

import org.junit.Test;

import java.util.Comparator;

/**
 * Created by Jake on 2017-03-21.
 */


public class SortTest{

    @Test
    public void SelectionSort(){
        DelayedList<Integer> list = DelayedList.create(Delayed.Time.Fast,RandomNumbers.get(10));
        SelectionSorter sort = new SelectionSorter();
        DelayedComparator<Integer> comparator = DelayedComparator.create(Integer::compareTo, Delayed.Time.Fast);
        Comparator<Integer> compare = (o1, o2) -> {
            if (o1 < o2){
                return -1;
            } else if (o2 < o1){
                return 1;
            } else
                return 0;

        };

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();
        sort.sort(list,comparator);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    @Test
    public void InsertionSort(){
        DelayedList<Integer> list = DelayedList.create(Delayed.Time.Fast,RandomNumbers.get(10));
        InsertionSorter sort = new InsertionSorter();
        DelayedComparator<Integer> comparator = DelayedComparator.create(Integer::compareTo, Delayed.Time.Fast);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        sort.sort(list,comparator);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void QuickSort(){
        DelayedList<Integer> list = DelayedList.create(Delayed.Time.Fast,RandomNumbers.get(10));
        QuickSorter sort = new QuickSorter();
        DelayedComparator<Integer> comparator = DelayedComparator.create(Integer::compareTo, Delayed.Time.Fast);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        sort.sort(list,comparator);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void MergeSort(){
        DelayedList<Integer> list = DelayedList.create(Delayed.Time.Fast,RandomNumbers.get(15));
        MergeSorter sort = new MergeSorter();
        DelayedComparator<Integer> comparator = DelayedComparator.create(Integer::compareTo, Delayed.Time.Fast);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();

        long startTime = System.nanoTime();
        sort.sort(list,comparator);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);


        System.out.println(duration + " ns");
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }




}