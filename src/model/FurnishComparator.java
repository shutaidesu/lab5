package model;

import java.util.Comparator;

/**
 * Comparator for {@link Furnish}
 */
public class FurnishComparator implements Comparator<Furnish> {
    /**
     * @param a {@link Furnish} to compare
     * @param b {@link Furnish} to compare
     * @return -1 if a < b, 0 if a = b, 1 if a > b
     */
    @Override
    public int compare(final Furnish a, final Furnish b) {
        return Integer.compare(a.ordinal(), b.ordinal());
    }

}