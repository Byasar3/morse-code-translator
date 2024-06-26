package utils

object MorseCode {
  val morseCodeMap: Map[Char, String] = Map(
    'A' -> "*-",
    'B' -> "-***",
    'C' -> "-*-*",
    'D' -> "-**",
    'E' -> "*",
    'F' -> "**-*",
    'G' -> "--*",
    'H' -> "****",
    'I' -> "**",
    'J' -> "*---",
    'K' -> "-*-",
    'L' -> "*-**",
    'M' -> "--",
    'N' -> "-*",
    'O' -> "---",
    'P' -> "*--*",
    'Q' -> "--*-",
    'R' -> "*-*",
    'S' -> "***",
    'T' -> "-",
    'U' -> "**-",
    'V' -> "***-",
    'W' -> "*--",
    'X' -> "-**-",
    'Y' -> "-*--",
    'Z' -> "--**",
    '1' -> "*----",
    '2' -> "**---",
    '3' -> "***--",
    '4' -> "****-",
    '5' -> "*****",
    '6' -> "-****",
    '7' -> "--***",
    '8' -> "---**",
    '9' -> "----*",
    '0' -> "-----",
    '.' -> "*-*-*-",
    ',' -> "__**__",
    '?' -> "**__**",
    '\'' -> "*____*"
  )

  // Option because either Some(String) or None
  def getCharacter(character: Char): Option[String] = morseCodeMap.get(character.toUpper)
}
