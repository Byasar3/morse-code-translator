package logic

class MorseCodeEncoderService (encoder: MorseCodeEncoder){
  private def isValidCharacter(c: Char): Boolean = {
    c.isLetterOrDigit || c == ' '
  }

  def translateCharacter(c: Char) :String = {
    if (!isValidCharacter(c)) throw new Exception(s"Invalid character entered: $c")
    val translation = encoder.characterToMorseCode(c)
    s"Input: $c, Translation: $translation"
  }

  def translateString(s: String): String = {
    if (!s.forall(isValidCharacter)) {
      val invalidChars = s.filterNot(isValidCharacter)
      throw new Exception(s"Invalid characters entered: $invalidChars")
    }
    val translation = encoder.stringToMorseCode(s)
    s"Input: $s, Translation: $translation"
  }

}
