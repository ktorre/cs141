public class formattedGauge extends Gauge {

    protected String format;

    public formattedGauge() {
	this( 0, 100 );
	format = "%f%";
    }

    public formattedGauge( int max ) {
	this( 0, max );
    }

    public formattedGauge( String format ) {
	this( 0, 100 );
	this.format = format;
    }
    
    public formattedGauge( int min, int max ) {
	super( min, max );
	format = "%f%";
    }

    public formattedGauge( int max, String format ) {
	this( 0, max, format );
    }

    public formattedGauge( int min, int max, String format ) {
	super( min, max );
	this.format = format;
    }


    public String toString() {
	return String.format( format, ( ( state - min ) * 100.0 ) / ( max - min ) );
    }

}