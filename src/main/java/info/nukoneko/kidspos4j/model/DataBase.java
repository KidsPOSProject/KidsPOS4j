package info.nukoneko.kidspos4j.model;

import info.nukoneko.kidspos4j.util.config.SQLiteSetting;
import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by atsumi on 2016/02/03.
 */
public abstract class DataBase<T extends BaseModelAbstract> {
    abstract String QueryCreate();
    abstract String QueryInsert(T item);
    abstract String QueryUpdate(T item);
    abstract public Observable<List<T>> findAllRx();
    abstract public ArrayList<T> findAll();
    abstract public ArrayList<T> find(String where);
    abstract public T findFirst(String where);
    abstract public T findFromBarcode(String barcode);
    abstract void setValues(T model, ResultSet rs) throws SQLException;
    abstract TableKind getTableKind();

    DataBase(){
        try {
            Execute(QueryCreate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final T getLast(){
        List<T> obj = findAll();
        if (obj.size() == 0){
            return null;
        }

        return findAll().get(obj.size() - 1);
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

    public final boolean update(T item) {
        try {
            Execute(QueryUpdate(item));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public final boolean truncate() {
        return SQLiteSetting.getSqlProvider().truncate(getTableKind());
    }

    private boolean Execute(String query) throws SQLException {
        System.out.println(query);
        return SQLiteSetting.getSqlProvider().Execute(getTableKind(), query);
    }

    public boolean ExecuteQuery(String query, QueryCallback callback) throws SQLException {
        System.out.println(query);
        return SQLiteSetting.getSqlProvider().ExecuteQuery(getTableKind(), query, callback);
    }

    protected ArrayList<T> find(Class<T> modelItemClass) {
        return find(modelItemClass, null);
    }

    protected ArrayList<T> find(final Class<T> modelItemClass, String where) {
        final ArrayList<T> list = new ArrayList<T>();
        try {
            String base = "SELECT * FROM " + getTableKind().getName() + " ";
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

    final protected String getNowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        return sdf.format(new Date());
    }
}
