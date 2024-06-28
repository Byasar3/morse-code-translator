package logic

import utils.{MorseCode, Printer, Reader}

class MorseCodeEncoder {

  val reader =  new Reader()
  val printer = new Printer()

  // method to convert character to morse code
  def characterToMorseCode(c: Char): String = {
    // find character in data set
    // finds the morse code of the character in data set
    MorseCode.getCharacter(c).getOrElse(throw new Exception(s"Invalid character entered: $c"))
  }

  // method to convert string to morse code
  def stringToMorseCode(string: String): String ={
  // split up string into characters and pass each one through the above method?
    val secretStuff = string.toUpperCase.trim.map{
      case ' ' => "  "
      case char if MorseCode.getCharacter(char).isDefined => characterToMorseCode(char)
      case char => throw new Exception(s"Invalid character entered : $char")
    }.mkString(" ")
    printer.printMessage(secretStuff)
    secretStuff
  }

  def encode(): Unit = {
    val userInput = reader.readLine("\n write something you want translated into morse code: ")
    stringToMorseCode(userInput)
  }


}
