package info.nukoneko.kidspos4j.model;

/**
 * Created by atsumi on 2016/02/03.
 */
final public class StoreFactory {
    private static DataStoreImpl INSTANCE = new DataStoreImpl();
    public static DataBase<ModelStore> getInstance(){
        return INSTANCE;
    }
}
