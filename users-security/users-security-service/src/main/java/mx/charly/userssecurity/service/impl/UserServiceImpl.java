package mx.charly.userssecurity.service.impl;

import lombok.extern.apachecommons.CommonsLog;
import mx.charly.userssecurity.commons.mx.charly.userssecurity.exceptions.DaoException;
import mx.charly.userssecurity.commons.mx.charly.userssecurity.exceptions.ServiceException;
import mx.charly.userssecurity.dao.UserDao;
import mx.charly.userssecurity.dto.UserDto;
import mx.charly.userssecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Risko
 * @since 14/11/2016.
 */
@CommonsLog
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto findByPk(Integer id) {
        String msgErr;
        if (id == null) {
            msgErr = "El id del usuario a recuperar no puede ser nulo.";
            log.error(msgErr);
            throw new NullPointerException(msgErr);
        }

        try {
            UserDto user = userDao.findByPk(id);
            log.debug(user.toString());
            return user;
        } catch (Exception ex) {
            msgErr = "Error recuperando el usuario por id. " + ex.getMessage();
            log.error(msgErr, ex);
            throw new ServiceException(msgErr, ex);
        }
    }

    @Override
    public UserDto findByUserName(String userName) {
        String msgErr;
        if (userName == null || userName.trim().isEmpty()) {
            msgErr = "El userName del usuario a recuperar no puede ser nulo.";
            log.error(msgErr);
            throw new NullPointerException(msgErr);
        }

        try {
            UserDto user = userDao.findByUserName(userName);
            log.debug(user.toString());
            return user;
        } catch (DaoException daoEx) {
            log.error(daoEx.getMessage(), daoEx);
            throw daoEx;
        } catch (Exception ex) {
            msgErr = "Error recuperando el usuario por userName. " + ex.getMessage();
            log.error(msgErr, ex);
            throw new ServiceException(msgErr, ex);
        }
    }

    @Override
    public void saveUser(UserDto userDto) {
        String msgErr;
        if (userDto == null) {
            msgErr = "El usuario a guardar no puede ser nulo.";
            log.error(msgErr);
            throw new NullPointerException(msgErr);
        }

        try {
            log.debug(userDto.toString());
            userDao.save(userDto);
        } catch (Exception ex) {
            msgErr = "Error guardando el usuario." + ex.getMessage();
            log.error(msgErr, ex);
            throw new ServiceException(msgErr, ex);
        }
    }

    @Override
    public void deleteUser(UserDto userDto) {
        String msgErr;
        if (userDto == null) {
            msgErr = "El usuario a eliminar no puede ser nulo.";
            log.error(msgErr);
            throw new NullPointerException(msgErr);
        }

        try {
            log.debug(userDto.toString());
            userDao.delete(userDto);
        } catch (Exception ex) {
            msgErr = "Error eliminando el usuario." + ex.getMessage();
            log.error(msgErr, ex);
            throw new ServiceException(msgErr, ex);
        }
    }
}
