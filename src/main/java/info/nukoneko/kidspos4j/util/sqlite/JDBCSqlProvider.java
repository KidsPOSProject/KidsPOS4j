package info.nukoneko.kidspos4j.util.sqlite;

import info.nukoneko.kidspos4j.model.QueryCallback;
import info.nukoneko.kidspos4j.model.TableKind;
import info.nukoneko.kidspos4j.util.config.SQLiteSetting;

import java.sql.*;

/**
 * Created by atsumi on 2016/02/20.
 */
public class JDBCSqlProvider implements ISql {
    @Override
    public boolean ExecuteQuery(TableKind tableKind, String query, QueryCallback callback) throws SQLException {
        try {
            Connection connection = getConnection(tableKind);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while( rs.next() ) {
                callback.result(rs);
            }
            rs.close();
            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Execute(TableKind tableKind, String query) throws SQLException {
        Connection connection = getConnection(tableKind);
        Statement stmt = connection.createStatement();
        boolean ret = stmt.execute(query);
        stmt.close();
        connection.close();
        return ret;
    }

    @Override
    public boolean truncate(TableKind tableKind) {
        try {
            Execute(tableKind, String.format("DELETE FROM '%s'", tableKind.getName()));
            Execute(tableKind, String.format("DELETE FROM sqlite_sequence where name='%s'", tableKind.getName()));
            Execute(tableKind, "VACUUM");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Connection getConnection(TableKind tableKind) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:sqlite:" + tableKind.getDbPath());
    }
}
