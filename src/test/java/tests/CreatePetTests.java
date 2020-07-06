package tests;

import endpoints.PetEndpoint;
import models.Pet;
import models.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class CreatePetTests {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;

    @Test
    public void createPet (){
    Pet pet = Pet.builder()
        .id(0)
        .name("Cat")
        .status(Status.AVAILABLE)
        .build();
    petId = petEndpoint.createPet(pet);
    }

    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }

}
