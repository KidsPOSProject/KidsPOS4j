package info.nukoneko.cuc.kidspos4j;

import info.nukoneko.cuc.kidspos4j.model.ModelItem;

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
