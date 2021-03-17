package fraction;

public class Fraction {

	private int x;
	private int y;

	public Fraction (int x) {
		this.x=x;
		this.y=1;
	}

	public Fraction (int x, int y) {

		this.x=x;
		this.y=y;


	}

	public double getDecimal () {
		return (double)x/y;
	}

	public int getNumerator() {
		return x;
	}

	public int getDenominator() {
		return y;
	}

	int gcd(int a, int b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b % a, a); 
	} 

	public Fraction simplify (Fraction a) {
		int div= gcd(a.x,a.y);
		a.x/=div;
		a.y/=div;

		return a;
	}

	public Fraction addition (Fraction b) {
		Fraction a=this;
		a=a.simplify(a);
		b=b.simplify(b);

		Fraction c=new Fraction(0,0);
		int z=gcd(a.y,b.y);
		int commonDen=a.y*b.y/z;

		c.y=commonDen;

		c.x=commonDen/a.y*a.x+commonDen/b.y*b.x;
		c=c.simplify(c);
		c.sign();

		return c;
	}

	public Fraction subtraction (Fraction b) {
		Fraction a=this;
		a=a.simplify(a);
		b=b.simplify(b);

		Fraction c=new Fraction(0,0);
		int z=gcd(a.y,b.y);
		int commonDen=a.y*b.y/z;

		c.y=commonDen;

		c.x=commonDen/a.y*a.x-commonDen/b.y*b.x;
		c=c.simplify(c);
		c.sign();

		return c;
	}

	public Fraction multiplication (Fraction b) {
		Fraction a=this;
		a=a.simplify(a);
		b=b.simplify(b);
		Fraction c=new Fraction(0,0);

		c.x=a.x*b.x;
		c.y=a.y*b.y;
		c=c.simplify(c);
		c.sign();

		return c;

	}

	public Fraction division (Fraction b) {
		Fraction a=this;
		a=a.simplify(a);
		b=b.simplify(b);
		Fraction c=new Fraction(0,0);

		c.x=a.x*b.y;
		c.y=a.y*b.x;
		c=c.simplify(c);
		c.sign();

		return c;
	}

	private Fraction sign() {
		if( Math.signum(this.y)==-1 ) {
			this.x *= -1;
			this.y *= -1;
		}
		return this;	
	}
}
