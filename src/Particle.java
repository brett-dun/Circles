import java.awt.Color;


public class Particle {
	
	
	private int myX;
	private int myY;
	private int myXVelocity;
	private int myYVelocity;
	private int mySize;
	private Color myColor;
	
	
	public Particle(int myX, int myY, int myXVelocity, int myYVelocity,
			int mySize, Color myColor) {
		super();
		this.myX = myX;
		this.myY = myY;
		this.myXVelocity = myXVelocity;
		this.myYVelocity = myYVelocity;
		this.mySize = mySize;
		this.myColor = myColor;
	}
	
	
	public int getMyX() {
		return myX;
	}
	public void setMyX(int myX) {
		this.myX = myX;
	}
	public int getMyY() {
		return myY;
	}
	public void setMyY(int myY) {
		this.myY = myY;
	}
	public int getMyXVelocity() {
		return myXVelocity;
	}
	public void setMyXVelocity(int myXVelocity) {
		this.myXVelocity = myXVelocity;
	}
	public int getMyYVelocity() {
		return myYVelocity;
	}
	public void setMyYVelocity(int myYVelocity) {
		this.myYVelocity = myYVelocity;
	}
	public int getMySize() {
		return mySize;
	}
	public void setMySize(int mySize) {
		this.mySize = mySize;
	}
	public Color getMyColor() {
		return myColor;
	}
	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}
	public void updateX() {
		this.myX += this.myXVelocity;
	}
	public void updateY() {
		this.myY += this.myYVelocity;
	}


	@Override
	public String toString() {
		return "Particle [myX=" + myX + ", myY=" + myY + ", myXVelocity="
				+ myXVelocity + ", myYVelocity=" + myYVelocity + ", mySize=" + mySize + ", myColor=" + myColor + "]";
	}
	
	
}

