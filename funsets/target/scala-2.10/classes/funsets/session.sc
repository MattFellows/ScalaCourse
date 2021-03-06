package funsets

import FunSets._

object session {
  val s1And3 = union(singletonSet(1), singletonSet(3))
                                                  //> s1And3  : Int => Boolean = <function1>
  val s2And4 = union(singletonSet(2), singletonSet(4))
                                                  //> s2And4  : Int => Boolean = <function1>
  val test = map(s1And3, x => x * x)              //> test  : Int => Boolean = <function1>
  
  printSet(s1And3)                                //> {1,3}
  printSet(s2And4)                                //> {2,4}
  printSet(test)                                  //> {1,9}
  
  val a1 = singletonSet(1)                        //> a1  : Int => Boolean = <function1>
  val a3 = singletonSet(3)                        //> a3  : Int => Boolean = <function1>
  val a4 = singletonSet(4)                        //> a4  : Int => Boolean = <function1>
  val a5 = singletonSet(5)                        //> a5  : Int => Boolean = <function1>
  val a7 = singletonSet(7)                        //> a7  : Int => Boolean = <function1>
  val a1000 = singletonSet(1000)                  //> a1000  : Int => Boolean = <function1>
  val a1001 = singletonSet(1001)                  //> a1001  : Int => Boolean = <function1>
 
  
  printSet(a7)                                    //> {7}
  printSet(a1000)                                 //> {1000}
  printSet(a1001)                                 //> {}
  printSet(union(a1001, a1000))                   //> {1000}
  printSet(union(a7, a1000))                      //> {7,1000}
}