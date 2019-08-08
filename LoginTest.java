package com.actitime.scripts;
import org.testng.annotations.Test;
import com.actitime.features.LoginFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
public class LoginTest extends BaseLib  
{
	ExcelUtilities eu;
@Test(priority=1)
public void Validlogin()
{
	eu=new ExcelUtilities("./TestData/testdata.xlsx");
	String Username = eu.ReadData("sheet1", 1, 1);
	System.out.println(Username);
	String password = eu.ReadData("sheet1", 1, 2);
	System.out.println(password);
	LoginFeatures lf=new LoginFeatures(driver);
	lf.Login(Username, password);
	lf.VerifyValidLogin();
}
@Test(priority=2)
public void InvalidLogin()
{
	eu=new ExcelUtilities("./TestData/testdata.xlsx");
	String Username = eu.ReadData("sheet1", 2, 1);
	System.out.println(Username);
	String password = eu.ReadData("sheet1", 2, 2);
	System.out.println(password);
	LoginFeatures lf=new LoginFeatures(driver);
	lf.Login(Username, password);
}
}
