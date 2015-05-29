package com.myorg.javacourse.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

/**
Portfolio.java
Purpose: Represents a Portfolio (Interface)

@author Eli Wainer
@version 1.2 22/05/2015
*/
public class Portfolio implements PortfolioInterface
{
	private final static int MAX_PORTFOLIO_SIZE = 5;
	public enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	
	// ***************************************
	// Members Section
	// ***************************************
	private String title;
	private StockInterface[] stocks;
	private int currPortfolioIndex;
	private float balance;
	
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
		balance = 0;
	}
	
	// public Portfolio(Stock[] stockArray) 
	// ====================================
	// Constructor from Array of Stocks
	public Portfolio(Stock[] stockArray) 
	{
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		currPortfolioIndex = 0;
		balance = 0;
		
		// Go over the given Array
		for(int i = 0; i < stockArray.length; i++)
		{
			// Add the Stock
			stocks[i] = stockArray[i];
			currPortfolioIndex++;
		}
	}
	
	// public Portfolio(Portfolio portfolioToCopy)  
	// ===========================================
	// Copy Constructor
	public Portfolio(Portfolio portfolioToCopy) 
	{
		title = portfolioToCopy.getTitle();
		currPortfolioIndex = portfolioToCopy.getCurrPortfolioIndex();
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		balance = portfolioToCopy.getBalance();
		
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
		return (Stock[]) stocks;
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
	
	// public float getBalance()
	// =========================
	// Return the Portfolio Balance
	public float getBalance()
	{
		return balance;
	}
	
	// public static int getMaxSize() 
	// ==============================
	// Return the Max Size of the Portfolio
	public static int getMaxSize() 
	{
		return MAX_PORTFOLIO_SIZE;
	}
	
	// public float getStocksValue()
	// =============================
	// Return the Total value of all Stocks
	public float getStocksValue()
	{
		float totalValue = 0;
		
		// Go over the Portfolio
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			// Calculate the value of each Stock, and sum to Total
			totalValue += ((Stock) stocks[i]).getStockQuantity() * stocks[i].getBid();
		}
		
		return (totalValue);
	}
	
	// public float getTotalValue()
	// ============================
	// Return the sum of all Stocks and Portfolio's Balance
	public float getTotalValue()
	{
		return (getStocksValue() + getBalance());
	}
	
	// ***************************************
	// Member Functions Section
	// ***************************************
	
	/**
	 * This method checks if the given Stock is in the Portfolio
	 *
	 * @param  symbolToFind		the symbol of the Stock to be checked
	 * @return      			Stock's index if found, -1 if not
	 */
	public int isStockInPortfolio(String symbolToFind)
	{
		// Go over the Portfolio
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			// If the current Stock matches the searched one
			if (stocks[i].getSymbol().equals(symbolToFind))
			{
				// Return found Stock's index
				return(i);
			}
		}
		
		// Return Stock not found
		return(-1);
	}
	
	/**
	 * This method finds the given Stock in the Portfolio
	 *
	 * @param  symbol		the symbol of the Stock to be found
	 * @return      		the Stock if found, NULL if not
	 */
	public Stock findStock(String symbol) 
	{
		// Go over the Portfolio
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			// If the current Stock matches the searched one
			if (stocks[i].getSymbol().equals(symbol))
			{
				// Return found Stock
				return (Stock) (stocks[i]);
			}
		}
		
		// Return Stock not found
		return(null);
	}
	
	/**
	 * This method adds a new Stock to the Portfolio
	 *
	 * @param  stockToAdd	the Stock to be added
	 */
	public void addStock(Stock stockToAdd)
	{
		// If Stock is not valid
		if(stockToAdd == null)
		{
			System.out.println("Stock is not valid!");
		}
		
		// If Portfolio is full
		else if (currPortfolioIndex >= MAX_PORTFOLIO_SIZE)
		{
			System.out.println("Can't add new Stock, portfolio can have only " + MAX_PORTFOLIO_SIZE + " stocks");
		}
		
		// If Stock is valid, Portfolio is not full and Stock doesn't already exists
		else if(isStockInPortfolio(stockToAdd.getSymbol()) == -1)
		{
			// Add Stock to Portfolio
			stocks[currPortfolioIndex] = stockToAdd;
			
			// Set added Stock quantity to 0
			((Stock) stocks[currPortfolioIndex]).setStockQuantity(0);
			
			// Update Portfolio size
			currPortfolioIndex++;
		}
	}
	
	/**
	 * This method Sells and Removes a Stock from the Portfolio
	 *
	 * @param  symbolToRemove	the symbol of the Stock to be removed
	 * @return      			True if Stock was Sold and Removed, False if not
	 */
	public boolean removeStock(String symbolToRemove)
	{
		// Check if the Stock to remove is in the Portfolio
		int indexToRemove = isStockInPortfolio(symbolToRemove);
		
		// If the Stock to remove is found in the Portfolio
		if(indexToRemove != -1)
		{
			// Sell all of the given stock
			// (No need to verify Sell operation, since the whole stock is beeing sold)
			sellStock(symbolToRemove, -1);
			
			// Go over the Portfolio
			for(int i = indexToRemove; i < currPortfolioIndex - 1; i++)
			{
				// Shift one Stock left at a time
				stocks[i] = stocks[i + 1];
			}
			
			// Remove last empty space
			stocks[currPortfolioIndex - 1] = null;
			
			// Update Portfolio size
			currPortfolioIndex--;
			
			// Stock successfully Sold and Removed
			return (true);
		}
		
		// If the Stock to remove is not found in the Portfolio
		return (false);
	}
	
	/**
	 * This method Sells a Stock from the Portfolio
	 *
	 * @param  symbolToSell		the symbol of the Stock to be Sold
	 * @param  quantity			the number of this Stock to be Sold
	 * @return      			True if Stock was Sold, False if not
	 */
	public boolean sellStock(String symbolToSell, int quantity)
	{
		// Check if the Stock to Sell is in the Portfolio
		int indexToSell = isStockInPortfolio(symbolToSell);
		
		// If the Stock to Sell is not found in the Portfolio
		if(indexToSell == -1)
		{
			System.out.println("Given Stock is not found in the Portfolio!");
			return (false);
		}
		
		// If the Stock's to Sell quantity is bigger than availiable
		else if(quantity > ((Stock) stocks[indexToSell]).getStockQuantity())
		{
			System.out.println("Not enough Stocks to Sell!");
			return (false);
		}
		
		// If the Stock and the Quantity are valid
		else
		{
			// If received quantity to sell is ALL
			if (quantity == -1)
			{
				// Sell the whole Stock
				quantity = ((Stock) stocks[indexToSell]).getStockQuantity();
			}
			
			// Update the Sold Stock's quantity
			((Stock) stocks[indexToSell]).setStockQuantity(((Stock) stocks[indexToSell]).getStockQuantity() - quantity);
			
			// Update the Portfolio's Balance
			updateBalance(quantity * stocks[indexToSell].getBid());
			
			return (true);
		}
		
	}
	
	/**
	 * This method Buys a Stock
	 *
	 * @param  stockToBuy		the Stock to be Bought
	 * @param  quantity			the number of this Stock to be Bought
	 * @return      			True if Stock was Bought, False if not
	 */
	public boolean buyStock(Stock stockToBuy, int quantity)
	{
		// Check if the Stock to Buy is already in the Portfolio
		int indexToBuy = isStockInPortfolio(stockToBuy.getSymbol());
		float totalPurchaseSum = 0;
		
		// If the Stock to Buy is already in the Portfolio
		if(indexToBuy != -1)
		{
			// If received quantity to buy is ALL
			if(quantity == -1)
			{
				// Calculate how much can be Bought with the current Balance
				quantity = (int)(getBalance() / stocks[indexToBuy].getAsk());
			}
			
			// Calculate the Total Purchase Sum
			totalPurchaseSum = quantity * stocks[indexToBuy].getAsk();
			
			// If the Total Purchase Sum exceeds from the Portfolio Balance
			if(totalPurchaseSum > getBalance())
			{
				System.out.println("Not enough Balance to complete Purchase!");
				return (false);
			}
			
			// If the Total Purchase Sum is valid
			else
			{
				// Update the Bought Stock's quantity
				((Stock) stocks[indexToBuy]).setStockQuantity(((Stock) stocks[indexToBuy]).getStockQuantity() + quantity);
				
				// Update the Portfolio's Balance
				updateBalance((-1) * quantity * stocks[indexToBuy].getAsk());
				
				return (true);
			}
		}
		
		// If the Stock to Buy is not in the Portfolio
		else
		{
			// If received quantity to buy is ALL
			if(quantity == -1)
			{
				// Calculate how much can be Bought with the current Balance
				quantity = (int)(getBalance() / stockToBuy.getAsk());
			}
			
			// Calculate the Total Purchase Sum
			totalPurchaseSum = quantity * stockToBuy.getAsk();
			
			// If the Total Purchase Sum exceeds from the Portfolio Balance
			if(totalPurchaseSum > getBalance())
			{
				System.out.println("Not enough Balance to complete Purchase!");
				return (false);
			}
			
			// If the Total Purchase Sum is valid
			else
			{
				// Add the Bought Stock to the Portfolio
				addStock(stockToBuy);
				
				// Update the Bought Stock's quantity
				((Stock) stocks[currPortfolioIndex - 1]).setStockQuantity(quantity);
				
				// Update the Portfolio's Balance
				updateBalance((-1) * quantity * stockToBuy.getAsk());
				
				return (true);
			}
		}
	}
	
	/**
	 * This method updates the Balance of the Portfolio
	 *
	 * @param  amount	the Amount to be added
	 */
	public void updateBalance(float amount)
	{
		// If the adding of the Amount will bring a negative result
		if(balance + amount < 0)
		{
			System.out.println("Portfolio Balance cannot be negative!");
		}
		
		// If the adding of the Amount will not bring a negative result
		else
		{
			// Updatet the Balance
			balance += amount;
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
		String retStr = new String("<h1>Portfolio Title: " + getTitle() + "</h1>");
		retStr += "<b>Total Portfolio Value: </b>" + getTotalValue() + "$" +
				  " <b>Total Stocks Value: </b>" + getStocksValue() + "$" +
				  " <b>Balance: </b>" + getBalance() + "$<br>";
		retStr += "{<br>";
				
		// Go over the Portfolio
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			// Add current Stock's info
			retStr += "&nbsp;&nbsp;&nbsp;&nbsp;" + ((Stock) stocks[i]).getHtmlDescription() + "<br>";
		}
		retStr += "}";
		return(retStr);
	}
}
