package info.nukoneko.kidspos4j.model;

import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
final class DataItemGenreImpl extends DataBase<ModelItemGenre> {

    @Override
    String QueryCreate() {
        return "CREATE TABLE IF NOT EXISTS " + getTableKind().getName() +
                "(id INTEGER  PRIMARY KEY AUTOINCREMENT, name TEXT, store TEXT)";
    }

    @Override
    String QueryInsert(ModelItemGenre item) {
        return String
                .format("INSERT INTO %s(name, store) VALUES('%s','%s')",
                        getTableKind().getName(), item.getName(), item.getStore());
    }

    @Override
    public Observable<ModelItemGenre> findAllRx() {
        ArrayList<ModelItemGenre> list = findAllImpl(ModelItemGenre.class);
        return Observable.from(list.toArray(new ModelItemGenre[list.size()]));
    }

    @Override
    public ArrayList<ModelItemGenre> findAll() {
        return findAllImpl(ModelItemGenre.class);
    }

    @Override
    void setValues(ModelItemGenre model, ResultSet rs) throws SQLException {
        model.setId(rs.getInt("id"));
        model.setName(rs.getString("name"));
        model.setStore(rs.getString("store"));
    }

    @Override
    TableKind getTableKind() {
        return TableKind.ITEM_GENRE;
    }
}
