package tests.StoreTests;

import endpoints.PetEndpoint;
import endpoints.StoreEndpoint;
import models.PetModels.Pet;
import models.PetModels.Status;
import models.StoreModels.StoreOrder;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class GetStoreOrderTests {
   private StoreEndpoint storeEndpoint = new StoreEndpoint();
   private PetEndpoint petEndpoint = new PetEndpoint();
   private int id;
   private Long petId;

    @Before
    public void before (){
        Pet pet = Pet.builder()
                .id(0)
                .name("Cat")
                .status(Status.AVAILABLE)
                .build();
       petId = petEndpoint.createPet(pet);
       StoreOrder storeOrder = StoreOrder.builder()
               .id(0)
               .petId(petId)
               .build();
       id =storeEndpoint.createStoreOrder(storeOrder);
    }

    @After
    public void after(){
        storeEndpoint.deleteStoreOrderById(id);
        petEndpoint.deletePetById(petId);
    }



    @Test
    public void getStoreOrder(){
        storeEndpoint.getStoreOrderById(id);
    }



}
