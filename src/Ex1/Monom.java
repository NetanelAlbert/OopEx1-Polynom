package Ex1;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape ax^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Netanel Albert, Avital Pikovsky
 * 
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	/**
	 * Constructs a Monom in form ax^b
	 * @param a - the coefficient
	 * @param b - the power
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	/**
	 * Constructs a deep copy of the given Monom.
	 * @param ot - other Monom to copy
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	/**
	 * @return this Monom coefficient
	 */
	public double get_coefficient() {
		return this._coefficient;
	}
	/**
	 * @return this Monom power
	 */
	public int get_power() {
		return this._power;
	}
	/** 
	 * @return the derivative of this Monom.
	 */
	public Monom derivative() {
		if(get_power()==0) 
			return getNewZeroMonom();
		return new Monom(get_coefficient()*get_power(), get_power()-1);
	}
	/**
	 * @param x a number to calculate the mathematics value for 
	 * 
	 * @return the Monom value in the specific x
	 */
	public double f(double x) {
		double ans=0;
		double p = get_power();
		double c = get_coefficient();
		ans = c*Math.pow(x, p);
		return ans;
	} 
	/**
	 * @return true if the coefficient is less then {@value #EPSILON}, false otherwise
	 */
	public boolean isZero() {
		return Math.abs(get_coefficient()) < EPSILON;
	}
	/**
	 * Constructs Monom from a String in form ax^b:
	 * 			a: double, -, + or empty coefficient. 
	 * 			x: low or capital x. 
	 * 			b: natural number as power (and '^' before power if needed). 
	 * @param s is a proper String representation of Monom
	 */
	public Monom(String s) { 
		s = s.toLowerCase();
		if(s.indexOf('x') != s.lastIndexOf('x'))
			throw new RuntimeException("'" + s + "' isn't a polynom and is"
					+ " an invalid coefficient");
		//find coefficient
		double c;
		if(!s.contains("x"))
				c = parseDouble(s);	
		else if(s.indexOf("x") == 0)
			c = 1;
		else if(s.indexOf('x') == 1) {
			if(s.charAt(0) == '-')
				c = -1;
			else if(s.charAt(0) == '+')
				c = 1;
			else 
				c = parseDouble(s.substring(0, s.indexOf('x')));
		} else 
			c = parseDouble(s.substring(0, s.indexOf('x')));
		
		// find power
		int p;
		if(!s.contains("x"))
			p = 0;
		else if(!s.contains("^")) {
			if(s.indexOf('x') != s.length()-1)
				throw new RuntimeException("'" +s + "' isn't a polynom and is"
						+ " an invalid coefficient");
			p = 1;
		}else
			p = parseInt(s.substring(s.indexOf('x')+2));
		// set coefficient and power
		this.set_coefficient(c);
		this.set_power(p);
	}
	
	/**
	 * add this Monom with the given Monom form the same power
	 * [(ax^b)+(mx^b) = (a+m)x^(b)] 
	 * @param d is other Monom to multiply with.
	 * @throws RuntimeException when the powers not equals.
	 */
	public void add(Monom m) {
		if(this.get_power() == m.get_power())
			set_coefficient(get_coefficient() + m.get_coefficient());
		else {
			throw new RuntimeException("adding differente powers isn't allowd "
					+ "(" + get_power() +", "+ m.get_power() + ")");
		}
	}
	/**
	 * multiply this Monom with the given Monom 
	 * [(ax^b)*(mx^n) = (a*m)x^(b+n)] 
	 * @param d is other Monom to multiply with
	 */
	public void multipy(Monom d) {
		set_coefficient(get_coefficient() * d.get_coefficient());
		set_power(get_power() + d.get_power());
	}
	
	public String toString() {
		String ans = "";
		if(get_coefficient() == -1) 
			ans += '-';
		else if(get_coefficient() != 1) 
			ans += String.format("%.10f", get_coefficient());
		
		if(get_power() > 0) ans += "x";
		if(get_power() > 1) ans += "^" + get_power();
		
		return ans;
	}
	
	/**
	 * @param m - a Monom to compare
	 * @return true if the powers are equals 
	 * and the coefficient difference is less then {@value #EPSILON}, false otherwise
	 */
	public boolean equals(Monom m) {
		return get_power() == m.get_power() &&
				Math.abs(get_coefficient() - m.get_coefficient()) < EPSILON;
	}

	//****************** Private Methods and Data *****************
	

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	/**
	 * @throws RuntimeException if the given power is less then 0
	 */
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	/**
	 * the purpose of this function is to throw a costume 
	 * RuntimeExeption instead of the NumberFormatException of Double.parseDouble
	 * @param s - the String we want to parse
	 * @return the double value of s
	 * @throws RuntimeException if s is null or not a double
	 */
	private double parseDouble(String s) {
		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			throw new RuntimeException("'" +s + "' isn't a float number and is"
					+ " an invalid coefficient");
		}
	}
	/**
	 * the purpose of this function is to throw a costume 
	 * RuntimeExeption instead of the NumberFormatException of Integer.parseDouble.
	 * @param s - the String we want to parse.
	 * @return the integer value of s.
	 * @throws RuntimeException if s is null or not a integer.
	 */
	private int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			throw new RuntimeException("'" +s + "' isn't a integer number and is"
					+ " an invalid power");		
			}
	}
	/**
	 * @return new zero Monom (0x^0).
	 */
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient;
	private int _power;
	@Override
	public function initFromString(String s) {
		return new Monom(s);
	}
	@Override
	public function copy() {
		return new Monom(this);
	}
	
	
}
