/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Martijn
 */
public class RequestModelTest {
    
    RequestModel testModel;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    public RequestModelTest() { }
    
    @Before
    public void setUp() throws Exception {
        Date fromDate = formatter.parse("2017-07-01");
        Date tillDate = formatter.parse("2017-07-14");       
      
        testModel = new RequestModel("Vakantie Cherso!", fromDate, tillDate);
    }
    
    @Test
    public void emptyConstructorTest() {
        RequestModel emptyModel = new RequestModel();
    }
    
    @Test 
    public void getStatusTest(){
        Assert.assertEquals(0, testModel.getStatus());
    }
    
    @Test
    public void setStatusTest(){
        testModel.setStatus(StatusEnum.APPROVED.ordinal());
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, testModel.getStatus());
    }
    
    @Test
    public void getAndSetRequestorTest() {
        LoginModel testLogin = new LoginModel();
        testLogin.setUserName("Jan Henk");
        testModel.setRequestor(testLogin);
        Assert.assertEquals("Jan Henk", testModel.getRequestor().getUserName());
    }
    
    @Test
    public void getReasonTest() {
        String expectedResult = "Vakantie Cherso!";
        String actualResult = testModel.getReason();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void setReasonTest() {
        testModel.setReason("Familiedag");
        String expectedResult = "Familiedag";
        String actualResult = testModel.getReason();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test    
    public void getStartDateTest() throws ParseException {
        Date expectedResult = formatter.parse("2017-07-01");
        Date actualResult = testModel.getStartDate();
        Assert.assertEquals(expectedResult, actualResult); 
    }

    @Test
    public void setStartDateTest() throws ParseException {
        Date expectedResult = formatter.parse("2020-05-27");
        testModel.setStartDate("2020-05-27");
        Date actualResult = testModel.getStartDate();
        Assert.assertEquals(expectedResult, actualResult); 
    }

    @Test
    public void getEndDateTest() throws ParseException {
        Date expectedResult = formatter.parse("2017-07-14");
        Date actualResult = testModel.getEndDate();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void setEndDateTest() throws ParseException {
        Date expectedResult = formatter.parse("2025-05-27");
        testModel.setEndDate("2025-05-27");
        Date actualResult = testModel.getEndDate();
        Assert.assertEquals(expectedResult, actualResult); 
    }
}
