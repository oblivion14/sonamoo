package so.dev.practice.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import so.dev.practice.model.Domain;
import so.dev.practice.model.ControlMessage;
import so.dev.practice.model.Service;
import so.dev.practice.model.VirtualObject;
import so.dev.practice.service.exception.AlreadyExistNameException;

import java.util.ArrayList;

/**
 * Created by melvin on 2016. 5. 24..
 */

@Controller
public class ServiceController {

    public static final String SERVICE_DEFAULT_ID = "service-1-1-";

    //NOTE: TEST
    public static final String SERVICE_LOCATION_TEST = "http://www.pineone.com/campus/LR0001";

    @RequestMapping(value = "/service/domainList", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ArrayList<Domain> getDomainList(){
        //
        ArrayList<Domain> domainArrayList = new ArrayList<>();

        //Todo : Retrieve DomainList at DAO or SDA
            // ex) variety of person Type, variety of locations Type
            // ex) 관리자, 학생, 강의실, 기숙사, 연구실..

        //NOTE: TEST
        Domain domain1 = new Domain();
        Domain domain2 = new Domain();
        domain1.setLoc(SERVICE_LOCATION_TEST);
        String location2 = "http://www.pineone.com/campus/DT0001";
        domain2.setLoc(location2);
        domainArrayList.add(domain1);
        domainArrayList.add(domain2);

        return domainArrayList;  // domainArrayList
    }

    @RequestMapping(value = "/service/actuator", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ArrayList<VirtualObject> getActuator(Domain domain){
        //
        ArrayList<VirtualObject> deviceList = new ArrayList<>();
        // 외부에는 Device로 표현, 내부에서 VirtualObject 사용

        //NOTE : TEST

        if(domain.getLoc().equals(SERVICE_LOCATION_TEST)){
            VirtualObject virtualObject1 = new VirtualObject();
            VirtualObject virtualObject2 = new VirtualObject();
            virtualObject1.setName("AirController");
            virtualObject2.setName("Humidifier");
            deviceList.add(virtualObject1);
            deviceList.add(virtualObject2);
        }

        //Todo : Retrieve VOList(domain) at DAO or SDA
            // ex) 강의실 도메인의 actuator 조회 - 에어컨, 히터, 전구 ..

        return deviceList;
    }

    @RequestMapping(value = "/service/register", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Service registerService(ControlMessage controlMessage){
        //
        String result;
        Service service = new Service();
        ArrayList<Service> serviceArrayList = new ArrayList<>(); //retrieve serviceList

        //Todo : Retrieve ServiceList DAO

        for(Service serviceTemp : serviceArrayList){
            if(serviceTemp.getName().equals(controlMessage.getName())){
                try {
                    throw new AlreadyExistNameException();
                } catch (AlreadyExistNameException alreadyExistNameException) {
                    alreadyExistNameException.printStackTrace();
                }
            }
        }

        service.setNumber(serviceArrayList.size() + 1);
        service.setServiceID(SERVICE_DEFAULT_ID + service.getNumber());
        service.setName(controlMessage.getName());
        service.setActuator(controlMessage.getVirtualObject());
        service.setOperation(controlMessage.getOperation());
        service.setValue(controlMessage.getValue());
        service.setIdealValue(controlMessage.isIdealValue());


        //Todo : Create DAO Service (service)
            // ex) xxx , service-1-1-xxx , CoolingService, AirCoolingDevice , ON , null
        //NOTE:TEST
        VirtualObject virtualObject = service.getActuator();
        System.out.println("ServiceNumber = " + service.getNumber());
        System.out.println("ServiceId = " + service.getServiceID());
        System.out.println("ServiceName = " + service.getName());
        System.out.println("ServiceActuator = " + virtualObject.getName());
        System.out.println("ServiceOperation = " + service.getOperation());
        System.out.println("ServiceValue = " + service.getValue());
        System.out.println("IdealTemp = " + service.isIdealValue());


        return service;

//        result = "serviceName : " + service.getName()  + ", serviceID : " + service.getServiceID() + " is registered";
//        return result;
    }
}
