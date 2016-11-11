// Basic demo of polymorphism
public class basic {
    public static void main( String[] args ) {
	int x = 5;
	int y = 0;
	int z = 0;
	int[] list = new int[ 4 ];
	boolean done = false;

	while ( ! done ) {
	    try {
		if ( y == 0 ) throw new Exception( "Sample Message Exception" );
		x = x / z;
		list[ x ] = 20;
		done = true;
	    } catch ( Exception e ) {
		System.out.println( "Exception Msg: " + e.getMessage() );
		if ( y == 1 && z == 1 ) x = 0;
		if ( y == 1 ) z = 1;
		y = 1;
	    }
	}
	System.out.println( "Done.\n\n" );
	
    }
}