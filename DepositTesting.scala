import org.scalatest._

class DepositTesting extends FlatSpec with Matchers {
  
  "Deposit" should "allow user to complete transaction" in {
    AccountFunctions.deposit(20) shouldEqual (true)
  }

  it should "not let user deposit zero dollars" in {
  	AccountFunctions.deposit(0) shouldEqual (false)
  }

  it should "not let user deposit a negative amount of money" in {
   	AccountFunctions.deposit(-5) shouldEqual (false)
   }

   it should "let user deposit amount with one decimal palce" in {
  	AccountFunctions.deposit(1.2) shouldEqual (true)
  }

  it should "let user deposit amount with two decimal palces" in {
  	AccountFunctions.deposit(17.38) shouldEqual (true)
  }

}