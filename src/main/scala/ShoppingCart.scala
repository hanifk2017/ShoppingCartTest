class ShoppingCart {

  val stockItems = Map("apple" -> BigDecimal(0.60), "orange" -> BigDecimal(0.25)).withDefaultValue(BigDecimal(0.0))

  def computeTotal(cartItems: Seq[String]): BigDecimal = {

    cartItems.map(_.toLowerCase).map(stockItems).sum

  }

}
