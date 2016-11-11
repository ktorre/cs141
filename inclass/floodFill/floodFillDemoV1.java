// This demo uses the flood fill method which checks only the 4 adjacent cells.
public class floodFillDemoV1 {
    public static void main( String[] args ) {
	char[][] canvas = new char[ 100 ][ 100 ];

	clear( canvas );
	square( 10, 10, 50, 50, '+', canvas );
	square( 30, 30, 70, 70, '+', canvas );
	line( 11, 11, 69, 69, (char)92, canvas );
	circle( 30, 30, 20, 'o', canvas );
	circle( 50, 50, 20, 'o', canvas );
	plot( 43, 37, 'x', canvas );
	display( canvas );
	floodFill( 37, 43, 'x', canvas );
	pause( 10000 );
    }

    public static void clear( char[][] canvas ) {
	for ( int i = 0; i < canvas.length; i++ )
	    for ( int j = 0; j < canvas[ i ].length; j++ )
		canvas[ i ][ j ] = ' ';
    }

    public static void display( char[][] canvas ) {
	System.out.print( (char)27 + "[2J" ); // clear screen
	System.out.print( (char)27 + "[0;0H" ); // cursor to 0,0
	// Outer loop needs to be my Y-coords since the screen
	//  prints left to right first.
	for ( int j = 0; j < canvas[ 0 ].length; j++ ) {
	    for ( int i = 0; i < canvas.length; i++ )
		System.out.print( canvas[ i ][ j ] );
	    System.out.println();
	}
    }

    public static void pause( int ms ) {
	try {
	    Thread.sleep( ms );
	} catch ( Exception e ) {}
    }

    public static void plot( int x, int y, char c, char[][] canvas ) {
	canvas[ x ][ y ] = c;
    }

    public static void circle( int Cx, int Cy, int radius, 
			       char c, char[][] C ) {
	double start = 0.0;
	double stop  = Math.PI / 4.0;
	double step  = ( stop - start ) / 40;
	double angle = start;
	int    x     = 0;
	int    y     = 0;

	while ( angle < stop ) {
	    x = (int)( radius * Math.cos( angle ) );
	    y = (int)( radius * Math.sin( angle ) );
	    plot( x + Cx, y + Cy, c, C );  // Quad 1
	    plot( y + Cx, x + Cy, c, C );  // Quad 1
	    plot( -x + Cx, y + Cy, c, C ); // Quad 2
	    plot( -y + Cx, x + Cy, c, C ); // Quad 2
	    plot( -x + Cx, -y + Cy, c, C );// Quad 3
	    plot( -y + Cx, -x + Cy, c, C );// Quad 3
	    plot( x + Cx, -y + Cy, c, C ); // Quad 4
	    plot( y + Cx, -x + Cy, c, C ); // Quad 4
	    angle += step;
	}
    }
    
    public static void line( int x1, int y1, int x2, int y2,
			     char c, char[][] C ) {
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
		plot( x1, i, c, C );
	} else if ( y1 == y2 ) { // Horizontal line
	    if ( x1 > x2 ) {
		temp = x1;
		x1 = x2;
		x2 = temp;
	    }
	    for ( int i = x1; i <= x2; i++ )
		plot( i, y1, c, C );
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
		    plot( x, y, c, C );
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
		    plot( x, y, c, C );
		}
	    }
	}
    }

    public static void square( int x1, int y1, int x2, int y2,
			       char c, char[][] C ) {
	line( x1, y1, x2, y1, c, C );
	line( x1, y1, x1, y2, c, C );
	line( x1, y2, x2, y2, c, C );
	line( x2, y1, x2, y2, c, C );
    }

    public static void floodFill( int x, int y, char c, char[][] C ) {
	if ( C[ x ][ y ] != ' ' ) return; // If not blank, no need to recurse.
	plot( x, y, c, C );
	display( C );
	pause( 200 );
	if ( x + 1 < C.length )
	    floodFill( x + 1, y, c, C ); // go right
	if ( x - 1 >= 0 )
	    floodFill( x - 1, y, c, C ); // go left
	if ( y - 1 >= 0 )
	    floodFill( x, y - 1, c, C ); // go up
	if ( y + 1 < C[ 0 ].length )
	    floodFill( x, y + 1, c, C ); // go down
    }

}