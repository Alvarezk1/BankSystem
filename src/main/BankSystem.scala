import scala.io.StdIn._
import scala.math._
import java.text._ 

class Account(var customerName: String, var customerPassword: String ){
	
	var costumerName: String = _
	var costumerId: String = _
	private var balance: Double = 100.00										//Hard code balance (testing perposes)
	val currency = NumberFormat.getCurrencyInstance								//formatting double currency 

	def deposit(amount: Double): Boolean = {           							//Takes one perameter in which is the amount the user will be depositing
			if ( amount > 0){													//Don't do anything if the amount is 0 or less
				balance = balance + amount										//If not add the amount to the balance and update (increment balance with ammount)
				true
			} else 
				false
	}

	def withdraw(amount: Double): Boolean = {          			
		if (amount > 0 && amount < balance){									//Don't do anything if the amount is 0 or less and more than balance
			balance = balance - amount											
			true	
		}
		else {
			println("Transaction cancelled due to insufficient funds")
			false
		}
	}

	def decimalCheck(amount: Double): Boolean = {
		var flag: Boolean = true 												//Flag setter
		var stringAmount: String = java.lang.Double.toString(Math.abs(amount))	//Convert amount type to Dtring
		var decimalPosition: Int = stringAmount.indexOf('.')					//Calculate the position of decimal
		var numDecimalPlaces: Int = stringAmount.length - decimalPosition - 1  	//Calculate number of decimals, Subtract 1 at end b/c index starts at 0
																				
		if (numDecimalPlaces > 2){ 												//If more than two decimals set flag
			flag = false
		}
		return flag
	}
	
	def accountMenu(): Unit = {													 //UserOptions & interactions 
		
		var userOption: String = " "
		var depositAmount: Double = 0.00
		var withdrawAmount: Double = 0.00
		var flag: Boolean = true

		println("Welcome to your bank account " + customerName)

		do{
			print("Please enter in a command (Deposit, Withdraw, Balance, Exit):  ")
			userOption = readLine

			if(userOption.equalsIgnoreCase("Deposit")){
				do {
					print("Please enter an amount to deposit: ")
					depositAmount = readDouble
					if (depositAmount > 0 && decimalCheck(depositAmount)){
						deposit(depositAmount)
						flag = false
					} else 
						println("ERROR Message: Invalid amount")
				} while (flag) 
					flag = true														//Reset flag
			}
			else if (userOption.equalsIgnoreCase("Withdraw")){
				do {
					print("Please enter an amount to withdraw: ")
					withdrawAmount = readDouble
					if (withdrawAmount > 0 && decimalCheck(withdrawAmount)){
						withdraw(withdrawAmount)
						flag = false
					} else 
						println("ERROR Message: Invalid amount")
				} while (flag) 
					flag = true														//Reset flag
			}
			else if (userOption.equalsIgnoreCase("Balance")){
				println("Your Balance is " + currency.format(balance)) 				//Format balance to currency 

			} else if (userOption.equalsIgnoreCase("Exit"))
				println("Have a nice day!")

			else
				println("ERROR Message: Please choose an option listed below.")

		} while (!userOption.equalsIgnoreCase("Exit")) 	
	}
}


object BankSystem{
	def main(args: Array[String]){
		
		val customer1 = new Account("Kristen", "wit2017")							//Hard code user and password
		customer1.accountMenu														//Idealy login will be implemented 

	}
} 

