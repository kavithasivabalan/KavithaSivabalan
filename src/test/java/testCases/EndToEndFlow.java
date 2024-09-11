package testCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.testng.annotations.Test;
import pojoResources.pojoRequests.GenerateBearerToken;
import pojoResources.pojoResponses.BearerToken;

public class EndToEndFlow {

    BearerToken bt;

    @Test
    public void getBeaererToken()
    {
        GenerateBearerToken gt = new GenerateBearerToken("Kavitha", "Kavitha123@gmail.com");
          gt.setClientName("kavitha");
          gt.setClientEmail("Kavitha123@gmail.com");
        JsonSerializer js =JsonSerializer.DEFAULT_READABLE;
        String reqPayload = js.serialize(gt);
        Response res = RestAssured.given()
            .body(reqPayload)
            .header("Content-Type","application/json")
            .post("/api-clients/")
            .then()
            .log().all().extract().response();
        String responsePayload = res.body().asString();
        JsonParser jp = JsonParser.DEFAULT;
        bt =  jp.parse(responsePayload, BearerToken.class);

    }

    }



