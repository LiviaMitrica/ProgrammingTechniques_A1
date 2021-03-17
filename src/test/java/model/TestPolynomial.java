package model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import fraction.Fraction;

public class TestPolynomial {

	private Polynomial create1() {
		Monomyal m11 = new Monomyal( new Fraction(1), 2);
		Monomyal m21= new Monomyal(new Fraction(2), 1);
		Monomyal m31 = new Monomyal(new Fraction(-6), 0);

		//Monomyal m11 = new Monomyal( new Fraction(2), 0);
		ArrayList<Monomyal> poly11 = new ArrayList<Monomyal>();
		poly11.add(m11);
		poly11.add(m21);
		poly11.add(m31);
		Polynomial pol11 = new Polynomial(poly11);
		return pol11;
	}

	private Polynomial create2() {
		Monomyal m41 = new Monomyal(new Fraction(1), 1);
		Monomyal m51 = new Monomyal(new Fraction(-3), 0);

		ArrayList<Monomyal> poly21 = new ArrayList<Monomyal>();
		poly21.add(m41);
		poly21.add(m51);

		Polynomial pol21 = new Polynomial(poly21);
		return pol21;
	}

	@Test
	public void displayInput() {
		TestPolynomial test = new TestPolynomial();
		Polynomial pol11 = test.create1();
		Polynomial pol21 = test.create2();
		System.out.println("Input 1: "+ pol11.toString());
		System.out.println("Input 2: "+ pol21.toString());
	}
	
	@Test
	public void testAddition() {

		TestPolynomial test = new TestPolynomial();
		Polynomial pol11 = test.create1();
		Polynomial pol21 = test.create2();
		Polynomial addition = pol11.add(pol21);

		ArrayList<Monomyal> testAddition = new ArrayList<Monomyal>();
		testAddition.add(new Monomyal(new Fraction(1), 2));
		testAddition.add(new Monomyal(new Fraction(3), 1));
		testAddition.add(new Monomyal(new Fraction(-9), 0));
		Polynomial additionPolynomial = new Polynomial(testAddition);

		System.out.println("@Test addition(): " + additionPolynomial.toString() + " = " + addition.toString());
		assertEquals(additionPolynomial.toString(), addition.toString());

	}

	@Test
	public void testSubtraction() {

		TestPolynomial test = new TestPolynomial();
		Polynomial pol11 = test.create1();
		Polynomial pol21 = test.create2();
		Polynomial subtraction = pol11.sub(pol21);

		ArrayList<Monomyal> testOp = new ArrayList<Monomyal>();
		testOp.add(new Monomyal(new Fraction(1), 2));
		testOp.add(new Monomyal(new Fraction(1), 1));
		testOp.add(new Monomyal(new Fraction(-3), 0));
		Polynomial subtractionPolynomial = new Polynomial(testOp);

		System.out.println("@Test subtraction(): " + subtractionPolynomial.toString() + " = " + subtraction.toString());
		assertEquals(subtractionPolynomial.toString(), subtraction.toString());

	}
	
	@Test
	public void testMultiplication() {

		TestPolynomial test = new TestPolynomial();
		Polynomial pol11 = test.create1();
		Polynomial pol21 = test.create2();
		Polynomial multiplication = pol11.mul(pol21);

		ArrayList<Monomyal> testAddition = new ArrayList<Monomyal>();
		testAddition.add(new Monomyal(new Fraction(1), 3));
		testAddition.add(new Monomyal(new Fraction(-1), 2));
		testAddition.add(new Monomyal(new Fraction(-12), 1));
		testAddition.add(new Monomyal(new Fraction(18), 0));
		Polynomial multiplicationPolynomial = new Polynomial(testAddition);

		System.out.println("@Test multplication(): " + multiplicationPolynomial.toString() + " = " + multiplication.toString());
		assertEquals(multiplicationPolynomial.toString(), multiplication.toString());

	}

	@Test
	public void testDivision() {

		TestPolynomial test = new TestPolynomial();
		Polynomial pol11 = test.create1();
		Polynomial pol21 = test.create2();
		Polynomial[] division = pol11.div(pol21);

		ArrayList<Monomyal> testOp = new ArrayList<Monomyal>();
		ArrayList<Monomyal> testOpp = new ArrayList<Monomyal>();
		testOp.add(new Monomyal(new Fraction(1), 1));
		testOp.add(new Monomyal(new Fraction(5), 0));
		testOpp.add(new Monomyal(new Fraction(9), 0));
		
		Polynomial quotient = new Polynomial(testOp);
		Polynomial remainder = new Polynomial(testOpp);

		System.out.println("@Test division() -> quotient: " + division[0].toString() + " = " + quotient.toString());
		System.out.println("@Test division() -> remainder: " + division[1].toString() + " = " + remainder.toString());
		assertEquals(division[0].toString(), quotient.toString());
		assertEquals(division[1].toString(), remainder.toString());

	}

	@Test
	public void testDifferentiation() {

		TestPolynomial test = new TestPolynomial();
		Polynomial pol11 = test.create1();
		Polynomial diff = pol11.deriv();

		ArrayList<Monomyal> testOp = new ArrayList<Monomyal>();
		testOp.add(new Monomyal(new Fraction(2), 1));
		testOp.add(new Monomyal(new Fraction(2), 0));
		
		Polynomial diffPolynomial = new Polynomial(testOp);

		System.out.println("@Test differentiation() on input 1: " + diff.toString() + " = " + diffPolynomial.toString());
		assertEquals(diff.toString(), diffPolynomial.toString());

	}
	
	@Test
	public void testIntegration() {

		TestPolynomial test = new TestPolynomial();
		Polynomial pol11 = test.create1();
		Polynomial integ = pol11.integ();

		ArrayList<Monomyal> testOp = new ArrayList<Monomyal>();
		testOp.add(new Monomyal(new Fraction(1,3), 3));
		testOp.add(new Monomyal(new Fraction(1), 2));
		testOp.add(new Monomyal(new Fraction(-6), 1));
		
		Polynomial integPolynomial = new Polynomial(testOp);

		System.out.println("@Test integration() on input 1: " + integ.toString() + " = " + integPolynomial.toString());
		assertEquals(integ.toString(), integPolynomial.toString());

	}
	
}
