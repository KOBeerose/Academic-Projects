case class Point(var x: Int, var y: Int) extends Movable with Metric{

  def this() = this(0, 0)
  def getX() : Int = this.x
  def getY() : Int = this.y
  def setX(X : Int) : Unit = this.x = X
  def setY(Y : Int) : Unit = this.y = Y
  def translate(dx : Int, dy : Int) : Unit = {
    this.setX(this.getX()+dx)
    this.setY(this.getY()+dx)
  }
  override def toString() : String = s"($x, $y)"

  override def length(): Double = 0

  override def distanceFromOrigin(): Double =
    math.sqrt(math.pow(this.x, 2)+math.pow(this.y, 2))
}
