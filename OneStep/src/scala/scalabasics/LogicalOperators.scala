package scala.scalabasics

object LogicalOperators {
  def main(args: Array[String]) {
    var a = true;
    var b = false;
    println("a && b = " + (a && b));
    println("a || b = " + (a || b));
    println("!(a && b) = " + !(a && b));
  }
}