package so.dev.practice.model;

/**
 * Created by melvin on 2016. 5. 25..
 */
public class ControlMessage {

   // String name, VirtualObject virtualObject, String operation, int value

    String name;
    VirtualObject virtualObject;
    String operation;
    int value;

    public ControlMessage(String name, VirtualObject virtualObject, boolean isIdealValue) {
        this.name = name;
        this.virtualObject = virtualObject;
        this.isIdealValue = isIdealValue;
    }

    boolean isIdealValue;  // 최적온도.. 등

    public ControlMessage(String name, VirtualObject virtualObject, String operation) {
        this.name = name;
        this.virtualObject = virtualObject;
        this.operation = operation;
    }

    public ControlMessage(String name, VirtualObject virtualObject, int value) {
        this.name = name;
        this.virtualObject = virtualObject;
        this.value = value;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VirtualObject getVirtualObject() {
        return virtualObject;
    }

    public void setVirtualObject(VirtualObject virtualObject) {
        this.virtualObject = virtualObject;
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

    public boolean isIdealValue() {
        return isIdealValue;
    }

    public void setIdealValue(boolean idealValue) {
        isIdealValue = idealValue;
    }


}
