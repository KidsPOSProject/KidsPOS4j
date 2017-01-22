package info.nukoneko.cuc.kidspos4j.model;

final public class StoreFactory {
    private static DataStoreImpl INSTANCE = new DataStoreImpl();
    public static DataStoreImpl getInstance(){
        return INSTANCE;
    }
}
