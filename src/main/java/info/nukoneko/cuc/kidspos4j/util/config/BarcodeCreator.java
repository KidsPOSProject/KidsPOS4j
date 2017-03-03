package info.nukoneko.cuc.kidspos4j.util.config;

import static info.nukoneko.cuc.kidspos4j.util.config.BarcodeRule.*;

public class BarcodeCreator {
    /**
     * バーコード文字列の作成
     *
     * @param codeType バーコード種類
     * @param typeValue1  種類別の値
     * @param typeValue2  種類の中でのユニークな値
     * @return 生成された文字列
     */
    public static String create(BARCODE_PREFIX codeType, Integer typeValue1, Integer typeValue2) {
        if (typeValue1 >= Math.pow(10, MAX_TYPE_VALUE1_LENGTH) || typeValue2 >= Math.pow(10, MAX_TYPE_VALUE2_LENGTH)) {
            return null;
        }
        String format = "%s%s%3$0" + MAX_TYPE_VALUE1_LENGTH + "d%4$0" + MAX_TYPE_VALUE2_LENGTH + "d";
        String gen = String.format(format, BARCODE_PREFIX_BASE, codeType.getPrefix(), typeValue1, typeValue2);
        if (gen.length() == BARCODE_NUM) {
            return gen;
        } else {
            return null;
        }
    }
}
