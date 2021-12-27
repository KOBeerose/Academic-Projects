package lab7

object lab7 extends App {
  val favoriteColors = Map(
    "Bob" -> "green",
    "Derek" -> "mangenta",
    "Pared" -> "yellow",
  )
  def getColor1(person: String) : Option[String] = favoriteColors.get(person)

  def getColor(person: String) : String = favoriteColors.get(person).getOrElse("Autre")

  print(getColor(person = "test"))
}
