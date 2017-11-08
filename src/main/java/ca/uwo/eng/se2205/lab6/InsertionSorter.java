package ca.uwo.eng.se2205.lab6;

/**
 * Created by Jake on 2017-03-18.
 */
public class InsertionSorter implements Sorter{

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
        int num;
        int i;
        int j;
        for (i = 0; i < sort.size(); i++){
            num = i;
            for (j = i+1; j < sort.size(); j++){
                if(comparator.compare(sort.get(num), sort.get(j)) >= 0){
                    sort.add(i, sort.remove(j));
                }
            }
        }
    }

}
