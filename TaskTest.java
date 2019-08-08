package com.actitime.scripts;
import org.testng.annotations.Test;
import com.actitime.features.LoginFeatures;
import com.actitime.features.TaskFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.EnterTimeTrackpage;
public class TaskTest extends BaseLib
{
@Test
public void CreateCustomer()
{
	ExcelUtilities eu=new ExcelUtilities("./TestData/testdata.xlsx");
	String Username = eu.ReadData("sheet1", 1, 1);
	String password = eu.ReadData("sheet1", 1, 2);
	LoginFeatures lf=new LoginFeatures(driver);
	lf.Login(Username, password);
	String CustomerName = eu.ReadData("sheet1", 3, 3);
	System.out.println(CustomerName);
	TaskFeatures tf=new TaskFeatures(driver);
	tf.CreateCustomer(CustomerName);
	tf.logout();
}
}
