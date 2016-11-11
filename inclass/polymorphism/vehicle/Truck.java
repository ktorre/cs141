public class Truck extends Vehicle {

    int    tonage;
    int    bedSize;
    String truckProp;

    public Truck() {
	bedSize = 100;
	tonage = 100;
	truckProp = "Expensive";
    }

    public void prop( String tp ) {
	truckProp = tp;
    }

    public String prop() {
	return truckProp;
    }

    public String toString() {
	return super.toString() + "; " +
	    "Bed Size : " + bedSize + "; " +
	    "Tonage : " + tonage + "; " +
	    "Prop : " + truckProp;
    }
}