import org.scalatest.{BeforeAndAfter, FunSuite}

class ShoppingCartTest extends FunSuite with BeforeAndAfter {

  var shoppingCart: ShoppingCart = _

  before {

    shoppingCart = new ShoppingCart

  }

  test("Null item list for computeTotal should return zero as total") {
    assert(shoppingCart.computeTotal(Nil) == 0.0)
  }

  test("Invalid item for computeTotal should be ignored") {
    assert(shoppingCart.computeTotal(Seq("Banana")) == 0.0)
  }

  test("1 apple for computeTotal should return 0.60 as total") {
    assert(shoppingCart.computeTotal(Seq("Apple")) == 0.60)
  }

  test("1 orange for computeTotal should return 0.25 as total") {
    assert(shoppingCart.computeTotal(Seq("Orange")) == 0.25)
  }

  test("Items in computeTotal should be case insensitive") {
    assert(shoppingCart.computeTotal(Seq("Apple", "APPLE", "apple")) == 1.80)
  }

  test("1 apple and 1 orange for computeTotal should return 0.85 as total") {
    assert(shoppingCart.computeTotal(Seq("Apple", "Orange")) == 0.85)
  }

  test("3 apples and 1 orange for computeTotal should return 2.05 as total") {
    assert(shoppingCart.computeTotal(Seq("Apple", "Apple", "Orange", "Apple")) == 2.05)
  }

  test("Null item list for computeTotalWithDiscounts should return zero as total") {
    assert(shoppingCart.computeTotalWithDiscounts(Nil) == 0.0)
  }

  test("1 apple and 1 orange for computeTotalWithDiscounts should return 0.85 as total") {
    assert(shoppingCart.computeTotalWithDiscounts(Seq("Apple", "Orange")) == 0.85)
  }

  test("2 apples and 3 oranges for computeTotalWithDiscounts should return 1.10 as total") {
    assert(shoppingCart.computeTotalWithDiscounts(Seq("Apple", "Apple", "Orange", "Orange", "Orange")) == 1.10)
  }

  test("5 apples and 5 oranges for computeTotalWithDiscounts should return 2.80 as total") {
    assert(shoppingCart.computeTotalWithDiscounts(Seq("Apple", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Orange")) == 2.80)
  }

}
