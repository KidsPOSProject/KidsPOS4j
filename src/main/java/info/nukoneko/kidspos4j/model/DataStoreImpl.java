package info.nukoneko.kidspos4j.model;

import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
public class DataStoreImpl extends DataBase<ModelStore> {
    @Override
    String QueryCreate() {
        return "CREATE TABLE  IF NOT EXISTS " + getTableKind().getName() +
                "(id INTEGER  PRIMARY KEY AUTOINCREMENT, name TEXT)";
    }

    @Override
    String QueryInsert(ModelStore item) {
        return String.format("INSERT INTO %s(name) VALUES('%s')",
                        getTableKind().getName(),
                        item.getName());
    }

    @Override
    public Observable<ModelStore> findAllRx() {
        ArrayList<ModelStore> list = findAllImpl(ModelStore.class);
        return Observable.from(list.toArray(new ModelStore[list.size()]));
    }

    @Override
    public ArrayList<ModelStore> findAll() {
        return findAllImpl(ModelStore.class);
    }

    @Override
    void setValues(ModelStore model, ResultSet rs) throws SQLException {
        model.setId(rs.getInt("id"));
        model.setName(rs.getString("name"));
    }

    @Override
    TableKind getTableKind() {
        return TableKind.STORE;
    }
}
