package com.myorg.javacourse.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.algo.service.ServiceManager;

import com.myorg.javacourse.service.PortfolioManager;

/**
InitServlet.java
Purpose: Represents the Main Servlet

@author Eli Wainer
@version 1.0 22/05/2015
*/
@SuppressWarnings("serial")
public class InitServlet extends HttpServlet
{
	@Override
	public void init() throws ServletException 
	{
		super.init();
		PortfolioManager pm = new PortfolioManager();
		ServiceManager.setPortfolioManager(pm);
	}
}
