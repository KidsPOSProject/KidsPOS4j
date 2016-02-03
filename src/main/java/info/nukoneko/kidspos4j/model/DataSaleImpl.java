package info.nukoneko.kidspos4j.model;

import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
final class DataSaleImpl extends DataBase<ModelSale> {

    @Override
    String QueryCreate() {
        return "CREATE TABLE  IF NOT EXISTS " + getTableKind().getName() +
                "(id INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                "barcode TEXT UNIQUE, " +
                "created_at TEXT, " +
                "points INTEGER, " +
                "price INTEGER, " +
                "items TEXT, " +
                "store INTEGER, " +
                "staff INTEGER)";
    }

    @Override
    String QueryInsert(ModelSale item) {
        return String
                .format("INSERT INTO %s(barcode, created_at, points, price, items, store, staff) " +
                                "VALUES('%s','%s', %d, %d, '%s' %d, %d)",
                        getTableKind().getName(),
                        item.getBarcode(),
                        item.getCreatedAt(),
                        item.getPoints(),
                        item.getPrice(),
                        item.getItems(),
                        item.getStore(),
                        item.getStaff());
    }

    @Override
    public Observable<ModelSale> findAllRx() {
        ArrayList<ModelSale> list = findAllImpl(ModelSale.class);
        return Observable.from(list.toArray(new ModelSale[list.size()]));
    }

    @Override
    public ArrayList<ModelSale> findAll() {
        return findAllImpl(ModelSale.class);
    }

    @Override
    void setValues(ModelSale model, ResultSet rs) throws SQLException {
        model.setId(rs.getInt("id"));
        model.setBarcode(rs.getString("barcode"));
        model.setCreatedAt(rs.getString("created_at"));
        model.setPoints(rs.getInt("points"));
        model.setPrice(rs.getInt("price"));
        model.setItems(rs.getString("items"));
        model.setStore(rs.getInt("store"));
        model.setStaff(rs.getInt("staff"));
    }

    @Override
    TableKind getTableKind() {
        return TableKind.SALE;
    }
}
