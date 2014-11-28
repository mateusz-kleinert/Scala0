/**
 * Created by Mateusz Kleinert on 14.11.14.
 */

import util.control.Breaks._

class Converter {
  val romanNumeral = Map[Int, String](1 -> "I", 4 -> "IV", 5 -> "V", 9 -> "IX", 10 -> "X", 40 -> "XL", 50 -> "L", 90 -> "XC", 100 -> "C", 400 -> "CD", 500 -> "D", 900 -> "CM", 1000 -> "M")
  val greekNumeral = Map[Int, String](1 -> "α", 2 -> "β", 3 -> "γ", 4 -> "δ", 5 -> "ε", 6 -> "ϝ", 7 -> "ζ", 8 -> "η", 9 -> "θ", 10 -> "ι", 20 -> "κ", 30 -> "λ", 40 -> "μ", 50 -> "ν", 60 -> "ξ", 70 -> "ο", 80 -> "π", 90 -> "ϟ", 100 -> "ρ", 200 -> "σ", 300 -> "τ", 400 -> "υ", 500 -> "φ", 600 -> "χ", 700 -> "ψ", 800 -> "ω", 900 -> "ϡ")
  val greekLowerNumeralSign = "͵"
  val greekUpperNumeralSign = "ʹ"

  def toRomanString(number: Int): String = {

    if (number > 4999) {
      return "Please enter number in range 1 - 4999."
    }

    var romanString = ""
    var subNumber = number

    while (subNumber > 0) {
      breakable {
        romanNumeral.toSeq.sortBy(_._1).reverse foreach {
          case (key, value) => {
            if (subNumber / key > 0) {
              romanString = romanString + value
              subNumber = subNumber - key
              break
            }
          }
        }
      }
    }

    return romanString
  }

  def toGreekString(number: Int): String = {

    if (number > 999999) {
      return "Please enter number in range 1 - 999999."
    }

    var greekString = ""
    var subNumber = number

    while (subNumber > 0) {
      breakable {
        greekNumeral.toSeq.sortBy(_._1).reverse foreach {
          case (key, value) => {
            if (subNumber / (key * 1000) > 0) {
              greekString = greekString + greekLowerNumeralSign + value
              subNumber = subNumber - (key * 1000)
              break
            }
          }
        }

        greekNumeral.toSeq.sortBy(_._1).reverse foreach {
          case (key, value) => {
            if (subNumber / key > 0) {
              greekString = greekString + value + greekUpperNumeralSign
              subNumber = subNumber - key
              break
            }
          }
        }
      }
    }

    return greekString
  }
}
