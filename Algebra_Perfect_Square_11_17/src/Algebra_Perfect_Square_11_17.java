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
		boolean isPrime = isAPrimeNumber();
		if (isPrime) {
			System.out.println(
					"Given number is a Prime number: " + m + ".Factorization of a prime number is not possible.");
		} else {
			perfectSquare(m);

		}
	}

	private static void perfectSquare(int m) {
		long perfectSquare = 0L;
		int n = 0;
		ArrayList<Integer> factors = new ArrayList<>();

		factors = factorization(m);
		for (Iterator iterator = factors.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println("\n" + integer);
		}
		
		
		System.out.println("The smallest number n for m * n to be a perfect square is 7 m * n is ");

	}

	private static ArrayList<Integer> factorization(int m) {
		ArrayList<Integer> factors = new ArrayList<>();
		int x = 2;
		while (x < m) {
			if ((isEven(m)) && (m % x) == 0) {
				m = (m / x);
				factors.add(x);
			} else {
				if ((isOdd(m)) && (m % x) == 0) {					
					m = (m / x);
					factors.add(x);
				}
			}
			if (isEven(m)){
				x = 2;
			} else {
				if(isOdd(m)){
					x++;
					if (isEven(x)){
						x++;
					}
				}
			}
		}
		return factors;
	}

	private static boolean isPrime(int m) {
		for (int x = 1; x < m; x++) {
			int y;
			for (y = 2; y < x; y++) {
				int n = (x % y);
				if (n == 0) {
					break;
				}
			}
			if (x == y) {
				return true;
			}
		}
		return false;
	}

	private static boolean isEven(int m) {
		if ((m % 2) == 0) {
			return true;
		}
		return false;
	}

	private static boolean isOdd(int m) {
		if ((m % 2) == 1) {
			return true;
		}
		return false;
	}

	private static boolean isAPrimeNumber() {
		// TODO Auto-generated method stub
		return false;
	}

}
