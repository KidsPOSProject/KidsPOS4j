package info.nukoneko.kidspos4j.model;

import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
public class DataStaffImpl extends DataBase<ModelStaff> {
    @Override
    String QueryCreate() {
        return "CREATE TABLE  IF NOT EXISTS " + getTableKind().getName() +
                "(barcode INTEGER PRIMARY KEY, name TEXT)";
    }

    @Override
    String QueryInsert(ModelStaff item) {
        return String.format("INSERT INTO %s(barcode,name) VALUES('%s','%s')",
                        getTableKind().getName(),
                        item.getBarcode(),
                        item.getName());
    }

    @Override
    public Observable<ModelStaff> findAllRx() {
        ArrayList<ModelStaff> list = findAllImpl(ModelStaff.class);
        return Observable.from(list.toArray(new ModelStaff[list.size()]));
    }

    @Override
    public ArrayList<ModelStaff> findAll() {
        return findAllImpl(ModelStaff.class);
    }

    @Override
    void setValues(ModelStaff model, ResultSet rs) throws SQLException {
        model.setBarcode(rs.getString("barcode"));
        model.setName(rs.getString("name"));
    }

    @Override
    TableKind getTableKind() {
        return TableKind.STAFF;
    }
}
