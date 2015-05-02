package com.myorg.javacourse.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;
import com.myorg.javacourse.service.PortfolioManager;

/**
PortfolioServlet.java
Purpose: Represents the Main Servlet for Portfolio actions

@author Eli Wainer
@version 1.1 02/05/2015
*/
@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		resp.setContentType("text/html");

		// SECTION A
		
		// Create a new Portfolio
		Portfolio testPortfolio1 = new Portfolio();
		testPortfolio1.setTitle("Portfolio #1");
		
		// Create instances of Date class
		Date date1 = new Date("11/15/2014");
		Date date2 = new Date("11/16/2014");
		Date date3 = new Date("11/17/2014");
		
		// Create instances of Stock class
		Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, date1);
		Stock stock2 = new Stock("AAL", (float)5.78, (float)5.5, date2);
		Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, date3);
		
		// Add the Stocks to the Portfolio
		testPortfolio1.addStock(stock1);
		testPortfolio1.addStock(stock2);
		testPortfolio1.addStock(stock3);
		
		// SECTION B
		Portfolio testPortfolio2 = new Portfolio(testPortfolio1);
		
		// SECTION C
		testPortfolio2.setTitle("Portfolio #2");
		
		// SECTION D + E + F
		resp.getWriter().println(testPortfolio1.getHtmlString());
		resp.getWriter().println(testPortfolio2.getHtmlString());
		
		resp.getWriter().println("-----------------------------------------------------------------------------------------------------");
		
		// SECTION G + H + I
		testPortfolio1.getStocks()[0] = testPortfolio1.getStocks()[1];
		testPortfolio1.getStocks()[1] = testPortfolio1.getStocks()[2];
		testPortfolio1.getStocks()[2] = null;
		testPortfolio1.setCurrPortfolioIndex(testPortfolio1.getCurrPortfolioIndex() - 1);
		resp.getWriter().println(testPortfolio1.getHtmlString());
		resp.getWriter().println(testPortfolio2.getHtmlString());
		
		resp.getWriter().println("-----------------------------------------------------------------------------------------------------");
		
		// SECTION J + K + I
		testPortfolio2.getStocks()[2].setBid((float)55.55);
		resp.getWriter().println(testPortfolio1.getHtmlString());
		resp.getWriter().println(testPortfolio2.getHtmlString());
	}
}