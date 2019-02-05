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


public class UpdateIssueTest {

    private static Logger log = LogManager.getLogger(CreateIssueTest.class.getName());



@Test
public void putInIssue(){
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("AssigningIssue.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/10029");
        Response response = RESTCalls.PUTRequest(uri,payLoad,sessionId);
        BaseAssertion.verifyResponseHeader(response,"Content-Type" ,"application/json;charset=UTF-8");
        BaseAssertion.verifyStatusCode(response,204);

 }


    @Test
    public void putInIssue2(){
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/10029");
        Response response = RESTCalls.PUTRequest(uri,payLoad,sessionId);
        BaseAssertion.verifyResponseHeader(response,"Cache-Control" ,"no-cache, no-store, no-transform");
        BaseAssertion.verifyStatusCode(response,204);
    }


    @Test
    public void putInIssue3(){
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/10039");
        Response response = RESTCalls.PUTRequest(uri,payLoad,sessionId);
        BaseAssertion.verifyResponseHeader(response,"X-Seraph-LoginReason" ,"OK");
        BaseAssertion.verifyStatusCode(response,204);
    }


    @Test
    public void putInComponent(){
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("CreateComponent2.json");
        String uri = URL.getEndPoint("/rest/api/2/component");
        Response response = RESTCalls.POSTRequest(uri,payLoad,sessionId);
        String payLoad1 = PayloadGenerator.generatePayLoadString("PutComponent.json");
        String uri1 = URL.getEndPoint("/rest/api/2/issue/10029");
        Response response1 = RESTCalls.PUTRequest(uri1,payLoad1,sessionId);
        BaseAssertion.verifyResponseHeader(response1,"X-Seraph-LoginReason" ,"OK");
        BaseAssertion.verifyStatusCode(response,201);
        BaseAssertion.verifyStatusCode(response1,204);
    }



}
