package week01

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 

  def abs(x: Double) = {
    if (x > 0) x else -x
  };System.out.println("""abs: (x: Double)Double""");$skip(114); 

  def isGoodEnough(guess: Double, x: Double): Boolean = {
  	abs(guess * guess - x) / x < 0.0000000000000001
  };System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(92); 
  
  def improveGuess(guess: Double, x: Double): Double = {
    (guess + x / guess) / 2
  };System.out.println("""improveGuess: (guess: Double, x: Double)Double""");$skip(136); 
	
	def sqrtIter(guess: Double, x: Double): Double = {
		if (isGoodEnough(guess, x)) guess
		else sqrtIter(improveGuess(guess, x), x)
	};System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(50); 

  def sqrt(x: Double): Double = sqrtIter(1.0, x);System.out.println("""sqrt: (x: Double)Double""");$skip(13); val res$0 = 
  
  sqrt(4);System.out.println("""res0: Double = """ + $show(res$0));$skip(233); 
  
  
  
  
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else if (money == 0) 1
    else if (money <= 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""")}
  
}
