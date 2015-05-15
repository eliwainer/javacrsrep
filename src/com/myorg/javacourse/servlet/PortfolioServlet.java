package com.myorg.javacourse.servlet;

import java.io.IOException;
import java.util.Calendar;
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
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio testPortfolio1 = portfolioManager.getPortfolio();
		resp.getWriter().println(testPortfolio1.getHtmlString());
	}
}