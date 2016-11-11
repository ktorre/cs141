public class myCube extends mySquare {
	public myCube(int length) {
		super(length);
		grow((int)(.5 * length),(int)(.5 * length));
		drawCube(length);
	}

	public void drawCube(int length) {
		drawSquare(length, 0, 0);
		drawSquare(length, (int)(.5 * length + .5)-1,(int)(.5 * length + .5)-1);
		int x = 0;
		int y = 0;
		while (x < .5*length-1 && y < .5*length-1) {
			plot((int)(x + 1.5),(int)(y + 1.5));
			plot((int)(x + length + .5),(int)(y + 1.5));
			plot((int)(x + 1.5),(int)(y + length + .5));
			plot((int)(x + length + .5),(int)(y + length + .5));
			x += 1;
			y += 1;
		}
	}
}
