import java.util.List;

public class InsertionSort extends Sort {
	
	/**
	 * This method sorts the rectangles in list using Insertion Sort.
	 * @param list	the list
	 * @param panel the panel
	 * @return
	 */
	public List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel panel) {
		int first = 0, last = list.size() - 1;
		int tempX, b;
		Rectangle key, copy;
		for (int a = first + 1; a <= last; a++) {
			key = list.get(a);
			b = a - 1;
			while (b >= first && key.compareTo(list.get(b)) == -1) {
				copy = new Rectangle(list.get(b).getX(), list.get(b).getHeight());
				tempX = list.get(b+1).getX();
				list.set(b+1, list.get(b));
				list.get(b+1).setX(tempX);
				list.set(b, copy);
	    		panel.refreshMethod(list);
				b--;
			}
			tempX = list.get(b+1).getX();
			list.set(b+1, key); // Set key in b+1
			list.get(b+1).setX(tempX);
			panel.refreshMethod(list);
		}
		return list;
	}

}
