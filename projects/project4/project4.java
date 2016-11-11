// De La Torre, Kevin { ktorre }
// CS 141 01
// Project #4 : PolyPlay
//

import java.util.Scanner;
import java.util.Arrays;

public class project4 {
	// Object array to hold both the keys and the values
	// I make it a size of 7 because there are 7 data types
	// so I'm going to make a 2d array to hold the type at the
	// top then the values below it
	private static Object[][] dataTypes = new Object[ 7 ][]; 
	
	public static void main( String[] args ) {
		Scanner input = new Scanner( System.in );

		initializeArray();
		readCommands( input );
		sortArray();
		printResults();
	}

	public static void initializeArray() {
		// The array datatype values are as follows:
		// 0 = "Character";
		// 1 = "Double";
		// 2 = "Exception";
		// 3 = "Float";
		// 4 = "Integer";
		// 5 = "Long";
		// 6 = "String";
		//
		for ( int i = 0; i < dataTypes.length; i++ ) {
			dataTypes[ i ] = new Object[0];
		}

	}

	public static void readCommands( Scanner input ) {
		char token = input.next().toLowerCase().charAt(0);

		while ( token != 'q' ) {
			switch ( token ) {
				case 'c': 
					increaseArray( 0 );
					dataTypes[ 0 ][ dataTypes[ 0 ].length - 1 ] = input.next().charAt(0);
					break;
				case 'd':
					increaseArray( 1 );
					dataTypes[ 1 ][ dataTypes[ 1 ].length - 1 ] = input.nextDouble();
					break;
				case 'e':
					increaseArray( 2 );
					dataTypes[ 2 ][ dataTypes[ 2 ].length - 1 ] = input.next();
					break;
				case 'f':
					increaseArray( 3 );
					dataTypes[ 3 ][ dataTypes[ 3 ].length - 1 ] = input.nextFloat();
					break;
				case 'i':
					increaseArray( 4 );
					dataTypes[ 4 ][ dataTypes[ 4 ].length - 1 ] = input.nextInt();
					break;
				case 'l':
					increaseArray( 5 );
					dataTypes[ 5 ][ dataTypes[ 5 ].length - 1 ] = input.nextLong();
					break;
				case 's':                		    
					increaseArray( 6 );
					dataTypes[ 6 ][ dataTypes[ 6 ].length - 1] = input.nextLine().trim();
					break;
			}
			token = input.next().toLowerCase().charAt(0);
		}	
	}

	public static void increaseArray( int position ) {
		// Increase the size of the specific dataType array by 1
		Object[] tempArray = new Object[ dataTypes[ position ].length + 1 ];
		for ( int i = 0; i < dataTypes[ position ].length; i++ ) {
			tempArray[ i ] = dataTypes[ position ][ i ];
		}
		dataTypes[ position ] = tempArray;
	}

	public static void sortArray() {
		// use the arrays class to sort the object array by data type
		for ( int i = 0; i < dataTypes.length; i++ ) {
			Arrays.sort( dataTypes[i] );
		}
	}

	public static void printResults() {
		String type = "";
		String format = "";
		for ( int i = 0; i < dataTypes.length; i++ ) {
			switch ( i ) {
				case 0 : type = "Character"; format = "%10c"; break;
				case 1 : type = "Double"; format = "%10.2f"; break;
				case 2 : type = "Exception"; format = "%s"; break;
				case 3 : type = "Float"; format = "%10.2f"; break;
				case 4 : type = "Integer"; format = "%10d"; break;
				case 5 : type = "Long"; format = "%10d"; break;
				case 6 : type = "String"; format = "%s"; break;
			}

			for ( int j = 0; j < dataTypes[i].length; j++ ) {
				// Strings use a different formatting string in order to make them
				// go to the right so I split them using polymorphism.
				if ( dataTypes[ i ][ j ] instanceof String ) {
					System.out.printf( "%-15s:%9s" + format + "%n", type, "", dataTypes[ i ][ j ] );
				} else {
					System.out.printf( "%-15s:" + format + "%n", type, dataTypes[ i ][ j ] );	
				}
			}
		}
	}
}
