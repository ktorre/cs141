// De La Torre, Kevin {ktorre}
// CS 141 01
// Project #3 : Shape Inheritance
//

// Purpose: In charge of managing a 2D array.
// Constructor:
// 	- Takes height and width
// Methods:
// 	- plot method
// 		- Takes x and y position (no character)
// 	- toString method
// 		- Return a string representation of the array
// 	- grow method
// 		- Takes height and width and grows the array by the given sizes
//

public class char2D {

	protected char[][] charArray;
	protected int height;
	protected int width;

	// Constructor used to make the array to hold the data
	public char2D( int height, int width ) {
		this.height = height;
		this.width = width;
		charArray = new char[ height ][ width ];
	}
	
	// Method to increase the size of the array to the given size
	public void grow( int height, int width ) {

		// Create a temporary array that will take place of the current array
		char[][] tempArray = new char[this.height + ( height - this.height )][ this.width + ( width - this.width ) ];
		
		for ( int i = 0; i < charArray.length; i++ ) {
			for ( int j = 0; j < charArray[0].length; j++ ) {
				tempArray[i][j] = charArray[i][j];
			}
		}

		charArray = tempArray;
		this.width = width;
		this.height = height;
	}

	public void plot( int y, int x ) {
		charArray[y][x] = '*';
	}


	public String toString() {
		// String to hold the array
		String tempString = "";
		
		for ( int i = 0; i < charArray.length; i++ ) {
			for ( int j = 0; j < charArray[0].length; j++ ) {
				// add character to string
				if (charArray[i][j] == '*') {
					tempString += charArray[i][j];
				} else {
					tempString += " ";	
				}

			}
			// jump to next line
			tempString += "\n";
		}
		// Added in a newline to the return to separate the shapes
		return tempString + "\n";
	}
}
