object Main extends App {
  def exe(): Unit = {

    var c : Complexe = new Complexe(7)
    println(c.tostring())
    c.operation()
  }
  exe()
}
