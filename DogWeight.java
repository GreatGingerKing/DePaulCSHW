// You must use this package
package wt;

// CSC 281
// David Kolschowsky
// I work with no one.

public class DogWeight extends Weight {
	
	private final int MAXP = 350;
	private final int MINP = 1;
	private final double MAXK = 158.757;
	private final double MINK = 0.453592;

	private static int numDogs = 0;
	
	public static int getNumDogs() {
	    return numDogs;
	}
	
	// The default constructor
	public DogWeight() {
		super(10,'p');
		numDogs++;
	}
	
	// The parameterized constructor
	public DogWeight(double initW, char initS) {
		if(initS=='p' || initS=='P' || initS=='k' || initS=='K'){
            scale=initS;
        }
        else scale = 'p';
        if(initS=='k' || initS=='K'){
            if(initW <= MAXK && initW >= MINK) wValue = initW;
            else wValue = MINK;
        }
        else{
            if(initW <= MAXP && initW >= MINP) wValue = initW;
            else wValue = MINP;
        }
        numDogs++;
	}
	
	public String toString() {
		if(scale=='k' || scale=='K')
		    return String.format("%.2f kilograms", wValue);
        return String.format("%.2f pounds", wValue);
	}
	
	public boolean equals(DogWeight other) {
		return getP()==other.getP();
	}
}
