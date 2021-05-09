import java.util.List;

public class SelectionSort extends Sort {

	/**
	 * This method sorts the rectangles in list using Selection Sort.
	 * @param list  the list
	 * @param panel the panel
	 * @return
	 */
	@Override
	public List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel  panel) {
		int n = list.size(), minIndex, tempX;
		Rectangle temp;
		for (int i = 0; i < n - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (list.get(j).compareTo(list.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			
			// Swap the found minimum element with the first element
			temp = list.get(minIndex);
			tempX = list.get(i).getX();
			list.set(minIndex, list.get(i));
			list.get(i).setX(temp.getX());
			list.set(i, temp);
			list.get(i).setX(tempX);
		}
		return list;
	}
}
