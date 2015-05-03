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
		Portfolio portfolio = new Portfolio();
		portfolio.setTitle("Portfolio #1");
		
		// Create instances of Calendar class
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2014, 11, 15);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2014, 11, 16);
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(2014, 11, 17);
		
		// Create instances of Stock class
		Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, calendar1.getTime());
		Stock stock2 = new Stock("AAL", (float)5.78, (float)5.5, calendar2.getTime());
		Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, calendar3.getTime());
		
		// Add the Stocks to the Portfolio
		portfolio.addStock(stock1);
		portfolio.addStock(stock2);
		portfolio.addStock(stock3);
		
		// Return the Portfolio
		return(portfolio);
	}
}
