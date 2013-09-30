package week02

object session {

  
  def trFactorial(x: Int): Int = {
  	def tailRecursiveFactorial(prevMultiple: Int, currentValue: Int): Int = {
  		if (currentValue == 1) prevMultiple else tailRecursiveFactorial(prevMultiple * currentValue, currentValue - 1)
  	}
  	
  	tailRecursiveFactorial(1, x)
  }                                               //> trFactorial: (x: Int)Int
  
  def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x-1)
                                                  //> factorial: (x: Int)Int
  
  trFactorial(6)                                  //> res0: Int = 720
  factorial(6)                                    //> res1: Int = 720
  
  
  
  def sum(f: Int => Int, a: Int, b: Int): Int = {
  	if (a > b) 0 else f(a) + sum(f, a+1, b)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  def trSum(f: Int => Int, a: Int, b: Int): Int = {
  	def loop(a: Int, acc: Int): Int = {
  		if (a > b) acc
  		else loop(a+1, f(a)+acc)
  	}
  	loop(a, 0)
  }                                               //> trSum: (f: Int => Int, a: Int, b: Int)Int
  
  sum(x => x, 1, 6)                               //> res2: Int = 21
  trSum(x => x, 1, 6)                             //> res3: Int = 21
  
  
  
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	
  		if (a > b) 1
  		else f(a) * product(f)(a+1, b)
  	
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x=>x*x)(3, 4)                           //> res4: Int = 144
  
  def newFactorial(n: Int) = product(x=>x)(1, n)  //> newFactorial: (n: Int)Int
  
  newFactorial(6)                                 //> res5: Int = 720
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  	if (a > b) zero
  	else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int
  mapReduce(x => x, (x, y) => x * y, 1)(1, 6)     //> res6: Int = 720
  
  def evenNewerFactorial(x: Int) = mapReduce(x => x, (x, y) => x * y, 1)(1, x)
                                                  //> evenNewerFactorial: (x: Int)Int
  evenNewerFactorial(6)                           //> res7: Int = 720
  
  def r = new Rational(1, 2)                      //> r: => week02.Rational
  r.numer                                         //> res8: Int = 1
  r.denom                                         //> res9: Int = 2
  r                                               //> res10: week02.Rational = 1/2
  
  def a = r                                       //> a: => week02.Rational
  def b = new Rational(2,3)                       //> b: => week02.Rational
  
  a + b                                           //> res11: week02.Rational = 7/6
  
  b - a                                           //> res12: week02.Rational = 1/6
  
  def x = new Rational(1,3)                       //> x: => week02.Rational
  def y = new Rational(5,7)                       //> y: => week02.Rational
  def z = new Rational(3,2)                       //> z: => week02.Rational
  
  x - y - z                                       //> res13: week02.Rational = -79/42
  
  y + y                                           //> res14: week02.Rational = 10/7
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