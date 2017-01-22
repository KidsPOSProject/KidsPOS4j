package info.nukoneko.cuc.kidspos4j.model;

final public class ItemFactory {
    private static DataItemImpl INSTANCE = new DataItemImpl();
    public static DataItemImpl getInstance(){
        return INSTANCE;
    }
}
