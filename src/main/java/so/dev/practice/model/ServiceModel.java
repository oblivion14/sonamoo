package so.dev.practice.model;

import java.util.ArrayList;

/**
 * Created by melvin on 2016. 5. 24..
  NOTE : 실질적으로 서비스를 실행시키기 위한 미리 생성된 서비스 집합(List)
  NOTE : ID, name, serviceList
 */
public class ServiceModel {

    int number;
    String serviceModelID;  // ex) serviceModel-1-1-001
    String serviceModelName;  // ex) IdealEnv
    ArrayList<Service> serviceModel = new ArrayList<>();
    //  ex) AirCoolingControl / AirHeatingControl / HumidifyControl / DeHumidifyControl / BrightLuxControl .. act
    String location; // http://www.pineone.com/campus/LR0001
    String person; // http://www.pineone.com/campus/Person0001

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getServiceModelID() {
        return serviceModelID;
    }

    public void setServiceModelID(String serviceModelID) {
        this.serviceModelID = serviceModelID;
    }

    public String getServiceModelName() {
        return serviceModelName;
    }

    public void setServiceModelName(String serviceModelName) {
        this.serviceModelName = serviceModelName;
    }

    public ArrayList<Service> getServiceModel() {
        return serviceModel;
    }

    public void setServiceModel(ArrayList<Service> serviceModel) {
        this.serviceModel = serviceModel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
