public class myLine extends char2D {

	public myLine(int length) {
		super(1, length);
	}

	public void drawHorizontalLine(int length, int x, int y) {
		for (int i = y; i < length + y; i++) {
			plot(x, i);
		}
	}

	public void drawVerticalLine(int length, int x, int y) {
		for (int i = x; i < length + x; i++) {
			plot(i, y);
		}
	}
}
