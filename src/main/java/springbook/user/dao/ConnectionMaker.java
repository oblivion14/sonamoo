package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by melvin on 2016. 4. 18..
 */
public interface ConnectionMaker {

    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
