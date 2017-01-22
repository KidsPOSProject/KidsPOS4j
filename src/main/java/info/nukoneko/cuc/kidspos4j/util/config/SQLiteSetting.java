package info.nukoneko.cuc.kidspos4j.util.config;

import info.nukoneko.cuc.kidspos4j.util.sqlite.JDBCSqlProvider;
import info.nukoneko.cuc.kidspos4j.util.sqlite.ISql;

public class SQLiteSetting {
    private static ISql sqlProvider = new JDBCSqlProvider();

    public static synchronized void setSqlProvider(ISql sqlProvider) {
        SQLiteSetting.sqlProvider = sqlProvider;
    }

    public static synchronized ISql getSqlProvider() {
        return sqlProvider;
    }
}
