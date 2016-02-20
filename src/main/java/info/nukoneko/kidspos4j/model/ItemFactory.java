package info.nukoneko.kidspos4j.model;

/**
 * Created by atsumi on 2016/02/03.
 */
final public class ItemFactory {
    private static DataItemImpl INSTANCE = new DataItemImpl();
    public static DataItemImpl getInstance(){
        return INSTANCE;
    }
}
