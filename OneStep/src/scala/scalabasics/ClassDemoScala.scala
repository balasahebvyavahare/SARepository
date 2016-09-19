package scala.scalabasics

class Point (val dx : Int , val dy : Int) {
  var x: Int = dx
  var y: Int = dy

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy

    println("X is " + x);
    println("Y is " + y);

  }
}



object demo {
  def main(args: Array[String]) {
    val pt = new Point(25 , 30 )

    pt.move(1, 2)

  }
}