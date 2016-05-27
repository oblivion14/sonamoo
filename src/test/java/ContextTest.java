import org.junit.Test;
import so.dev.practice.extra.model.RetrieveContextList;
import so.dev.practice.extra.manager.RetrieveContextManager;
import so.dev.practice.model.Location;
import so.dev.practice.extra.model.OntologyReference;

/**
 * Created by melvin on 2016. 5. 3..
 */


public class ContextTest {

    RetrieveContextManager retrieveContextManager =
            new RetrieveContextManager(RetrieveContextList.getDeviceWithOntology);
    Location location = new Location();
    OntologyReference ontology = new OntologyReference();


    @Test
    public void getUri() throws Exception {

        location.setLocationUri(Location.classRoomUri);
        ontology.setReference(OntologyReference.REF_AIR_COOLING_CONTROL);

        String context = retrieveContextManager.getDeviceListFromSDA(ontology,location);
        System.out.println(context);
    }
}
