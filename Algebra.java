// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int changeSign(int x){
		if (x == 0) {
			return 0; 
		}
		int y = 0; 
		if (x > 0) { 
			
			while (x != 0) {
				x--; 
				y--; 
			}
		} else {
			
			while (x != 0) {
				x++; 
				y++; 
			}
		}
		return y; 
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		if (x1 > 0 && x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
			return x1;
		}
		if (x1 > 0) {
			if(x2 == 0) {return x1;}
			else {
				for( int i = x2; i < 0; i++) {
					x1--;
				}
				return x1;
			}
		}
		if (x2 > 0){
			if(x1 == 0) {return x2;}
			else {
				for( int i = x1; i < 0; i++) {
					x2--;
				}
				return x2;
			}
		}
		if (x1 == 0 && x2 == 0) {return 0;}
		if (x1 < 0 && x2 < 0) {
			for (int i = x2; i < 0; i++) {
				x1--;
			}
			return x1;
		}
		return 0;
		
}
	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if(x1 < -1000000) {x1++; return x1;}

		if(x1 > 0 && x2 > 0){
			int r = plus(x1, changeSign(x2));
			return r;
		}
		if (x1 > 0){
			if (x2 == 0) {return x1;}
				else {
					int r = plus(x1, changeSign(x2));
					return r;
				}
		}
		if (x2 > 0) {
			if (x1 == 0) {return changeSign(x2);}
				else {
					int r =  changeSign(plus(changeSign(x1), x2));
					return r;
				}
		}
		if(x1 == 0 && x2 == 0) {return 0;}
		if ( x1 < 0 && x2 < 0) {
			int r =  plus(x1, changeSign(x2));
			return r;
		}
		return 0;
		
}
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		return 0;
		}
		
		
	

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		if (n == 0){return 1;}
		if (n == 1){ return x;}
		if (x == 0){return 0;}
		if (x == 1){return 1;}


			int change = x;
			for (int i = 1; i < n; i++) {
				x = times(x, change);
			}
			return x;
		
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		return 0;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		return 0;
		
	
}
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		return 0;

		

	}	  	
	
	public static int abs(int x) {
		if (x > 0) {return x;}
		else{ int r = changeSign(x); return r;}
	}
}