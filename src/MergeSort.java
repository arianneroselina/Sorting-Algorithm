import java.util.ArrayList;
import java.util.List;

public class MergeSort extends Sort {

	/**
	 * The method that will be used for calling.
	 * @param list		the list
	 * @param panel		the panel
	 * @return			the sorted list
	 */
	public List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel panel) {
		return sort(list, list.size());
	}

	/**
	 * This method divides the list into two smaller list with the same size.
	 * @param list		the list
	 * @param size		the size of the list
	 * @return			the sorted list
	 */
	public List<Rectangle> sort(List<Rectangle> list, int size) {
		if (size < 2) return list;

		int mid = size / 2;
		List<Rectangle> left = new ArrayList<Rectangle>();
		List<Rectangle> right = new ArrayList<Rectangle>();

		int i;
		for (i = 0; i < mid; i++) left.add(list.get(i));
		for (i = mid; i < size; i++) right.add(list.get(i));
		
		sort(left, mid);
		sort(right, size - mid);
		merge(list, left, right, mid, size - mid);
		return list;
	}

	/**
	 * This method sorts the list using Merge Sort.
	 * @param list		the list
	 * @param left		the smaller left list
	 * @param right		the smaller right list
	 * @param leftSize	the size of the left list
	 * @param rightSize	the size of the right list
	 */
	public void merge(List<Rectangle> list, List<Rectangle> left, List<Rectangle> right, int leftSize, int rightSize) {
		int i = 0, j = 0, k = 0, tempX;
		while (i < leftSize && j < rightSize) {
			if (left.get(i).compareTo(right.get(j)) <= 0) {
				tempX = list.get(k).getX();
				list.set(k, new Rectangle(tempX ,left.get(i).getHeight()));
				k++;
				i++;
			}
			else {
				tempX = list.get(k).getX();
				list.set(k, new Rectangle(tempX ,right.get(j).getHeight()));
				k++;
				j++;
			}
		}
		while (i < leftSize) {
			tempX = list.get(k).getX();
			list.set(k, new Rectangle(tempX ,left.get(i).getHeight()));
			k++;
			i++;
		}
		while (j < rightSize) {
			tempX = list.get(k).getX();
			list.set(k, new Rectangle(tempX ,right.get(j).getHeight()));
			k++;
			j++;
		}
	}

}
