package funsets

import FunSets._

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(106); 
  val s1And3 = union(singletonSet(1), singletonSet(3));System.out.println("""s1And3  : Int => Boolean = """ + $show(s1And3 ));$skip(55); 
  val s2And4 = union(singletonSet(2), singletonSet(4));System.out.println("""s2And4  : Int => Boolean = """ + $show(s2And4 ));$skip(37); 
  val test = map(s1And3, x => x * x);System.out.println("""test  : Int => Boolean = """ + $show(test ));$skip(22); 
  
  printSet(s1And3);$skip(19); 
  printSet(s2And4);$skip(17); 
  printSet(test);$skip(30); 
  
  val a1 = singletonSet(1);System.out.println("""a1  : Int => Boolean = """ + $show(a1 ));$skip(27); 
  val a3 = singletonSet(3);System.out.println("""a3  : Int => Boolean = """ + $show(a3 ));$skip(27); 
  val a4 = singletonSet(4);System.out.println("""a4  : Int => Boolean = """ + $show(a4 ));$skip(27); 
  val a5 = singletonSet(5);System.out.println("""a5  : Int => Boolean = """ + $show(a5 ));$skip(27); 
  val a7 = singletonSet(7);System.out.println("""a7  : Int => Boolean = """ + $show(a7 ));$skip(33); 
  val a1000 = singletonSet(1000);System.out.println("""a1000  : Int => Boolean = """ + $show(a1000 ));$skip(33); 
  val a1001 = singletonSet(1001);System.out.println("""a1001  : Int => Boolean = """ + $show(a1001 ));$skip(20); 
 
  
  printSet(a7);$skip(18); 
  printSet(a1000);$skip(18); 
  printSet(a1001);$skip(32); 
  printSet(union(a1001, a1000));$skip(29); 
  printSet(union(a7, a1000))}
}
