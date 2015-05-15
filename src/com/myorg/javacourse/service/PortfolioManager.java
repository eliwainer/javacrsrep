package com.myorg.javacourse.service;
import java.util.Calendar;
import java.util.Date;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

/**
PortfolioManager.java
Purpose: Represents a Portfolio Manager

@author Eli Wainer
@version 1.1 02/05/2015
*/
public class PortfolioManager 
{
	// public Portfolio getPortfolio()
	// ===============================
	// Return the Portfolio
	public Portfolio getPortfolio()
	{
		// Create a new Portfolio
		Portfolio myPortfolio = new Portfolio();
		myPortfolio.setTitle("Exercise 7 Portfolio");
		myPortfolio.updateBalance(10000);
		
		// Create instances of Calendar class
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2014, 12, 15);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2014, 12, 15);
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(2014, 12, 15);
		
		// Create instances of Stock class
		Stock stock1 = new Stock("PIH", (float)10, (float)8.5, calendar1.getTime(), 0);
		Stock stock2 = new Stock("AAL", (float)30, (float)25.5, calendar2.getTime(), 0);
		Stock stock3 = new Stock("CAAS", (float)20, (float)15.5, calendar3.getTime(), 0);
		
		// Buy the Stocks to the Portfolio
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		// Sell all of AAL Stock
		myPortfolio.sellStock("AAL", -1);
		
		// Remove CAAS Stock
		myPortfolio.removeStock("CAAS");
		
		// Return the Portfolio
		return(myPortfolio);
	}
}
