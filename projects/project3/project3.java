// De La Torre, Kevin {ktorre}
// CS 141 01
// Project #3 : Shape Inheritance
//

import java.util.Scanner;

public class project3 {
	public static void main(String[] args) {
		String commands = getCommands( args );
		Scanner read = new Scanner(commands);
		String shape = "";

		while (read.hasNext()) {
			shape = read.next();
			switch ( shape.toLowerCase().charAt( 0 ) ) {
				case 'l': makeLine( read.nextInt() ); break;
				case 's': makeSquare( read.nextInt() ); break;
				case 'c': makeCube( read.nextInt() ); break; 
			}
		
		}
	}

	public static String getCommands( String[] args ) {
		String tempStr = "";
		for ( int x = 0; x < args.length; x++ ) {
			tempStr += " " + args[x];
		}
		return tempStr;
	}

	public static void makeLine( int width ) {
		myLine line = new myLine( width );
		line.makeLine( 0, 0 );
		System.out.print(line);
	}

	public static void makeSquare( int length ) {
		mySquare square = new mySquare( length );
		square.makeSquare( 0, 0 );
		System.out.print(square);
	}

	public static void makeCube( int length ) {
		myCube cube = new myCube( length );
		cube.makeCube();
		System.out.print(cube);
	}
}
