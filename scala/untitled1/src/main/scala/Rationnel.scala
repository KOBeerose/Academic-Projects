class Rationnel(var n : Int, var d : Int) {
  require(d != 0)
  private def pgc(n : Int, d : Int): Int = {
    if ( n >= d ) {
      var r = n % d
      if (r == 0) d
      else pgc(d, r)
    }
    else {
      var r = d % n
      if ( r == 0 ) n
      else pgc(n, r)
    }
  }



  def ins() : Rationnel = new Rationnel(n/pgc(d, n), d/pgc(d, n))

  def +(p : Rationnel) : Rationnel = new Rationnel(n*p.d + p.n*d, d*p.d)

  def -(p : Rationnel) : Rationnel = new Rationnel(n*p.d - p.n*d, d*p.d)

  def *(p : Rationnel) : Rationnel = new Rationnel(n*p.n, d*p.d)

  def /(p : Rationnel) : Rationnel = new Rationnel(n*p.d, d*p.n)

  override def toString(): String = n+" / "+d

  def operation(p : Rationnel): Rationnel = {
    println("Choose an operation : \n" +
      "1) Addition\n" +
      "2) Sustraction\n" +
      "3) Multiplication\n" +
      "4) Division\n")
    var n : Int = scala.io.StdIn.readInt()
    n match {
      case 1 => this.+(p)
      case 2 => this.-(p)
      case 3 => this.*(p)
      case 4 => this./(p)
      case _ => null
    }
  }

}
