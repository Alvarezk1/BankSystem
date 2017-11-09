import org.scalatest._

class DecimalCheckTesting extends FlatSpec with Matchers {
	"DecimalCheck" should "allow user to enter an amount with no decimal places" in {
		AccountFunctions.decimalCheck(35) should equal (true)
	}

	it should "allow user to enter an amount with one decimal place" in {
  	AccountFunctions.decimalCheck(10.2) shouldEqual (true)
  	}

  	it should "allow user to enter an amount with two decimal places" in {
  	AccountFunctions.decimalCheck(78.25) shouldEqual (true)
  	}

  	it should "not allow user to enter an amount with three or more decimal places" in {
  	AccountFunctions.decimalCheck(64.7685) shouldEqual (false)
  	}
}
