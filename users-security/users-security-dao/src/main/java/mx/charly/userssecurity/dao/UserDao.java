package mx.charly.userssecurity.dao;
import mx.charly.userssecurity.commons.util.GenericDao;
import mx.charly.userssecurity.dto.UserDto;

/**
 * @author Risko
 * @since 13/11/2016.
 */
public interface UserDao extends GenericDao<UserDto, Integer> {
    UserDto findByUserName(String usrname);
}
