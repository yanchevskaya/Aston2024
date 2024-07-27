package lesson_17.api;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class EchoPostmanTest {
    private final static String BASE_URI = "https://postman-echo.com";
    private final String expectedText = "This is expected to be sent back as part of response body.";


    @Test
    public void getRequestTest() {

        Specification.installSpecification(Specification.requestSpec(BASE_URI), Specification.responseSpecOK200());
        EchoPojo param = given()
                        .when()
                        .get("/get?foo1=bar1&foo2=bar2")
                        .then()
                        .log().all()
                        .extract().body().jsonPath().getObject("args", EchoPojo.class);

        Assert.assertEquals(param.getFoo1(), "bar1");
        Assert.assertEquals(param.getFoo2(), "bar2");

//                .assertThat()
//                .body("args.foo1", Matchers.equalTo("bar1"))
//                .body("args.foo2", Matchers.equalTo("bar2"));
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
                .log().all()
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

