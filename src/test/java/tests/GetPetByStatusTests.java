package tests;
import endpoints.PetEndpoint;
import models.Pet;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class GetPetByStatusTests {

    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;

    private String status;

    public GetPetByStatusTests(String status) {
        this.status = status;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"available"},
                {"sold"},
                {"pending"}
        });
    }

    @Before
    public void before (){
        Pet pet = Pet.builder()
                .id(0)
                .name("Cat")
                .status(status)
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @Test
    public void getPetByStatusTest(){
        petEndpoint.getPetByStatus(status);
    }

    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }
}
