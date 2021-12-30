object obj {

  def main(args : Array[String]): Unit = {
    var r = new Rationnel(10, 6)
    r = r.ins()
    var r2 = new Rationnel(15, 30)
    r2 = r2.ins()
    println("r1 = "+r.toString())
    println("r2 = "+r2.toString())
    println("r1 + r2 = "+r.+(r2).toString())
    println("r1 - r2 = "+r.-(r2).toString())
    println("r1 * r2 = "+r.*(r2).toString())
    println("r1 / r2 = "+r./(r2).toString())
    println(r.operation(r2).toString())
  }
}
