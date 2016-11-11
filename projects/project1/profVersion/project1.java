import java.util.Scanner;
import java.io.*;
public class project1 {
    public static void main( String[] args ) throws IOException {
	Scanner inFile = new Scanner( new File( args[1] ) );
	String[] cypherLines;
	
	outputHeaderLines( inFile );
	cypherLines = getCypherLines( inFile );
	outputObscureLines( process( args[0], getDataArrayFrom( cypherLines ) ), cypherLines );
	outputRestOfLines( inFile );
	inFile.close();
    }

    public static void outputRestOfLines( Scanner F ) {
	while ( F.hasNext() )
	    System.out.println( F.nextLine() );
    }

    public static void outputObscureLines( char[][] data, String[] lines ) {
	// Print data chars and then rest of chars from lines
	for ( int row = 0; row < data.length; row++ ) {
	    for ( int col = 0; col< data.length; col++ ) {
		System.out.print( data[ row ][ col ] );
	    }
	    for ( int col = data.length; col < lines[ row ].length(); col++ ) {
		System.out.print( lines[ row ].charAt( col ) );
	    }
	    System.out.println();
	}
	// Now output that "extra" line we remembered
	System.out.println( lines[ lines.length - 1 ] );
    }

    public static char[][] process( String command, char[][] dataArray ) {
	char[][] newDataArray = duplicate( dataArray );

	for ( int i = 0; i < command.length(); i++ ) {
	    switch ( command.charAt( i ) ) {
	    case 'v':
	    case 'V':
		newDataArray = flipVertical( newDataArray ); break;
	    case 'h':
	    case 'H':
		newDataArray = flipHorizontal( newDataArray ); break;
	    case 'r':
	    case 'R':
		newDataArray = rotate( newDataArray ); break;
	    default:
		// this should be an error, but we'll presume the
		// command sequence is valid and do nothing.
	    }
	}
	return newDataArray;
    }

    public static char[][] rotate( char[][] data ) {
	char[][] temp = new char[ data.length ][ data.length ];

	for ( int row = 0; row < data.length; row++ )
	    for ( int col = 0; col < data.length; col++ )
		temp[ data.length - col - 1 ][ row ] = data[ row ][ col ];
	return temp;
    }

    public static char[][] flipHorizontal( char[][] data ) {
	char[][] temp = new char[ data.length ][ data.length ];
	
	for ( int col = 0; col < data.length; col++ ) 
	    for ( int row = 0; row < data.length; row++ )
		temp[ row ][ data.length - col - 1 ] = data[ row ][ col ];
	return temp;
    }

    public static char[][] flipVertical( char[][] data ) {
	char[][] temp = new char[ data.length ][ data.length ];
	
	for ( int row = 0; row < data.length; row++ ) 
	    for ( int col = 0; col < data.length; col++ )
		temp[ data.length - row - 1 ][ col ] = data[ row ][ col ];
	return temp;
    }

    public static char[][] duplicate( char[][] data ) {
	char[][] temp = new char[ data.length ][ data.length ];

	for ( int row = 0; row < data.length; row++ )
	    for ( int col = 0; col < data[ row ].length; col++ )
		temp[ row ][ col ] = data[ row ][ col ];
	return temp;
    }

    public static char[][] getDataArrayFrom( String[] lines ) {
	char[][] data = new char[ lines.length - 1 ][ lines.length - 1 ];

	// Only process valid cypher lines
	for ( int row = 0; row < lines.length - 1; row++ ) 
	    for ( int col = 0; col < lines.length - 1; col++ )
		data[ row ][ col ] = lines[ row ].charAt( col );
	return data;
    }

    public static String[] getCypherLines( Scanner F ) {
	String[] lines = new String[0];
	String currentLine = F.nextLine();

	while ( ( currentLine.length() == 64 ) && 
		( lines.length <= 64 ) &&
		noEqualSigns( currentLine ) ) {
	    lines = push( lines, currentLine );
	    currentLine = F.nextLine();
	}
	// I have a current line of cypher text I need to preserve.
	return push( lines, currentLine );
    }

    public static void outputHeaderLines( Scanner F ) {
	String currentLine = "";
	
	do {
	    currentLine = F.nextLine();
	    System.out.println( currentLine );
	} while ( ! blank( currentLine ) );
	System.out.println();
    }
    
    public static String[] push( String[] list, String item ) {
	String[] newList = new String[ list.length + 1];

	for ( int i = 0; i < list.length; i++ )
	    newList[ i ] = list[ i ];
	newList[ list.length ] = item;
	return newList;
    }

    public static boolean noEqualSigns( String line ) {
	// If they exist, they'll be at the end, so just check the
	// last char 
	return line.charAt( line.length() - 1 ) != '=';
    }

    public static boolean blank( String line ) {
	for ( int i = 0; i < line.length(); i++ )
	    if ( ( line.charAt( i ) != ' ' ) &&
		 ( line.charAt( i ) != (char)9 ) )
		return false;
	return true;
    }

}
