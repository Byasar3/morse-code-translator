import logic.{MorseCodeEncoder, MorseCodeEncoderService}
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec
import org.mockito.MockitoSugar._
import org.mockito.ArgumentMatchersSugar._

class MorseCodeEncoderServiceTest extends AnyFunSpec with BeforeAndAfter {

  var mockMorseCodeEncoder: MorseCodeEncoder = _
  var morseCodeEncoderService: MorseCodeEncoderService = _

  before {
    mockMorseCodeEncoder = mock[MorseCodeEncoder]
    morseCodeEncoderService = new MorseCodeEncoderService(mockMorseCodeEncoder)

  }

  describe("MorseCodeEncoderService") {

    it("should translate valid char") {
      // Define mock behavior
      when(mockMorseCodeEncoder.characterToMorseCode('A')).thenReturn(".-")

      // Call the method to be tested
      val result = morseCodeEncoderService.translateCharacter('A')

      // Assert the result
      assert(result == "Input: A, Translation: .-")
    }
  }
  it("should handle invalid char") {
    // Define mock behavior (e.g., throwing exception)
    when(mockMorseCodeEncoder.characterToMorseCode('*')).thenThrow(new Exception("Invalid character entered: *"))

    // Call the method with invalid input
    val exception = intercept[Exception] {
      morseCodeEncoderService.translateCharacter('*')
    }

    // Assert the exception message or behavior as needed
    assert(exception.getMessage == "Invalid character entered: *")
  }

  it("should translate valid string") {
    // Define mock behavior for string translation
    when(mockMorseCodeEncoder.stringToMorseCode("HELLO")).thenReturn(".... . .-.. .-.. ---")

    // Call the method to be tested
    val result = morseCodeEncoderService.translateString("HELLO")

    // Assert the result
    assert(result == "Input: HELLO, Translation: .... . .-.. .-.. ---")
  }

  it("should handle invalid string") {
    // Define mock behavior (e.g., throwing exception)
    when(mockMorseCodeEncoder.stringToMorseCode("HELLO@")).thenThrow(new Exception("Invalid characters"))

    // Call the method with invalid input
    val exception = intercept[Exception] {
      morseCodeEncoderService.translateString("HELLO@")
    }

    // Assert the exception message or behavior as needed
    assert(exception.getMessage == "Invalid characters entered: @")
  }
}
