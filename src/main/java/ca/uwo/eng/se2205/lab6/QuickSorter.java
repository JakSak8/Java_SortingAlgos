package ca.uwo.eng.se2205.lab6;

import java.util.Random;

/**
 * Created by Jake on 2017-03-18.
 */
public class QuickSorter implements Sorter {

    /*
    @Override
    public String getName(){
        return "Quick Sort";
    }
    */

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
      quickSort(sort, comparator, 0, sort.size() - 1);
    }

    private <E> void quickSort(DelayedList<E> sort, DelayedComparator<E> comparator, int  minIndex, int maxIndex){
        int min = minIndex;
        int max = maxIndex;
        E temp;

        Random rand = new Random();
        int partition = rand.nextInt(maxIndex - minIndex + 1) + minIndex;

        while(min <= max){
            while (comparator.compare(sort.get(min), sort.get(partition)) < 0){
                min++;
            }
            while (comparator.compare(sort.get(max), sort.get(partition)) > 0){
                max--;
            }
            if (min <= max){
                temp = sort.get(min);
                sort.set(min, sort.get(max));
                sort.set(max, temp);

                min++;
                max--;
            }
        }
        if (minIndex < max)
            quickSort(sort, comparator, minIndex, max);
        if (min < maxIndex)
            quickSort(sort, comparator, min, maxIndex);
    }

}
