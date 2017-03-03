package info.nukoneko.cuc.kidspos4j.util.sqlite;

import info.nukoneko.cuc.kidspos4j.model.QueryCallback;
import info.nukoneko.cuc.kidspos4j.model.TABLE_KIND;

import java.sql.SQLException;

public interface ISql {
    boolean ExecuteQuery(TABLE_KIND tableKind, String query, QueryCallback callback) throws SQLException;
    boolean Execute(TABLE_KIND tableKind, String query) throws SQLException;
    boolean truncate(TABLE_KIND tableKind);
}
