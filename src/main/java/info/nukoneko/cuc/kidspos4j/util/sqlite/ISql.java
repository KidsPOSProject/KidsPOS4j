package info.nukoneko.cuc.kidspos4j.util.sqlite;

import info.nukoneko.cuc.kidspos4j.model.QueryCallback;
import info.nukoneko.cuc.kidspos4j.model.TableKind;

import java.sql.SQLException;

public interface ISql {
    boolean ExecuteQuery(TableKind tableKind, String query, QueryCallback callback) throws SQLException;
    boolean Execute(TableKind tableKind, String query) throws SQLException;
    boolean truncate(TableKind tableKind);
}
