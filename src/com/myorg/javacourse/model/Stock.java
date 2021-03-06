package com.myorg.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.StockInterface;

import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

/**
Stock.java
Purpose: Represents a Stock (Interface)

@author Eli Wainer
@version 1.2 22/05/2015
*/
public class Stock implements StockInterface
{
	// ***************************************
	// Members Section
	// ***************************************
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	
	// ***************************************
	// C'tor/D'tor Section
	// ***************************************
	
	// public Stock() 
	// ==============
	// Empty Constructor
	public Stock() 
	{
	}
	
	// public Stock(String symbol, float ask, float bid, Date date, int stockQuantity)
	// ===============================================================================
	// Default Constructor
	public Stock(String symbol, float ask, float bid, Date date, int stockQuantity) 
	{
		super();
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
		this.stockQuantity = stockQuantity;
	}
	
	// public Stock(Stock stockToCopy) 
	// ===============================
	// Copy Constructor
	public Stock(Stock stockToCopy) 
	{
		this(new String(stockToCopy.getSymbol()), 
			 stockToCopy.getAsk(), 
			 stockToCopy.getBid(), 
			 new Date(stockToCopy.getDate().getTime()),
			 stockToCopy.getStockQuantity());
	}
	
	// ***************************************
	// Access Methods Section
	// ***************************************

	// public String getSymbol() 
	// =========================
	// Get the Stock's Symbol
	public String getSymbol()
	{
		return symbol;
	}
	
	// public void setSymbol(String symbol)
	// ====================================
	// Set the Stock's Symbol
	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}
	
	// public float getAsk()
	// =====================
	// Get the Stock's Ask price
	public float getAsk()
	{
		return ask;
	}
	
	// public void setAsk(float ask)
	// =============================
	// Set the Stock's Ask price
	public void setAsk(float ask)
	{
		this.ask = ask;
	}
	
	// public float getBid()
	// =====================
	// Get the Stock's Bid price
	public float getBid()
	{
		return bid;
	}
	
	// public void setBid(float bid)
	// =============================
	// Set the Stock's Bid price
	public void setBid(float bid)
	{
		this.bid = bid;
	}
	
	// public Date getDate()
	// =====================
	// Get the Stock's Date
	public Date getDate()
	{
		return date;
	}
	
	// public void setDate(Date date)
	// ==============================
	// Set the Stock's Date
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	// public void setDate(long time) 
	// ==============================
	// Set the Stock's Date from Long
	public void setDate(long time) 
	{
		this.date = new Date(time);
	}
	
	// public int getStockQuantity()
	// =============================
	// Get the Stock's Quantity
	public int getStockQuantity()
	{
		return stockQuantity;
	}
	
	// public void setStockQuantity(int stockQuantity)
	// ===============================================
	// Set the Stock's Quantity
	public void setStockQuantity(int stockQuantity)
	{
		this.stockQuantity = stockQuantity;
	}
	
	// public Enum<ALGO_RECOMMENDATION> getRecommendation() 
	// ====================================================
	// Get the Stock's Recommendation
	public Enum<ALGO_RECOMMENDATION> getRecommendation() 
	{
		return this.recommendation;
	}
	
	// public void setRecommendation(ALGO_RECOMMENDATION valueOf) 
	// ==========================================================
	// Set the Stock's Recommendation
	public void setRecommendation(ALGO_RECOMMENDATION valueOf) 
	{
		this.recommendation = valueOf;
	}
	
	// ***************************************
	// Member Functions Section
	// ***************************************
	
	/**
	 * This method gets an HTML description of the Stock
	 *
	 * @return      the HTML description of the Stock
	 */
	public String getHtmlDescription()
	{
		// Format the Date object
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateToStr = simpleDateFormat.format(getDate());

		return(new String("<b>Stock Symbol: </b>" + getSymbol() +
						  " <b>Bid: </b>" + getBid() +
						  " <b>Ask: </b>" + getAsk() + 
						  " <b>Date: </b>" + dateToStr +
						  " <b>Quantity: </b>" + getStockQuantity()));
	}
}
