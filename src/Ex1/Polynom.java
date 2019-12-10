package Ex1;

import java.util.Iterator;
import java.util.TreeMap;
import Ex1.Monom;

/**
 * This class represents a Polynom with add, multiply functionality, it also
 * should support the following: 1. Riemann's Integral:
 * https://en.wikipedia.org/wiki/Riemann_integral 2. Finding a numerical value
 * between two values (currently support root only f(x)=0). 3. Derivative
 * 
 * @author Netanel Albert, Avital Pikovsky
 *
 */
public class Polynom implements Polynom_able {

	/**
	 * Keeps the Monoms of this Polynom when the power of each Monom is the key for it.
	 * the benefits of the TreeMap are: a. non duplicate structure, b. get a Monom in O(1), 
	 * c. keep the Monoms orders from small (power) to the big.
	 */
	private TreeMap<Integer, Monom> map = new TreeMap<Integer, Monom>();

	/**
	 * Zero (empty Polynom)
	 */
	public Polynom() {}

	/**
	 * init a Polynom from a String such as: {"x", "3+1.4X^3-34x",
	 * "25", "-3X^78 + 14.3X" etc};
	 * 
	 * @param s: is a string represents a Polynom.
	 * 			except: well defined Monoms (double, -, + or empty coefficient. 
	 * 			low or capital x. natural number as power(and '^' before power))
	 * 			and + / - between the Monoms. (without (,),*)
	 */
	public Polynom(String s) {
		s = s.replaceAll(" ", "");
		String[] monoms = s.split("(?=[-,+])");
		for (int i = 0; i < monoms.length; i++) 
			add(new Monom(monoms[i]));
	}

	@Override
	public double f(double x) {
		double ans = 0;
		for (Iterator<Monom> iterator = iteretor(); iterator.hasNext();) {
			Monom monom = iterator.next();
			ans += monom.f(x);
		}
		return ans;
	}

	@Override
	public void add(Polynom_able p1) {
		for (Iterator<Monom> iterator = p1.iteretor(); iterator.hasNext();) {
			Monom monom = iterator.next();
			if(!monom.isZero())
				add(monom);
		}
	}

	@Override
	public void add(Monom m1) {
		int index = m1.get_power();

		if (map.get(index) != null)
			map.get(index).add(m1);
		else
			map.put(index, new Monom(m1));

		if(map.get(index).isZero()) // remove empty Monom
			map.remove(index);

	}

	@Override
	public void substract(Polynom_able p1) {
		Polynom_able c = (Polynom_able) p1.copy();
		c.multiply(Monom.MINUS1);
		add(c);
	}

	@Override
	public void multiply(Polynom_able p1) {
		if(p1.isZero()) {
			map.clear();
			return;
		}
		Iterator<Monom> it = p1.iteretor();
		Polynom_able copy = copy();

		map.clear();
		while (it.hasNext()) {
			Polynom_able tmp = (Polynom_able) copy.copy();
			tmp.multiply(it.next());
			add(tmp);
		}
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof ComplexFunction)
			return o.equals(this);
		
		if(o instanceof Polynom)
			return equals((Polynom)o);
		
		if(o instanceof Monom)
			return equals(new Polynom(o.toString()));
		
		return false;
	}
	private boolean equals(Polynom p1) {
		Polynom_able p = copy();
		p.substract(p);
		return p.isZero();
	}
	
	@Override
	public boolean isZero() {
		for (Iterator<Monom> iterator = this.iteretor(); iterator.hasNext();) {
			Monom monom = iterator.next();
			if (!monom.isZero())
				return false;
		}
		return true;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		if(f(x0)*f(x1) > 0)
			throw new RuntimeException("Invalid input: x1 and x0 can't be in the same side of the x line");

		if(f(x0) > 0)
			return root(x1,x0,eps);

		double x = (x0+x1)*0.5;
		double y = f(x);
		if(-eps < y && y < eps)
			return x;

		if(y > 0)
			return root(x0, x, eps);
		else
			return root(x, x1, eps);
	}

	@Override
	public Polynom_able copy() {
		Polynom p = new Polynom();
		p.add(this);
		return p;
	}

	@Override
	public Polynom_able derivative() { // נגזרת
		Polynom p = new Polynom();
		Iterator<Monom> it = iteretor();
		while (it.hasNext()) {
			Monom m = it.next();
			p.add(m.derivative());
		}
		return p;
	}

	@Override
	public double area(double x0, double x1, double eps) {
		double area = 0, averageF ;
		while (x0 + eps < x1) {
			averageF = (f(x0) + f(x0+eps))*0.5;
			if(averageF > 0)
				area += averageF*eps;
			x0 += eps;
		}
		averageF = (f(x0) + f(x1))*0.5;
		if(averageF > 0 && x0 < x1)
			area += averageF*(x1-x0);		
		return area;
	}

	@Override
	public Iterator<Monom> iteretor() {
		return map.values().iterator();
	}

	@Override
	public void multiply(Monom m1) {
		if(m1.isZero()) {
			map.clear();
		} else {
			Iterator<Monom> it = copy().iteretor();
			map.clear();

			while (it.hasNext()) {
				Monom m = it.next();
				m.multipy(m1);
				map.put(m.get_power(), m);
			}
		}
	}

	/**
	 * Returns a string representation of the polynom, 
	 * when the lowest power are in the left and the highest in the right.
	 * 
	 * @Returns:a string representation of the polynom, in form of "a + bx + cx^2 + dx^3..."
	 */
	@Override
	public String toString() {
		if(map.size() == 0)
			return "0";
		Iterator<Monom> iter = iteretor();
		String ans = "";
		if(iter.hasNext())
			ans += iter.next();

		while (iter.hasNext()) {
			Monom monom = iter.next();
			if(monom.get_coefficient() > 0)
				ans += '+';
			ans += monom;
		}
		return ans;
	}

	@Override
	public function initFromString(String s) {
		return new Polynom(s);
	}
}