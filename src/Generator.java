import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generator sort = new Generator();
		sort.generateRect(50); // Set the number of elementes/rectangles.

	}

	public void generateRect(int n) {
		List<Rectangle> rectList = new ArrayList<Rectangle>();
		Random randomizer = new Random();
		int x = 10, randomHeight, maxHeight = 0;
		for (int i = 0; i < n; i++) {
			randomHeight = randomizer.nextInt(300) + 50;
			maxHeight = Math.max(maxHeight, randomHeight);
			rectList.add(new Rectangle(x, randomHeight));
			x += 15;
		}
		new MainView(rectList, x + 20, maxHeight + 100);
	}

}
