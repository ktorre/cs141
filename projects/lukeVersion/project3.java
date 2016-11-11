// Walsh, Luke {lhwalsh}
// CS 141 01
// Project #3 : Shape Inheritance
// 

public class project3{
	public static void main( String args[]) {
		String shape = "";
		for (int i = 0; i < args.length; i++) {
			if (i % 2 == 0) {
				shape = args[i];
			}
			else {
				drawShape(shape, Integer.parseInt(args[i]));
			}
		}
	}

	public static void drawShape(String shape, int size) {
		switch (shape) {
			case "l": drawLine(size);
				  break;
			case "s": drawSquare(size);
				  break;
			case "c": drawCube(size);
				  break;
		}
	}

	public static void drawLine(int size) {
		myLine line = new myLine(size);
		line.drawHorizontalLine(size, 0, 0);
		System.out.println(line);
	}

	public static void drawSquare(int size) {
		mySquare square = new mySquare(size);
		square.drawSquare(size, 0, 0);
		System.out.println(square);
	}
	
	public static void drawCube(int size) {
		myCube cube = new myCube(size);
		cube.drawCube(size);
		System.out.println(cube);
	}
}
