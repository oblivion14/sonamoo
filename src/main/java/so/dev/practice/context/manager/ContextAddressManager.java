package so.dev.practice.context.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by melvin on 2016. 5. 3..
 * SDA에 조회를 위한 기본 Address를 관리 - 기본 Address는 변경 여지가 있으므로 프로퍼티로 관리
 * 조회에 필요한 Context URI를 생성.
 */
public class ContextAddressManager {

   private static ContextAddressManager INSTANCE;

    private ContextAddressManager(){};

    public String getAddress(){
        //
        String sdaConnection = null;

        Properties sdaInfo = new Properties();
        InputStream in = ContextAddressManager.class.getClassLoader().getResourceAsStream("sda.properties");

        try {
            sdaInfo.load(in);
            sdaConnection = sdaInfo.getProperty("Sda_Connection");
        } catch (IOException e) {
            e.printStackTrace();

        }

        return sdaConnection;
    }

    public static synchronized ContextAddressManager getINSTANCE(){
        if(INSTANCE == null) INSTANCE = new ContextAddressManager();
        return INSTANCE;
    }
}
