import logic.MorseCodeEncoder
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

class MorseCodeEncoderTest extends AnyFunSpec with BeforeAndAfter{

  var morseCodeEncoder: MorseCodeEncoder = _

  before {
    morseCodeEncoder = new MorseCodeEncoder()
  }

  describe("MorseCodeEncoder"){
    it("should encode a single character correctly"){
      val actual = morseCodeEncoder.stringToMorseCode("S")
      val expected = "..."
      assert(actual == expected)
    }

    it("should encode any word correctly"){
      val actual = morseCodeEncoder.stringToMorseCode("SOS")
      val expected = "... --- ..."
      assert(actual == expected)
    }

    it("should encode any sentence correctly"){
      val actual = morseCodeEncoder.stringToMorseCode("I NEED HELP")
      val expected = "..    -. . . -..    .... . .-.. .--."
      assert(actual == expected)
    }

    it("should handle mixed-case input correctly"){
      val actual = morseCodeEncoder.stringToMorseCode("BOAT 3")
      val expected = "-... --- .- -    ...--"
      assert(actual == expected)
    }

    it("should handle punctuation correctly"){
      val actual = morseCodeEncoder.stringToMorseCode("NEED HELP? ROGER.")
      val expected = "-. . . -..    .... . .-.. .--. ..--..    .-. --- --. . .-. .-.-.-"
      assert(actual == expected)
    }

    it("should throw exception for invalid characters"){
      val input = "SOS@"
      val exception = intercept[Exception] {
        morseCodeEncoder.stringToMorseCode(input)
      }

      assert(exception.getMessage == "Invalid character entered : @")
    }

    it("should handle empty string input"){
      val actual = morseCodeEncoder.stringToMorseCode("")
      val expected = ""
      assert(actual == expected)
    }

    it("should handle input with leading and trailing spaces"){
      val actual = morseCodeEncoder.stringToMorseCode("         SOS         ")
      val expected = "... --- ..."
      assert(actual == expected)
    }

    it("should maintain case insensitivity"){
      val actual = morseCodeEncoder.stringToMorseCode("sOs")
      val actual2 = morseCodeEncoder.stringToMorseCode("sos")
      val expected = "... --- ..."
      assert(actual == expected)
      assert(actual2 == expected)
    }
  }
}
