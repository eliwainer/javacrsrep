package com.myorg.javacourse;
import com.myorg.javacourse.Stock;

import java.util.Date;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		// Create instances of Date class
		Date date1 = new Date("11/15/2014");
		Date date2 = new Date("11/16/2014");
		Date date3 = new Date("11/17/2014");
		
		// Create instances of Stock class
		Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, date1);
		Stock stock2 = new Stock("AAL", (float)5.78, (float)5.5, date2);
		Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, date3);
		
		resp.setContentType("text/html");
		resp.getWriter().println(stock1.getHtmlDescription() + "<br>" +
								 stock2.getHtmlDescription() + "<br>" +
								 stock3.getHtmlDescription());
	}
}