package TestScripts;

import HelperClasses.ApiResult;
import HelperClasses.People;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;

public class TestGetCharactersAndVehicles {

    @Test
    public void testGet(){
        baseURI = "https://swapi.dev/api";
        String title = "A New Hope";
        String name = "Biggs Darklighter";

        //Task 1
        Response response = RestAssured.get("/films");
        response.then().assertThat().body("results.title", hasItem(title));

        //Task 2
        ApiResult data = new Gson().fromJson( response.asString(), ApiResult.class);
        List<String> characterApis = data.findCharacters(title);
        List<People> people = new ArrayList<>();
        for (String characterApi: characterApis) {
            people.add(new Gson().fromJson( given().when().get(characterApi).asString(), People.class));
        }
        assertTrue("There is no match for the given name",people.stream().anyMatch(p -> p.getName().equals(name)));

        //Task 3
        people.stream().filter(p -> p.getName().equals(name)).forEach(p2 -> System.out.println(p2.getStrarships()));

        //Task 4

    }
}
