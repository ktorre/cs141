// De La Torre, Kevin {ktorre}
// CS 141 01
// Project #2 : Furniture Layout
//

import java.util.Scanner;
import java.io.*;

public class project2 {

    public static void main( String[] args ) throws Exception {
	Scanner inFile = null;

	try {
	    inFile = initFile( args[ 0 ] );
	    doWork( inFile );
	    inFile.close();
	} catch ( ArrayIndexOutOfBoundsException e ) {
	    if ( e.getMessage().charAt( 0 ) == '.' ) 
		System.out.println( "\nPlot - ArrayIndexOutOfBoundsException\n\n" );
	    else
		System.out.println( "\nPlease provide input file name argument.\n" );
	} catch ( IOException e ) {
	    System.out.println( "\nError reading input file: " + args[0] );
	} catch ( Exception e ) {
	    inFile.close();
	    throw e;
	}
    }

    public static Scanner initFile( String S ) throws IOException {
	return new Scanner( new File( S ) );
    }

    public static void doWork( Scanner inFile ) {
	String commandToken;
	Canvas myCanvas = null;
	furniture shape = null;

	while ( inFile.hasNextLine() ) {
	    commandToken = inFile.next();
	    if ( commandToken.charAt(0) == '/' ) {
		inFile.nextLine();
	    } else {
		if (commandToken.equals("d")) {
		    myCanvas = setDimensions( inFile );
		} else if (commandToken.equals("b")) {
		    eraseGrid( inFile, myCanvas );
		} else {
		    try {
			makeFurniture( inFile, commandToken, shape, myCanvas );
		    } catch ( IOException e ) {} // Continue if no file found to prevent crash
		}
	    }
	}

	ANSI.cls();
	myCanvas.output();

    }

    public static Canvas setDimensions( Scanner inFile ) {
	return new Canvas( inFile.nextInt(), inFile.nextInt() );
    }

    public static void makeFurniture(Scanner inFile, String commandToken, furniture shape, Canvas myC ) throws IOException {
	// I create a scanner first because I want to check if the file is real before doing anything
	Scanner shapeReader = initFile( commandToken + ".cmd" ); 
	
	int x = inFile.nextInt();
	int y = inFile.nextInt();
	String orientation = inFile.next();
	String token;
	
	while ( shapeReader.hasNextLine()) {
	    token = shapeReader.next();
	    if ( token.charAt(0) == '/' ) {
		shapeReader.nextLine();
	    } else {
		switch ( token.charAt(0) ) {
		    case 'd' : 
			System.out.println("Creating shape.");
			shape = new furniture(shapeReader.nextInt(), shapeReader.nextInt());
			System.out.println("Shape Created.");
			break;
		    case 'b' : 
			setDefaultShape(shapeReader, shape);
			break;
		    case 'l' :
			drawLine( shapeReader, shape );
			break;
		    case 'c' :
			drawCircle( shapeReader, shape );
			break;
		    case 'p' :
			plotPoint( shapeReader, shape );
			break;
		    default:
		}
	    }
	}

	process( orientation, shape );
	drawOnCanvas( myC, shape, x, y );
    }

    public static void drawOnCanvas( Canvas myC, furniture shape, int x, int y ) {
	for ( int i = 0; i < shape.getWidth(); i++ ) {
	    for ( int j = 0; i < shape.getHeight(); j++ ) {
	    }
	}
    }

    public static void process( String command, furniture shape ) {

	for ( int i = 0; i < command.length(); i++ ) {
	    switch ( command.charAt( i ) ) {
	    case 'v':
	    case 'V':
		shape.flipVertical(); break;
	    case 'h':
	    case 'H':
		shape.flipHorizontal(); break;
	    case 'r':
	    case 'R':
		shape.rotate(); break;
	    case 'n':
	    case 'N':
		break;
	    default:
		// this should be an error, but we'll presume the
		// command sequence is valid and do nothing.
	    }
	}
    }


    public static void setDefaultShape( Scanner inFile, furniture shape ){
	// This method is pretty much the same as the eraseGrid method but 
	// unless I made them both canvases it would've been harder to try to make
	// a generic method that did this.

	String token;
	char C;
	int FG;
	int BG;
	
	token = inFile.next();
	C = ( token.equals( "space" ) ) ? ' ' : token.charAt(0);

	FG = color2Int( inFile.next() );
	BG = color2Int( inFile.next() );
	System.out.println(token);
	System.out.println("Character: " + C + ", Foreground: " + FG + ", Background: " + BG + "");

	shape.setDefault( C, FG, BG);
    }

    public static void eraseGrid( Scanner inFile, Canvas MyC ){
	String token;
	char C;
	int FG;
	int BG;
	
	token = inFile.next();
	C = ( token.equals( "space" ) ) ? ' ' : token.charAt(0);

	FG = color2Int( inFile.next() );
	BG = color2Int( inFile.next() );

	MyC.erase( C, FG, BG );
    }

    public static int color2Int( String S ) {
	    if ( S.toLowerCase().equals( "black" ) ) 
		return ANSI.BLACK;
	    if ( S.toLowerCase().equals( "red" ) ) 
		return ANSI.RED;
	    if ( S.toLowerCase().equals( "green" ) ) 
		return ANSI.GREEN;
	    if ( S.toLowerCase().equals( "yellow" ) ) 
		return ANSI.YELLOW;
	    if ( S.toLowerCase().equals( "blue" ) ) 
		return ANSI.BLUE;
	    if ( S.toLowerCase().equals( "magenta" ) ) 
		return ANSI.MAGENTA;
	    if ( S.toLowerCase().equals( "cyan" ) ) 
		return ANSI.CYAN;
	    if ( S.toLowerCase().equals( "white" ) ) 
		return ANSI.WHITE;
	    return ANSI.DEFAULT;
    }



    public static void outputGrid( Scanner inFile, Canvas MyC ){
	MyC.output();
    }

    public static void line( int x1, int y1, int x2, int y2, char C, int FG, int BG, furniture Myfurniture ) {
	double m;
	double b;
	int temp;
	int x, y;

	if ( x1 == x2 ) { // Vertical line
	    if ( y1 > y2 ) {
		temp = y1;
		y1 = y2;
		y2 = temp;
	    }
	    for ( int i = y1; i <= y2; i++ )
		Myfurniture.plot( x1, i, C, FG, BG );
	} else if ( y1 == y2 ) { // Horizontal line
	    if ( x1 > x2 ) {
		temp = x1;
		x1 = x2;
		x2 = temp;
	    }
	    for ( int i = x1; i <= x2; i++ )
		Myfurniture.plot( i, y1, C, FG, BG );
	} else {             // Diagonal Line
	    m = ( y2 - y1 ) * 1.0 / ( x2 - x1 ); // * 1.0 to force
						 // floating point
						 // math 
	    // y = mx + b, so
	    // b = y - mx  ....either point will solve for b
	    b = y1 - m * x1;  // m is double, so all the math will now
			      // be floating point math...want that
			      // precision! 
	    
	    if ( Math.abs( m ) <= 1.0 ) { // "flatter" line, loop on
					 // X's
		if ( x2 < x1 ) { // swap points to start on left
		    temp = x1;
		    x1 = x2;
		    x2 = temp;
		    temp = y1;
		    y1 = y2;
		    y2 = temp;
		}
		for ( x = x1; x <= x2; x++ ) {
		    y = (int)( m * x + b );
		    Myfurniture.plot( x, y, C, FG, BG );
		}
	    } else { // "Steeper" line, loop on Y's
		// y = mx + b, so
		// x = ( y - b ) / m
		if ( y2 < y1 ) { // swap points to start on at lower Y
		    temp = x1;   // value
		    x1 = x2;
		    x2 = temp;
		    temp = y1;
		    y1 = y2;
		    y2 = temp;
		}
		for ( y = y1; y <= y2; y++ ) {
		    x = (int)( ( y - b ) / m );
		    Myfurniture.plot( x, y, C, FG, BG );
		}
	    }
	}
    }

    public static void circle( int Cx, int Cy, float radius, char C, int FG, int BG, furniture Myfurniture ) {
	double start = 0.0;
	double stop  = Math.PI / 4.0;
	double step  = ( stop - start ) / 40;
	double angle = start;
	int    x     = 0;
	int    y     = 0;
	
	while ( angle < stop ) {
	    x = (int)( radius * Math.cos( angle ) );
	    y = (int)( radius * Math.sin( angle ) );
	    Myfurniture.plot( x + Cx, y + Cy, C, FG, BG );
	    Myfurniture.plot( y + Cx, x + Cy, C, FG, BG );
	    Myfurniture.plot( -x + Cx, y + Cy, C, FG, BG );
	    Myfurniture.plot( -y + Cx, x + Cy, C, FG, BG );
	    Myfurniture.plot( -x + Cx, -y + Cy, C, FG, BG );
	    Myfurniture.plot( -y + Cx, -x + Cy, C, FG, BG );
	    Myfurniture.plot( x + Cx, -y + Cy, C, FG, BG );
	    Myfurniture.plot( y + Cx, -x + Cy, C, FG, BG );
	    angle += step;
	}
   }

    public static void drawLine( Scanner inFile, furniture Myfurniture ){
	String token;
	char C;
	int FG, BG, x1, y1, x2, y2; 

	x1 = inFile.nextInt();
	y1 = inFile.nextInt();
	x2 = inFile.nextInt();
	y2 = inFile.nextInt();
	C = inFile.next().charAt(0);
	FG = color2Int( inFile.next() );
	BG = color2Int( inFile.next() );

	line( x1, y1, x2, y2, C, FG, BG, Myfurniture );
    }

    public static void drawCircle( Scanner inFile, furniture Myfurniture ){
	String token;
	char C;
	int FG, BG, Cx, Cy;
	float radius;

	Cx = inFile.nextInt();
	Cy = inFile.nextInt();
	radius = inFile.nextFloat();
	C = inFile.next().charAt(0);
	FG = color2Int( inFile.next() );
	BG = color2Int( inFile.next() );

	circle( Cx, Cy, radius, C, FG, BG, Myfurniture );
    }

    public static void plotPoint( Scanner inFile, furniture Myfurniture ){
	String token;
	char C;
	int FG, BG, Cx, Cy, radius;

	Cx = inFile.nextInt();
	Cy = inFile.nextInt();
	C = inFile.next().charAt(0);
	FG = color2Int( inFile.next() );
	BG = color2Int( inFile.next() );

	Myfurniture.plot( Cx, Cy, C, FG, BG );
    }

}
