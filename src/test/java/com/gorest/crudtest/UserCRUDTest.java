package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    static ValidatableResponse response;


    @Test
    public void verifyUserCreatedSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Mr kishan");
        userPojo.setEmail( getRandomValue()+"@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization", "Bearer 52bd449199e8dc65f4310a6397aff500dc80b81bd7c2c81a3acee391ec5ec8fc")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }
    @Test
    public void verifyUserGetSuccessfully(){
        Response response = given()
                .header("Authorization", "Bearer 52bd449199e8dc65f4310a6397aff500dc80b81bd7c2c81a3acee391ec5ec8fc")
                .header("Connection", "keep-alive")
                .when()
                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void verifyUserUpdateSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Mr."+getRandomValue());
        userPojo.setEmail( getRandomValue()+"@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("inactive");
        Response response = given()
                .header("Authorization", "Bearer 52bd449199e8dc65f4310a6397aff500dc80b81bd7c2c81a3acee391ec5ec8fc")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .put("/users/11937");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void VerifyUserDeleteSuccessfully(){
        Response response = given()
                .header("Authorization", "Bearer 52bd449199e8dc65f4310a6397aff500dc80b81bd7c2c81a3acee391ec5ec8fc")
                .header("Connection", "keep-alive")
                .when()
                .delete("/users/11937");
        response.prettyPrint();
        response.then().statusCode(204);
    }
}


