import java.util.Scanner;
public class sample {
    public static void main( String[] args ) {
	Scanner   k = new Scanner( System.in );
	int       count = 5;
	Vehicle[] list = new Vehicle[ 5 ];
	Vehicle   tmpV;
	Sedan     tmpS;
	Truck     tmpT;
	
	while ( count > 0 ) {
	    if ( ( count % 2 ) == 0 ) {
		list[ count - 1 ] = new Sedan();  
	    } else {
		list[ count - 1 ] = new Truck();
	    }
	    count--;
	}


	while ( count < 5 ) {
	    list[ count ].prop( "duck" );

	    // if ( list[ count ] instanceof Sedan ) {
	    // 	tmpS = (Sedan)list[ count ];
	    // 	tmpS.prop( "Smart" );
	    // } else if ( list[ count ] instanceof Truck ) {
	    // 	tmpT = (Truck)list[ count ];
	    // 	tmpT.prop( "Chevy" );
	    // } else {
	    // 	System.out.println( "!!! WTF !!!" );
	    // }
	    count++;
	}

	count--;
	while ( count >= 0 ) {
	    System.out.println( count + " : " + list[ count-- ] );
	}

    }
}