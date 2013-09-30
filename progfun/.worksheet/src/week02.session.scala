package week02

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(308); 

  
  def trFactorial(x: Int): Int = {
  	def tailRecursiveFactorial(prevMultiple: Int, currentValue: Int): Int = {
  		if (currentValue == 1) prevMultiple else tailRecursiveFactorial(prevMultiple * currentValue, currentValue - 1)
  	}
  	
  	tailRecursiveFactorial(1, x)
  };System.out.println("""trFactorial: (x: Int)Int""");$skip(72); 
  
  def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x-1);System.out.println("""factorial: (x: Int)Int""");$skip(20); val res$0 = 
  
  trFactorial(6);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  factorial(6);System.out.println("""res1: Int = """ + $show(res$1));$skip(106); 
  
  
  
  def sum(f: Int => Int, a: Int, b: Int): Int = {
  	if (a > b) 0 else f(a) + sum(f, a+1, b)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(165); 
  
  def trSum(f: Int => Int, a: Int, b: Int): Int = {
  	def loop(a: Int, acc: Int): Int = {
  		if (a > b) acc
  		else loop(a+1, f(a)+acc)
  	}
  	loop(a, 0)
  };System.out.println("""trSum: (f: Int => Int, a: Int, b: Int)Int""");$skip(23); val res$2 = 
  
  sum(x => x, 1, 6);System.out.println("""res2: Int = """ + $show(res$2));$skip(22); val res$3 = 
  trSum(x => x, 1, 6);System.out.println("""res3: Int = """ + $show(res$3));$skip(127); 
  
  
  
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	
  		if (a > b) 1
  		else f(a) * product(f)(a+1, b)
  	
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$4 = 
  
  product(x=>x*x)(3, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(52); 
  
  def newFactorial(n: Int) = product(x=>x)(1, n);System.out.println("""newFactorial: (n: Int)Int""");$skip(21); val res$5 = 
  
  newFactorial(6);System.out.println("""res5: Int = """ + $show(res$5));$skip(180); 
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  	if (a > b) zero
  	else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(46); val res$6 = 
  mapReduce(x => x, (x, y) => x * y, 1)(1, 6);System.out.println("""res6: Int = """ + $show(res$6));$skip(82); 
  
  def evenNewerFactorial(x: Int) = mapReduce(x => x, (x, y) => x * y, 1)(1, x);System.out.println("""evenNewerFactorial: (x: Int)Int""");$skip(24); val res$7 = 
  evenNewerFactorial(6);System.out.println("""res7: Int = """ + $show(res$7));$skip(32); 
  
  def r = new Rational(1, 2);System.out.println("""r: => week02.Rational""");$skip(10); val res$8 = 
  r.numer;System.out.println("""res8: Int = """ + $show(res$8));$skip(10); val res$9 = 
  r.denom;System.out.println("""res9: Int = """ + $show(res$9));$skip(4); val res$10 = 
  r;System.out.println("""res10: week02.Rational = """ + $show(res$10));$skip(15); 
  
  def a = r;System.out.println("""a: => week02.Rational""");$skip(28); 
  def b = new Rational(2,3);System.out.println("""b: => week02.Rational""");$skip(11); val res$11 = 
  
  a + b;System.out.println("""res11: week02.Rational = """ + $show(res$11));$skip(11); val res$12 = 
  
  b - a;System.out.println("""res12: week02.Rational = """ + $show(res$12));$skip(31); 
  
  def x = new Rational(1,3);System.out.println("""x: => week02.Rational""");$skip(28); 
  def y = new Rational(5,7);System.out.println("""y: => week02.Rational""");$skip(28); 
  def z = new Rational(3,2);System.out.println("""z: => week02.Rational""");$skip(15); val res$13 = 
  
  x - y - z;System.out.println("""res13: week02.Rational = """ + $show(res$13));$skip(11); val res$14 = 
  
  y + y;System.out.println("""res14: week02.Rational = """ + $show(res$14))}
}


class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must not be 0")
  
  def this(x: Int) = this(x, 1)
  
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a%b)
	private val g = gcd(x, y)

	def numer = x / g
	def denom = y / g
	
	def <(that: Rational): Boolean = numer * that.denom < that.numer * denom
	
	def max(that: Rational): Rational = if (this < that) that else this
	
	def +(that: Rational) = {
		new Rational(
			that.numer * denom + numer * that.denom,
			denom * that.denom
		)
	}
	
	def unary_- : Rational = new Rational(-numer, denom)
	
	def -(that: Rational) = this + -that
	
	override def toString = numer + "/" + denom
}
