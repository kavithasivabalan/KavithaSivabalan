package base;

import io.restassured.RestAssured;
import staticResource.GlOBAL_STATIC;
import excelUtility.ExcelTestDataUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public void testSetup() throws IOException {
        FileInputStream  propertyFile = new FileInputStream("config/conig.properties");
        GlOBAL_STATIC.prop = new Properties();
        GlOBAL_STATIC.testData = new ExcelTestDataUtility("src/test/java/testData/clientdetails.xlsx");
        GlOBAL_STATIC.prop.load(propertyFile);
        RestAssured.baseURI= GlOBAL_STATIC.prop.getProperty("baseURI");
        GlOBAL_STATIC.bearerToken = GlOBAL_STATIC.prop.getProperty("bearerToken");
    }

}
