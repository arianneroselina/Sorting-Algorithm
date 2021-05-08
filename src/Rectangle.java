
public class Rectangle {

	public int x;
	public static int y = 0;
	public static int width = 10;
	public int height;
	
	public Rectangle(int x, int height) {
        this.x = x;
        this.height = height;
    }
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return height;
	}
	
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public int compareTo(Rectangle other) {
		if (height < other.height) return -1;
		else if (height == other.height) return 0;
		return 1;
		
	}

}
