package info.nukoneko.kidspos4j.model;

/**
 * Created by atsumi on 2016/02/03.
 */
final public class ItemGenreFactory {
    private static DataItemGenreImpl INSTANCE = new DataItemGenreImpl();
    public static DataBase<ModelItemGenre> getInstance(){
        return INSTANCE;
    }
}
