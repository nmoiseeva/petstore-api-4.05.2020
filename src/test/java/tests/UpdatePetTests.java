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
        Pet pet = Pet.builder()
                .id(0)
                .name("Cat")
                .status("available")
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @Test
    public void updatePet (){
        Pet pet = Pet.builder()
                .id(petId)
                .status("sold")
                .build();
        petEndpoint.updatePet(pet);
    }

    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }

}
