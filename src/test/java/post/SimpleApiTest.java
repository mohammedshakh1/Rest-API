package post;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleApiTest {

        public  String getSessionId() throws IOException {



            String uri = "http://localhost:8080/rest/auth/1/session";
           // String filePath = "/Users/jahidul/IdeaProjects/RestAssuredFramwork/resources/JiraLogin.json";
            // This will convert the .json payload to Strign
            String payLoad = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/resources/JiraLogin.json")));
            //response = RESTCalls.POSTRequest(endPointURI, loginPayload);
            RequestSpecification requestSpecification = RestAssured.given().body(payLoad);
            requestSpecification.contentType("application/json");
            // Make send call
            Response response = requestSpecification.post(uri);

            String strResponse = response.getBody().asString();

            JsonPath jsonResponse = new JsonPath(strResponse);

            System.out.println(jsonResponse);

            String sessionId = jsonResponse.getString("session.value");

            return sessionId;

        }

      //  @Test
    public  void createIssue() throws IOException {

            String sessionId =  getSessionId();

            String payloadPath = "/Users/jahidul/IdeaProjects/RestAssuredFramwork/resources/CreateBug.json";

            String issuePayload = new String(Files.readAllBytes(Paths.get(payloadPath)));

            RequestSpecification requestSpecification =RestAssured.given().body(issuePayload);


            // passing session id in header
           requestSpecification.header("cookie", "JSESSIONID=" + sessionId+"");

           // passing ContentType in header
            requestSpecification.contentType("application/json");

            // creat POST call
            Response  response = requestSpecification.post("http://localhost:8080/rest/api/2/issue/");

            // convert response body to string
            String stringResponse = response.body().asString();

            // create jsonpath reference variable by stringResponse
            JsonPath jsonResponse = new JsonPath(stringResponse);

            // Get value of key from jsonResponse
           String actualIssueKey = jsonResponse.getString("key");


            System.out.println(actualIssueKey);

            Assert.assertEquals(actualIssueKey, "REST-30");



        }

}
