package com.myorg.javacourse.service;
import java.util.Date;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;

/**
PortfolioManager.java
Purpose: Represents a Portfolio Manager

@author Eli Wainer
@version 1.0 01/05/2015
*/
public class PortfolioManager 
{
	// public Portfolio getPortfolio()
	// ===============================
	// Return the Portfolio
	public Portfolio getPortfolio()
	{
		// Create a new Portfolio
		Portfolio retPortfolio = new Portfolio("MyTestPortfolio");
		
		// Create instances of Date class
		Date date1 = new Date("11/15/2014");
		Date date2 = new Date("11/16/2014");
		Date date3 = new Date("11/17/2014");
		
		// Create instances of Stock class
		Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, date1);
		Stock stock2 = new Stock("AAL", (float)5.78, (float)5.5, date2);
		Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, date3);
		
		// Add the Stocks to the Portfolio
		retPortfolio.addStock(stock1);
		retPortfolio.addStock(stock2);
		retPortfolio.addStock(stock3);
		
		// Return the created Portfolio
		return(retPortfolio);
	}
}
