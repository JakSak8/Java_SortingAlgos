package ca.uwo.eng.se2205.lab6;

/**
 * Created by Jake on 2017-03-19.
 */
public class MergeSorter implements Sorter{

    /*
    @Override
    public String getName(){
        return "Merge Sort";
    }
    */

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
        int first = 0;
        int last = sort.size() - 1;
        int mid = (last - first) / 2;
        mergeSort(sort, comparator, first, last);
    }

    private <E> void mergeSort(DelayedList<E> sort, DelayedComparator<E> comparator, int first, int last){
        if (last - first == 0){
            return;
        }else if (last - first == 1){
            if (comparator.compare(sort.get(last),sort.get(first)) < 0){
                E temp = sort.get(first);
                sort.set(first, sort.get(last));
                sort.set(last, temp);
            }
        }else{
            int mid = Math.abs((last + first) / 2);
            // if(sort.subList(first, mid).size() != 0){
            //    if(sort.subList(mid + 1, last).size() != 0){
            mergeSort(sort, comparator, first, mid);
            mergeSort(sort, comparator, mid + 1, last);
            merge(sort, comparator, first, mid, last);
        }

        //    }
        // } else if (comparator.compare(sort.get(first), sort.get(last)) > 0){
        //   E temp = sort.get(first);
        //   sort.set(first, sort.get(last));
        //   sort.set(last, temp);
        //}
    }


    private <E> void merge(DelayedList<E> sort, DelayedComparator<E> comparator, int first, int mid, int last) {
        E temp, temp2;
        int i = first;
        while (i <= mid) {
            if (comparator.compare(sort.get(i), sort.get(mid + 1)) > 0) {
                temp = sort.get(i);
                sort.set(i, sort.get(mid + 1));
                sort.set(mid + 1, temp);

                for (int j = mid + 1; j < last; j++) {
                    if (comparator.compare(sort.get(j), sort.get(j + 1)) > 0) {
                        temp2 = sort.get(j);
                        sort.set(j, sort.get(j + 1));
                        sort.set(j + 1, temp2);
                    }
                }
            } i++;
        }
    }
}
