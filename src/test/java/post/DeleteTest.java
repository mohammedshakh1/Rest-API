package post;

import RestAssuredCore.BaseAssertion;
import RestAssuredCore.BaseTest;
import RestAssuredCore.RESTCalls;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utils.URL;

public class DeleteTest {

    private static Logger log = LogManager.getLogger(CreateIssueTest.class.getName());


    @Test
    public void getIssue(){
         String sessionId = BaseTest.doLogin();
        //  String payLoad = PayloadGenerator.generatePayLoadString("UpdateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/10034");
        Response response = RESTCalls.DELETERequest(uri,sessionId);
        BaseAssertion.verifyResponseHeader(response,"Cache-Control" ,"no-cache, no-store, no-transform");
        BaseAssertion.verifyStatusCode(response,204);
    }


}
