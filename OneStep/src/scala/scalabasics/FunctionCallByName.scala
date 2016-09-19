package scala.scalabasics

/*
 * Scala has both functions and methods and we use the terms method and function interchangeably with a minor difference.
 *  A Scala method is a part of a class which has a name, 
 *  a signature, optionally some annotations, 
 *  and some bytecode where as a function in Scala is a complete object which can be assigned to a variable. In other words,
 *   a function, which is defined as a member of some object, is called a method.
 * 
 */


object FunctionCallByName {
  def main(args: Array[String]) {
    delayed(time());
  }

  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }
  def delayed(t: => Long) = {           // this needs to be cleared
    println("In delayed method")
    println("Param: " + t)
  }

}