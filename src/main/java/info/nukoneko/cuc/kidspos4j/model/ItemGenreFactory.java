package info.nukoneko.cuc.kidspos4j.model;

final public class ItemGenreFactory {
    private static DataItemGenreImpl INSTANCE = new DataItemGenreImpl();
    public static DataItemGenreImpl getInstance(){
        return INSTANCE;
    }
}
