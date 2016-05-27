package so.dev.practice.extra.model;

import so.dev.practice.context.model.Context;

/**
 * Created by melvin on 2016. 5. 3..
 */
public class RetrieveContextList {

    Context context;

    public static final String getDeviceWithOntology = "CM-1-1-110/?p=";

    public boolean addContext(String contextName, String contextId, String time){

        context.setName(contextName);
        context.setId(contextId);
        context.setPeriod(time);
        //TODO : Context 등록 DB Provider 이용
        return true;
    }

    public String readContext(String contextName){

        context.setName(contextName);
        //Todo : Context 이름으로 SDA에 연결할 ContextId(Address애 사용될) 조회하는 DB Provider 이용
        String contextId = context.getId();
        return contextId;
    }

    public boolean updateContext(String contextName, String contextId, String time){

        context.setName(contextName);
        context.setId(contextId);
        context.setPeriod(time);
        //Todo : Context 이름에 해당하는 내용의 주소를 변경하기 위한 DB Provider 이용
        return true;
    }

    public boolean deleteContext(String contextName){

        context.setName(contextName);
        //Todo : Context 이름에 해당하는 내용 삭제하기 위한 DB Provider 이용
        return true;
    }


}
