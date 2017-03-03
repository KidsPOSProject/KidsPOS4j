package info.nukoneko.cuc.kidspos4j.model;

import rx.Observable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDownloadApkImpl extends DataBase<SpecificModelDownloadApk> {
    @Override
    String QueryCreate() {
        return "CREATE TABLE IF NOT EXISTS " + getTableKind().getName() +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "buildNumber INTEGER UNIQUE, " +
                "fileName TEXT)";
    }

    @Override
    String QueryInsert(SpecificModelDownloadApk item) {
        return String
                .format("INSERT INTO %s (buildNumber, fileName) VALUES(%d, '%s')",
                        getTableKind().getName(), item.getBuildNumber(), item.getFileName());
    }

    @Override
    String QueryUpdate(SpecificModelDownloadApk item) {
        throw new NotImplementedException();
    }

    @Override
    public Observable<List<SpecificModelDownloadApk>> findAllRx() {
        return Observable.from(find(SpecificModelDownloadApk.class)).toList();
    }

    @Override
    public ArrayList<SpecificModelDownloadApk> findAll() {
        return find(SpecificModelDownloadApk.class);
    }

    @Override
    public ArrayList<SpecificModelDownloadApk> find(String where) {
        return find(SpecificModelDownloadApk.class, where);
    }

    @Override
    public SpecificModelDownloadApk findFirst(String where) {
        ArrayList<SpecificModelDownloadApk> arrayList = find(SpecificModelDownloadApk.class, where);
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList.get(0);
    }

    @Override
    public SpecificModelDownloadApk findFromBarcode(String barcode) {
        throw new NotImplementedException();
    }

    @Override
    void setValues(SpecificModelDownloadApk model, ResultSet rs) throws SQLException {
        model.setId(rs.getInt("id"));
        model.setBuildNumber(rs.getInt("buildNumber"));
        model.setFileName(rs.getString("fileName"));
    }

    @Override
    TABLE_KIND getTableKind() {
        return TABLE_KIND.DOWNLOAD_APK;
    }
}
