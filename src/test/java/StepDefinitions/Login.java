package StepDefinitions;

import Resources.Resources;
import Resources.Data;
import Resources.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Login extends Util {
    RequestSpecification request;
    Response response;
    static String value;
    public static String issueid;
    public String commentId;
    @Given("Add Login payload with {string} and {string}")
    public void add_login_payload_with_and(String un, String pwd) throws Exception {
        request = given().relaxedHTTPSValidation().spec(requestSpecification()).body(Data.getLoginPayload(un,pwd));
    }
    @When("Hit the {string} with {string} http request")
    public void hit_the_with_http_request(String resource, String httpMethod) {
        Resources source = Resources.valueOf(resource);
        System.out.println(source.getResource());
        System.out.println(httpMethod);
        if(httpMethod.equalsIgnoreCase("Post"))
            response = request.when().post(source.getResource());
        }

    @Then("Verify the status code is {int}")
    public void verify_the_status_code_is(Integer statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());

    }
    @Then("Parse the JSon to get sessionid")
    public void parse_the_j_son_to_get_sessionid() {
        JsonPath js = getJson(response);
       value = js.get("session.value");
    }

    @Given("Add input payload and cookie")
    public void add_input_payload_and_cookie() throws Exception {
        System.out.println(value);
        request = given().spec(requestSpecification()).cookie("JSESSIONID",value).body(Data.getCreateIssuePayload("Out of balance in SA","return + txn discount OOB reject in SA"));
    }
    @Then("get the issue id")
    public void get_the_issue_url() {
         JsonPath js =getJson(response);
         issueid = js.get("key");
        System.out.println(issueid);
    }

    @Given("Add the input Payload with body:")
    public void add_the_input_payload_with_body(String docString) throws Exception {
        request = given().spec(requestSpecification()).cookie("JSESSIONID",value).pathParam("Key",issueid).body(Data.getAddCommentPayload(docString));
    }
    @Then("Parse the Json to get the commentId")
    public void parse_the_json_to_get_the_comment_id() {
        JsonPath js =getJson(response);
        commentId = js.getString("id");
    }
    @Given("Add input payload with file {string}")
    public void add_input_payload_with_file(String string) throws Exception {
        request = given().spec(requestSpecification()).header("X-Atlassian-Token", "no-check").pathParam("Key", issueid).header("Content-Type", "multipart/form-data").cookie("JSESSIONID", value).multiPart(new File(string));
    }

}
