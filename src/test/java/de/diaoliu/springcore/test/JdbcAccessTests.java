package de.diaoliu.springcore.test;

import de.diaoliu.springcore.dao.UserDao;
import de.diaoliu.springcore.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class JdbcAccessTests {

    @Autowired
    BasicDataSource dataSource;

    @Autowired
    UserDao userDao;

    private static Logger logger = Logger.getLogger(JdbcAccessTests.class.toString());

    @Test
    public void userDaoTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("create table user(id int primary key,email varchar(32), createdAt date)");
        userDao.setDataSource();

        User user = new User();
        user.setId(1);
        user.setEmail("diaoliu@gmail.com");

        userDao.save(user);

        User result = userDao.getUserByEmail("diaoliu@gmail.com");
        Assert.assertNotNull(result);

        logger.info(result.toString());
    }
}
