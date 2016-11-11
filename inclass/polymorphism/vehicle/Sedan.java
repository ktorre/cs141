public class Sedan extends Vehicle {

    int    trunkSize;
    String sedanProp;

    public Sedan() {
	trunkSize = 100;
	sedanProp = "Smooth Ride";
    }

    // public String prop() {
    // 	return sedanProp;
    // }

    // public void prop( String p ) {
    // 	sedanProp = p;
    // }

    public String toString() {
	return 
	    "Doors : " + doors + "; " +
	    "Wheels : " + wheels + "; " +
	    "Trunk Size : " + trunkSize + "; " +
	    "Prop : " + sedanProp;
    }
}