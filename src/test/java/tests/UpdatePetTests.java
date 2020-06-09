package tests;

import endpoints.PetEndpoint;
import models.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdatePetTests {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;


    @Before
    public void before (){
       // Pet pet = new Pet(0, "Cat");
        //petId = petEndpoint.createPet(pet);
    }

    @Test
    public void updatePet (){
        String body = "{\n" +
                "\"id\":0,\n" +
                "\"category\":{\n" +
                "\"id\":0,\n" +
                "\"name\":\"CatName\"\n" +
                "},\n" +
                "\"name\":\"CatName\",\n" +
                "\"photoUrls\":[\n" +
                "\"string\"\n" +
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"CatName\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"available\"\n" +
                "}";
        petEndpoint.updatePet(body, "CatName");
    }

    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }

}
