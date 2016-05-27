package so.dev.practice.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import so.dev.practice.model.Domain;
import so.dev.practice.model.Service;
import so.dev.practice.model.ServiceModel;
import so.dev.practice.service.exception.AlreadyExistNameException;

import java.util.ArrayList;

/**
 * Created by melvin on 2016. 5. 24..
 */
public class ServiceModelController {

    public static final String SERVICE_MODEL_DEFAULT_ID = "SM-1-1-";

    @RequestMapping(value = "/service/domainList", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ArrayList<Domain> getDomainList(){
        //
        ArrayList<Domain> domainArrayList;

        //Todo : Retrieve DomainList DAO or SDA
        // ex) variety of person Type, variety of locations Type
        // ex) 관리자, 학생, 강의실, 기숙사, 연구실..
        return null;  // domainArrayList
    }

    @RequestMapping(value = "/servicemodel/serviceList", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ArrayList<Service> getServiceList(){
        //
        ArrayList<Service> serviceArrayList;  // Retrieve ServiceList

        //Todo : Retrieve serviceList DAO

        return null;  // domainArrayList
    }

    @RequestMapping(value = "/servicemodel/register", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ServiceModel registerService(String name, ArrayList<Service> serviceArrayList){
        //
        String result;
        ServiceModel serviceModel = new ServiceModel();
        ArrayList<ServiceModel> serviceModelArrayList = new ArrayList<>(); // retrieve ServiceModelList

        //Todo : Retrieve ServiceModelList DAO

        for(ServiceModel serviceModelTemp : serviceModelArrayList) {
            if (serviceModelTemp.getServiceModelName().equals(name)) {
                try {
                    throw new AlreadyExistNameException();
                } catch (AlreadyExistNameException alreadyExistNameException) {
                    alreadyExistNameException.printStackTrace();
                }
            }
        }
        serviceModel.setNumber(serviceModelArrayList.size() + 1);
        serviceModel.setServiceModelID(SERVICE_MODEL_DEFAULT_ID + serviceModel.getNumber());
        serviceModel.setServiceModelName(name);
        serviceModel.setServiceModel(serviceArrayList);

        //Todo : Create DAO ServiceModel (serviceModel)
        // ex) xxx , SM-1-1-xxx , IdealEnvironment, [AirCoolingService, AirHeatingService, HumidifyService ... ]

        return serviceModel;
//        result = "serviceName : " + serviceModel.getServiceModelName() + "serviceID : "
//                + serviceModel.getServiceModelID() + "is registered";
//        return result;
    }
}
