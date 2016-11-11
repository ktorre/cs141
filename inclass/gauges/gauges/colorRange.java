public class colorRange {
    protected int min;
    protected int max;
    protected int color;

    public colorRange( int min, int max, int color ) {
	if ( min < max ) {
	    this.min = min;
	    this.max = max;
	} else {
	    this.min = max;
	    this.max = min;
	}
	this.color = Math.abs(color) % 10 + 40;
	if ( this.color == 48 ) this.color = 49;
    }

    public boolean inRange( int value ) {
	return ( min <= value ) && ( value <= max );
    }
    
    public String toString() {
	return (char)27 + "[" + color + "m";
    }
}