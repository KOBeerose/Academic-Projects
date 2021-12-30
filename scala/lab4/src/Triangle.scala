case class Triangle(var segment1 : Segment, var segment2 : Segment,
               var segment3 : Segment, var color : Int) extends Drawable with Movable{

  override def getColor() : Int = this.color
  override def setColor(c : Int): Unit = this.color = color

  override def draw() : Unit = {
    this.segment1.draw()
    this.segment2.draw()
    this.segment3.draw()
  }

  override def translate(dx: Int, dy: Int): Unit = {
    this.segment1.translate(dx/2, dy/2)
    this.segment2.translate(dx/2, dy/2)
    this.segment3.translate(dx/2, dy/2)
  //La division sur 2 car on translate la même coordonnée deux fois
  }
}
