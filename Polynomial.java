import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.lang.Math;


public class Polynomial{
	double[] nonzero;
	int[] exp;
	
	public Polynomial(){
		nonzero = null;
		exp = null;
	}
	
	public Polynomial(double[] arg, int[] exp){
		nonzero = arg;
		this.exp = exp;
	}
	
	public Polynomial add(Polynomial poly){
		Polynomial tmp;
		int []arr1;
		int a = poly.exp.length;
		int b = 0;
		for(int i = 0; i < exp.length; i++){
			for(int j = 0; j < poly.exp.length; j++){
				if(exp[i] == poly.exp[j]){
					b = 1;
				}
			}
			if(b == 0){
				a = a+1;

			}
			b = 0;	
		}
		arr1 = new int[a];
		for(int i = 0; i < exp.length; i++){
			arr1[i] = exp[i];
		}
		a = exp.length;
		b = 0;
		for(int i = 0; i < poly.exp.length; i++){
			for(int j = 0; j < exp.length; j++){
				if(poly.exp[i]==exp[j]){
					b = 1;
				}
			}
			if(b== 0){
				arr1[a] = poly.exp[i];
				a = a+1;
			}
			b = 0;
		}
		double[]arr2 = new double[arr1.length];
		b=0;
		a = 0;
		for(int i = 0; i < arr2.length; i++){
			for(int j = 0; j < poly.exp.length; j++){
				if(arr1[i]==poly.exp[j]){
					arr2[i] = arr2[i] + poly.nonzero[j];
				}
			}
			for(int j= 0; j < exp.length; j++){
				if(arr1[i] == exp[j]){
					arr2[i] = arr2[i] + nonzero[j];
				}
			}
		}
		tmp = new Polynomial(arr2, arr1);
		return tmp;
	}
	public double evaluate(double val){
		double tmp = 0;
		double tmp2 = 0;
		for(int i = 0; i < exp.length;i++){
			tmp2 = Math.pow(val, exp[i]);
			tmp = tmp + tmp2*nonzero[i];
		}
		return tmp;
	}
	public boolean hasRoot(double arg){
		double tmp = 0;
		double tmp2 = 0;
		for(int i = 0; i < exp.length;i++){
			tmp2 = Math.pow(arg, exp[i]);
			tmp = tmp + tmp2*nonzero[i];
		}		

		if (tmp == 0)
			return true;
		else 
			return false;

	}
	public int[] arrayadd(int[] arr1, int[] arr2, int ind){
		int [] arr3 = new int[arr1.length];
		for(int i = 0; i < arr1.length; i++){
			arr3[i] = arr1[i] + arr2[ind];
		}
		return arr3;
	}

	public double[] arradd(double[] arr1, double[] arr2, int ind){
		double[] arr3 = new double[arr1.length];
		for(int i = 0; i < arr1.length; i++){
			arr3[i] = arr1[i] + arr2[ind];
		}
		return arr3;
	}
	

    
	public Polynomial multiply(Polynomial arg){
		
		Polynomial py;
		double[]coeff = new double[nonzero.length];
		int[]pow = new int[exp.length];
		for(int i = 0; i < nonzero.length; i++){
			coeff[i] = nonzero[i] * arg.nonzero[0];
			pow[i] = exp[i] + arg.exp[0];
		}
		py = new Polynomial(coeff, pow);
		for(int j = 1; j < arg.nonzero.length; j++){
			double[] coeff1 = new double[nonzero.length];
			int[] pow1 = new int[exp.length];

			for(int i = 0; i < nonzero.length; i++ )
			{
				coeff1[i] = nonzero[i] * arg.nonzero[j];
				pow1[i] = exp[i] + arg.exp[j];
			}
			
			Polynomial py2 = new Polynomial(coeff1, pow1);
			py = py.add(py2);
			
		}
		return py;
	}




	
}