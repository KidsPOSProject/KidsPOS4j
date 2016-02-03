package info.nukoneko.kidspos4j.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TEJNEK on 2016/02/03.
 */
public interface QueryCallback {
    void result(ResultSet resultSet) throws SQLException;
}
