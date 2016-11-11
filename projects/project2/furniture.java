public class furniture {
    private charCell[][] shape;
    
    public furniture(int width, int height) {
	shape = new charCell[ width ][ height ];
    }
    
    public void setDefault(char C, int FG, int BG) {
	for ( int i = 0; i < shape.length; i++ )
	    for ( int j = 0 ; j < shape[0].length; j++ ) 
		shape[ i ][ j ] = new charCell( C, FG, BG );

    }

    public void plot( int x, int y, char C, int FG, int BG ) {
	try {
	    shape[ x ][ y ] = new charCell( C, FG, BG );
	} catch ( ArrayIndexOutOfBoundsException e ) {
	    throw new ArrayIndexOutOfBoundsException( "." );
	}
    }

    public void flipVertical() {
	charCell[][] temp = new charCell[ shape.length ][ shape[0].length ];
	
	for ( int row = 0; row < shape.length; row++ ) 
	    for ( int col = 0; col < shape[0].length; col++ )
		temp[ shape.length - row - 1 ][ col ] = shape[ row ][ col ];
	
	for ( int i = 0; i < shape.length; i++ ) 
	    for ( int j = 0; j < shape[0].length; j++ )
		shape[i][j] = temp[i][j];
    }

    public void flipHorizontal() {
	charCell[][] temp = new charCell[ shape.length ][ shape[0].length ];
	
	for ( int col = 0; col < shape.length; col++ ) 
	    for ( int row = 0; row < shape[0].length; row++ )
		temp[ row ][ shape[0].length - col - 1 ] = shape[ row ][ col ];

	for ( int i = 0; i < shape.length; i++ ) 
	    for ( int j = 0; j < shape[0].length; j++ )
		shape[i][j] = temp[i][j];

    }

    public void rotate() {
	charCell[][] temp = new charCell[ shape[0].length ][ shape.length ];

//	for ( int row = 0; row < shape.length; row++ )
//	    for ( int col = 0; col < shape[0].length; col++ )
//		temp[ shape[0].length - col - 1 ][ row ] = shape[ row ][ col ];

	for (int i = 0; i < shape[0].length; i++) {
	    for (int j = 0; j < shape.length; j++) {
		temp[j][shape.length - i - 1] = shape[i][j];
	    }
	}
	shape = temp;

    }

    public int getWidth() {
	return shape.length;
    }

    public int getHeight() {
	return shape[0].length;
    }

    public charCell getData( int x, int y ) {
	return shape[x][y];
    }

}
