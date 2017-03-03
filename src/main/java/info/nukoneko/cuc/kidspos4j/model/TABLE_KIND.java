package info.nukoneko.cuc.kidspos4j.model;

public enum TABLE_KIND {
    ITEM("item", "item.db"),
    ITEM_GENRE("item_genre", "item.db"),
    SALE("sale", "sale.db"),
    STORE("store", "item.db"),
    STAFF("staff", "staff.db"),
    DOWNLOAD_APK("apk", "download.db");

    private final String name;
    private final String dbPath;
    TABLE_KIND(final String name, final String dbPath){
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
