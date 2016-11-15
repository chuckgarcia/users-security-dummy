package mx.charly.userssecurity.test.dao.impl;

import lombok.extern.apachecommons.CommonsLog;
import mx.charly.userssecurity.commons.util.LoggerConstants;
import mx.charly.userssecurity.dao.UserDao;
import mx.charly.userssecurity.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Risko
 * @since 13/11/2016.
 */
@CommonsLog
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/dao.applicationContext.xml"
})
public class UsersDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findByIdTest(){
        log.debug(LoggerConstants.INICIO);
        UserDto user = userDao.findByPk(2);
        log.debug(user.toString());
        log.debug(LoggerConstants.FINAL);
    }

    @Test
    public void findByUserName(){
        log.debug(LoggerConstants.INICIO);
        UserDto user = userDao.findByUserName("carlos");
        log.debug(user.toString());
        log.debug(LoggerConstants.FINAL);
    }
}
