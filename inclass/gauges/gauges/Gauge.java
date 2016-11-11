public class Gauge {

    protected int min, max, state;

    // Set up default constructor which will call, other overloaded constructor with 2 int parameters 
    // Set the guage values equal from 0 to 100
    public Gauge() {
	this( 0, 100 );
    }

    // If a guage is created with just 1 int create from 0 to the number given.
    public Gauge( int max ) {
	this( 0, max );
    }

    // Create's a guage with the 2 ints given, and set's the state at 0.
    public Gauge( int min, int max ) {
	this.min = min;
	this.max = max;
	state = 0;
    }

    // Mutator - allows you to change the state of the guage.
    public void state( int x ) {
	state = x;
    }

    // Accessor - allows you to read the current state of the guage.
    public int state() {
	return state;
    }

    public String toString() {
	return "" + (int)( ( ( state - min ) * 1.0 ) / 
			   ( max - min ) * 100.0 );
    }

}
