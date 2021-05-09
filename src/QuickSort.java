import java.util.List;

public class QuickSort extends Sort {

    /**
     * The method that will be used for calling.
     *
     * @param list  the list
     * @param panel the panel
     * @return      the sorted list
     */
    public List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel panel) {
        return sort(list, 0, list.size() - 1);
    }

    /**
     * This method helps to sort the list using Quick Sort.
     *
     * @param list  the list
     * @param first the first element's index
     * @param last  the last element's index
     * @return the sorted list
     **/
    public static List<Rectangle> sort(List<Rectangle> list, int first, int last) {
        if (first <= last) {
            int q = partition(list, first, last);
            sort(list, first, q - 1);
            sort(list, q + 1, last);
        }
        return list;
    }

    /**
     * Partition method for Quick Sort.
     *
     * @param list  the list
     * @param first the first element's index
     * @param last  the last element's index
     * @return the new pivot's index
     */
    public static int partition(List<Rectangle> list, int first, int last) {
        int pivot = first;
        swap(list, pivot, first);
        Rectangle x = list.get(first);
        int i = first;
        for (int j = first + 1; j <= last; j++) {
            if (list.get(j).compareTo(x) <= 0) {
                i++;
                swap(list, j, i);
            }
        }
        swap(list, first, i); //swap pivot
        return i;
    }
}