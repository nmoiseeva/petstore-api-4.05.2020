package tests;
import endpoints.PetEndpoint;
import models.Category;
import models.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(SerenityRunner.class)
public class UploadPetImageTests {

    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;

    @Before
    public void before (){
        Pet pet = Pet.builder()
                .id(0)
                .name("Cat")
                .status("available")
                .build();
        petId = petEndpoint.createPet(pet);
    }


    @Test
    public void uploadPetImage(){
        Pet pet = Pet.builder()
                .id(petId)
                .build();
        petEndpoint.uploadPetImage(pet, "meta", new File("C:\\AutoTests\\petstore-api-4.05.2020\\1397.jpg"));
    }


    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }
}
