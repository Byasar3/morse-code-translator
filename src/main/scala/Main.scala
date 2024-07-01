import logic.MorseCodeEncoder

object Main {
  def main(args: Array[String]): Unit = {
    val encoder = new MorseCodeEncoder
    encoder.encode()
  }
}
