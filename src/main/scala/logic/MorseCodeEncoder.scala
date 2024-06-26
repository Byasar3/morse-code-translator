package logic

import utils.MorseCode

class MorseCodeEncoder {

  // method to convert character to morse code
  def characterToMorseCode(c: Char): String = {
    // find character in data set
    // finds the morse code of the character in data set
    MorseCode.getCharacter(c).getOrElse("")
  }


  // method to convert string to morse code
  def stringToMorseCode(string: String): String ={
  // split up string into characters and pass each one through the above method?
    string.toUpperCase.map(char => characterToMorseCode(char)).mkString(" ")
  }


}
