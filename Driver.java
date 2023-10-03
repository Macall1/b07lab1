public class Driver {
	public static void main(String [] args) {
		
		double [] c1 = {6,-5,-4,5};
		int [] c2 = {2,1,3,0};
		double [] c3 = { 1, 2, 3};
		int [] c4 = {3,4,1};
		Polynomial p1 = new Polynomial(c1, c2);
		Polynomial p2 = new Polynomial(c3,c4);
		Polynomial s = p1.multiply(p2);
		for(int i = 0; i < s.exp.length; i++){
			System.out.println(s.exp[i]);
			System.out.println(s.nonzero[i]);
		}
		System.out.println("s(0.1) = " + s.evaluate(0.1));
		if(s.hasRoot(1))
			System.out.println("1 is a root of s");
		else
			System.out.println("1 is not a root of s");
	}
}