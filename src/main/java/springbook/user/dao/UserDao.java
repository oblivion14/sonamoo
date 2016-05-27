package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

/**
 * Created by melvin on 2016. 4. 15..
 * JDBC 를 이용하여 사용자정보를 DB에 넣고 관리
 */
public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(){
        connectionMaker = new ConnectionMakerImpl();
    }

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    /**
     * DB에 새로운 사용자를 생성한다.
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException{
        Connection connection = connectionMaker.makeConnection();

        /**
         * SQL을 담은 Statement(또는 preparedStatement)를 만든다.
         */
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into users(id,name,password) VALUES (?,?,?)");
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }



    /**
     * 아이디를 가지고 사용자 정보를 조회(get)
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection connection = connectionMaker.makeConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * FROM users where id = ?");
        preparedStatement.setString(1, id);

        /**
         * 조회의 경우 SQL 쿼리의 실행 결과를 ResultSet으로 받아서 정보를 저장할 오브젝트(Users)에 옮겨준다.
         */
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

//    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
//
//    public class NUserDao extends UserDao{
//
//        @Override
//        public Connection getConnection() throws ClassNotFoundException, SQLException {
//            return null; // N사 코드
//        }
//    }
//
//    public class DUserDao extends UserDao{
//
//        @Override
//        public Connection getConnection() throws ClassNotFoundException, SQLException {
//            return null; // D사 코드
//        }
//    }
//
//    public class KUserDao extends UserDao{
//
//        @Override
//        public Connection getConnection() throws ClassNotFoundException, SQLException {
//
//
//            Class.forName("com.mysql.jdbc.Driver");
//            /**
//             * DB 연결을 위한 Connection을 가져온다.
//             */
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost/springbook", "root", "gkdtkd11");
//            return connection;
//        }
//    }
}
