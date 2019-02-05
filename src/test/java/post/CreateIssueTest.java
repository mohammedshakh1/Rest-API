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



public class CreateIssueTest {

    private static Logger log = LogManager.getLogger(CreateIssueTest.class.getName());

/*
    @Test
    public void createIssue(){

     String sessionId = BaseTest.doLogin();
     String payLoad = PayloadGenerator.generatePayLoadString("CreateBug.json");
     String uri = URL.getEndPoint("/rest/api/2/issue/");
     Response response = RESTCalls.POSTRequest(uri,payLoad, sessionId);
     // BaseAssertion.verifyResonseBodyByJsonPath(response,"key", "REST-41");
        BaseAssertion.verifyResponseHeader(response,"Content-Type" ,"application/json;charset=UTF-8");
        BaseAssertion.verifyStatusCode(response,201);


    }*/
/* @Test
public void putInIssue(){
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("AssigningIssue.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/10029");
        Response response = RESTCalls.PUTRequest(uri,payLoad,sessionId);
     BaseAssertion.verifyResponseHeader(response,"Content-Type" ,"application/json;charset=UTF-8");
     BaseAssertion.verifyStatusCode(response,204);
 }*/

 /*@Test
    public void createSubBug(){
     String sessionId = BaseTest.doLogin();
     String payLoad = PayloadGenerator.generatePayLoadString("CreateBug2.json");
     String uri = URL.getEndPoint("/rest/api/2/issue");
     Response response = RESTCalls.POSTRequest(uri,payLoad,sessionId);
     BaseAssertion.verifyResponseHeader(response,"Content-Type" ,"application/json;charset=UTF-8");
     BaseAssertion.verifyStatusCode(response,201);
 }*/

// @Test
// public void createSubBug2(){
//  String sessionId = BaseTest.doLogin();
//  String payLoad = PayloadGenerator.generatePayLoadString("CreateBug2.json");
//  String uri = URL.getEndPoint("/rest/api/2/issue");
//  Response response = RESTCalls.POSTRequest(uri,payLoad,sessionId);
//  BaseAssertion.verifyResponseHeader(response,"X-AUSERNAME" ,"mohammedshakh1");
//  BaseAssertion.verifyStatusCode(response,201);
// }
//
// @Test
// public void createNewUser(){
//  String sessionId = BaseTest.doLogin();
//  String payLoad = PayloadGenerator.generatePayLoadString("CreateUser.json");
//  String uri = URL.getEndPoint("/rest/api/2/user");
//  Response response = RESTCalls.POSTRequest(uri,payLoad,sessionId);
//  BaseAssertion.verifyResponseHeader(response,"X-AUSERNAME" ,"mohammedshakh1");
//  BaseAssertion.verifyStatusCode(response,201);
// }

    @Test
    public void createNewG() {
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("CreateGroup.json");
        String uri = URL.getEndPoint("/rest/api/2/group");
        Response response = RESTCalls.POSTRequest(uri, payLoad, sessionId);
        BaseAssertion.verifyResponseHeader(response, "X-AUSERNAME", "mohammedshakh1");
        BaseAssertion.verifyStatusCode(response, 201);
    }

    @Test
    public void createNewComponent() {
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("CreateComponent.json");
        String uri = URL.getEndPoint("/rest/api/2/component");
        Response response = RESTCalls.POSTRequest(uri, payLoad, sessionId);
        BaseAssertion.verifyResponseHeader(response, "Transfer-Encoding", "chunked");
        BaseAssertion.verifyStatusCode(response, 201);
    }

    @Test
    public void createIssue4() {

        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("CreateBug.json");
        String uri = URL.getEndPoint("/rest/api/2/issue/");
        Response response = RESTCalls.POSTRequest(uri, payLoad, sessionId);
        BaseAssertion.verifyStatusCode(response, 201);
        BaseAssertion.verifyStatusMessage(response,"HTTP/1.1 201 ");

    }

    @Test
    public void createGroup() {
        String sessionId = BaseTest.doLogin();
        String payLoad = PayloadGenerator.generatePayLoadString("CreateGroup.json");
        String uri = URL.getEndPoint("/rest/api/2/group");
        Response response = RESTCalls.POSTRequest(uri, payLoad, sessionId);
       BaseAssertion.verifyResonseBodyByJsonPath(response,"$.users.max-results",50);
        BaseAssertion.verifyStatusCode(response, 201);
    }

}