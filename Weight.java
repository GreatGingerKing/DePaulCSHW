package hw4;

// Author: Amber Settle
// CSC 281
// David Kolschowsky
// I worked alone with no collaborators.
import java.util.Scanner;

public class Weight
{
	// Please do not declare any additional members of the class
	// Feel free to use local variables as necessary in each method
	private double wValue;
	// If you like, you can change the type of scale to Character
	private char scale;
	
	private final double FACTOR = 2.2046;
	
	private Scanner vScan = new Scanner(System.in);

 	// The default constructor for the class
 	public Weight()
 	{
     	wValue=0;
     	scale='p';
 	}

 	// The parameterized constructor for the class
	public Weight(double initW, char initS)
	{
		if(initW<0){
			wValue=0;
		}
		else wValue = initW;
		if(initS =='k'){
			scale=initS;
		}
		else scale='p';
	}

 	// Input values for the instance variables using the Scanner vScan
 	public void set()
 	{
 		System.out.println("Entering the set method.");
 		boolean scaleFound= false;
 		char userScale='N';
 		boolean valueFound = false;
 		double userValue=-1;
 		while(!scaleFound){
 			System.out.print("Please enter the weight scale(p/k): ");
 			userScale=vScan.nextLine().charAt(0);
 			if(userScale !='p' && userScale !='k'){
 				System.out.println("Pounds and kilos are the only valid scales");
			}
			else
				scaleFound=true;
		}
 		scale=userScale;

 		while(!valueFound){
 			System.out.print("Please enter a weight measurement: ");
 			userValue = Double.parseDouble(vScan.nextLine());
 			if(userValue <0){
 				System.out.println("The weight measurement cannot be negative");
			}
			else valueFound=true;
		}
		wValue=userValue;

     	System.out.println("Leaving the set method.");
 	}

 	// Return the weight in pounds
	public double getP()
	{
		// A stub -- replace by the correct code
        if(scale=='p') return wValue;
		else
		    return wValue*FACTOR;
	}

	// Return the weight in kilos
	public double getK()
	{
		// A stub -- replace by the correct code
        if(scale=='k') return wValue;
        else
            return wValue/FACTOR;

	}

}

