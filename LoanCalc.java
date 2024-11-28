// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		// Replace the following statement with your code
		rate = rate / 100.00;
		for (int i = 0; i < n; i++) {
			loan = (loan - payment) * (1 + rate);
		}
		return loan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		iterationCounter = 0;
		boolean check = false;
		double balance;
		double x = loan / n;
		while (check == false) {
			balance = endBalance(loan, rate, n, x);
			if (Math.abs(balance) < epsilon) { check = true;}
			else { x = x + 0.01; iterationCounter++;}
		}
		return x;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        // Replace the following statement with your code
		iterationCounter = 0;
		boolean check = false;
		double l = 0.0;
		double h = loan;
		double x = (l + h) / 2;
		while (check == false) {
			if (Math.abs(endBalance(loan, rate, n, x)) < epsilon || h - l < epsilon) {check = true;}
			else {
				if( endBalance(loan, rate, n, x) < 0){
					h = x;
					x = (l + h) / 2;
					iterationCounter++;
				} else {
					l = x;
					x = (l + h) / 2;
					iterationCounter++;
				}
			}

		}
		iterationCounter--;
		return x;
    }
}