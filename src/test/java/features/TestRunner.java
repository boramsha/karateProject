package features;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import cucumber.api.CucumberOptions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;

import com.intuit.karate.junit5.Karate;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.*;


//@RunWith(Karate.class)
//@CucumberOptions(
//    features = {"src\\test\\java\\features"},
//      // glue = {"stepdefs"},
//      plugin = {"json:target/cucumber.json"})
//      
@TestMethodOrder(OrderAnnotation.class)

public class TestRunner {


	@Test
	@Order(1)
 void CreateAccount() {
        Results results = Runner.path("classpath:features\\POST_CreateAccount.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	
	@Test
	@Order(2)
 void AccessToken() {
        Results results = Runner.path("classpath:features\\AccessToken.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	@Test
	@Order(3)
 void CreateAddress() {
        Results results = Runner.path("classpath:features\\POST_CreateAddress.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	@Test
	@Order(4)
 void RetriveAccount() {
        Results results = Runner.path("classpath:features\\GET_RetriveAccount.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	@Test
	@Order(5)
 void ListAllAddress() {
        Results results = Runner.path("classpath:features\\GET_ListAllAddress.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	@Test
	@Order(6)
 void CreateCart() {
        Results results = Runner.path("classpath:features\\POST_CreateCart.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	@Test
	@Order(7)
 void AddItemToCart() {
        Results results = Runner.path("classpath:features\\POST_AddItemToCart.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	
	@Test
	@Order(8)
 void RetriveCart() {
        Results results = Runner.path("classpath:features\\GET_RetriveCart.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	
	@Test
	@Order(9)
 void DELETE_DeleteCart() {
        Results results = Runner.path("classpath:features\\DELETE_DeleteCart.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	@Test
	@Order(10)
 void RemoveAddress() {
        Results results = Runner.path("classpath:features\\DELETE_RemoveAddress.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	@Test
	@Order(11)
 void UpdateAccount() {
        Results results = Runner.path("classpath:features\\PATCH_UpdateAccount.feature").parallel(0);
       generateReport(results.getReportDir());
        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }
	
	
	public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "SpreeCommerce");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

//	@Test
//	@Order(1)
// void Parallel() {
//        Results results = Runner.path("classpath:features").parallel(2);
//       generateReport(results.getReportDir());
//        //assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
//        assertEquals(0,results.getFailCount(),results.getErrorMessages());
//    }
	
	
//@Order(1)	
//@Karate.Test
//
//	Karate AccessToken() 
//	{
//		return Karate.run("AccessToken").relativeTo(getClass());
//	}
///*****************************************************************************/
//@Order(2)	
//@Karate.Test
//Karate CreateAccount() 
//{
//	return Karate.run("POST_CreateAccount").relativeTo(getClass());
//}
//
///*****************************************************************************/
//@Order(3)		
//@Karate.Test
//Karate RetriveAccount() 
//{
//	return Karate.run("GET_RetriveAccount").relativeTo(getClass());
//}
//
///*****************************************************************************/
//
//@Order(4)
//@Karate.Test
//Karate CreateAddress() 
//{
//	return Karate.run("POST_CreateAddress").relativeTo(getClass());
//}
//
///*****************************************************************************/
//@Order(5)
//@Karate.Test
//Karate ListAllAddress() 
//{
//	return Karate.run("GET_ListAllAddress").relativeTo(getClass());
//}
//
///*****************************************************************************/
//@Order(6)
//@Karate.Test
//Karate RemoveAddress() 
//{
//	return Karate.run("DELETE_RemoveAddress").relativeTo(getClass());
//}
//
///*****************************************************************************/
//@Order(7)
//@Karate.Test
//Karate CreateCart() 
//{
//	return Karate.run("POST_CreateCart").relativeTo(getClass());
//}
//
///*****************************************************************************/
//@Order(8)
//@Karate.Test
//Karate AddItemToCart() 
//{
//	return Karate.run("POST_AddItemToCart").relativeTo(getClass());
//}
///*****************************************************************************/
//
//@Order(9)
//@Karate.Test
//Karate RetriveCart() 
//{
//	return Karate.run("GET_RetriveCart").relativeTo(getClass());
//}
///*****************************************************************************/
//@Order(10)
//@Karate.Test
//Karate DeleteCart() 
//{
//	return Karate.run("DELETE_DeleteCart").relativeTo(getClass());
//}
//
///*****************************************************************************/
//@Order(11)
//@Karate.Test
//Karate UpdateAccount() 
//{
//	return Karate.run("PATCH_UpdateAccount").relativeTo(getClass());
//}		
//	
	
}
