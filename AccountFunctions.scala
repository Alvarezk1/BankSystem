import scala.io.StdIn._
import scala.math._
import java.text._ 

object AccountFunctions{
		
	var balance: Double = 50.00
	val currency = NumberFormat.getCurrencyInstance								 

	def deposit(amount: Double): Boolean = {           							
			if (amount > 0){													
				balance = balance + amount										
				true
			} else 
				false
	}

	def withdraw(amount: Double): Boolean = {          							
		if (amount > 0 && amount < balance){														
			balance = balance - amount											
			true	
		}
		else {
			println("Transaction cancelled due to insufficient funds")
			false
		}
	}

	def decimalCheck(amount: Double): Boolean = {
		var flag: Boolean = true
		var stringAmount: String = java.lang.Double.toString(Math.abs(amount))
		var decimalPosition: Int = stringAmount.indexOf('.')
		var numDecimalPlaces: Int = stringAmount.length - decimalPosition - 1  	

		if (numDecimalPlaces > 2) {
			flag = false
		}
		
		flag
	}
	
	def accountMenu(): Unit = {													 
		
		var userOption: String = " "
		var depositAmount: Double = 0.00
		var withdrawAmount: Double = 0.00
		var flag: Boolean = true


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
					flag = true	
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
					flag = true	
			}
			else if (userOption.equalsIgnoreCase("Balance"))
				println("Your Balance is " + currency.format(balance)) 

			else if (userOption.equalsIgnoreCase("Exit"))
				println("Have a nice day!")
			
			else
				println("ERROR Message: Please choose an option listed below.")

		} while (!userOption.equalsIgnoreCase("Exit")) 	
	}
}