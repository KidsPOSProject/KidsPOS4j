package info.nukoneko.kidspos4j;

import info.nukoneko.kidspos4j.model.ModelItem;

/**
 * Created by atsumi on 2016/10/06.
 */
public class CommonTest {
    public static ModelItem getModel(String barcode){
        ModelItem item = new ModelItem();
        item.setName("Yamada");
        item.setBarcode(barcode);
        item.setPrice(500);
        item.setStoreId(10);
        item.setGenreId(1);
        return item;
    }
}
