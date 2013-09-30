package week01

object session {

  def abs(x: Double) = {
    if (x > 0) x else -x
  }                                               //> abs: (x: Double)Double

  def isGoodEnough(guess: Double, x: Double): Boolean = {
  	abs(guess * guess - x) / x < 0.0000000000000001
  }                                               //> isGoodEnough: (guess: Double, x: Double)Boolean
  
  def improveGuess(guess: Double, x: Double): Double = {
    (guess + x / guess) / 2
  }                                               //> improveGuess: (guess: Double, x: Double)Double
	
	def sqrtIter(guess: Double, x: Double): Double = {
		if (isGoodEnough(guess, x)) guess
		else sqrtIter(improveGuess(guess, x), x)
	}                                         //> sqrtIter: (guess: Double, x: Double)Double

  def sqrt(x: Double): Double = sqrtIter(1.0, x)  //> sqrt: (x: Double)Double
  
  sqrt(4)                                         //> res0: Double = 2.0
  
  
  
  
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else if (money == 0) 1
    else if (money <= 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }                                               //> countChange: (money: Int, coins: List[Int])Int
  
}