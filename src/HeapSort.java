import java.util.List;

public class HeapSort extends Sort {

	/**
	 * This method sorts the list using Heap Sort.
	 * 
	 * @param list  the list
	 * @param panel the panel
	 * @return the sorted list
	 */
	public List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel panel) {
		int size = list.size();

		// Build heap (rearrange array)
		for (int i = size/2 - 1; i >= 0; i--)
			heapify(list, size, i);

		// One by one extract an element from heap
		for (int i = size - 1; i > 0; i--) {
			swap(list, 0, i); // Move current root to end
			heapify(list, i, 0); // Call max heapify on the reduced heap
		}
		return list;
	}

	/**
	 * This method heapifies a subtree rooted with node i.
	 * @param list	the list
	 * @param size	the size of the list
	 * @param index	an index in the list
	 */
	void heapify(List<Rectangle> list, int size, int index) {
		int largest = index;
		int left = 2*index + 1;
		int right = 2*index + 2;

		if (left < size && list.get(left).compareTo(list.get(largest)) > 0)
			largest = left;
		if (right < size && list.get(right).compareTo(list.get(largest)) > 0)
			largest = right;
		if (largest != index) {
			swap(list, index, largest);
			heapify(list, size, largest);
		}
	}
}
