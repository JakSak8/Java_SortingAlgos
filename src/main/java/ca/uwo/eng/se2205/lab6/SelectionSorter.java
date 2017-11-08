package ca.uwo.eng.se2205.lab6;

/**
 * Created by Jake on 2017-03-18.
 */
public class SelectionSorter implements Sorter {

    /*
    @Override
    public String getName(){
        return "Selection Sort";
    }
    */

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
        int num;
        int i;
        int j;
        E temp;
        for (i = 0; i < sort.size() - 1; i++) {
            num = i;
            for (j = i + 1; j < sort.size(); j++) {
                if (comparator.compare(sort.get(num), sort.get(j)) > 0) {
                    num = j;
                }
            }
            temp = sort.get(i);
            sort.set(i, sort.get(num));
            sort.set(num, temp);
        }
    }

}
