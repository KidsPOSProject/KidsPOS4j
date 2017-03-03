package info.nukoneko.cuc.kidspos4j.model;

import info.nukoneko.cuc.kidspos4j.util.config.BarcodeCreator;
import info.nukoneko.cuc.kidspos4j.util.config.BarcodeRule;
import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Observable<List<ModelItem>> findAllRx() {
        return Observable.from(find(ModelItem.class)).toList();
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
    TABLE_KIND getTableKind() {
        return TABLE_KIND.ITEM;
    }

    public ModelItem createNewItem(String name,
                                   Integer storeId,
                                   Integer genreId,
                                   Integer price) {
        String barcode = BarcodeCreator.create(
                BarcodeRule.BARCODE_PREFIX.ITEM,
                storeId, getNewItemId());

        ModelItem ret = new ModelItem();
        ret.setBarcode(barcode);
        ret.setName(name);
        ret.setPrice(price);
        ret.setStoreId(storeId);
        ret.setGenreId(genreId);

        if (insert(ret)) {
            return findFromBarcode(barcode);
        }
        return null;
    }

    public int getNewItemId(){
        int last = findAll().size();
        if (last > 0) {
            String _bar = findAll().get(last - 1).getBarcode();
            _bar = _bar.substring(_bar.length() - BarcodeRule.MAX_TYPE_VALUE2_LENGTH);
            return (Integer.parseInt(_bar) + 1);
        } else {
            return  1;
        }
    }
}
