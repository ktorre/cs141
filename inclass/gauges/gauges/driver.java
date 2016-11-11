public class driver {
    public static void main( String[] args ) {
	String type = args[ 0 ];

	switch ( type.toLowerCase().charAt( 0 ) ) {
	case 'c': testColoredBarGauge( args ); break;
	case 'b': testBarGauge( args ); break;
	case 'g': testGauge( args ); break;
	case 'f': testFormattedGauge( args ); break;
	}
    }

    public static void testGauge( String[] args ) {
	int min = Integer.parseInt( args[ 1 ] );
	int max = Integer.parseInt( args[ 2 ] );
	int ms  = Integer.parseInt( args[ 3 ] );
	Gauge G = new Gauge( min, max );

	for (int i = min; i <= max; i++ ) {
	    G.state( i );
	    System.out.println( G );
	    pause( ms );
	}
    }

    public static void pause( int ms ) {
	try {
	    Thread.sleep( ms );
	} catch ( Exception e ) {}
    }

    public static void testFormattedGauge( String[] args ) {
	int min = Integer.parseInt( args[ 1 ] );
	int max = Integer.parseInt( args[ 2 ] );
	int ms  = Integer.parseInt( args[ 3 ] );
	formattedGauge F = new formattedGauge( min, max, "%6.2f%%" );

	for (int i = min; i <= max; i++ ) {
	    F.state( i );
	    System.out.println( F );
	    pause( ms );
	}
    }
    public static void testBarGauge( String[] args ) {
	int min   = Integer.parseInt( args[ 1 ] );
	int max   = Integer.parseInt( args[ 2 ] );
	int width = Integer.parseInt( args[ 3 ] );
	int ms    = Integer.parseInt( args[ 4 ] );
	barGauge G = new barGauge( min, max, width );

	for (int i = min; i <= max; i++ ) {
	    G.state( i );
	    System.out.print( "\r" + G );
	    pause( ms );
	}
	System.out.println();
    }

    public static void testColoredBarGauge( String[] args ) {
	int min   = Integer.parseInt( args[ 1 ] );
	int max   = Integer.parseInt( args[ 2 ] );
	int width = Integer.parseInt( args[ 3 ] );
	int ms    = Integer.parseInt( args[ 4 ] );
	coloredBarGauge G = new coloredBarGauge( min, max, width );
	
	G.setRange( 0, 30, 41 );
	G.setRange( 30, 60, 42 );
	G.setRange( 60, 90, 43 );
	G.setRange( 90, 100, 44 );

	for (int i = min; i <= max; i++ ) {
	    G.state( i );
	    System.out.print( "\r" + G );
	    pause( ms );
	}
	System.out.println();
    }
    
}