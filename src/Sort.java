import java.util.List;

public abstract class Sort {

	public abstract List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel panel);
	
	/**
	 * Swap two elements at index a and index b.
	 * @param list	the list
	 * @param a		the first element's index
	 * @param b		the second element's index
	 */
	public static void swap(List<Rectangle> list, int a, int b) {
		int tempInt = list.get(a).getX();
		list.get(a).setX(list.get(b).getX());
		list.get(b).setX(tempInt);
		
		Rectangle tempRec = list.get(a);
		list.set(a, list.get(b));
		list.set(b, tempRec);
	}
}
