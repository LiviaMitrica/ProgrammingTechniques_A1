package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fraction.Fraction;

public class Monomyal implements Comparable<Monomyal> {

	Fraction coeff;

	private int pow;

	public Monomyal(Fraction coeff, int pow) {
		super();
		this.coeff = coeff;
		this.pow = pow;
	}

	public Fraction getCoeff() {
		return coeff;
	}
	public void setCoeff(Fraction coeff) {
		this.coeff = coeff;
	}
	public int getPow() {
		return pow;
	}
	public void setPow(int pow) {
		this.pow = pow;
	}

	public int compareTo(Monomyal o) {
		return -o.getPow()+this.getPow();
	}

	@Override
	public String toString() {
		return "Monomial [coeff=" + coeff.getNumerator() + ", pow=" + pow + "]";
	}

	public Monomyal toMonomial(String string) {

		int sign = 1; // suppose all coefficients are positive
		if( string.charAt(0)=='-' ) sign = -1; // negative coefficient
		if( string.charAt(0)=='-' || string.charAt(0)=='+' ) string = string.substring(1); // if string starts with a sign, remove it 

		int pow=0;
		int coefficient = 0;
		final String regex = "[+-]?(\\d+)?([x])?(\\^)?(\\d+)?";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(string);
		int ok=0;

		if (matcher.find()) 
			ok=1;

		if(ok==1) {
			if( matcher.group(1)!=null ) coefficient = sign * Integer.parseInt(matcher.group(1));
			else coefficient = sign;
			if( matcher.group(2)==null ) pow = 0;
			else pow = 1;
			if( matcher.group(4)!=null ) pow = Integer.parseInt(matcher.group(4));
		}

		this.setCoeff(new Fraction(coefficient));
		this.setPow(pow);
		return this;
	}
}
