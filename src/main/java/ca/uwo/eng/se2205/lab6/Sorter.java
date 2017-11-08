package ca.uwo.eng.se2205.lab6;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Comparator;

/**
 * Defines that a class can sort a {@link DelayedList} based on a {@link Comparator}.
 */
@ParametersAreNonnullByDefault
@FunctionalInterface
public interface Sorter {

    /**
     * Sorts the content of the {@link DelayedList} in-place.
     * @param <E> Type of the collection
     * @param sort The List to sort
     * @param comparator Compares two elements
     */
    <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator);

    /**
     * Did not know if including this would cause problems so I put it in to make the CSV look nice and then commented it out.
     */
    //String getName();
}
