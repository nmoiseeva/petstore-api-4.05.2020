import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdatePetTests {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private Long petId;


    @Before
    public void before (){
        String body = "{\n" +
                "\"id\":0,\n" +
                "\"category\":{\n" +
                "\"id\":0,\n" +
                "\"name\":\"Cat\"\n" +
                "},\n" +
                "\"name\":\"Cat\",\n" +
                "\"photoUrls\":[\n" +
                "\"string\"\n" +
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"Cat\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"available\"\n" +
                "}";
        petId = petEndpoint.createPet(body, "Cat");
    }

    @Test
    public void updatePet (){
        String body = "{\n" +
                "\"id\":0,\n" +
                "\"category\":{\n" +
                "\"id\":0,\n" +
                "\"name\":\"CatName\"\n" +
                "},\n" +
                "\"name\":\"CatName\",\n" +
                "\"photoUrls\":[\n" +
                "\"string\"\n" +
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"CatName\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"available\"\n" +
                "}";
        petEndpoint.updatePet(body, "CatName");
    }

    @After
    public void after(){
        petEndpoint.deletePetById(petId);
    }

}
