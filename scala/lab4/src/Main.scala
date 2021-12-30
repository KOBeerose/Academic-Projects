object Main {
  def main(args: Array[String]): Unit = {
    var p1 : Point = new Point(1, 1)
    var p2 : Point = new Point(2, 2)
    var p3 : Point = new Point(5, 5)
    println("Les points sont :")
    println(p1.toString())
    println(p2.toString())
    println(p3.toString())
    println("Les segments sont :")
    var seg1 : Segment = new Segment(p1, p2, 1)
    var seg2 : Segment = new Segment(p2, p3, 1)
    var seg3 : Segment = new Segment(p3, p1, 1)
    seg1.draw()
    seg2.draw()
    seg2.draw()
    println("Le triangle est ")
    var triangle = new Triangle(seg1, seg2, seg3, 3)
    triangle.draw()
    println("Le trinagle translaté est :")
    triangle.translate(5, 5)
    triangle.draw()
  }
}