package model;

import java.util.ArrayList;

import fraction.Fraction;
//import view.CalcView;
//import model.CalcModel;
import model.Monomyal;
import model.Polynomial;

public class Testing {

	public static void main(String[] args) {
		Monomyal m1 = new Monomyal( new Fraction(1), 3);
		Monomyal m2 = new Monomyal(new Fraction(-2), 2);
		Monomyal m3 = new Monomyal(new Fraction(-4), 0);

		Monomyal m4 = new Monomyal(new Fraction(1), 1);
		Monomyal m5 = new Monomyal(new Fraction(-3), 0);

		ArrayList<Monomyal> poly1 = new ArrayList<Monomyal>();
		ArrayList<Monomyal> poly2 = new ArrayList<Monomyal>();

		poly1.add(m1);
		poly1.add(m2);
		poly1.add(m3);
		poly2.add(m4);
		poly2.add(m5);
		//poly2.add(m6);

		Polynomial pol1 = new Polynomial(poly1);
		Polynomial pol2 = new Polynomial(poly2);
		
		System.out.println(pol1.toString());
		System.out.println(pol2.toString());
		System.out.println();
		
	
		System.out.println("addition: "+pol1.add(pol2).toString());

		System.out.println("subtraction: "+pol1.sub(pol2).toString());
		
		System.out.println("mul: "+pol1.mul(pol2).toString());
		
		System.out.println("integ: "+pol1.integ().toString());
		
		System.out.println("deriv: "+pol1.deriv().toString());
		System.out.println();
		
		Polynomial[] divR = pol1.div(pol2);
		
		System.out.println("q: "+divR[0]);
		System.out.println("r: "+divR[1]);
		System.out.println();
		
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		String s1 = "x^2-5x+8";
		String s2 = "-10";
		p1.toPolynomial(s1);
		p2.toPolynomial(s2);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p1.mul(p2).toString());
		
	}

}
