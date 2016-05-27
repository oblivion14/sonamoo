package so.dev.practice.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import so.dev.practice.model.Service;
import so.dev.practice.model.ServiceModel;

import java.util.ArrayList;


/**
 * Created by melvin on 2016. 5. 25..
 */
public class ServiceExecuteController {

    @RequestMapping(value = "/service/execute", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String executeService(String name) {
        //
        String result;
        Service service = new Service();
        ServiceModel serviceModel = new ServiceModel();
        ArrayList<Service> serviceArrayList = null; // retrieve Service
        ArrayList<ServiceModel> serviceModelArrayList = null; // retrieve ServiceModelList

        //Todo : Retrieve ServiceModelList DAO
        for (ServiceModel serviceModelTemp : serviceModelArrayList) {
            if (serviceModelTemp.getServiceModelName().equals(name)) {

                // Todo : 서비스 진행 로직
            }
        }

        //Todo : Retrieve ServiceModelList DAO
        for (Service serviceTemp : serviceArrayList) {
            if (serviceTemp.getName().equals(name)) {
                //Todo: 서비스 진행 로직
            }
        }
        result = "serviceName : " + name + "is executed";
        return result;
    }
}
