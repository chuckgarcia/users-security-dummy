package mx.charly.userssecurity.commons.util;

import java.io.Serializable;

/**
 * @author Risko
 * @since 13/11/2016.
 */
public interface GenericDao<T extends GenericDto, I extends Serializable> {
    void save(T dto);
    void saveOrUpdate(T dto);
    void delete(T dto);
    void update(T dto);
    T findByPk(I id);
}
