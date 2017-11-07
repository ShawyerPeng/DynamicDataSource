import dao.UserDao;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class BasicTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("Shawyer");
        userDao.insert(user);
    }

    @Test
    public void testFindAllUser() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
    }
}
