package mx.charly.userssecurity.test.service.impl;

import lombok.extern.apachecommons.CommonsLog;
import mx.charly.userssecurity.commons.util.LoggerConstants;
import mx.charly.userssecurity.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Risko
 * @since 14/11/2016.
 */
@CommonsLog
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/dao.applicationContext.xml",
        "classpath:/service.applicationContext.xml"
})
public class UsersServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserByIdTest(){
        log.debug(LoggerConstants.INICIO);
        userService.findByPk(1);
        log.debug(LoggerConstants.FINAL);
    }
}
