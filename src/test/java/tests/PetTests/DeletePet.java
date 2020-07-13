package tests.PetTests;

import endpoints.PetEndpoint;
import models.PetModels.Pet;
import models.PetModels.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DeletePet {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;


    @Before
    public void before (){
        Pet pet = Pet.builder()
                .id(0)
                .name("Cat")
                .status(Status.AVAILABLE)
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @Test
    public void deletePet(){
        petEndpoint.deletePetById(petId);
    }
}
