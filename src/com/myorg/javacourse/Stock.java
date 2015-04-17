package com.myorg.javacourse;

import java.util.Date;

/**
Stock.java
Purpose: Represents a Stock

@author Eli Wainer
@version 1.0 17/04/2015
*/
public class Stock 
{
	// ***************************************
	// Members Section
	// ***************************************
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	// ***************************************
	// C'tor/D'tor Section
	// ***************************************
	
	// public Stock(String symbol, float ask, float bid, Date date) 
	// ============================================================
	// Constructor
	public Stock(String symbol, float ask, float bid, Date date) 
	{
		super();
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
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
	
	// ***************************************
	// Member Functions Section
	// ***************************************
	
	// public String getHtmlDescription()
	// ==================================
	// Get an HTML description of the Stock
	public String getHtmlDescription()
	{
		return(new String("<b>Stock Symbol: </b>" + getSymbol() +
						  " <b>Bid: </b>" + getBid() +
						  " <b>Ask: </b>" + getAsk() + 
						  " <b>Date: </b>" + getDate()));
	}
}
