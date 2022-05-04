/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;

	/**
	 * This entry function will test all classes created in this assignment.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		/* TODO - write a function for each class */
		// Each function here should test a different class. You should test ExpTokenizer as well.

		//BinaryOp
		ExpTokenizer check = new ExpTokenizer("( ( 6 - ( 2 + 3.6 ) * 3 + ( 87.6 / 2 ) ) ^ 2 ) + 3");
		StackCalculator new1 = new StackCalculator();
		StackCalculator pc = new StackCalculator();
		String postExp = pc.infixToPostfix("( -6 * 3 ) - ( -4 * 12 )");


		TreeCalculator tr = new TreeCalculator();
		System.out.println(tr.evaluate(postExp));
		System.out.println(tr.getInfix());
		System.out.println(tr.getPostfix());
		System.out.println(tr.getPrefix());

		testAddOp();
		// (6-(2+3) * 3+(8/2))^2+3
		//...
		//Calculators
		testStackCalculator();
		//...


		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked.
	 * In addition, if a test fails the function will print the error message.
	 *
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;

		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: " + msg);
		}
	}

	/**
	 * Checks the AddOp class.
	 */
	private static void testAddOp() {
		AddOp op = new AddOp();
		test((op.toString().equals("+")), "The string + should be printed.");
		test((op.operate(1.0, 2.5) == 3.5), "The answer should be 3.5 .");
	}


	/**
	 * Checks the StackCalculator class.
	 */
	private static void testStackCalculator() {

		StackCalculator pc = new StackCalculator();

		String postExp = pc.infixToPostfix("2 + 3");
		test(postExp.equals("2.0 3.0 +"), "The output of \"2 3 -\" should be  2.0 3.0 +");
		System.out.println(pc.evaluate(postExp));
		double result = pc.evaluate(postExp);
		test(result == 5.0, "The output of \"2 3 -\" should be 5.0");
	}
}
