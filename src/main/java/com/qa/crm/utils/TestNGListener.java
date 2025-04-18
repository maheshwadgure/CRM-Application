package com.qa.crm.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//ITestListener.super.onTestFailure(result);
		System.out.println("Test Case is Failed and result is"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test case is Skipped and result is "+result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		//ITestListener.super.onTestStart(result);
		System.out.println("Test case is started and details is "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//ITestListener.super.onTestSuccess(result);
		System.out.println("Test case is sucessful and the result is"+result.getName());
	}

}
