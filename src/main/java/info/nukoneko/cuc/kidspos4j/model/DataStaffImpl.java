package info.nukoneko.cuc.kidspos4j.model;

import info.nukoneko.cuc.kidspos4j.util.config.BarcodeCreator;
import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Observable<List<ModelStaff>> findAllRx() {
        return Observable.from(find(ModelStaff.class)).toList();
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

    public ModelStaff createNewStaff(String name) {
        String barcode =
                BarcodeCreator.create(
                        BarcodeCreator.BARCODE_PREFIX.STAFF,
                        16, getNewItemId());

        ModelStaff ret = new ModelStaff();
        ret.setBarcode(barcode);
        ret.setName(name);
        if (insert(ret)) {
            return findFromBarcode(barcode);
        }
        return null;
    }

    public int getNewItemId(){
        int last = findAll().size();
        int itemId;
        if (last > 0) {
            String _bar = findAll().get(last - 1).getBarcode();
            _bar = _bar.substring(_bar.length() - BarcodeCreator.MAX_ITEM_LENGTH);
            return (Integer.parseInt(_bar) + 1);
        } else {
            return 1;
        }
    }
}
