case class Segment(var beginning : Point, var ending : Point, var color : Int)
  extends Movable with Drawable with Metric{

  def getColor() : Int = this.color
  def setColor(color : Int) : Unit = this.color = color
  def translate(dx : Int, dy : Int) : Unit = {
    this.beginning.translate(dx, dy)
    this.ending.translate(dx, dy)
  }
  def draw(): Unit = {
    println(s"beginning${ending.toString()} - ending${beginning.toString()} ")
  }

  override def length(): Double =
    math.sqrt(math.pow(beginning.x - ending.x, 2)+math.pow(beginning.y - ending.y, 2))
}
