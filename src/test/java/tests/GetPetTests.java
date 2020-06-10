package tests;

import endpoints.PetEndpoint;
import models.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GetPetTests {
   private PetEndpoint petEndpoint = new PetEndpoint();
   private Long petId;


    @Before
    public void before (){
        Pet pet = new Pet(0, "Cat");
        petId = petEndpoint.createPet(pet);
    }


    @Test
    public void getPet(){
        petEndpoint.getPetById(petId);
    }


    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }


}
