package scala.scalabasics

class ClassDemoScala {
  var x: Int = 5
  var y: Int = 5

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy

    println("X is " + x);
    println("Y is " + y);

  }
}

object demo {
  def main(args: Array[String]) {
    val pt = new ClassDemoScala()

    pt.move(10, 20)

  }
}