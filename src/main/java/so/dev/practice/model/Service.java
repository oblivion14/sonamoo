package so.dev.practice.model;

/**
 * Created by melvin on 2016. 5. 24..
 NOTE : SO에서 제어할 서비스들의 단위, 서비스들을 묶어서 종합서비스를 실행시키기 위해 생성하는 객체
 NOTE : ID, Name, ActuatorDevice, Operation or Value
 */
public class Service {

    int number;
    String serviceID;  // ex) service-1-1-0001(number)
    String name; // ex) AirCoolingControl
    VirtualObject actuator; // 외부적으로 Actuator 로 표현
    // 내부적으로 OntologyRef 참조 ex) http://www.pineone.com/campus/AirCoolingControl
    String operation; // ON or OFF
    int value; // ex) 30'C
    String location; // http://www.pineone.com/campus/LR0001
    String person; // http://www.pineone.com/campus/Person0001
    boolean isIdealValue;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VirtualObject getActuator() {
        return actuator;
    }

    public void setActuator(VirtualObject actuator) {
        this.actuator = actuator;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public boolean isIdealValue() {
        return isIdealValue;
    }

    public void setIdealValue(boolean idealValue) {
        isIdealValue = idealValue;
    }
}
