package mx.charly.userssecurity.dao.impl;

import lombok.extern.apachecommons.CommonsLog;
import mx.charly.userssecurity.commons.mx.charly.userssecurity.exceptions.DaoException;
import mx.charly.userssecurity.commons.util.CustomHibernateDaoSupport;
import mx.charly.userssecurity.dao.UserDao;
import mx.charly.userssecurity.dto.UserDto;
import mx.charly.userssecurity.queries.UserQueries;

import javax.persistence.Query;

/**
 * @author Risko
 */
@CommonsLog
public class UserDaoImpl extends CustomHibernateDaoSupport<UserDto, Integer> implements UserDao {

    public UserDaoImpl() {
        super(UserDto.class);
    }

    @Override
    public UserDto findByUserName(final String usrname) {
        String msgErr;
        UserDto user;
        if (usrname == null || usrname.trim().isEmpty()) {
            msgErr = "El nombre del usuario a recuperar es nulo. ";
            log.error(msgErr);
            throw new NullPointerException(msgErr);
        }
        try {
            user = getHibernateTemplate().execute(session -> {
                String strQuery = getHibernateQueries().getQuery(UserQueries.RECUPERAR_POR_USERNAME);
                log.debug("strQuery: " + strQuery);
                Query query = session.createQuery(strQuery);
                query.setParameter("usrname", usrname);
                return (UserDto) query.getSingleResult();
            });
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DaoException(ex.getMessage(), ex);
        }
        return user;
    }
}
