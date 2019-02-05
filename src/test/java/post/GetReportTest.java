package post;

import RestAssuredCore.BaseAssertion;
import RestAssuredCore.BaseTest;
import RestAssuredCore.RESTCalls;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utils.PayloadGenerator;
import utils.URL;

public class GetReportTest {
    private static Logger log = LogManager.getLogger(CreateIssueTest.class.getName());



    @Test
    public void getIssue(){
       // String sessionId = BaseTest.doLogin();
      //  String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/createmeta");
        Response response = RESTCalls.GETRequest(uri);
        BaseAssertion.verifyResponseHeader(response,"Cache-Control" ,"no-cache, no-store, no-transform");
        BaseAssertion.verifyStatusCode(response,200);
    }
    @Test
    public void getIssue2(){
        // String sessionId = BaseTest.doLogin();
        //  String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/createmeta");
        Response response = RESTCalls.GETRequest(uri);
        BaseAssertion.verifyResponseHeader(response,"Vary" ,"User-Agent");
        BaseAssertion.verifyStatusCode(response,200);
    }
    @Test
    public void getIssue3(){
        // String sessionId = BaseTest.doLogin();
        //  String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/createmeta");
        Response response = RESTCalls.GETRequest(uri);
        BaseAssertion.verifyResponseHeader(response,"Content-Encoding" ,"gzip");
        BaseAssertion.verifyStatusCode(response,200);
    }

    @Test
    public void getCurrentUser(){
        String sessionId = BaseTest.doLogin();
        //  String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/myself");
        Response response = RESTCalls.GETRequest(uri);
        BaseAssertion.verifyResponseHeader(response,"Content-Encoding" ,"gzip");
        BaseAssertion.verifyStatusCode(response,200);
    }

    @Test
    public void getComponentCountBody(){
        String sessionId = BaseTest.doLogin();
        //  String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/component/10001/relatedIssueCounts");
        Response response = RESTCalls.GETRequest(uri);
        String expectedText = "HTTP/1.1 200 ";//PayloadGenerator.generatePayLoadString("ComponentCountBody.json");
        BaseAssertion.verifyResponseBody(response,expectedText);
        BaseAssertion.verifyResponseHeader(response,"Content-Encoding" ,"gzip");
        BaseAssertion.verifyStatusCode(response,200);
    }

    @Test
    public void getComponentCount(){
        String sessionId = BaseTest.doLogin();
        //  String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/component/10001/relatedIssueCounts");
        Response response = RESTCalls.GETRequest(uri);
        String expectedText = "HTTP/1.1 200 ";//PayloadGenerator.generatePayLoadString("ComponentCountBody.json");
        BaseAssertion.verifyResponseBody(response,expectedText);
        BaseAssertion.verifyResponseHeader(response,"Content-Encoding" ,"gzip");
        BaseAssertion.verifyStatusCode(response,200);
        BaseAssertion.verifyResonseBodyByJsonPath(response,"$.issueCount","null");
    }


}
