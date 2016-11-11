// Circle will be computed as centered at (0,0) on a typical
// graph.  Then we'll "translate" the point to the screen.
//
// For circles, we only need to compute the first 45 degrees
// worth.  The rest are just transpositions of those computed
// points. 
//
// Note: Math.sin( angle ) and Math.cos( angle ) take angle in
// radians! 

public class asciiCircleColor {

    public static final char $ESC = (char)27;
    public static final double $2PI = 2.0 * Math.PI;

    public static void main( String[] args ) {
	int    radius = getRadius( args );
	double  steps = getSteps( args );
	long       ms = Integer.parseInt( args[2] );

	double  stepAngle = $2PI / steps;
	double      angle = 0.0;

	int             X = 0;
	int             Y = 0;

	// Clear the screen
	System.out.print( $ESC + "[2J" );

	// Now loop
	while ( true ) {
	    X = (int)( radius * Math.cos( angle ) );
	    Y = (int)( radius * Math.sin( angle ) );
	    screenPlot( X, Y, radius, ' ', 30 ); // 31 == read text color
	    System.out.print( $ESC + "[0;0H" ); // move cursor to (1,1)
	    if ( angle >= $2PI )
		angle = 0.0;
	    sleepTime( ms );
	    angle += stepAngle;
	    screenPlot( X, Y, radius, '*', 30 );
	}
    }

    public static int getRadius( String[] args ) {
	if ( args.length == 0 ) return 10;
	return Integer.parseInt( args[0] );
    }

    public static int getSteps( String[] args ) {
	if ( args.length < 2 ) return 5;
	return Integer.parseInt( args[1] );
    }

    public static void sleepTime( long time ) {
	try { 
	    Thread.sleep( time );
	} catch ( Exception e ) {
	}
    }
    
    // This takes a typical point on the circle and shoves it all into
    // the screen dimensions.
    // 
    // For this example, we'll put the center of the circle at screen
    // position (30,30).
    //
    // This means every point on our circle, needs to be plus'd 30.
    // 
    // Of course, this assumes our radius will be 30 or less.
    public static void screenPlot( int x, int y, int radius, char C, int color ) {
	// Notice all print statements use only 'print', not
	// 'println'! 

	// Shift our ( X, Y )
	x += radius;
	y += radius;

	// Move the cursor to the screen position
	// Notice the y-coord is placed first.
	System.out.print( $ESC + "[" + y + ";" + x + "H" );
	System.out.print( $ESC + "[" + color + "m" );

	// Now print a "point"
	System.out.print( C );
    }

}


