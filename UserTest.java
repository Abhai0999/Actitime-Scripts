package com.actitime.scripts;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.actitime.features.LoginFeatures;
import com.actitime.features.UserFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.EnterTimeTrackpage;

public class UserTest extends BaseLib 
{
	ExcelUtilities eu;
	UserFeatures uf;
	@Test(priority=1)
	public void CreateUser()
	{
		eu=new ExcelUtilities("./TestData/testdata.xlsx");
		String Username = eu.ReadData("sheet1", 8, 1);
		String password = eu.ReadData("sheet1", 8, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.Login(Username, password);
		uf=new UserFeatures(driver);
		String UserName = eu.ReadData("sheet1", 8, 3);
		String PassNrePass = eu.ReadData("sheet1", 8, 4);
		String FrstName = eu.ReadData("sheet1", 8, 5);
		String LstName = eu.ReadData("sheet1", 8, 6);
		String Email = eu.ReadData("sheet1", 8, 7);
		uf.CreateNewUser(UserName, PassNrePass, FrstName, LstName, Email);
		uf.VerifyCreateNewUser();
		uf.logout();
	}
	
	@Test(dependsOnMethods = {"NewUserLogin"})
	public void DelUser() throws InterruptedException
	{
		eu=new ExcelUtilities("./TestData/testdata.xlsx");
		String Username = eu.ReadData("sheet1", 10, 1);
		String password = eu.ReadData("sheet1", 10, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.Login(Username, password);
		uf=new UserFeatures(driver);
		uf.DeleteUser();
		Thread.sleep(3000);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		Thread.sleep(3000);
		uf.VerifyDeleteUser();
		uf.logout();
		
	}
	@Test(priority=2)
	public void NewUserLogin()
	{
		eu=new ExcelUtilities("./TestData/testdata.xlsx");
		String Username = eu.ReadData("sheet1", 9, 1);
		String password = eu.ReadData("sheet1", 9, 2);
		LoginFeatures lf=new LoginFeatures(driver);
		lf.Login(Username, password);
		lf.VerifyValidLogin();
	}
}
