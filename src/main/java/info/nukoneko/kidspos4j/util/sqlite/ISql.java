package info.nukoneko.kidspos4j.util.sqlite;

import info.nukoneko.kidspos4j.model.QueryCallback;
import info.nukoneko.kidspos4j.model.TableKind;

import java.sql.SQLException;

/**
 * Created by atsumi on 2016/02/20.
 */
public interface ISql {
    boolean ExecuteQuery(TableKind tableKind, String query, QueryCallback callback) throws SQLException;
    boolean Execute(TableKind tableKind, String query) throws SQLException;
    boolean truncate(TableKind tableKind);
}
