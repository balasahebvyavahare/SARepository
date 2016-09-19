package scala.scalabasics

object FunctionWithNamedArgument {

  def main(args: Array[String]) {
    printInt(b = 5, a = 20);
  }
  def printInt(a: Int, b: Int) = {
    println("Value of a : " + a);
    println("Value of b : " + b);
  }

}