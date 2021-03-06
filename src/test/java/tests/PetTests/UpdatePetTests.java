package tests.PetTests;

import endpoints.PetEndpoint;
import lombok.extern.slf4j.Slf4j;
import models.PetModels.Category;
import models.PetModels.Pet;
import models.PetModels.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@Slf4j
@RunWith(SerenityRunner.class)
public class UpdatePetTests {


    @Steps
    private PetEndpoint petEndpoint;
    private Long petId;


    @Before
    public void before() {
        Pet pet = Pet.builder()
                .category(Category.builder()
                        .id(0)
                        .name("test")
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @Test
    public void updatePet() {
        Pet pet = Pet.builder()
                .id(petId)
                .category(Category.builder()
                        .id(0)
                        .name("test")
                        .build())
                .status(Status.SOLD)
                .build();
        petEndpoint.updatePet(pet);
        log.info(String.format("Created Pet with id = %s", petId));
    }

    @After
    public void after() {
        petEndpoint.deletePetById(petId);
    }

}
