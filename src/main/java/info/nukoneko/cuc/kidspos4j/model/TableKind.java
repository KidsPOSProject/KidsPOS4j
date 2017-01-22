package info.nukoneko.cuc.kidspos4j.model;

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
