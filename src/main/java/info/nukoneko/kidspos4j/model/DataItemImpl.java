package info.nukoneko.kidspos4j.model;

import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
final class DataItemImpl extends DataBase<ModelItem> {
    @Override
    String QueryCreate() {
        return "CREATE TABLE  IF NOT EXISTS " + getTableKind().getName() +
                "(id INTEGER  PRIMARY KEY AUTOINCREMENT, barcode INTEGER UNIQUE, name TEXT, price INTEGER, shop INT, genre TEXT)";
    }

    @Override
    String QueryInsert(ModelItem item) {
        return String
                .format("INSERT INTO %s(barcode, name, price, shop, genre) VALUES('%s','%s', %d, %d, '%s')",
                        getTableKind().getName(),
                        item.getBarcode(),
                        item.getName(),
                        item.getPrice(),
                        item.getShop(),
                        item.getGenre());
    }

    @Override
    public Observable<ModelItem> findAllRx() {
        ArrayList<ModelItem> list = findAllImpl(ModelItem.class);
        return Observable.from(list.toArray(new ModelItem[list.size()]));
    }

    @Override
    public ArrayList<ModelItem> findAll() {
        return findAllImpl(ModelItem.class);
    }

    @Override
    void setValues(ModelItem model, ResultSet rs) throws SQLException {
        model.setId(rs.getInt("id"));
        model.setBarcode(rs.getString("barcode"));
        model.setName(rs.getString("name"));
        model.setPrice(rs.getInt("price"));
        model.setShop(rs.getInt("shop"));
        model.setGenre(rs.getString("genre"));
    }

    @Override
    TableKind getTableKind() {
        return TableKind.ITEM;
    }
}
