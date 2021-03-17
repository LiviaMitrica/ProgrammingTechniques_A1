package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fraction.Fraction;

public class Polynomial {

	private List<Monomyal> poly = new ArrayList<Monomyal>();

	public Polynomial() {

	}

	public Polynomial( List<Monomyal> p) {
		this.poly = p;
	}

	public void setPoly(List<Monomyal> poly) {
		this.poly = poly;
	}

	public int getRank() {
		int rank = -1;
		for( Monomyal m: this.poly ) 
			if( m.getPow()>rank && m.getCoeff().getNumerator()!=0)
				rank = m.getPow();
		return rank;

	}

	public Polynomial add( Polynomial poly2) {	
		Collections.sort(this.poly);
		Polynomial result = new Polynomial();
		for ( int i = 0; i<= ( this.getRank()>poly2.getRank() ? this.getRank(): poly2.getRank() ); i++ )
			result.poly.add(new Monomyal( new Fraction(0),i));
		for( Monomyal m1 : this.poly ) 			
			result.poly.get(m1.getPow()).setCoeff(m1.getCoeff());

		for(Monomyal m2 : poly2.poly) {
			Fraction coeff= m2.getCoeff();
			int pow=m2.getPow();
			Fraction currentCoeff = result.poly.get(pow).getCoeff();
			result.poly.get(pow).setCoeff(currentCoeff.addition(coeff));
		}

		return result;
	}

	public Polynomial sub( Polynomial poly2) {	
		Collections.sort(this.poly);
		Polynomial result = new Polynomial();
		for ( int i = 0; i<= ( this.getRank()>=poly2.getRank() ? this.getRank(): poly2.getRank() ); i++ )
			result.poly.add(new Monomyal( new Fraction(0),i));
		for( Monomyal m1 : this.poly ) 		
			if( m1.getPow()<=this.getRank()){
				result.poly.get(m1.getPow()).setCoeff(m1.getCoeff());
			}


		for(Monomyal m2 : poly2.poly) {
			Fraction coeff= m2.getCoeff();
			int pow=m2.getPow();
			Fraction currentCoeff = result.poly.get(pow).getCoeff();
			result.poly.get(pow).setCoeff(currentCoeff.subtraction(coeff));
		}

		return result;
	}

	public Polynomial mul( Polynomial poly2) {
		Collections.sort(this.poly);
		int rank1 = this.getRank();
		int rank2 = poly2.getRank();
		Polynomial result = new Polynomial();
		for( int i=0; i<= rank1+rank2 ; i++ )
			result.poly.add(new Monomyal( new Fraction(0),i));

		for( Monomyal m1 : poly ) {
			for(Monomyal m2 : poly2.poly) {
				Fraction coeff=m1.getCoeff().multiplication(m2.getCoeff());
				int pow=m1.getPow()+m2.getPow();
				Fraction currentCoeff = result.poly.get(pow).getCoeff();
				result.poly.get(pow).setCoeff(currentCoeff.addition(coeff));
			}
		}

		//this.poly = result.poly;
		return result;
	}

	public Polynomial[] div( Polynomial poly2 ) {

		Collections.sort(this.poly);
		Collections.sort(poly2.poly);

		Polynomial q = new Polynomial();
		Polynomial r = this;			
		Fraction p2Coeff = poly2.lead();

		while ( r.exists() && r.getRank()>=poly2.getRank() ) {
			int pow = r.getRank()-poly2.getRank();
			Fraction rCoeff = r.lead();
			Fraction coeff = rCoeff.division(p2Coeff) ;
			Monomyal lead = new Monomyal(coeff, pow);

			Polynomial t = new Polynomial();
			t.poly.add(lead);
			q = q.add(t);
			r = r.sub(t.mul(poly2));

		}

		Polynomial[] divisionResults = new Polynomial[] {q, r};
		return divisionResults;
	}

	public Polynomial deriv( ) {	
		Polynomial result = new Polynomial();
		Monomyal m2;
		for( Monomyal m1 : poly ) {
			if( m1.getPow()>0) {
				m2 = new Monomyal( m1.getCoeff().multiplication( new Fraction(m1.getPow())), m1.getPow()-1 );
				result.poly.add(m2);
			}
			else
				if(m1.getPow()==0) {
					m2 = new Monomyal( new Fraction(0), 0);
					result.poly.add(m2);
				}		
		}
		return result;
	}

	public Polynomial integ( ) {	
		Polynomial result = new Polynomial();
		Monomyal m2;
		for( Monomyal m1 : poly ) {
			m2 = new Monomyal( m1.getCoeff().division(new Fraction((m1.getPow()+1))), m1.getPow()+1 );
			result.poly.add(m2);
		}
		//		this.poly = result.poly;
		return result;
	}

	@Override

	public String toString() {
		// TODO Auto-generated method stub
		Collections.sort(this.poly, Collections.reverseOrder());
		String string = new String ("");
		for( Monomyal m: this.poly ) {
			if(m.getCoeff().getDecimal()!=0) {
				if( Math.abs(m.getCoeff().getDenominator()) !=1 ) // it is a fraction, not an integer
					string+=(m.getCoeff().getNumerator()>0? "+" : "")+m.getCoeff().getNumerator()+"/"+m.getCoeff().getDenominator()+"x^"+m.getPow();	
				else { // integer
					if( m.getPow()>1 && Math.abs(m.getCoeff().getNumerator()) !=1  ) {
						string+= (m.getCoeff().getNumerator()>0? "+" : "")+m.getCoeff().getNumerator()+"x^"+m.getPow();
					}
					if( m.getPow()>1 && Math.abs(m.getCoeff().getNumerator()) ==1  ) {
						string+= (m.getCoeff().getNumerator()>0? "+" : "-")+"x^"+m.getPow();
					}
					if (m.getPow()==1 ) {
						if( Math.abs(m.getCoeff().getNumerator()) ==1  ) 
							string+= (m.getCoeff().getNumerator()>0? "+" : "-")+"x";
						else
							if ( Math.abs(m.getCoeff().getNumerator()) !=1  ) 
								string+= (m.getCoeff().getNumerator()>0? "+" : "")+m.getCoeff().getNumerator()+"x";
					}
					if ( m.getPow()==0) {
						string+= (m.getCoeff().getNumerator()>0? "+" : "")+m.getCoeff().getNumerator();
					}
				}
			}
		}
		if(string.length()>0 && string.charAt(0)=='+' ) string = string.substring(1);
		return string;
	}

	public boolean exists () {
		if( this.getRank()>=0)
			return true;
		return false;
	}

	private Fraction lead() {
		Fraction l= new Fraction(0);
		int rank = this.getRank();
		for ( Monomyal m: this.poly)
			if( m.getPow() == rank)
				l = m.getCoeff();

		return l;
	}

	public Polynomial toPolynomial (String polyString) {
		Pattern pattern = Pattern.compile("([+-]?\\d*x(\\^\\d+)?|[+-]\\d+)");
		Matcher matcher = pattern.matcher(polyString);
		int x=0;
		List<Monomyal> poly = new ArrayList<Monomyal>();
		Polynomial pol = new Polynomial();
		boolean matches = true;
		matches = polyString.matches("-?\\d+(\\d+)?");
		if( matches == true) {
			Monomyal m= new Monomyal((new Fraction(Integer.parseInt(polyString))), 0);
			poly.add(m);
		}
		else {
			if ( pol.isPolynomial(polyString) )
				while (matcher.find()) {
					x=x+1;
					String monomial = matcher.group(1);
					Monomyal m = new Monomyal(new Fraction(0), 0);
					m.toMonomial(monomial);
					poly.add(m);
				}
		}
		pol = new Polynomial(poly);
		this.poly = pol.poly;

		return this;
	}

	public boolean isPolynomial ( String string) {
		Pattern pattern = Pattern.compile("([+-]?\\d*x(\\^\\d+)?|[+-]\\d+)");
		Matcher matcher = pattern.matcher(string);
		int end=0;
		int x=0;
		boolean matches = true;
		matches = string.matches("-?\\d+(\\d+)?");

		if ( matches == false ) {
			matches = true;
			while (matcher.find()) {
				x=x+1;
				if( x!=1 && matcher.start()!=end )
					matches = false;		
				end = matcher.end();
			}
			if( end!= string.length())
				matches=false;			
		}
		return matches;
	}
}
