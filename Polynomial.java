public class Polynomial{
	double[] coefficient;
	
	public Polynomial(){
		coefficient = new double[1];
		coefficient[0] = 0;
	}
	
	public Polynomial(double[] arg){
		coefficient = arg;
	}
	
	public Polynomial add(Polynomial poly){
		Polynomial tmp;
		
		if (coefficient.length >= poly.coefficient.length){
			tmp = new Polynomial(coefficient);
			for(int i = 0; i < poly.coefficient.length-1; i++){
				tmp.coefficient[i] = tmp.coefficient[i] + poly.coefficient[i];
			} 
		}
		else{
			tmp = new Polynomial(poly.coefficient);
			for(int i = 0; i < poly.coefficient.length-1; i++){
				tmp.coefficient[i] = coefficient[i] + tmp.coefficient[i];
			}
		}	

		return tmp;
	}
	public double evaluate(double val){
		double tmp;
		double tmp2;
		tmp = coefficient[0];
		tmp2 = val;
		for(int i = 1; i < coefficient.length; i++){
			for(int j = 1; j < i; j++){
				tmp2 = tmp2*val;
			}
			tmp = tmp + tmp2*coefficient[i];
		}
		return tmp;
	}
	public boolean hasRoot(double arg){
		double tmp;
		double tmp2;
		tmp = coefficient[0];
		tmp2 = arg;
		for(int i = 1; i < coefficient.length; i++){
			for(int j = 1; j < i; j++){
				tmp2 = tmp2*arg;
			}
			tmp = tmp + tmp2*coefficient[i];
		}
		if (tmp == 0)
			return true;
		else 
			return false;

	}
	
}