import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.ConnectionMakerImpl;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by melvin on 2016. 4. 15..
 */

public class testClass {

    /**
     * User 오브젝트 생성후 프로퍼티에 값을 넣은 후에 add()메소드를 이용해 디비에 추가
     * UserDao와 ConnectionMaker 구현 클래스와의 런타임 오브젝트 의존 관계를 설정하는 책임을 담당
     * @throws Exception
     */
    @Test
    public void userTest() throws Exception {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = applicationContext.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("Id2253133");
        user.setName("테스트");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

    }

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
