package tests;

import endpoints.PetEndpoint;
import org.junit.After;
import org.junit.Test;


public class CreatePetTests {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;

    @Test
    public void createPet (){
        String body = "{\n" +
                "\"id\":0,\n" +
                "\"category\":{\n" +
                "\"id\":0,\n" +
                "\"name\":\"Cat\"\n" +
                "},\n" +
                "\"name\":\"Cat\",\n" +
                "\"photoUrls\":[\n" +
                "\"string\"\n" +
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"Cat\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"available\"\n" +
                "}";
      //  petId = petEndpoint.createPet(body, "Cat");
    }

    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }

}
