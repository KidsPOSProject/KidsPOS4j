package info.nukoneko.kidspos4j.model;

import info.nukoneko.kidspos4j.exception.CannotCreateItemException;
import info.nukoneko.kidspos4j.util.config.BarcodeCreatetor;
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
    String QueryUpdate(ModelStaff item) {
        return null;
    }

    @Override
    public Observable<ModelStaff> findAllRx() {
        ArrayList<ModelStaff> list = find(ModelStaff.class);
        return Observable.from(list.toArray(new ModelStaff[list.size()]));
    }

    @Override
    public ArrayList<ModelStaff> findAll() {
        return find(ModelStaff.class);
    }

    @Override
    public ArrayList<ModelStaff> find(String where) {
        return find(ModelStaff.class, where);
    }

    @Override
    public ModelStaff findFirst(String where) {
        ArrayList<ModelStaff> arrayList =
                find(ModelStaff.class, where);
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList.get(0);
    }

    @Override
    public ModelStaff findFromBarcode(String barcode) {
        return findFirst(String.format("barcode = '%s'", barcode));
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

    public ModelStaff createNewStaff(String name)
            throws CannotCreateItemException {
        String barcode =
                BarcodeCreatetor.create(
                        BarcodeCreatetor.BARCODE_PREFIX.STAFF, 16, findAll().size());
        // TODO: 16 はflexible...
        ModelStaff ret = new ModelStaff();
        ret.setBarcode(barcode);
        ret.setName(name);
        if (insert(ret)) {
            ret = findFromBarcode(barcode);
            if (ret == null){
                throw new CannotCreateItemException();
            }
            return ret;
        } else {
            throw new CannotCreateItemException();
        }
    }
}
