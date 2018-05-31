class ShoppingCart {

  val stockItems = Map("apple" -> BigDecimal(0.60), "orange" -> BigDecimal(0.25)).withDefaultValue(BigDecimal(0.0))

  def computeTotal(cartItems: Seq[String]): BigDecimal = {

    cartItems.map(_.toLowerCase).map(stockItems).sum

  }

  def computeTotalWithDiscounts(cartItems: Seq[String]): BigDecimal = {

    // could possibly be simplified to a one liner with filter, zipWithIndex and modulus

    // apple offer - buy 1 get 1 free

    val noOfApples: Int = cartItems.map(_.toLowerCase).count(_ == "apple")

    val effectiveNoOfApples: Int = noOfApples - noOfApples / 2

    // orange offer - buy 3 for the price of 2

    val noOfOranges: Int = cartItems.map(_.toLowerCase).count(_ == "orange")

    val effectiveNoOfOranges: Int = noOfOranges - noOfOranges / 3

    effectiveNoOfApples * stockItems("apple") + effectiveNoOfOranges * stockItems("orange")

  }

}
