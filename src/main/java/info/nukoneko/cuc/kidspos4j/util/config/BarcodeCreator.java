package info.nukoneko.cuc.kidspos4j.util.config;

public class BarcodeCreator {
    private final static Integer BARCODE_NUM = 10;

    // 10 00 15 0004
    private final static Integer MAX_STORE_LENGTH = 2;
    final public static Integer MAX_ITEM_LENGTH = 4;

    private final static String BARCODE_PREFIX_BASE = "10";

    /**
     * バーコードの種類についての列挙
     */
    public enum BARCODE_PREFIX {
        STAFF("00"),
        ITEM("01"),
        SALE("02");

        private final String prefix;
        BARCODE_PREFIX(String prefix){
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    /**
     * バーコード文字列の作成
     * @param codeType バーコード種類
     * @param storeID 販売するお店ID
     * @param itemId 販売する商品のID
     * @return 生成された文字列
     */
    public static String create(BARCODE_PREFIX codeType,
                                Integer storeID,
                                Integer itemId){
        if (storeID >= Math.pow(10, MAX_STORE_LENGTH) ||
                itemId >= Math.pow(10, MAX_ITEM_LENGTH)) {
            System.out.println("StoreID");
            System.out.println(storeID >= Math.pow(10, MAX_STORE_LENGTH));

            System.out.println("ItemID");
            System.out.println(itemId >= Math.pow(10, MAX_ITEM_LENGTH));
            System.out.println("おかしい 長さ");
            return null;
        }
        String format = "%s%s%3$0" + MAX_STORE_LENGTH + "d%4$0" + MAX_ITEM_LENGTH + "d";
         String gen = String.format(format, BARCODE_PREFIX_BASE, codeType.getPrefix(), storeID, itemId);
        if (gen.length() == BARCODE_NUM){
            return gen;
        } else {
            System.out.println("これバーコードの長さじゃない");
            System.out.println("これ" + gen);
            return null;
        }
    }
}
