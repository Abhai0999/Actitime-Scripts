package com.actitime.scripts;
import org.testng.annotations.Test;
import com.actitime.features.LoginFeatures;
import com.actitime.features.TaskFeatures;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.EnterTimeTrackpage;
public class TaskTest extends BaseLib
{
   ExcelUtilities eu;
   TaskFeatures tf;
@Test(priority=1)
public void CreateCustomer()
{
    eu=new ExcelUtilities("./TestData/testdata.xlsx");
	String Username = eu.ReadData("sheet1", 1, 1);
	String password = eu.ReadData("sheet1", 1, 2);
	LoginFeatures lf=new LoginFeatures(driver);
	lf.Login(Username, password);
	String CustomerName = eu.ReadData("sheet1", 3, 3);
	System.out.println(CustomerName);
	tf=new TaskFeatures(driver);
	tf.CreateCustomer(CustomerName);
	tf.ValidateCreatenewCust(CustomerName);
	tf.logout();
}
	  @Test(priority=2) public void CreateProject() 
	  { 
	  eu=new ExcelUtilities("./TestData/testdata.xlsx");
	  String Username =eu.ReadData("sheet1", 1, 1); 
	  String password = eu.ReadData("sheet1", 1, 2);
	  LoginFeatures lf=new LoginFeatures(driver); 
	  lf.Login(Username, password);
	  String CustomerName = eu.ReadData("sheet1", 5, 3); 
	  String Projectname =eu.ReadData("sheet1", 5, 4);
	  System.out.println(CustomerName);
	  tf=new TaskFeatures(driver); 
	  tf.CreateProject(CustomerName, Projectname);
	  tf.ValidateProject(Projectname); tf.logout(); 
	  }
	
	  @Test(priority=3) 
	  public void DeleteCust() 
	  { eu=new
	  ExcelUtilities("./TestData/testdata.xlsx"); 
	  String Username =eu.ReadData("sheet1", 1, 1); 
	  String password = eu.ReadData("sheet1", 1, 2);
	  LoginFeatures lf=new LoginFeatures(driver);
	  lf.Login(Username, password);
	  tf=new TaskFeatures(driver); 
	  tf.CheckDelcustfunc();
	  tf.VerifyCheckDelcust();
	  tf.logout(); }
	 	
}
