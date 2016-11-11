import java.util.Scanner;
import java.util.InputMismatchException;

public class tt {
	public static void main( String[] args ) {
		args = new String[1];
		int x = getInteger();
		while ( x >= 0 && x <= 100 ) {
			args[ 0 ] = "" + x;
			print_table( build_table( args ) );
			x = getInteger();
		}
    }

	public static int getInteger() {
	    Scanner k = new Scanner( System.in );
	    int     x = -1;

	    while ( x < 0 || x > 100 ) {
		    System.out.print( "Enter an integer [0-100] : " );
		    try {
			    x = k.nextInt();
			    if ( x == -1 ) return x;
			    if ( x < 0 || x > 100 ) {
				    // System.out.println( "Invalid Input" );
				    throw new InputMismatchException();
			    }
		    } catch ( InputMismatchException e ) {
			    System.out.println( "Invalid Input" );
		    }
	    }
	    return x;
    }

    public static int[][] build_table( String[] sa ) {
	int      size = Integer.parseInt( sa[0] ) + 1;
	int[][] table = new int[ size ][ size ];

	// Populating the times table
	for ( int row = 0; row < table.length; row++ ) {
	    for ( int col = 0; col < table[0].length; col++ ) {
		table[ row ][ col ] = row * col;
	    }
	}
	return table;
    }

    public static void print_table( int[][] T ) {
	print_header( T.length );
	print_rows( T );
    }

    public static void print_header( int len ) {
	// Print top label
	System.out.print( "     " );
	for ( int col = 0; col < len; col++ ) {
	    System.out.printf( "%4d", col );
	}
	System.out.print( "\n" );

	System.out.print( "    +" );
	for ( int col = 0; col < 4 * len ; col++ ) {
	      System.out.print( "-" );
	}
	System.out.print( "\n" );
    }

    public static void print_rows( int[][] T ) {
	for ( int row = 0; row < T.length; row++ ) {
	    print_row( row, T );
	}
    }

    public static void print_row( int row, int[][] T ) {
	System.out.printf( "%3d |", row );
	for ( int col = 0; col < T[0].length; col++ ) {
	    System.out.printf( "%4d", T[ row ][ col ] );
	}
	System.out.print( "\n" );
    }
}
