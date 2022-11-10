package GunTour.StepDefinitions.Admin;

import GunTour.API.AdminAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PostTotalPendakiStep {
    @Steps
    AdminAPI adminAPI;
    @Given("set post pendaki with valid request body to json data")
    public void setPostPendakiWithValidBody(){
        File json = new File(AdminAPI.JSON_FILE+"/RequestBody/admin/PostTotalPendaki.json");
        adminAPI.postAddTotalPendaki(json);
    }
    @When("send request post add total pendaki")
    public void sendRequestPostAddTotalPendaki() {
        SerenityRest.when().post(AdminAPI.POST_TOTAL_PENDAKI);
    }
    @And("post add total pendaki json schema")
    public void postAddTotalPendakiJsonSchema() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/PostTotalPendakiJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("set post pendaki with invalid request body to json data")
    public void setPostPendakiWithInvalidRequestBodyToJsonData() {
        File json = new File(AdminAPI.JSON_FILE+"/RequestBody/admin/PostTotalPendakiInv.json");
        adminAPI.postAddTotalPendaki(json);
    }
    @And("post total pendaki with invalid body json schema")
    public void postTotalPendakiWithInvalidBodyJsonSchema() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/PostTotalPendakiInvJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("set post pendaki with empty request body to json data")
    public void setPostPendakiWithEmptyRequestBodyToJsonData() {
        File json = new File(AdminAPI.JSON_FILE+"/RequestBody/admin/PostTotalPendakiEmpty.json");
        adminAPI.postAddTotalPendaki(json);
    }

    @Given("set post pendaki incomplete request body to json data")
    public void setPostPendakiIncompleteRequestBodyToJsonData() {
        File json = new File(AdminAPI.JSON_FILE+"/RequestBody/admin/PostTotalPendakiIncomplete.json");
        adminAPI.postAddTotalPendaki(json);
    }

    @And("API send pendakiID to dynamic variable")
    public void apiSendPendakiIDToDynamicVariable() {
    }

    @And("assert pendakiID not {int}")
    public void assertPendakiIDNot(int arg0) {
    }
}
