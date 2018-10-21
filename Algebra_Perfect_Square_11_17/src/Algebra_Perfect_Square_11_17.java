import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * **11.17 (Algebra: perfect square) 
 * Write a program that prompts the user to enter an integer m 
 * and find the smallest integer n such that m * n is a perfect square. 
 * (Hint: Store all smallest factors of m into an array list. 
 * n is the product of the factors that
 * appear an odd number of times in the array list.
 * For example, consider m = 90,
 * store the factors 2, 3, 3, 5 in an array list.
 * 2 and 5 appear an odd number of times
 * in the array list. So, n is 10.) 
 * 
 * Here are sample runs:
 * Enter an integer m: 1500
The smallest number n for m * n to be a perfect square is 15
m * n is 22500

Enter an integer m: 63
The smallest number n for m * n to be a perfect square is 7
m * n is 441
 */

public class Algebra_Perfect_Square_11_17 {

	public static void main(String[] args) {
		System.out.println("Enter an integer m: ");
		Scanner scan = new Scanner(System.in);

		int m = scan.nextInt();
		scan.close();

		ArrayList<Integer> factors = new ArrayList<>();
		factors = factorization(m);

		ArrayList<Integer> oddNumbers = findNumber(factors);
		int n = findMultiple(oddNumbers);

		System.out.println("The smallest number n for m * n to be a perfect square is " +  n 
				+ " m (" + m + ") * " + "n(" + n + ")" + n + " is " + (m * n));

		// boolean isPrime = isAPrimeNumber(m);
		// if (isPrime) {
		// System.out.println(
		// "Given number is a Prime number: " + m + ".Factorization of a prime
		// number is not possible.");
		// } else {
		//
		//
		// }
	}

	private static int findMultiple(ArrayList<Integer> oddNumbers) {
		if (oddNumbers.size() > 0) {
			int product = oddNumbers.get(0);
			for (int x = 1; x < oddNumbers.size(); x++) {
				product *= oddNumbers.get(x);
			}
			return product;
		}
		return -1;
	}

	private static ArrayList<Integer> findNumber(ArrayList<Integer> factors) {
		int count = 0;
		int number = factors.get(0);
		ArrayList<Integer> oddTimesIntegers = new ArrayList<>();
		int i = 0;
		
		while(i < factors.size()) {
			
			for (int j = 0; j < factors.size(); j++) {
				if (number == factors.get(j)) {
					count++;			
				}
				number = factors.get(i);
			}			
			if ((count % 2) == 1) {
				oddTimesIntegers.add(number);
			}
			i++;
		}
		return oddTimesIntegers;
	}

	private static ArrayList<Integer> factorization(int m) {
		ArrayList<Integer> factors = new ArrayList<>();
		for (int x = 2; x <= m; x++) {
			while ((m % x) == 0) {
				factors.add(x);
				m /= x;
			}
		}
		return factors;
	}

//	private static boolean isAPrimeNumber(int m) {
//		for (int x = 1; x < m; x++) {
//			int y;
//			for (y = 2; y < x; y++) {
//				int n = (x % y);
//				if (n == 0) {
//					break;
//				}
//			}
//			if (x == y) {
//				return true;
//			}
//		}
//		return false;
//	}
}
