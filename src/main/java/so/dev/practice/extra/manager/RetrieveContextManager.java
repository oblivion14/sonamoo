package so.dev.practice.extra.manager;


import so.dev.practice.context.manager.ContextAddressManager;
import so.dev.practice.extra.model.OntologyReference;
import so.dev.practice.model.Location;

/**
 * Created by melvin on 2016. 5. 3..
 * NOTE : 조회용으로 SDA를 이용시 조회하기 위한 URL을 추출하기 위해 사용
 */
public class RetrieveContextManager  {

    //String sdaConnection = super.sdaConnection;

    String contextId;

    static String distinguishChar =",";

    public RetrieveContextManager(String contextId) {
        this.contextId = contextId;
    }

    public String getDeviceListFromSDA(OntologyReference ontologyReference, Location location){
        String url = ContextAddressManager.getINSTANCE().getAddress()+ contextId + location.getLocationUri() +
                distinguishChar + ontologyReference.getReference();

        return url;
    }
}

