package tests;

import endpoints.PetEndpoint;
import models.Pet;
import models.Tags;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UpdatePetTests {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;


    @Before
    public void before (){
        List<String> photoUrls = new ArrayList<String>();
        photoUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRVlkjGDM2rebw1bNAWRVypFu-ntTRQ0eYvWYfF59yZHPTOPcFC&usqp=CAU");
        List<Tags> tag = new ArrayList<Tags>();
        tag.add(new Tags(0, "Fluffy"));
        Pet pet = new Pet(0, "Cat", photoUrls, tag, "available");
        petId = petEndpoint.createPet(pet);
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
