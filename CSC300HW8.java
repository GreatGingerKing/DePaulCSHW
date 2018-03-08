package hw;

import csc300w18.CSC300Sorts;  // you must have the csc300.jar file installed
							  // and added to the build path.
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.Stopwatch;

/*
 * This is the starter file for Homework 8
 * <your name goes here>
 * <Explain how you used this program to collect your data here>
 * 
 */
public class CSC300HW8 {


	//	write a function:  isSorted,  which will check to see if an array of doubles 
	//	passed as a parameter, is sorted.
	//  
	 public static boolean isSorted(double[] lst){
	     for(int i=0; i<lst.length-1; i++)
	         if(!(lst[i] <=lst[i+1])) return false;
	     return true;
	 }
	
	
	// this sample main program creates an array of size 9, passes it to Sort1
	// and prints the elapsed time.
	// you might try changing Sort2, Sort3, Sort4  just to make sure 
	// they are 'callable'
	//
	//  ToDo:  Change main, add additional methods if you want to facilitate
	//         collecting the data you need.
	//         You can automate this as much or as little as you like
	//
	//         You might want to review  XSortCompare in algs21 for some code hints
	//
	//	       Somewhere you should show how you used the   isSorted  function   
	//
	//		   You may not use any other Java classes or methods

    public static double[] randArrayDouble(int length){
	     double[] rADouble = new double[length];

	     for(int i =0; i<length; i++){
	         rADouble[i]=StdRandom.uniform((double) 0,(double) 100);
         }
         return rADouble;
    }

    public static void testSort1(double[] a){
        Stopwatch sw = new Stopwatch();
        CSC300Sorts.Sort1(a);
        double elapsed = sw.elapsedTime();
        if(isSorted(a)) {
            StdOut.format(" elapsed time %10.6f\n", elapsed);
        }
        else StdOut.println("Sorting Method Failed to sort the list.");
    }

    public static double testSortTrials1(int length, int M) {
        double runtimes = 0;

        for (int i = 0; i < M; i++) {
            double[] dtest = randArrayDouble(length);
            Stopwatch sw = new Stopwatch();
            CSC300Sorts.Sort1(dtest);
            double elapsed = sw.elapsedTime();
            if (isSorted(dtest)) {
                runtimes += elapsed;
            } else {
                StdOut.println("Array Not sorted.");
                return 0;
            }

        }
        StdOut.format("Average time for Sort 1 using %d trials of length %d using is %10.6f\n", M, length, runtimes / M);
        return runtimes / M;
    }

    public static double testSortTrials2(int length, int M) {
        double runtimes = 0;

        for (int i = 0; i < M; i++) {
            double[] dtest = randArrayDouble(length);
            Stopwatch sw = new Stopwatch();
            CSC300Sorts.Sort2(dtest);
            double elapsed = sw.elapsedTime();
            if (isSorted(dtest)) {
                runtimes += elapsed;
            } else {
                StdOut.println("Array Not sorted.");
                return 0;
            }

        }
        StdOut.format("Average time for Sort 2 using %d trials of length %d using is %10.6f\n", M, length, runtimes / M);
        return runtimes / M;
    }

    public static double testSortTrials3(int length, int M) {
        double runtimes = 0;

        for (int i = 0; i < M; i++) {
            double[] dtest = randArrayDouble(length);
            Stopwatch sw = new Stopwatch();
            CSC300Sorts.Sort3(dtest);
            double elapsed = sw.elapsedTime();
            if (isSorted(dtest)) {
                runtimes += elapsed;
            } else {
                StdOut.println("Array Not sorted.");
                return 0;
            }
            StdOut.format("Average time for Sort 3 using %d trials of length %d using is %10.6f\n", M, length, runtimes / M);

        }
        return runtimes / M;
    }

    public static double testSortTrials4(int length, int M) {
        double runtimes = 0;

        for (int i = 0; i < M; i++) {
            double[] dtest = randArrayDouble(length);
            Stopwatch sw = new Stopwatch();
            CSC300Sorts.Sort4(dtest);
            double elapsed = sw.elapsedTime();
            if (isSorted(dtest)) {
                runtimes += elapsed;
            } else {
                StdOut.println("Array Not sorted.");
                return 0;
            }

        }
        StdOut.format("Average time for Sort 4 using %d trials of length %d using is %10.6f\n", M, length, runtimes / M);
        return runtimes / M;
    }


    public static void testSort2(double[] a){
        Stopwatch sw = new Stopwatch();
        CSC300Sorts.Sort2(a);
        double elapsed = sw.elapsedTime();
        if(isSorted(a)) {
            StdOut.format(" elapsed time %10.6f\n", elapsed);
        }
        else StdOut.println("Sorting Method Failed to sort the list.");
    }

    public static void testSort3(double[] a){
        Stopwatch sw = new Stopwatch();
        CSC300Sorts.Sort3(a);
        double elapsed = sw.elapsedTime();
        if(isSorted(a)) {
            StdOut.format(" elapsed time %10.6f\n", elapsed);
        }
        else StdOut.println("Sorting Method Failed to sort the list.");
    }

    public static void testSort4(double[] a){
        Stopwatch sw = new Stopwatch();
        CSC300Sorts.Sort4(a);
        double elapsed = sw.elapsedTime();
        if(isSorted(a)) {
            StdOut.format(" elapsed time %10.6f\n", elapsed);
        }
        else StdOut.println("Sorting Method Failed to sort the list.");
    }

    public static void  printArray(double[] a){
	     String arrayString = new String();
	     arrayString +='[';
	     for(int i = 0; i<a.length; i++){
	         arrayString+=a[i];
             arrayString+=',';
         }
         arrayString +=']';
	     StdOut.println(arrayString);
    }
	public static void main( String[] args) {
	     double[] a = new double[] {9,8,7,6,5,4,3,2,1};
		Stopwatch sw = new Stopwatch();
		CSC300Sorts.Sort3(a);
		if(isSorted(a)) {
            double elapsed = sw.elapsedTime();
            StdOut.format(" elapsed time %10.6f\n", elapsed);
        }
        else StdOut.println("Sorting Method Failed to sort the list.");

		double[] averageTime = new double[9];
        int i =0;
        for(int N =1024; N<=262144; N*=2){
           averageTime[i]=testSortTrials1(N, 50);
           i++;

        }
        StdOut.println("Doubling Ratio's are: ");
        for(int k =0; k<averageTime.length-1; k++){
           StdOut.format("%f, ",averageTime[k+1]/averageTime[k]);
        }
        StdOut.println();


        i =0;
        for(int N =1024; N<=16384; N*=2){
            averageTime[i]=testSortTrials2(N, 20);
            i++;

        }
        StdOut.println("Doubling Ratio's are: ");
        for(int k =0; k<averageTime.length-1; k++){
            StdOut.format("%f, ",averageTime[k+1]/averageTime[k]);
        }
        StdOut.println();

        i =0;
        for(int N =1024; N<=65536; N*=2){
            averageTime[i]=testSortTrials4(N, 20);
            i++;

        }
        StdOut.println("Doubling Ratio's are: ");
        for(int k =0; k<averageTime.length-1; k++){
            StdOut.format("%f, ",averageTime[k+1]/averageTime[k]);
        }
        StdOut.println();



	}

}
