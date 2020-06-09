package tests;

import endpoints.PetEndpoint;
import models.Pet;
import org.junit.Before;
import org.junit.Test;

public class DeletePet {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;


    @Before
    public void before (){
   //     Pet pet = new Pet(0, "Cat");
   //     petId = petEndpoint.createPet(pet);
    }

    @Test
    public void deletePet(){
        petEndpoint.deletePetById(petId);
    }
}
