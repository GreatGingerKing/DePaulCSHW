// You must use this package
// Do not change it
package wt;

// Author: Amber Settle
// Do not change this class

import java.util.Scanner;

public class Weight
{
	protected double wValue;
	protected char scale;
	
	private final double FACTOR = 2.2046;
	private final double MINW = 10.0;
	
	private Scanner vScan = new Scanner(System.in);

 	// The default constructor for the class
 	public Weight()
 	{
     	wValue = MINW;
		scale = 'p';
 	}

 	// The parameterized constructor for the class
	public Weight(double initW, char initS)
	{
		if (initS != 'p' && initS != 'P' && initS != 'k' && initS != 'K')
		  	scale = 'p';
		else scale = initS;
		if (initW >= MINW)
			wValue = initW;
		else wValue = MINW;
	}

 	// Input values for the instance variables using the Scanner vScan
 	public void set()
 	{
	  	String iText;
	  	boolean done = false;

     	while (!done) {
			System.out.print("Please enter the weight scale (p/k): ");
			iText = vScan.next();
			scale = iText.charAt(0);
			if (scale != 'p' && scale != 'P' && scale != 'k' && scale != 'K')
				System.out.println("Pounds and kilos are the only valid scales");
			else done = true;
		}
     	
     	done = false;
     	while (!done) {
     		System.out.print("Please enter a weight measurement: ");
     		wValue = vScan.nextDouble();
     		if (wValue < MINW)
     			System.out.println("The weight measurement must be larger than " + MINW + ".");
     		else done = true;
     	}
 	}

 	// Return the weight in pounds
	public double getP()
	{
		double value;

		if (scale == 'p' || scale == 'P')
			value = wValue;
		else value = wValue * FACTOR;
		
		return value;
	}

	// Return the weight in kilos
	public double getK()
	{
		double value;

		if (scale == 'k' || scale == 'K')
			value = wValue;
		else value = wValue / FACTOR;
		
		return value;
	}

}

