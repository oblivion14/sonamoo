package service;

import org.junit.Test;
import so.dev.practice.model.*;
import so.dev.practice.service.controller.ServiceController;
import so.dev.practice.service.controller.ServiceModelController;

import java.util.ArrayList;

/**
 * Created by melvin on 2016. 5. 26..
 */
public class ServiceTest {

    @Test
    public void ServiceRegisterTest() throws Exception {
        //get Domain List
        System.out.println("*********** Step1 ***********");
        ServiceController serviceController = new ServiceController();

        String domainStr;
        ArrayList<Domain> domainArrayList = serviceController.getDomainList();

        for(Domain domain : domainArrayList){
            domainStr = domain.getLoc();
            System.out.println("감지 도메인 : " + domainStr);
        }
        System.out.println();

        //choose Domain
        System.out.println("*********** Step2 ***********");
        Domain chooseDomain = domainArrayList.get(0);

        System.out.println("도메인 선택 : " + chooseDomain.getLoc());
        System.out.println();

        //get DeviceList in Domain(Choice)
        ArrayList<VirtualObject> deviceList = serviceController.getActuator(chooseDomain);

        for(VirtualObject virtualObject : deviceList){
            System.out.println("강의실의 장치 : " + virtualObject.getName());
        }
        System.out.println();

        //choose Device
        System.out.println("*********** Step3 ***********");
        VirtualObject chooseVO1 = deviceList.get(0);
        VirtualObject chooseVO2 = deviceList.get(1);

        //Register Service
        ControlMessage controlMessage1 = new ControlMessage("IdealCoolingTemp",chooseVO1,true);
        Service service1 = serviceController.registerService(controlMessage1);
        System.out.println();
        ControlMessage controlMessage2 = new ControlMessage("TurnOnHumidifier",chooseVO2,"ON");
        Service service2 = serviceController.registerService(controlMessage2);
        System.out.println();
        ControlMessage controlMessage3 = new ControlMessage("setTempValue",chooseVO1,30);
        Service service3 = serviceController.registerService(controlMessage3);

        ArrayList<Service> serviceDB = new ArrayList<>();
        serviceDB.add(service1);
        serviceDB.add(service2);
        serviceDB.add(service3);
        System.out.println();

        //ServiceList 조회
        System.out.println("*********** Step4 ***********");
        for(Service service : serviceDB){
            System.out.println("감지 서비스 : " + service.getName());
        }
        System.out.println();

        System.out.println("*********** Step5 ***********");
        //Choose Service
        Service chooseService01 = serviceDB.get(0);
        Service chooseService02 = serviceDB.get(1);

        //Register ServiceModel
        ServiceModel serviceModel;
        ArrayList<Service> serviceModelTemp = new ArrayList<>();

        serviceModelTemp.add(chooseService01);
        serviceModelTemp.add(chooseService02);

        ServiceModelController serviceModelController = new ServiceModelController();
        serviceModel = serviceModelController.registerService("IdealClassEnv",serviceModelTemp);

        System.out.println("ServiceModel : " + serviceModel.getServiceModelName());
        System.out.println("ServiceModelID : " + serviceModel.getServiceModelID());

        for(Service serviceTemp : serviceModel.getServiceModel()){
            serviceTemp.setLocation(chooseDomain.getLoc());
        }
        System.out.println();

        System.out.println("*********** Step6 ***********");
        System.out.println();
        System.out.println("##### ServiceStart : " + serviceModel.getServiceModelName());
        System.out.println();
        for (Service serviceTemp : serviceModel.getServiceModel()){
            System.out.println("ServiceDomain : " + serviceTemp.getLocation());
            System.out.println("ExecuteService : " + serviceTemp.getName());
            System.out.println("ExecuteActuator : " + serviceTemp.getActuator().getName());
            System.out.println("ExecuteOperation : " + serviceTemp.getOperation());
            System.out.println("ExecuteValue : " + serviceTemp.getValue());
            System.out.println("ExecuteIdealValue : " + serviceTemp.isIdealValue());
            System.out.println();
        }
//        return serviceModel.getServiceModel();
    }
}
