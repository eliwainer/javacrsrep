package com.myorg.javacourse.model;

/**
Portfolio.java
Purpose: Represents a Portfolio

@author Eli Wainer
@version 1.1 02/05/2015
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
	// Empty Constructor
	public Portfolio() 
	{
		super();
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		currPortfolioIndex = 0;
	}
	
	// public Portfolio(Portfolio portfolioToCopy)  
	// ===========================================
	// Copy Constructor
	public Portfolio(Portfolio portfolioToCopy) 
	{
		title = portfolioToCopy.getTitle();
		currPortfolioIndex = portfolioToCopy.getCurrPortfolioIndex();
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		
		// Go over the given Portfolio
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			// Deep Clone the current stock
			stocks[i] = new Stock(portfolioToCopy.getStocks()[i]);
		}
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
	
	// public void setTitle(String newTitle)
	// =====================================
	// Set the Title of the Portfolio
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	// public int getCurrPortfolioIndex()
	// ==================================
	// Return the current Portfolio index
	public int getCurrPortfolioIndex()
	{
		return currPortfolioIndex;
	}
	
	// public int setCurrPortfolioIndex()
	// ==================================
	// Set the current Portfolio index
	public void setCurrPortfolioIndex(int newIndex)
	{
		currPortfolioIndex = newIndex;
	}
	
	// ***************************************
	// Member Functions Section
	// ***************************************
	
	/**
	 * This method adds a new Stock to the Portfolio
	 *
	 * @param  stockToAdd	the Stock to be added
	 */
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

	/**
	 * This method gets an HTML description of the Portfolio
	 *
	 * @return      the HTML description of the Portfolio
	 */
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
