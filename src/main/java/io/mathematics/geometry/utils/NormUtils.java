package io.mathematics.utils;
/**
 * @author gentjan kolicaj
 *
 */
public class NormUtils {
	
	public static double absoluteNorm(double x) {
		return Math.abs(x);
	}
	
	public static double euclidianNorm(Double...values) {
		double x=0;
		for(Double var:values) {
			x=x+(var*var);
		}
		return Math.sqrt(x);
	}
	
	public static double manhattanNorm(Double...values) {
		double x=0;
		for(Double var:values) {
			x=x+Math.abs(var);
		}
		return x;
	}
	
	public static double maximumNorm(Double...values) {
		double max=0;
		for(Double var:values) {
			double tmp=Math.abs(var);
			if(max<tmp) 
				max=tmp;
		}
		return max;
	}

}
