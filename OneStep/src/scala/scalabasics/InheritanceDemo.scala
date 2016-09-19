package scala.scalabasics

class InheritanceDemo(override val dx: Int, override val dy: Int, val dz: Int)
    extends Point(dx, dy) {

  var z: Int = dz

  def move(dx: Int, dy: Int, dz: Int) {

    x = x + dx
    y = y + dy
    z = z + dz

    println(" \n X = " + x + " \n Y = " + y + " \n Z = " + z);

  }

}

object demo1 {
  def main(args: Array[String]) {
    val id = new InheritanceDemo(10, 20, 30);
    id.move(10, 20, 30);

  }
}