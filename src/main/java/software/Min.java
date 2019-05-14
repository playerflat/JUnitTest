package software;

import java.util.ArrayList;
import java.util.Iterator;

public class Min {
    public static <T extends Comparable<? super T>> T min(ArrayList<? extends T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("software.Min.min");
        }
        Iterator<? extends T> itr = list.iterator();
        T result = itr.next();

        if (result == null) throw new NullPointerException("software.Min.min");

        while (itr.hasNext()) {
            T comp = itr.next();
            if (comp.compareTo(result) < 0) {
                result = comp;
            }
        }
        return result;
    }
}
