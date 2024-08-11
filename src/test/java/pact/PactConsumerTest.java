package pact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import static io.pactfoundation.consumer.dsl.LambdaDsl.*;
import io.pactfoundation.consumer.dsl.LambdaDslJsonBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "reqres", pactVersion = PactSpecVersion.V3)
public class PactConsumerTest {

    @Pact(provider = "reqres", consumer = "alphacoder")
    public RequestResponsePact pact(PactDslWithProvider builder) {

        LambdaDslJsonBody body = newJsonBody(main_ -> {
            main_.numberType("page",1);
            main_.numberType("per_page",10);
            main_.numberType("total",20);
            main_.numberType("total_pages",1);
            main_.array("data", ar -> {
                ar.object(aob -> {
                    aob.numberType("id",1);
                    aob.stringType("email","syz@email.com");
                    aob.stringType("first_name","john");
                    aob.stringType("last_name","wick");
                    aob.stringType("avatar","https://www.somerandomepic.com/img.png");
                });
            });
            main_.object("support", support -> {
                support.stringType("url","https://www.somerandomeurl.com/");
                support.stringType("text","lorem ipsusm");
            });
        });

        return builder
                .given("ready state")
                .uponReceiving("to get users list")
                .path("/api/users")
                .method("GET")
                .matchQuery("page", ".*")
//                .matchQuery("page", "2")  // Adding query parameter matcher
                .willRespondWith()
                .status(200)
                .body(body.build())
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "pact", hostInterface = "localhost", port = "8080")
    void pactConsumerTest(MockServer mockServer) {
        System.out.println(mockServer.getUrl());

        int status = RestAssured.given()
                .accept(ContentType.JSON)
                .baseUri(mockServer.getUrl())
                .log().all()  // Log the request for debugging
                .when()
                .get("/api/users?page=2")
                .then()
                .log().all()  // Log the response for debugging
                .extract()
                .response()
                .getStatusCode();

        Assertions.assertEquals(200, status);
    }
}
