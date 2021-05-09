import java.util.ArrayList;
import java.util.List;

public class RadixSort extends Sort {

    /**
     * This method sorts the list using Radix Sort.
     *
     * @param list  the list
     * @param panel the panel
     * @return the sorted list
     */
    public List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel panel) {
        int size = list.size();
        Rectangle m = getMax(list, size);

        for (int base = 1; m.getHeight() / base > 0; base *= 10)
            sort(list, size, base);
        return list;
    }

    /**
     * Get the rectangle with maximum height.
     *
     * @param list the list
     * @param size the size of the list
     * @return rectangle with the maximum height
     */
    public Rectangle getMax(List<Rectangle> list, int size) {
        Rectangle max = list.get(0);
        for (int i = 1; i < size; i++)
            if (list.get(i).compareTo(max) > 0)
                max = list.get(i);
        return max;
    }

    /**
     * This method sorts the list according to the digit represented by base.
     *
     * @param list the list
     * @param size the size of the list
     * @param base the base
     */
    public void sort(List<Rectangle> list, int size, int base) {
        List<Rectangle> output = new ArrayList<Rectangle>();
        int i, index, count[] = new int[10];

        for (i = 0; i < size; i++) {
            count[(list.get(i).getHeight() / base) % 10]++;
            output.add(null);
        }

        // Change count[i] so that count[i] now contains actual position of this digit in output
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = size - 1; i >= 0; i--) {
            index = count[(list.get(i).getHeight() / base) % 10];
            output.set(index - 1, new Rectangle(10 + (15 * index), list.get(i).getHeight()));
            count[(list.get(i).getHeight() / base) % 10]--;
        }

        for (i = 0; i < size; i++)
            if (output.get(i) != null) list.set(i, output.get(i));
    }
}
