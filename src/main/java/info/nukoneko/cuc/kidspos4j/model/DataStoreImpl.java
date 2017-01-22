package info.nukoneko.cuc.kidspos4j.model;

import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    String QueryUpdate(ModelStore item) {
        return String
                .format("UPDATE %s SET name = '%s' " +
                        "WHERE id = '%s'",
                        getTableKind().getName(),
                        item.getName(),
                        item.getId()
                );
    }

    @Override
    public Observable<List<ModelStore>> findAllRx() {
        return Observable.from(find(ModelStore.class)).toList();
    }

    @Override
    public ArrayList<ModelStore> findAll() {
        return find(ModelStore.class);
    }

    @Override
    public ArrayList<ModelStore> find(String where) {
        return find(ModelStore.class, where);
    }

    @Override
    public ModelStore findFirst(String where) {
        ArrayList<ModelStore> arrayList =
                find(ModelStore.class, where);
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList.get(0);
    }

    @Override
    public ModelStore findFromBarcode(String barcode) {
        return null;
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

    public ModelStore createNewStore(String name) {
        ModelStore ret = new ModelStore();
        ret.setName(name);
        if (insert(ret)) {
            return findFirst(String.format("name = '%s'", name));
        }
        return null;
    }
}
