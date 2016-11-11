public class tohAnimated {

    public static final int $SRC = 0;
    public static final int $TMP = 1;
    public static final int $DST = 2;
    public static int $MS = 0;
    public static int moves = 0;
    
    public static void main( String[] args ) {
	int numDisks = Integer.parseInt( args[0] );

	String[][] posts = new String[ 3 ][ numDisks + 2 ];
	buildPost( posts, $SRC, numDisks );
	buildPost( posts, $TMP, 0 );
	buildPost( posts, $DST, 0 );
	
	displayPosts( posts );

	//  Solve TOH for numDisks from srcPost to dstPost using tmpPost as temp storage
	solveTOH( posts, numDisks, $SRC, $DST, $TMP );
    }

    // The recursion...
    public static void solveTOH( String[][] posts, int numDisks, int SRC, int DST, int TMP ) {
	if ( numDisks > 1 ) {
	    // move N-1 disks from SRC to TMP, using DST as temp
	    solveTOH( posts, numDisks - 1, SRC, TMP, DST );
	    // move Disk N from SRC to DST
	    //	    System.out.println( "Move Disk " + numDisks + " from " +
	    //				"post " + SRC + " to post " + DST );
	    moves++;
	    if ( ! moveDisk( posts, SRC, DST ) ) {
		System.out.println( "Error!" );
	    };
	    // move N-1 disks form TMP to DST, using SRC as temp
	    solveTOH( posts, numDisks - 1, TMP, DST, SRC );
	} else {
	    // move Disk N from SRC to DST
	    //	    System.out.println( "Move Disk " + numDisks + " from " +
	    //				"post " + SRC + " to post " + DST );
	    moves++;
	    if ( ! moveDisk( posts, SRC, DST ) ) {
		System.out.println( "Error!" );
	    };
	}
    }

    public static void cls() {
	System.out.print( "\033[2J" );
	System.out.print( "\033[0;0H" );
    }

    public static void pause() {
	try {
	    Thread.sleep( $MS );
	} catch ( Exception e ) {
	}
    }

    public static void displayPosts( String[][] post ) {
	pause();
	cls();

	for ( int pos = 0; pos < post[ 0 ].length; pos++ ) {	
	    for ( int postNum = 0; postNum < 3; postNum++ ) {
		System.out.print( post[ postNum ][ pos ] + "     " );
	    }
	    System.out.println();
	}
	System.out.println( "Moves : " + moves ); 
    }

    public static void buildPost( String[][] posts, int P, int N ) {
	int width = ( 2 * ( posts[ P ].length - 2 ) + 5 ); 
	String tmp; 

	// Handle the base
	posts[ P ][ posts[ P ].length - 1 ] = String.format( "%" + width +
							     "s", ' ' ).replace( ' ', '=' );
	for ( int disk = posts[ P ].length - 2; disk >= 0; disk-- ) {
	    if ( N > 0 ) {
		tmp = String.format( "%" + N + "s", ' ').replace( ' ', '-' );
		tmp = '(' + tmp + N + tmp + ')';
		tmp = String.format( "%" + ((width - tmp.length())/2) + "s", ' ' ) +
		    tmp +
		    String.format( "%" + ((width - tmp.length())/2) + "s", ' ' );
		posts[ P ][ disk ] = tmp;
		N--;
	    } else {
		// Put a "blank" onto post
		tmp = String.format( "%" + width + "s", ' ' );
		tmp = tmp.substring( 0, tmp.length() / 2 );
		posts[ P ][ disk ] = tmp + '|' + tmp;
	    }
	}

    }

    public static boolean moveDisk( String[][] posts, int SRC, int DST ) {
	int srcPos = findDisk( posts, SRC );
	int dstPos = findAvailable( posts, DST );
	String tmp;

	if ( srcPos < 0 || dstPos < 0 ) return false;

	posts[ DST ][ dstPos ] = posts[ SRC ][ srcPos ];
	posts[ SRC ][ srcPos ] = posts[ SRC ][ 0 ];
	displayPosts( posts );
	return true;
    }

    public static int findAvailable( String[][] posts, int P ) {
	for ( int pos = posts[ P ].length - 1 ; pos >= 0; pos-- )
	    if ( posts[ P ][ pos ].matches( ".*\\|.*" ) )
		return pos;
	return -1;
    }

    public static int findDisk( String[][] posts, int P ) {
	for ( int pos = 0; pos < posts[ P ].length; pos++ )
	    if ( posts[ P ][ pos ].matches( ".*[0-9].*" ) )
		return pos;
	return -1;
    }
}
