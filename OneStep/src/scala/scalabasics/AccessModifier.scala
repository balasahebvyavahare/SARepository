package scala.scalabasics

class AccessModifier {
  class Inner {
    private def f() {
      println("F");
    }
    class InnerMost {
      def callf() {
        f()
      }
    }
  }
}
