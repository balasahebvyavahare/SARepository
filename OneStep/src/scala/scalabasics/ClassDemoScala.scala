package scala.scalabasics

class Point (val vx : Int , val vy : Int) {
  var x: Int = vx
  var y: Int = vy

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