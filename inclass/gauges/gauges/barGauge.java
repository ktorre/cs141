public class barGauge extends Gauge {

    protected int width; // width of entire bar including leftBar/rightBar
    protected char leftBar = '|';
    protected char rightBar = '|';
    protected char progress = '>';

    public barGauge() {
	width = 20;
    }

    public barGauge( int min, int max, int width ) {
	super( min, max );
	this.width = width;
    }

    public String toString() {
	double percent = ( ( state - min ) * 1.0 ) / ( max - min );
	int numOfEquals = (int)( ( width - 2 ) * percent );
	String S = "" + leftBar;

	for ( int i = 0; i < width - 2; i++ ) {
	    if ( i < numOfEquals ) 
		S += '=';
	    else if ( i == numOfEquals )
		S += progress;
	    else
		S += ' ';
	}
	return S + rightBar;
    }

}