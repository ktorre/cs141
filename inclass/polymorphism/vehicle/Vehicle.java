public class Vehicle {

    int doors;
    int wheels;
    String vehicleProp;

    public Vehicle () {
	doors = 2;
	wheels = 4;
    }

    public void prop( String p ) {
	vehicleProp = p;
    }

    public String prop() {
	return vehicleProp;
    }

    public String toString() {
	return "Doors : " + doors + "; " +
	    "Wheels : " + wheels;
    }
}

