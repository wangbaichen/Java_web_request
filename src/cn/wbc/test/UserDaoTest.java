package cn.wbc.test;

import cn.wbc.dao.UserDao;
import cn.wbc.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testlogin(){
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("123");

        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        System.out.println(login);
    }
}
