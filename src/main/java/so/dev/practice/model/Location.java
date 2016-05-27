package so.dev.practice.model;

/**
 * Created by melvin on 2016. 5. 3..
 * NOTE: 장소 정보를 저장할 공간
 */
public class Location {

    public static final String classRoomUri = "http://www.pineone.com/campus/LR0001";

    String locationUri;


    public String getLocationUri() {
        return locationUri;
    }

    public void setLocationUri(String locationUri) {
        this.locationUri = locationUri;
    }
}
