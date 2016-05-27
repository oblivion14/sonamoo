package so.dev.practice.extra.card;

import so.dev.practice.context.model.Context;
import so.dev.practice.model.Location;

import java.util.List;

/**
 * Created by melvin on 2016. 5. 4..
 * NOTE : 상황이 발생한 장소를 수신 받으면 해당 장소의 컨텍스트들을 모두 조회한다.
 * NOTE : 조회후 발생결과인 ContextList를 리턴한다. 이는 OccContextManager에 의해 SDA와 조회가 이뤄진다.
 */
public class ContextCard {

    Location location;

    public ContextCard(Location location){
        this.location = location;
    }

    public List<Context> readContextCard(){
        //
        String locationUri = location.getLocationUri();
        //Todo : locationUri로 해당 Location 정보를 포함하고 있는 ContextList 조회하는 DB provider 필요
        return null;
    }

}
