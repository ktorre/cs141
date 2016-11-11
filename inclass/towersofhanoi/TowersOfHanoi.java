public class TowersOfHanoi {

    public static int moves = 0;
    
    public static void main( String[] args ) {
	int numDisks = Integer.parseInt( args[0] );
	int srcPost = 1;
	int tmpPost = 2;
	int dstPost = 3;

	//  Solve TOH for numDisks from srcPost to dstPost using tmpPost as temp storage
	solveTOH( numDisks, srcPost, dstPost, tmpPost );
    }

    // The recursion...
    public static void solveTOH( int numDisks, int SRC, int DST, int TMP ) {
	if ( numDisks > 1 ) {
	    // move N-1 disks from SRC to TMP, using DST as temp
	    solveTOH( numDisks - 1, SRC, TMP, DST );
	    // move Disk N from SRC to DST
	    moves++;
	    System.out.println( "Move Disk " + numDisks + " from " +
				"post " + SRC + " to post " + DST +
				" : Moves = " + moves );

	    // move N-1 disks form TMP to DST, using SRC as temp
	    solveTOH( numDisks - 1, TMP, DST, SRC );
	} else {
	    // move Disk N from SRC to DST
	    moves++;
	    System.out.println( "Move Disk " + numDisks + " from " +
				"post " + SRC + " to post " + DST +
				" : Moves = " + moves );

	}
    }
}
