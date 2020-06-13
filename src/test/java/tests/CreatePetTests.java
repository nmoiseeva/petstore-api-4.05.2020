package tests;

import endpoints.PetEndpoint;
import models.Pet;
import org.junit.After;
import org.junit.Test;



public class CreatePetTests {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;

    @Test
    public void createPet (){
    Pet pet = Pet.builder()
        .id(0)
        .name("Cat")
        .status("available")
        .build();
    petId = petEndpoint.createPet(pet);
    }

    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }

}
