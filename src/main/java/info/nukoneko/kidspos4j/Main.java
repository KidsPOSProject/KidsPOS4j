package info.nukoneko.kidspos4j;

import info.nukoneko.kidspos4j.model.DataBase;
import info.nukoneko.kidspos4j.model.ItemFactory;
import info.nukoneko.kidspos4j.model.ModelItem;

/**
 * Created by TEJNEK on 2016/02/03.
 */
public class Main {
    public static void main(String[] args){
        ItemFactory.getInstance().truncate();
        DataBase<ModelItem> model = ItemFactory.getInstance();
        ModelItem item = getModel("12345");
        model.insert(item);
        ModelItem item2 = getModel("67891");
        model.insert(item2);

       ModelItem item3 = model.find("barcode = '12345'").get(0);
        System.out.println(item.equals(item3));
    }

    private static ModelItem getModel(String barcode){
        ModelItem item = new ModelItem();
        item.setName("Yamada");
        item.setBarcode(barcode);
        item.setPrice(500);
        item.setShop(100);
        item.setGenre("Human");
        return item;
    }
}
