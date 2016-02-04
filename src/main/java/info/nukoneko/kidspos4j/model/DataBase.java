package info.nukoneko.kidspos4j.model;

import rx.Observable;

import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
public abstract class DataBase<T extends BaseModelAbstract> {
    abstract String QueryCreate();
    abstract String QueryInsert(T item);
    abstract public Observable<T> findAllRx();
    abstract public ArrayList<T> findAll();
    abstract public ArrayList<T> find(String where);
    abstract void setValues(T model, ResultSet rs) throws SQLException;
    abstract TableKind getTableKind();

    DataBase(){
        try {
            Execute(QueryCreate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final boolean insert(T item) {
        try {
            Execute(QueryInsert(item));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public final boolean truncate() {
        try {
            Execute(String.format("DELETE FROM '%s'", getTableKind().getName()));
            Execute(String.format("DELETE FROM sqlite_sequence where name='%s'", getTableKind().getName()));
            Execute("VACUUM");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:sqlite:"+ getTableKind().getDbPath());
    }

    private boolean Execute(String query) throws SQLException {
//        System.out.println(query);
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        boolean ret = stmt.execute(query);
        stmt.close();
        connection.close();
        return ret;
    }

    public boolean ExecuteQuery(String query, QueryCallback callback) throws SQLException {
//        System.out.println(query);
        try {
            Connection connection = getConnection();
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

    protected ArrayList<T> find(Class<T> modelItemClass) {
        return find(modelItemClass, null);
    }

    protected ArrayList<T> find(final Class<T> modelItemClass, String where) {
        final ArrayList<T> list = new ArrayList<T>();
        try {
            String base = "SELECT * FROM '" + getTableKind().getName() + "' ";
            if (where != null) {
                base += String.format("WHERE %s", where);
            }
            ExecuteQuery(base, new QueryCallback() {
                @Override
                public void result(ResultSet resultSet) throws SQLException {
                    try {
                        T model = modelItemClass.newInstance();
                        setValues(model, resultSet);
                        list.add(model);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
