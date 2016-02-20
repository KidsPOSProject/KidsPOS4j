package info.nukoneko.kidspos4j.model;

/**
 * Created by atsumi on 2016/02/03.
 */
public enum TableKind {
    ITEM("item", "item.db"),
    ITEM_GENRE("item_genre", "item.db"),
    SALE("sale", "item.db"),
    STORE("store", "item.db"),
    STAFF("staff", "staff.db");

    private final String name;
    private final String dbPath;
    TableKind(final String name, final String dbPath){
        this.name = name;
        this.dbPath = dbPath;
    }

    public String getName(){
        return this.name;
    }

    public String getDbPath(){
        return this.dbPath;
    }
}
