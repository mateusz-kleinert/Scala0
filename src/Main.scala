/**
 * Created by Mateusz Kleinert on 14.11.14.
 */

object Main extends App {
  val converter = new Converter()

  val testNumberRoman = 4999
  val resultRoman = converter.toRomanString(testNumberRoman)
  println("Number " + testNumberRoman + " converted to Roman string is: " + resultRoman)

  val testNumberGreek = 2010
  val resultGreek = converter.toGreekString(testNumberGreek)
  println("Number " + testNumberGreek + " converted to Greek string is: " + resultGreek)
}
