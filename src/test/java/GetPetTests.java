import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GetPetTests {
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
        petId = petEndpoint.createPet(body);
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
