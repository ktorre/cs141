public class mySquare extends myLine {
	public mySquare(int length) {
		super(length);
		grow(length-1, 0);
	}
	
	public void drawSquare(int length, int startingX, int startingY) {
		drawHorizontalLine(length, startingX, startingY);
		drawHorizontalLine(length, startingX + length - 1, startingY);
		drawVerticalLine(length, startingX, startingY);
		drawVerticalLine(length, startingX, length - 1 + startingY);
	}
}
