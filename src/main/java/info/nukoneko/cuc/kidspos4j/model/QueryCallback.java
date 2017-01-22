package info.nukoneko.cuc.kidspos4j.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueryCallback {
    void result(ResultSet resultSet) throws SQLException;
}
