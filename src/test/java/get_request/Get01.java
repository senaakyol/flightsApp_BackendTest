package get_request;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class Get01 {

    @Test
    public void test01() {
        String url = "https://flights-api.buraky.workers.dev/";
        Response response = given().when().get(url);
        response.then().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
        response.prettyPrint();
        String responseBody = response.getBody().asString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray dataArray = jsonResponse.getJSONArray("data");
        JSONObject firstDataObject = dataArray.getJSONObject(0);
        Assert.assertEquals(firstDataObject.getInt("id"), 1);
        Assert.assertEquals(firstDataObject.getString("from"), "IST");
        Assert.assertEquals(firstDataObject.getString("to"), "LAX");
        Assert.assertEquals(firstDataObject.getString("date"), "2022-12-13");

    }


}
