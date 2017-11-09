import org.scalatest._

class WithdrawTesting extends FlatSpec with Matchers {
  
  "Withdraw" should "allow user to complete transaction" in {
    AccountFunctions.withdraw(20) shouldEqual (true)
  }
	it should "let user withdraw amount with one decimal palce" in {
  	AccountFunctions.withdraw(1.2) shouldEqual (true)
  }

  it should "let user withdraw amount with two decimal palces" in {
  	AccountFunctions.withdraw(17.38) shouldEqual (true)
  }

  it should "not let user withdraw zero dollars" in {
  	AccountFunctions.withdraw(0) shouldEqual (false)
  }
  
  it should "not let user withdraw more than the balance in account" in {
  	AccountFunctions.withdraw(200) shouldEqual (false)
  }

  it should "not let user withdraw a negative amount of money" in {
   	AccountFunctions.withdraw(-5) shouldEqual (false)
   }
   
}