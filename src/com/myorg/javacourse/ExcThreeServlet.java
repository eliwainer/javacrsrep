package com.myorg.javacourse;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ExcThreeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		// Calculate Circle Area
		int circleRadius = 50;
		double circleArea = Math.PI * Math.pow(circleRadius, 2);
		String line1 = new String("Calculation 1: Area of circle with radius " + circleRadius + " cm is: " + circleArea + " square-cm");
		
		// Convert given Degrees to Radians and calculate the Opposite
		double angleB = Math.toRadians(30);
		int hypotenuseLen = 50;
		double oppositeLen = Math.sin(angleB) * hypotenuseLen;
		String line2 = new String("Length of Opposite where angle B is 30 degrees and hypotenuse length is 50 cm is: " + oppositeLen + " cm");
		
		// Power calculation
		double powResult = Math.pow(20, 13);
		String line3 = new String("Power of 20 with exp of 13 is: " + powResult + " cm");
		
		// Final result presentation
		String resultStr = new String("<h1>" + line1 + "<br>" + line2 + "<br>" + line3 + "</h1>");
		resp.setContentType("text/html");
		resp.getWriter().println(resultStr);
	}
}