package com.myorg.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class StockMarketServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		// Variable declaration
		int num1;
		int num2;
		int num3;
		
		// Variable assignment
		num1 = 4;
		num2 = 3;
		num3 = 7;
		
		// Perform calculation and prepare result string
		int result = (num1 + num2) * num3;
		String resultStr = new String("<h1>Result of (" + num1 + "+" + num2 + ")*" + num3 + "=" + result + "</h1>");
		
		resp.setContentType("text/html");
		resp.getWriter().println(resultStr);
	}
}
