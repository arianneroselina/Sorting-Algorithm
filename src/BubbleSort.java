import java.util.List;
import javax.swing.JPanel;

public class BubbleSort extends Sort {

	/**
	 * This method sorts the list using Bubble Sort.
	 * 
	 * @param list		the list
	 * @param panel		the panel
	 * @return			the sorted list
	 */
	public List<Rectangle> sort(List<Rectangle> list, MainView.SortPanel panel) {
		int n = list.size();
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (list.get(j).compareTo(list.get(j + 1)) > 0)
					swap(list, j, j + 1);
		return list;
	}
}
