package tests;

import endpoints.PetEndpoint;
import models.Pet;
import models.Tags;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeletePet {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;


    @Before
    public void before (){
//        List<String> photoUrls = new ArrayList<String>();
//        photoUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRVlkjGDM2rebw1bNAWRVypFu-ntTRQ0eYvWYfF59yZHPTOPcFC&usqp=CAU");
//        List<Tags> tag = new ArrayList<Tags>();
//        tag.add(new Tags(0, "Fluffy"));
//        Pet pet = new Pet(0, "Cat", photoUrls, tag, "available");
//        petId = petEndpoint.createPet(pet);
    }

//    @Test
//    public void deletePet(){
//        petEndpoint.deletePetById(petId);
//    }
}