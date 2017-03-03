package info.nukoneko.cuc.kidspos4j.util.config;

/**
 * バーコードの仕様です
 * 1234567890
 * 12: 固定
 * 34: 種類識別
 * 56: 種類毎の値 (お店: お店ID, スタッフ: 年度)
 * 7890: 種類毎の値 種類毎にユニークな値 (id とか)
 */
public final class BarcodeRule {
    /**
     * バーコードの種類についての列挙
     */
    public enum BARCODE_PREFIX {
        STAFF("00"),
        ITEM("01"),
        SALE("02"),
        UNKNOWN("99");

        private final String prefix;

        BARCODE_PREFIX(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }

        public static BARCODE_PREFIX typeOf(String prefix) {
            for (BARCODE_PREFIX barcodePrefix : BARCODE_PREFIX.values()) {
                if (barcodePrefix.getPrefix().equalsIgnoreCase(prefix)) return barcodePrefix;
            }
            return BARCODE_PREFIX.UNKNOWN;
        }

        public static BARCODE_PREFIX typeOf(int prefix) {
            try {
                final String _prefix = String.valueOf(prefix);
                for (BARCODE_PREFIX barcodePrefix : BARCODE_PREFIX.values()) {
                    if (barcodePrefix.getPrefix().equalsIgnoreCase(_prefix)) return barcodePrefix;
                }
                return BARCODE_PREFIX.UNKNOWN;
            } catch (ClassCastException ignore) {
                return BARCODE_PREFIX.UNKNOWN;
            }
        }
    }

    public final static Integer BARCODE_NUM = 10;
    public final static String BARCODE_PREFIX_BASE = "10";
    public final static Integer MAX_TYPE_VALUE1_LENGTH = 2;
    public final static Integer MAX_TYPE_VALUE2_LENGTH = 4;
}
