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
final public class DataItemImpl extends DataBase<ModelItem> {
    @Override
    String QueryCreate() {
        return "CREATE TABLE  IF NOT EXISTS " + getTableKind().getName() +
                "(id INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                "barcode INTEGER UNIQUE, " +
                "name TEXT, " +
                "price INTEGER, " +
                "shop INT, " +
                "genre TEXT)";
    }

    @Override
    String QueryInsert(ModelItem item) {
        return String
                .format("INSERT INTO %s(barcode, name, price, shop, genre) VALUES('%s','%s', %d, %d, '%s')",
                        getTableKind().getName(),
                        item.getBarcode(),
                        item.getName(),
                        item.getPrice(),
                        item.getStoreId(),
                        item.getGenreId());
    }

    @Override
    String QueryUpdate(ModelItem item) {
        return String
                .format("UPDATE %s " +
                        "SET barcode = '%s', name = '%s', price = '%s', shop = '%s', genre = '%s' " +
                        "WHERE id = '%s'",
                        getTableKind().getName(),
                        item.getBarcode(),
                        item.getName(),
                        item.getPrice(),
                        item.getStoreId(),
                        item.getGenreId(),
                        item.getId()
                );
    }

    @Override
    public Observable<ModelItem> findAllRx() {
        ArrayList<ModelItem> list = find(ModelItem.class);
        return Observable.from(list.toArray(new ModelItem[list.size()]));
    }

    @Override
    public ArrayList<ModelItem> findAll() {
        return find(ModelItem.class);
    }

    @Override
    public ArrayList<ModelItem> find(String where) {
        return find(ModelItem.class, where);
    }

    @Override
    public ModelItem findFirst(String where) {
        ArrayList<ModelItem> arrayList =
                find(ModelItem.class, where);
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList.get(0);
    }

    @Override
    public ModelItem findFromBarcode(String barcode) {
        return findFirst(String.format("barcode = '%s'", barcode));
    }

    @Override
    void setValues(ModelItem model, ResultSet rs) throws SQLException {
        model.setId(rs.getInt("id"));
        model.setBarcode(rs.getString("barcode"));
        model.setName(rs.getString("name"));
        model.setPrice(rs.getInt("price"));
        model.setStoreId(rs.getInt("shop"));
        model.setGenreId(Integer.valueOf(rs.getString("genre")));
    }

    @Override
    TableKind getTableKind() {
        return TableKind.ITEM;
    }

    public ModelItem createNewItem(String name,
                                   Integer storeId,
                                   Integer genreId,
                                   Integer price) throws CannotCreateItemException {
        String barcode =
                BarcodeCreatetor.create(
                BarcodeCreatetor.BARCODE_PREFIX.ITEM,
                storeId, 0);
        ModelItem ret = new ModelItem();
        ret.setBarcode(barcode);
        ret.setName(name);
        ret.setPrice(price);
        ret.setStoreId(storeId);
        ret.setGenreId(genreId);
        if (insert(ret)) {
            ret = findFromBarcode(barcode);
            if (ret == null){
                throw new CannotCreateItemException();
            }
            ret.setBarcode(
                    BarcodeCreatetor.create(
                            BarcodeCreatetor.BARCODE_PREFIX.ITEM,
                            storeId, ret.getId()));
            if (update(ret)) {
                return ret;
            } else {
                throw new CannotCreateItemException();
            }
        } else {
            throw new CannotCreateItemException();
        }
    }
}
