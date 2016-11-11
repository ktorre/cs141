public class coloredBarGauge extends barGauge {

    private colorRange[] ranges = new colorRange[ 9 ];
    private int  numColorRanges = 0;
    private String defaultColor = (char)27 + "[49m";
    public char barChar = ' ';

    public coloredBarGauge( int min, int max, int width ) {
	super( min, max, width );
    }

    public boolean setRange( int num1, int num2, int color ) {
	if ( numColorRanges >= ranges.length ) return false;
	ranges[ numColorRanges++ ] = new colorRange( num1, num2, color );
	return true;
    }

    private String getColor( int i ) {
	// 0 < i < width-2  => need percentage
	int widthPercent = (int)( ( i * 1.0 ) / ( width - 2 ) * 100.0 );

	for ( colorRange cr : ranges ) {
	    if ( cr == null ) return null;
	    if ( cr.inRange( widthPercent ) )
		return "" + cr;
	}
	return null;
    }

    public String toString() {
	double percent = ( ( state - min ) * 1.0 ) / ( max - min );
	int stopColor = (int)( ( width - 2 ) * percent );
	String S = "" + leftBar;
	String color = "";

	for ( int i = 0; i < width - 2; i++ ) {
	    if ( i >= stopColor ) 
		S += defaultColor + barChar;
	    else {
		color = getColor( i );
		if ( color == null )
		    S += defaultColor + barChar;
		else
		    S += color + barChar;
	    }
	}
	return S + defaultColor + rightBar;
    }
}