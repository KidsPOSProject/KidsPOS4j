package info.nukoneko.kidspos4j.model;

import rx.Observable;

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
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        boolean ret = stmt.execute(query);
        stmt.close();
        connection.close();
        return ret;
    }

    protected ArrayList<T> findAllImpl(Class<T> modelItemClass) {
        ArrayList<T> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + getTableKind().getName());
            while( rs.next() ) {
                T model = modelItemClass.newInstance();
                setValues(model, rs);
                list.add(model);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

}
