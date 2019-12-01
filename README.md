The project written by:

Netanel Albert - 206290074
Avital Pikovsky - 316331198

Our project represent a Polynom and a Monom when each of them has functions that can be applied on them.

We have 2 classes in our project:

Monom - shape ax^b, where a real number and b is an integer(none negative), Polynom- shape array of monoms.


MONOM CLASS:

Monoms class have some functions:

1.Add monoms with the same power(new one and exist one).

2.f(x) - Calculate specific x (int and double x).

3.Derivative.

4.Multiply two monoms.

5.Check if two monoms are equals.

6.Check if the monom is the zero monom.

7.Substract between two monoms with the same power.

7.GetCoef - help functions that get string that represent monom and find his coefficient.

8.GetPower - help functions that get string that represent monom and find his power.

9.To string - return a string of the monom.

The class have 3 constructor:

1.Defult constractor.

2.Copy constractor.

3.String constractor- get string of monom and make it to new monom.

We also have getteres and setters:

1.Power getter and setter.

2.Coefficient getter and setter.


POLYNOM CLASS:

The class have 1 field:

TreeMap map - we used this data stracture for 2 reasons:

1.to add/get Monoms easely and quick by the Key-Value Method. we did it by use the power of the Monom as the key.

2.to keep the Monoms sorted (by the power value).

The class have 3 constructor:

1.Defult constractor.

2.String constractor- get string of polynom and make it to new polynom.

3.Copy constractor.

Polynom class have some functions:

1.Add monom to our polynom.

2.Add polynom to our polynom.

3.Substract between two polynoms.

4.Substract monom from our polynom.

5.Multiply two polynoms.

6.Check if two polynoms are equals.

7.Check if the polynom is the zero monom.

8.Root-finds a root value of a polynom while given 2 values that 1 is positive and the other negative and eps which will make sure that we are eps close to the 0.

9.Create a deep copy of this Polynum.

10.Derivative of the polynom.

11.Area - Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps.

12.Iterator (of Monoms) over this Polynom.

13.Calculate specific x to the polynom (int and double).

14.to string - return a string of the Polynom.