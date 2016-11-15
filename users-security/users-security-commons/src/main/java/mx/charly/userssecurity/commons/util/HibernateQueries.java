package mx.charly.userssecurity.commons.util;

import lombok.Data;
import java.util.Map;

/**
 * @author Risko
 * @since 13/11/2016.
 */
@Data
public abstract class HibernateQueries {

    private Map<String, String> queries;

    public String getQuery(String queryName) {
        String query = queries.get(queryName);
        if (query == null) {
            throw new NullPointerException("El Query: " + queryName + " no está definido.");
        }
        return query;
    }
}
