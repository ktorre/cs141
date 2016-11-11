// De La Torre, Kevin {ktorre}
// CS 141 01
// Project #3 : Shape Inheritance
//

// Purpose: make a line for the char2D array
//

public class myLine extends char2D {
	protected int width;
	
	public myLine( int width ) {
		super( 1, width );
		this.width = width;
	}

	public void makeLine( int y, int x ) {
		
		for ( int i = x; i < ( width + x ); i++ ) {
			plot( y, i );
		}
	}

}
