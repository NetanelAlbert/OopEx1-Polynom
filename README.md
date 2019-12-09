The project written by:

Netanel Albert - 206290074
Avital Pikovsky - 316331198

Our project represent a 4 main classes: Polynom, Monom, ComplexFunction and Function_GUI when each of them has functions that can be applied on them.

Monom - shape ax^b, where a real number and b is an integer(none negative),
Polynom - shape list of monoms,
ComplexFunction - shape of - Operation(function, function) when function is Monom, Polynom or ComplexFunction.
Function_GUI - class that hold a collection of functions, write and read the functions to file and show them on GUI.

MONOM CLASS:

Monoms class have some functions:

1.Add monoms with the same power(new one and exist one).

2.f(x) - Calculate specific x (double x).

3.Derivative.

4.Multiply two monoms.

5.Check if two monoms are equals.

6.Check if the monom is the zero monom.

7.Substract between two monoms with the same power.

7.get_Coefficient - help functions that get string that represent monom and find his coefficient.

8.get_Power - help functions that get string that represent monom and find his power.

9.To string - return a string of the monom.

10.initFromString that get String and return monom.

11.copy - Create a deep copy of this Monom.

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

3.Substract monom from our polynom.

4.Multiply our polynom with other polynom.

5.Multiply our polynom with monom.

6.equals - Check if two objects are equals.

7.isZero - Check if the polynom is the zero monom.

8.Root - finds a root value of a polynom while given 2 values that 1 is positive and the other negative and eps which will make sure that we are eps close to the 0.

9.copy - Create a deep copy of this Polynum.

10.Derivative of the polynom.

11.Area - Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps.

12.Iterator (of Monoms) over this Polynom.

13.f(x) - Calculate specific x to the polynom (double x).

14.to string - return a string of the Polynom.

15.initFromString that get String and return polynom.


ComplexFunction CLASS:

The class have 3 constructor:

1.ComplexFunction(function f)

2.ComplexFunction(Operation op, function f1, function f2)

3.ComplexFunction(String s, function f1, function f2)

ComplexFunction class have some functions:

1.f(x) - Calculate specific x (double x).

2.initFromString that gets String and return function.

3.copy - Create a deep copy of this.

4.geters: left, right, getOp.

5.Operations functions that get (function f) : plus, mul, div, max, min, comp.
  the functions change this object shape to op(this, f).
  
6.equals - Check if two objects are partly equals (issue #2).

7.to string - return a string of the ComplexFunction shape: "op(left, right)".

Function_GUI class extends ArrayList:

1.initFromFile
2.saveToFile
3.drawFunctions that gets (int width, int height, Range rx, Range ry, int resolution)
4.drawFunctions that gets String 'json_file'.

