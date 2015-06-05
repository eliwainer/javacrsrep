package com.myorg.javacourse.exception;

import org.algo.exception.PortfolioException;

public class StockNotExistException extends PortfolioException
{
	public StockNotExistException(String msg)
	{
		super(msg);
	}
}
