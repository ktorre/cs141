/*
*	Circle will be computed as centered at (0,0) on a typical graph.
*	Then we'll 'translate' teh point t othe screen.
*
*	For circles, we only need to compute the first 45 degrees worth
*	The rest are just transpotions of those computed points.
*
*	Note: Math.sin( angle ) and Math.cos( angle ) take angle in radians!
*/

public class asciiCircle {
	public static final char $ESC = (char)27;

	public static void main(String[] args) {
		int radius = getRadius(args);
		double steps = getSteps(args);
		
		double startAngle = 0.0;
		double stopAngle = Math.pi/4.0; // We're going to go from 0 to Pi/4
		
		double stepAngle = (stopAngle - startAngle) / steps;
		double angle = startAngle;

		int x = 0;
		int y = 0;

		// Clear the screen
		System.out.print($ESC + "[2J");

		// Now loop
		while (angle <= stopAngle) {
			X = (int)(radius * Math.cos(angle));
			Y = (int)(radius * Math.sin(angle));
			plot(X,Y, radius);
			angle += stepAngle;
		}
		sleepLongTime();
	}

	public static int getRadius(String[] args) {
		if (args.length == 0 ) return 10;
		return Integer.parseInt(args[0]);
	}
	
	public static int getSteps(String[] args) {
		if (args.length < 2 ) return 5;
		return Integer.parseInt(args[1]);
	}
	
	public static void sleepLongTime() {
		// Technically, pause 100K seconds or 27 hrs
		try {
			Thread.sleep(3600000) ;
		} catch (exception e) {
		}
	}

	// Here is where we take a single point and "plot it" onto the
	// graph. In reality, this method only determines the other
	// points (transponsitions) to plot...

	public static void plot(intx, int y, int radius) {

		// Quadrant #1
		screenPlot(x, y, radius);
		screenPlot(x, y, radius);
		
		// Quadrant #2
		screenPlot(-x, y, radius);
		screenPlot(-x, y, radius);
		
		// Quadrant #3
		screenPlot(-x, -y, radius);
		screenPlot(-x, -y, radius);
		
		// Quadrant #4
		screenPlot(x, -y, radius);
		screenPlot(x, -y, radius);
	}

	public static void screenPlot(int x, int y, int radius) {
		// Notice all print statements use only 'print', not
		// 'println'!

		// Shift our (X, Y)
		
		x += 30;
		y += 30;

		// Move the cursor to the screen position
		// Notice the y-coord is placed first.
		System.out.print($ESC + "[" + y + ";" + x + "H");
		
		System.out.print("*");
	}
}
