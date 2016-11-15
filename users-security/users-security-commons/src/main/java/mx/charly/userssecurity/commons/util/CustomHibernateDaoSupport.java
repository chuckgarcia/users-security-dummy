package mx.charly.userssecurity.commons.util;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author Risko
 * @since 13/11/2016.
 */
@CommonsLog
@Repository
public abstract class CustomHibernateDaoSupport<T extends GenericDto, I extends Serializable> extends HibernateDaoSupport {

    @Getter @Setter
    private  HibernateQueries hibernateQueries;
    private final Class<T> entityClass;

    protected CustomHibernateDaoSupport(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(@Valid T dto){
        getHibernateTemplate().save(dto);
    }

    public void saveOrUpdate(@Valid T dto){
        getHibernateTemplate().saveOrUpdate(dto);
    }

    public void delete(T dto){
        getHibernateTemplate().delete(dto);
    }

    public void update(@Valid T dto){
        getHibernateTemplate().update(dto);
    }

    public void findByExample(@Valid T dto){
        getHibernateTemplate().findByExample(dto);
    }

    public T findByPk(I id){
        return getHibernateTemplate().get(entityClass, id);
    }

}
