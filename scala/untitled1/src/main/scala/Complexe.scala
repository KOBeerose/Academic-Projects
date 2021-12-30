class Complexe(var real : Double, var imaginary : Double = 0) {

  //Multiplication par scalaire
  def sc(a : Double) : Complexe = new Complexe(real*a, imaginary*a)
  //Norme, Module
  def norm() : Double = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2))
  //Conjugué
  def conj() : Complexe = new Complexe(this.real, -this.imaginary)
  def +(z : Complexe) : Complexe = new Complexe( real + z.real, imaginary + z.imaginary)
  def -(z : Complexe) : Complexe = new Complexe( real - z.real, imaginary - z.imaginary)
  def *(z : Complexe) : Complexe =
    new Complexe( real*z.real - imaginary*z.imaginary, real*z.imaginary + imaginary*z.real)
  def /(z : Complexe) : Complexe = {
    if (z.real == 0 & z.imaginary == 0) null
    else (this.*(z.conj())).sc(1/Math.pow(z.norm(), 2))
  }

  def tostring() : String = {
    if (imaginary != 0 ) real+" + i*"+imaginary
    else real+""
  }

  def operation(): Unit = {
    var r : Double = 0
    var i : Double = 0
    println("La partie réelle du premier opérande : ")
    r = scala.io.StdIn.readInt()
    println("La partie imaginaire : ")
    i = scala.io.StdIn.readInt()
    var y : Complexe = new Complexe(r, i)
    println("Le nombre entré est : "+y.tostring())
    println("La partie réelle du deuxième opérande : ")
    r = scala.io.StdIn.readInt()
    println("La partie imaginaire : ")
    i = scala.io.StdIn.readInt()
    var z : Complexe = new Complexe(r, i)
    println("Le nombre entré est : "+z.tostring())
    println("Choose an operation : \n" +
      "1) Addition\n" +
      "2) Sustraction\n" +
      "3) Multiplication\n" +
      "4) Division\n" +
      "5) Normes\n")
    var n : Int = scala.io.StdIn.readInt()
    n match {
      case 1 => println(y.tostring()+" + "+z.tostring()+" = "+y.+(z).tostring())
      case 2 => println(y.tostring()+" - "+z.tostring()+" = "+y.-(z).tostring())
      case 3 => println(y.tostring()+" * "+z.tostring()+" = "+y.*(z).tostring())
      case 4 => println(y.tostring()+" / "+z.tostring()+" = "+y./(z).tostring())
      case 5 => println("Les modules sont : "+y.norm()+" et "+z.norm)
      case _ => println("Réponse invalide !")
    }
    /*println("Continuer [y/n]")
    var c : Char = scala.io.StdIn.readChar()
    c match {
      case 'y' => this.operation()
      case _ => "Au revoir !"
    }*/
  }




}
