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
	String Username = eu.ReadData("sheet1", 3, 1);
	String password = eu.ReadData("sheet1", 3, 2);
	LoginFeatures lf=new LoginFeatures(driver);
	lf.Login(Username, password);
	String CustomerName = eu.ReadData("sheet1", 3, 3);
	System.out.println(CustomerName);
	tf=new TaskFeatures(driver);
	tf.CreateCustomer(CustomerName);
	tf.ValidateCreatenewCust(CustomerName);
	tf.logout();
   }
	 
        @Test(priority=2)
        public void CreateProject() 
	  { 
	  eu=new ExcelUtilities("./TestData/testdata.xlsx");
	  String Username =eu.ReadData("sheet1", 5, 1); 
	  String password = eu.ReadData("sheet1", 5, 2);
	  LoginFeatures lf=new LoginFeatures(driver); 
	  lf.Login(Username, password);
	  String CustomerName = eu.ReadData("sheet1", 5, 3); 
	  String Projectname =eu.ReadData("sheet1", 5, 4);
	  tf=new TaskFeatures(driver); 
	  tf.CreateProject(CustomerName, Projectname);
	  tf.ValidateProject(Projectname); 
	  tf.logout(); 
	  }
	//@Test(enabled=false)
	 @Test(dependsOnMethods = {"DeleteTask"})
	  public void DeleteCust() 
	  { 
	  eu=new ExcelUtilities("./TestData/testdata.xlsx"); 
	  String Username =eu.ReadData("sheet1", 4, 1); 
	  String password = eu.ReadData("sheet1", 4, 2);
	  LoginFeatures lf=new LoginFeatures(driver); 
	  lf.Login(Username, password);
	  tf=new TaskFeatures(driver); 
	  String CustomerName=eu.ReadData("sheet1", 4, 3);
	  tf.CheckDelcustfunc(CustomerName);
	  tf.VerifyCheckDelcust();
	  tf.logout(); 
	  } 	
	  @Test(priority=3)
	 public void CreateTask()
	 {   
		 eu=new ExcelUtilities("./TestData/testdata.xlsx");
		  String Username =eu.ReadData("sheet1", 6, 1); 
		  String password = eu.ReadData("sheet1", 6, 2);
		  LoginFeatures lf=new LoginFeatures(driver); 
		  lf.Login(Username, password);
		  tf=new TaskFeatures(driver);
		  String CustomerName = eu.ReadData("sheet1", 6, 3); 
		  String Projectname =eu.ReadData("sheet1", 6, 4);
		 String TaskName=eu.ReadData("sheet1", 6, 5);
		 tf.CreateNewTask(CustomerName, Projectname, TaskName);
		 tf.ValidateCreateNewTask(CustomerName, Projectname, TaskName);
		 tf.logout(); 
	 }
	  @Test(dependsOnMethods = {"CreateTask"})
	  public void DeleteTask() 
	  {
		  eu=new ExcelUtilities("./TestData/testdata.xlsx");
		  String Username =eu.ReadData("sheet1", 7, 1); 
		  String password = eu.ReadData("sheet1", 7, 2);
		  LoginFeatures lf=new LoginFeatures(driver); 
		  lf.Login(Username, password);
		  tf=new TaskFeatures(driver);
		  String CustomerName = eu.ReadData("sheet1", 7, 3); 
		  String Projectname =eu.ReadData("sheet1", 7, 4);
		  String TaskName=eu.ReadData("sheet1", 7, 5);  
		  tf.DelTask(CustomerName, Projectname, TaskName);
		  tf.VerifyDelTask();
		  tf.logout();
	  }
}
