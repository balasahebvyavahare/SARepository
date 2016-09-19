package scala.scalabasics

object forLoopwithUntil {
  def main(args: Array[String]) {
    var a = 0;

    for (a <- 1 until 10) {
      println("Value of a: " + a);
    }
  }

}