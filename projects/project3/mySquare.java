// De La Torre, Kevin {ktorre}
// CS 141 01
// Project #3 : Shape Inheritance
//

public class mySquare extends myLine {
	protected int length;

	public mySquare( int length ) {
		super( length );
		grow( length, length );
		this.length = length;
	}

	public void makeSquare( int x, int y ) {
		super.width = length;
		
		// Top Line
		makeLine( y, x );

		// Left Line
		makeVerticalLine( y, x );

		// Bottom Line
		makeLine( y + ( length - 1 ), x );

		// Right Line
		makeVerticalLine( y + (length - 1), x );
	}

	public void makeVerticalLine( int x, int y ) {
		
		for ( int i = y; i < ( length + y ); i++ ) {
			plot( i, x );
		}
	}
}
