package com.myorg.javacourse.model;
import com.myorg.javacourse.Stock;

/**
Portfolio.java
Purpose: Represents a Portfolio

@author Eli Wainer
@version 1.0 01/05/2015
*/
public class Portfolio 
{
	// ***************************************
	// Members Section
	// ***************************************
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int currPortfolioIndex;
	
	// ***************************************
	// C'tor/D'tor Section
	// ***************************************
	
	// public Portfolio() 
	// ==================
	// Constructor
	public Portfolio(String newTitle) 
	{
		super();
		title = newTitle;
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		currPortfolioIndex = 0;
	}
	
	// ***************************************
	// Access Methods Section
	// ***************************************
	
	// public Stock[] getStocks() 
	// ==========================
	// Return the Stocks array
	public Stock[] getStocks() 
	{
		return stocks;
	}
	
	// public String getTitle()
	// ========================
	// Return the Portfolio title
	public String getTitle()
	{
		return title;
	}
	
	// ***************************************
	// Member Functions Section
	// ***************************************
	
	// public void addStock(Stock stockToAdd)
	// ======================================
	// Add a new Stock to the Portfolio
	public void addStock(Stock stockToAdd)
	{
		// If Stock is valid and Portfolio is not full
		if((stockToAdd != null) && (currPortfolioIndex < MAX_PORTFOLIO_SIZE))
		{
			// Add Stock to Portfolio
			stocks[currPortfolioIndex] = stockToAdd;
			
			// Update Portfolio size
			currPortfolioIndex++;
		}
		
		// If Stock is not valid or Portfolio is full
		else
		{
			System.out.println("Stock is not valid or Portfolio is full");
		}
	}

	// public String getHtmlString()
	// =============================
	// Get an HTML string of the Portfolio
	public String getHtmlString()
	{
		// Add Portfolio's title
		String retStr = new String("<h1>" + getTitle() + "</h1>");
		
		// Go over the Portfolio
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			// Add current Stock's info
			retStr += stocks[i].getHtmlDescription() + "<br>";
		}
		
		return(retStr);
	}
}
