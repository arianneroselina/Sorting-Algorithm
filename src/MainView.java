import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainView {
	
	public static List<Rectangle> listOfRect;
	public int frameWidth;
	public int frameHeight;
	public static JFrame frame = new JFrame();
	public SortPanel panel = new SortPanel();
	public JPanel buttonPanel = new JPanel();
	
	public MainView(List<Rectangle> listOfRect) {
		new MainView(listOfRect, getWidth(), getHeight());
    }
	
	public MainView(List<Rectangle> listOfRect, int width, int height) {
		setList(listOfRect);
		this.frameWidth = width;
		this.frameHeight = height;
		frame.add(panel);
		frame.add(buttonToSort(), BorderLayout.SOUTH);
		setFrame();
    }
	
	public void setFrame() {
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sorting Algorithm Visualization");
		frame.setSize(getWidth(), getHeight());
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public JPanel buttonToSort() {
		JButton sortButton = new JButton("Sort");
	    sortButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		sort(new InsertionSort()); // Change which algorithm to use.
	    	}
	    });
	    buttonPanel.add(sortButton);
	    return buttonPanel;
	}

	public void sort(Sort sortType) {
		List<Rectangle> list = sortType.sort(listOfRect, panel);
		panel.refreshMethod(list);
	}
	
	class SortPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			for (Rectangle eachRect : listOfRect) {
				g2d.setColor(Color.GRAY);
				g2d.fillRect(eachRect.getX(), Rectangle.y, Rectangle.width, eachRect.getHeight());
			}
		}

		public void refreshMethod(List<Rectangle> list) {
			setList(list);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.repaint();
		}
	}

	public static List<Rectangle> getList() {
		return listOfRect;
	}
	
	public static void setList(List<Rectangle> list) {
		listOfRect = list;
	}
	
	public int getWidth() {
		return frameWidth;
	}
	
	public void setWidth(int width) {
		this.frameWidth = width;
	}
	
	public int getHeight() {
		return frameHeight;
	}
	
	public void setHeight(int height) {
		this.frameHeight = height;
	}
}
