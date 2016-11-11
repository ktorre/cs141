// Circle will be computed as centered at (0,0) on a typical
// graph.  Then we'll "translate" the point to the screen.
//
// For circles, we only need to compute the first 45 degrees
// worth.  The rest are just transpositions of those computed
// points. 
//
// Note: Math.sin( angle ) and Math.cos( angle ) take angle in
// radians! 

public class asciiCircleAnim {

    public static final char $ESC = (char)27;

    public static void main( String[] args ) {
	int    radius = getRadius( args );
	double  steps = getSteps( args );

	double startAngle = 0.0;
	double  stopAngle = Math.PI /4.0;  // We're going to go from
					   // 0 to Pi/4
	double  stepAngle = ( stopAngle - startAngle ) / steps;
	double      angle = startAngle;

	int             X = 0;
	int             Y = 0;

	// Clear the screen
	System.out.print( $ESC + "[2J" );

	// Now loop
	while ( angle <= stopAngle ) {
	    X = (int)( radius * Math.cos( angle ) );
	    Y = (int)( radius * Math.sin( angle ) );
	    plot( X, Y, radius );
	    sleepTime( 250 );
	    angle += stepAngle;
	}
	sleepTime( 3600000 );
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
    
    // Here is where we take a single point and "plot it" onto the
    // graph.  In reality, this method only determines the other
    // points (transpositions) to plot.  Then we'll use "screenPlot"
    // to actually put the points onto the screen.
    public static void plot( int x, int y, int radius ) {
	// (x,y) is only in the first 8th of the circle.  The other
	// points are:

	// Quadrant #1: (x,y), (y,x)
	screenPlot( x, y, radius );
	screenPlot( y, x, radius );

	// Quadrant #2: (-x,y), (-y,x)
	screenPlot( -x, y, radius );
	screenPlot( -y, x, radius );
	
	// Quadrant #3: (-x,-y), (-y,-x)
	screenPlot( -x, -y, radius );
	screenPlot( -y, -x, radius );

	// Quadrant #4: (x,-y), (y,-x)
	screenPlot( x, -y, radius );
	screenPlot( y, -x, radius );
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
    public static void screenPlot( int x, int y, int radius ) {
	// Notice all print statements use only 'print', not
	// 'println'! 

	// Shift our ( X, Y )
	x += radius;
	y += radius;

	// Move the cursor to the screen position
	// Notice the y-coord is placed first.
	System.out.print( $ESC + "[" + y + ";" + x + "H" );

	// Now print a "point"
	System.out.print( "*" );
    }

}


