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
	public JPanel buttonPanel = new JPanel();
	
	public MainView(List<Rectangle> listOfRect) {
		new MainView(listOfRect, getWidth(), getHeight());
    }
	
	public MainView(List<Rectangle> listOfRect, int width, int height) {
		setList(listOfRect);
		this.frameWidth = width;
		this.frameHeight = height;
		frame.add(new SortPanel());
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
	    		SortPanel panel = new SortPanel();
	    		panel.sort(new InsertionSort()); // Change which algorithm to use. 
	    	}
	    });
	    buttonPanel.add(sortButton);
	    return buttonPanel;
	}
	
	public static void refreshMethod(List<Rectangle> listOfRect) {
		setList(listOfRect);
        /*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    frame.repaint();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
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
		
		public void sort(Sort sortType) {
			List<Rectangle> list = sortType.sort(listOfRect, frame);
    		refreshMethod(list);
		}
	}

	public static List<Rectangle> getList() {
		return listOfRect;
	}
	
	public static void setList(List<Rectangle> list) {
		listOfRect = list;
		frame.repaint();
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
