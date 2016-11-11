// De La Torre, Kevin {ktorre}
// CS 141 01
// Project #3 : Shape Inheritance
//

public class myCube extends mySquare {
	protected int length;
	
	public myCube( int length ) {
		super( length );
		
		// We grow the array to 1.5 times the original size because the diagonal
		// lines are half of the length so we have to create space for the second square.
		grow( ( (int)(1.5 * length)+((length%10)%2)), ((int)(1.5 * length )+((length%10)%2)) );
		
	}

	public void makeCube() {
		this.length = super.length;
		// First we make the square in the back
		makeSquare( 0, 0 ); 

		// Then we make the second square in the front
		// I subtracted one because for some reason I was having a bug where the square was one too big.
		makeSquare( ( ( int )( length * .5 - 1 ) ), ( ( int )( length * .5 - 1 ) ) );


		// Then we connect them together.
		makeDiagonals();

	}

	public void makeDiagonals() {
		// Subtracted one here too due to the same reason as before
		for ( int i = 0; i < (int)( length * .5 - 1 ); i++ ) {

			// top left
			plot( i, i );

			// top right
			plot( i, (length + i - 1) );

			// bottom right
			plot( i + length, ( i + length ) );

			// bottom left
			plot( ( length + i - 1 ), i );
		}
	}
}
