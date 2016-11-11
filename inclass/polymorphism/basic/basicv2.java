// Basic demo of polymorphism, with 'instanceof'
public class basicv2 {
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
		if ( e instanceof ArithmeticException )
		    System.out.print( "Arithmetic Exception: " );
		else if ( e instanceof ArrayIndexOutOfBoundsException )
		    System.out.print( "Bad Array Index: " );
		else if ( e instanceof Exception )
		    System.out.print( "General Exception: " );
		else
		    System.out.print( "???????: " );
		System.out.println( e.getMessage() );
		if ( y == 1 && z == 1 ) x = 0;
		if ( y == 1 ) z = 1;
		y = 1;
	    }
	}
	System.out.println( "Done.\n\n" );
	
    }
}