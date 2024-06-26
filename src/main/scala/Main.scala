import logic.MorseCodeEncoder

object Main {
  def main(args: Array[String]): Unit = {
    val encoder = new MorseCodeEncoder
    val char = 'A'
    val morseCode = encoder.characterToMorseCode(char)
    println(s"Morse code for $char is $morseCode")

    val word = "sos"
    val morseCode2 = encoder.stringToMorseCode(word)
    println(s"Morse code for $word is $morseCode2")

    val word2 = "hello?"
    val morseCode3 = encoder.stringToMorseCode(word2)
    println(s"Morse code for $word2 is $morseCode3")
  }
}
