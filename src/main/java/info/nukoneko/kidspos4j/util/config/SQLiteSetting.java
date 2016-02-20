package info.nukoneko.kidspos4j.util.config;

import info.nukoneko.kidspos4j.model.TableKind;
import info.nukoneko.kidspos4j.util.sqlite.ISql;
import info.nukoneko.kidspos4j.util.sqlite.JDBCSqlProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by atsumi on 2016/02/20.
 */
public class SQLiteSetting {
    private static ISql sqlProvider = new JDBCSqlProvider();

    public static synchronized void setSqlProvider(ISql sqlProvider) {
        SQLiteSetting.sqlProvider = sqlProvider;
    }

    public static synchronized ISql getSqlProvider() {
        return sqlProvider;
    }
}
