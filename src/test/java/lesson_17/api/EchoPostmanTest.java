package lesson_17.api;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class EchoPostmanTest {
    private final static String BASE_URI = "https://postman-echo.com";
    private final String expectedText = "This is expected to be sent back as part of response body.";

    private final String HOST = "postman-echo.com";
    private final String PROTO = "https";
    private final String PORT = "443";
    private final String TYPE_JSON = "application/json";
    private final String USER_AGENT = "Apache-HttpClient/4.5.13 (Java/18.0.2)";
    private final String ENCODING = "gzip,deflate";

    List<String> headersListJSon = List.of(HOST, PROTO, PORT, TYPE_JSON, USER_AGENT, ENCODING);
    List<String> headersListURLen = List.of(HOST, PROTO, PORT, TYPE_JSON, USER_AGENT, ENCODING);
    @Test
    public void getRequestTest() {

        Specification.installSpecification(Specification.requestSpec(BASE_URI), Specification.responseSpecOK200());
        EchoPojo param = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("args", EchoPojo.class);

        Assert.assertEquals(param.getFoo1(), "bar1");
        Assert.assertEquals(param.getFoo2(), "bar2");

//                .assertThat()
//                .body("args.foo1", Matchers.equalTo("bar1"))
//                .body("args.foo2", Matchers.equalTo("bar2"));

        HeadersPojo headers = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("headers", HeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));

    }

    @Test
    public void postRawTextTest() {

        Specification.installSpecification(Specification.requestSpec(BASE_URI), Specification.responseSpecOK200());
        String rawText = "\"test\": \"value\"";

        given()
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .log().all()
                .assertThat()
                .body("data", Matchers.equalTo(rawText));

        HeadersPojo headers = given()
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .log().all()
                .extract().body().jsonPath().getObject("headers", HeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }


    @Test
    public void postFormTest() {
        Specification.installSpecification(Specification.requestSpecificationUnlencoded(BASE_URI), Specification.responseSpecOK200());

        EchoPojo param = given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .extract().body().jsonPath().getObject("form", EchoPojo.class);

        Assert.assertEquals(param.getFoo1(), "bar1");
        Assert.assertEquals(param.getFoo2(), "bar2");

//                .assertThat()
//                .body("form.foo1", Matchers.equalTo("bar1"))
//                .body("form.foo2", Matchers.equalTo("bar2"));
    }

    @Test
    public void putRawTextTest() {
        Specification.installSpecification(Specification.requestSpec(BASE_URI), Specification.responseSpecOK200());

        given()
                .body(expectedText)
                .when()
                .put("/put")
                .then()
                .log().all()
                .assertThat()
                .body("data", Matchers.equalTo(
                        expectedText));

        HeadersPojo headers = given()
                .body(expectedText)
                .when()
                .put("/put")
                .then()
                .log().all()
                .extract().body().jsonPath().getObject("headers", HeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }

    @Test
    public void patchRawTextTest() {
        Specification.installSpecification(Specification.requestSpec(BASE_URI), Specification.responseSpecOK200());

        given()
                .body(expectedText)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .assertThat()
                .body("data", Matchers.equalTo(
                        expectedText));

        HeadersPojo headers = given()
                .body(expectedText)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .extract().body().jsonPath().getObject("headers", HeadersPojo.class);

        Assert.assertTrue(headers.isTrueListCon(headersListJSon));
    }

    @Test
    public void deleteRawTextTest() {
        Specification.installSpecification(Specification.requestSpec(BASE_URI), Specification.responseSpecOK200());

        given()
                .body(expectedText)
                .when()
                .delete("/delete")
                .then().log().all()
                .assertThat()
                .body("data", Matchers.equalTo(
                        "This is expected to be sent back as part of response body."));
    }
}

