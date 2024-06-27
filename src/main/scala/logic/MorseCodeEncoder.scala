package logic

import utils.{MorseCode, Printer, Reader}

class MorseCodeEncoder {

  val reader =  new Reader()
  val printer = new Printer()

  // method to convert character to morse code
  def characterToMorseCode(c: Char): String = {
    // find character in data set
    // finds the morse code of the character in data set
    MorseCode.getCharacter(c).getOrElse("")
  }

  // method to convert string to morse code
  def stringToMorseCode(string: String): Unit ={
  // split up string into characters and pass each one through the above method?
    val secretStuff = string.toUpperCase.map{
      case ' ' => "  "
      case char => characterToMorseCode(char)
    }.mkString(" ")
    printer.printMessage(secretStuff)
  }

  def encode(): Unit = {
    val userInput = reader.readLine("\n write something you want translated into morse code: ")
    stringToMorseCode(userInput)
  }


}
